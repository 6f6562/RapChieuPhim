USE [master]
GO
/****** Object:  Database [Java_RapChieuPhim]    Script Date: 4/23/2024 3:14:14 PM ******/
CREATE DATABASE [Java_RapChieuPhim]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Java_RapChieuPhim', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java_RapChieuPhim.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Java_RapChieuPhim_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java_RapChieuPhim_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Java_RapChieuPhim] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Java_RapChieuPhim].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Java_RapChieuPhim] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ARITHABORT OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Java_RapChieuPhim] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Java_RapChieuPhim] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Java_RapChieuPhim] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Java_RapChieuPhim] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET RECOVERY FULL 
GO
ALTER DATABASE [Java_RapChieuPhim] SET  MULTI_USER 
GO
ALTER DATABASE [Java_RapChieuPhim] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Java_RapChieuPhim] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Java_RapChieuPhim] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Java_RapChieuPhim] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Java_RapChieuPhim] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Java_RapChieuPhim] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Java_RapChieuPhim', N'ON'
GO
ALTER DATABASE [Java_RapChieuPhim] SET QUERY_STORE = OFF
GO
USE [Java_RapChieuPhim]
GO
/****** Object:  UserDefinedFunction [dbo].[getTimeSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create   function [dbo].[getTimeSuatChieu](@maSC int, @mode int)
returns datetime
as
begin
	declare @result datetime
	if @mode = 1
		select @result = sc.GioBatDau from SuatChieu sc where sc.MaSuatChieu = @maSC
	if @mode = 2
	begin
		
		select @result = DATEADD(MINUTE, p.ThoiLuong, sc.GioBatDau) from SuatChieu sc, Phim p
		where sc.MaSuatChieu = @maSC
			and sc.MaPhim = p.MaPhim
	end
	return @result
end
GO
/****** Object:  UserDefinedFunction [dbo].[isTimeBetweenSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create   function [dbo].[isTimeBetweenSuatChieu](@maSC int, @startTime datetime, @endTime dateTime)
returns int
as
begin
	-- Thời gian giãn cách các suất chiếu để chuẩn bị -- 15p
	declare @prepareTime int
	set @prepareTime = 15


	if (DATEDIFF(MINUTE, dbo.getTimeSuatChieu(@maSC, 1), @startTime) >= 0)
		if (DATEDIFF(MINUTE, dbo.getTimeSuatChieu(@maSC, 2), @startTime)  <= 0)
			return 0
	if (DATEDIFF(MINUTE, dbo.getTimeSuatChieu(@maSC, 1), @endTime) >= 0)
		if (DATEDIFF(MINUTE, dbo.getTimeSuatChieu(@maSC, 2), @endTime)  <= 0)
			return 0
	--Có thể đổi return value để biết là không đủ thời gian để chuẩn bị
	if (abs(DATEDIFF(MINUTE, @endTime,  dbo.getTimeSuatChieu(@maSC, 1))) < @prepareTime)
		return 0
	return 1
end
GO
/****** Object:  UserDefinedFunction [dbo].[isValidTimeSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create   function [dbo].[isValidTimeSuatChieu](@startTime datetime, @phongChieu int, @maPhim int)
returns int
as
begin
	-- Thời gian giãn cách các suất chiếu để chuẩn bị -- 15p
	declare @prepareTime int
	set @prepareTime = 15

	declare @endTime datetime
	select @endTime = DATEADD(MINUTE, p.ThoiLuong, @startTime) from Phim p where p.MaPhim = @maPhim
	
	--Kiểm tra xem thời gian có nằm giữa giờ chiếu của các suất chiếu khác không
	declare @maxSuatChieu int 
	set @maxSuatChieu = (select max(MaSuatChieu) from SuatChieu sc where sc.PhongChieuMaPhong = @phongChieu)
	declare @i int
	set @i = (select min(MaSuatChieu) from SuatChieu sc where sc.PhongChieuMaPhong = @phongChieu)

	--Duyệt toàn bộ suất chiếu của phòng chiếu
	while (@i <= @maxSuatChieu)
	begin
		if (@i in (select sc.MaSuatChieu from SuatChieu sc where sc.MaSuatChieu = @i))
		begin
			--Gọi function để kiểm tra
			if (dbo.isTimeBetweenSuatChieu(@i, @startTime, @endTime) = 0)
				return 0
		end
		set @i += 1
	end

	--Không thấy nằm trong  suất chiếu khác => đúng
	return 1
end
GO
/****** Object:  Table [dbo].[Ghe]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ghe](
	[MaGhe] [int] IDENTITY(1,1) NOT NULL,
	[HangGhe] [nvarchar](3) NULL,
	[SoGhe] [int] NOT NULL,
	[PhongChieuMaPhong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaGhe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GheSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GheSuatChieu](
	[MaGheSC] [int] IDENTITY(1,1) NOT NULL,
	[SuatChieuMaSuatChieu] [int] NOT NULL,
	[GheMaGhe] [int] NOT NULL,
	[TrangThai] [bit] NULL,
	[GiaTien] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaGheSC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[CCCD] [nvarchar](20) NOT NULL,
	[SDT] [nvarchar](12) NULL,
	[Tuoi] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CCCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](255) NULL,
	[ChucVu] [nvarchar](255) NULL,
	[MoTaCongViec] [nvarchar](255) NULL,
	[NgaySinh] [date] NULL,
	[TaiKhoan] [nvarchar](255) NULL,
	[MatKhau] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phim]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phim](
	[MaPhim] [int] IDENTITY(1,1) NOT NULL,
	[TenPhim] [nvarchar](255) NULL,
	[QuocGia] [nvarchar](255) NULL,
	[NgayPhatHanh] [date] NULL,
	[ThoiLuong] [int] NOT NULL,
	[MoTa] [nvarchar](255) NULL,
	[DaoDien] [nvarchar](255) NULL,
	[DienVien] [nvarchar](255) NULL,
	[DoTuoi] [int] NOT NULL,
	[LoaiPhim] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongChieu](
	[MaPhong] [int] IDENTITY(1,1) NOT NULL,
	[TenPhong] [nvarchar](10) NULL,
	[soGhe] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SuatChieu](
	[MaSuatChieu] [int] IDENTITY(1,1) NOT NULL,
	[GioBatDau] [datetime] NULL,
	[PhongChieuMaPhong] [int] NOT NULL,
	[MaPhim] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSuatChieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VeXemPhim]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VeXemPhim](
	[MaVe] [int] IDENTITY(1,1) NOT NULL,
	[MaNhanVien] [int] NOT NULL,
	[KhachHangCCCD] [nvarchar](20) NOT NULL,
	[GheSuatChieuMaGheSC] [int] NOT NULL,
	[NgayDatVe] [datetime] NULL,
	[TongTien] [real] NOT NULL,
	[KhuyenMai] [real] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Ghe] ON 

INSERT [dbo].[Ghe] ([MaGhe], [HangGhe], [SoGhe], [PhongChieuMaPhong]) VALUES (1, N'A', 1, 1)
INSERT [dbo].[Ghe] ([MaGhe], [HangGhe], [SoGhe], [PhongChieuMaPhong]) VALUES (4, N'A', 3, 1)
INSERT [dbo].[Ghe] ([MaGhe], [HangGhe], [SoGhe], [PhongChieuMaPhong]) VALUES (5, N'A', 4, 1)
SET IDENTITY_INSERT [dbo].[Ghe] OFF
GO
SET IDENTITY_INSERT [dbo].[Phim] ON 

INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [QuocGia], [NgayPhatHanh], [ThoiLuong], [MoTa], [DaoDien], [DienVien], [DoTuoi], [LoaiPhim]) VALUES (1, N'GODZILLA X KONG: ĐẾ CHẾ MỚI', N'Mỹ', CAST(N'2024-03-29' AS Date), 115, N'Kong và Godzilla - hai sinh vật vĩ đại huyền thoại, hai kẻ thủ truyền kiếp sẽ cùng bắt tay thực thi một sứ mệnh chung mang tính sống còn để bảo vệ nhân loại, và trận chiến gắn kết chúng với loài người mãi mãi sẽ bắt đầu.', N'Adam Wingard', N'Rebecca Hall; Brian Tyree Henry; Dan Stevens; Kaylee Hottle; Alex Ferns; Fala Chen,...', 13, N'Hành Động, Phiêu Lưu')
INSERT [dbo].[Phim] ([MaPhim], [TenPhim], [QuocGia], [NgayPhatHanh], [ThoiLuong], [MoTa], [DaoDien], [DienVien], [DoTuoi], [LoaiPhim]) VALUES (3, N'Phim 3', N'Mỹ', CAST(N'2024-03-29' AS Date), 115, N'Kong và Godzilla - hai sinh vật vĩ đại huyền thoại, hai kẻ thủ truyền kiếp sẽ cùng bắt tay thực thi một sứ mệnh chung mang tính sống còn để bảo vệ nhân loại, và trận chiến gắn kết chúng với loài người mãi mãi sẽ bắt đầu.', N'Adam Wingard', N'Rebecca Hall; Brian Tyree Henry; Dan Stevens; Kaylee Hottle; Alex Ferns; Fala Chen,...', 13, N'Hành Động, Phiêu Lưu')
SET IDENTITY_INSERT [dbo].[Phim] OFF
GO
SET IDENTITY_INSERT [dbo].[PhongChieu] ON 

INSERT [dbo].[PhongChieu] ([MaPhong], [TenPhong], [soGhe]) VALUES (1, N'A1', 40)
SET IDENTITY_INSERT [dbo].[PhongChieu] OFF
GO
SET IDENTITY_INSERT [dbo].[SuatChieu] ON 

INSERT [dbo].[SuatChieu] ([MaSuatChieu], [GioBatDau], [PhongChieuMaPhong], [MaPhim]) VALUES (5, CAST(N'2024-04-23T09:00:00.000' AS DateTime), 1, 1)
INSERT [dbo].[SuatChieu] ([MaSuatChieu], [GioBatDau], [PhongChieuMaPhong], [MaPhim]) VALUES (9, CAST(N'2024-04-23T12:00:00.000' AS DateTime), 1, 1)
INSERT [dbo].[SuatChieu] ([MaSuatChieu], [GioBatDau], [PhongChieuMaPhong], [MaPhim]) VALUES (10, CAST(N'2024-04-23T05:00:00.000' AS DateTime), 1, 1)
SET IDENTITY_INSERT [dbo].[SuatChieu] OFF
GO
ALTER TABLE [dbo].[Ghe]  WITH CHECK ADD  CONSTRAINT [FKGhe662327] FOREIGN KEY([PhongChieuMaPhong])
REFERENCES [dbo].[PhongChieu] ([MaPhong])
GO
ALTER TABLE [dbo].[Ghe] CHECK CONSTRAINT [FKGhe662327]
GO
ALTER TABLE [dbo].[GheSuatChieu]  WITH CHECK ADD  CONSTRAINT [FKGheSuatChi492824] FOREIGN KEY([SuatChieuMaSuatChieu])
REFERENCES [dbo].[SuatChieu] ([MaSuatChieu])
GO
ALTER TABLE [dbo].[GheSuatChieu] CHECK CONSTRAINT [FKGheSuatChi492824]
GO
ALTER TABLE [dbo].[GheSuatChieu]  WITH CHECK ADD  CONSTRAINT [FKGheSuatChi995007] FOREIGN KEY([GheMaGhe])
REFERENCES [dbo].[Ghe] ([MaGhe])
GO
ALTER TABLE [dbo].[GheSuatChieu] CHECK CONSTRAINT [FKGheSuatChi995007]
GO
ALTER TABLE [dbo].[SuatChieu]  WITH CHECK ADD  CONSTRAINT [FKSuatChieu352641] FOREIGN KEY([PhongChieuMaPhong])
REFERENCES [dbo].[PhongChieu] ([MaPhong])
GO
ALTER TABLE [dbo].[SuatChieu] CHECK CONSTRAINT [FKSuatChieu352641]
GO
ALTER TABLE [dbo].[SuatChieu]  WITH CHECK ADD  CONSTRAINT [FKSuatChieu631621] FOREIGN KEY([MaPhim])
REFERENCES [dbo].[Phim] ([MaPhim])
GO
ALTER TABLE [dbo].[SuatChieu] CHECK CONSTRAINT [FKSuatChieu631621]
GO
ALTER TABLE [dbo].[VeXemPhim]  WITH CHECK ADD  CONSTRAINT [FKVeXemPhim284628] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[VeXemPhim] CHECK CONSTRAINT [FKVeXemPhim284628]
GO
ALTER TABLE [dbo].[VeXemPhim]  WITH CHECK ADD  CONSTRAINT [FKVeXemPhim406206] FOREIGN KEY([GheSuatChieuMaGheSC])
REFERENCES [dbo].[GheSuatChieu] ([MaGheSC])
GO
ALTER TABLE [dbo].[VeXemPhim] CHECK CONSTRAINT [FKVeXemPhim406206]
GO
ALTER TABLE [dbo].[VeXemPhim]  WITH CHECK ADD  CONSTRAINT [FKVeXemPhim507970] FOREIGN KEY([KhachHangCCCD])
REFERENCES [dbo].[KhachHang] ([CCCD])
GO
ALTER TABLE [dbo].[VeXemPhim] CHECK CONSTRAINT [FKVeXemPhim507970]
GO
/****** Object:  Trigger [dbo].[insertSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create   trigger [dbo].[insertSuatChieu]
on [dbo].[SuatChieu]
instead of insert as
begin
	declare @startTime dateTime
	declare @maPhong int
	declare @maPhim int
	select @startTime = i.GioBatDau, @maPhim = i.MaPhim, @maPhong = i.PhongChieuMaPhong from inserted i
	if (dbo.isValidTimeSuatChieu(@startTime, @maPhong, @maPhim) = 1)
	begin
		insert into SuatChieu values(@startTime, @maPhong, @maPhim)
		print 'Oke them r'
	end
	else print 'Trung r khong them duoc'
end
GO
ALTER TABLE [dbo].[SuatChieu] ENABLE TRIGGER [insertSuatChieu]
GO
/****** Object:  Trigger [dbo].[updateSuatChieu]    Script Date: 4/23/2024 3:14:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create   trigger [dbo].[updateSuatChieu]
on [dbo].[SuatChieu]
instead of update as
begin
	declare @maSC int
	declare @startTime dateTime
	declare @maPhong int
	declare @maPhim int
	select @startTime = i.GioBatDau, @maPhim = i.MaPhim, @maPhong = i.PhongChieuMaPhong, @maSC = i.MaSuatChieu from inserted i

	delete SuatChieu where MaSuatChieu = @maSC

	if (dbo.isValidTimeSuatChieu(@startTime, @maPhong, @maPhim) = 0)
	begin
		print 'Update d duoc rollback lai nhe'
		rollback
	end
	else
	begin
		insert into SuatChieu values(@startTime, @maPhong, @maPhim)
	end
end
GO
ALTER TABLE [dbo].[SuatChieu] ENABLE TRIGGER [updateSuatChieu]
GO
USE [master]
GO
ALTER DATABASE [Java_RapChieuPhim] SET  READ_WRITE 
GO
