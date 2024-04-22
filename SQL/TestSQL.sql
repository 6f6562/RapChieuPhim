
--create table
CREATE TABLE Ghe (MaGhe int IDENTITY NOT NULL, HangGhe nvarchar(3) NULL, SoGhe int NOT NULL, PhongChieuMaPhong int NOT NULL, PRIMARY KEY (MaGhe));
CREATE TABLE GheSuatChieu (MaGheSC int IDENTITY NOT NULL, SuatChieuMaSuatChieu int NOT NULL, GheMaGhe int NOT NULL, TrangThai bit NULL, GiaTien float(10) NULL, PRIMARY KEY (MaGheSC));
CREATE TABLE KhachHang (CCCD nvarchar(20) NOT NULL, SDT nvarchar(12) NULL, Tuoi int NOT NULL, PRIMARY KEY (CCCD));
CREATE TABLE NhanVien (MaNhanVien int IDENTITY NOT NULL, TenNhanVien nvarchar(255) NULL, ChucVu nvarchar(255) NULL, MoTaCongViec nvarchar(255) NULL, NgaySinh date NULL, TaiKhoan nvarchar(255) NULL, MatKhau nvarchar(255) NULL, PRIMARY KEY (MaNhanVien));
CREATE TABLE Phim (MaPhim int IDENTITY NOT NULL, TenPhim nvarchar(255) NULL, QuocGia nvarchar(255) NULL, NgayPhatHanh date NULL, ThoiLuong int NOT NULL, MoTa nvarchar(255) NULL, DaoDien nvarchar(255) NULL, DienVien nvarchar(255) NULL, DoTuoi int NOT NULL, LoaiPhim nvarchar(255) NULL, PRIMARY KEY (MaPhim));
CREATE TABLE PhongChieu (MaPhong int IDENTITY NOT NULL, TenPhong nvarchar(10) NULL, soGhe int NULL, PRIMARY KEY (MaPhong));
CREATE TABLE SuatChieu (MaSuatChieu int IDENTITY NOT NULL, GioBatDau datetime NULL, PhongChieuMaPhong int NOT NULL, MaPhim int NOT NULL, PRIMARY KEY (MaSuatChieu));
CREATE TABLE VeXemPhim (MaVe int IDENTITY NOT NULL, MaNhanVien int NOT NULL, KhachHangCCCD nvarchar(20) NOT NULL, GheSuatChieuMaGheSC int NOT NULL, NgayDatVe datetime NULL, TongTien float(10) NOT NULL, KhuyenMai float(10) NOT NULL, PRIMARY KEY (MaVe));
ALTER TABLE SuatChieu ADD CONSTRAINT FKSuatChieu352641 FOREIGN KEY (PhongChieuMaPhong) REFERENCES PhongChieu (MaPhong);
ALTER TABLE VeXemPhim ADD CONSTRAINT FKVeXemPhim284628 FOREIGN KEY (MaNhanVien) REFERENCES NhanVien (MaNhanVien);
ALTER TABLE VeXemPhim ADD CONSTRAINT FKVeXemPhim507970 FOREIGN KEY (KhachHangCCCD) REFERENCES KhachHang (CCCD);
ALTER TABLE SuatChieu ADD CONSTRAINT FKSuatChieu631621 FOREIGN KEY (MaPhim) REFERENCES Phim (MaPhim);
ALTER TABLE VeXemPhim ADD CONSTRAINT FKVeXemPhim406206 FOREIGN KEY (GheSuatChieuMaGheSC) REFERENCES GheSuatChieu (MaGheSC);
ALTER TABLE GheSuatChieu ADD CONSTRAINT FKGheSuatChi995007 FOREIGN KEY (GheMaGhe) REFERENCES Ghe (MaGhe);
ALTER TABLE GheSuatChieu ADD CONSTRAINT FKGheSuatChi492824 FOREIGN KEY (SuatChieuMaSuatChieu) REFERENCES SuatChieu (MaSuatChieu);
ALTER TABLE Ghe ADD CONSTRAINT FKGhe662327 FOREIGN KEY (PhongChieuMaPhong) REFERENCES PhongChieu (MaPhong);

--Phim
insert into Phim 
values(N'GODZILLA X KONG: ĐẾ CHẾ MỚI', N'Mỹ', '2024-3-29', 115, N'Kong và Godzilla - hai sinh vật vĩ đại huyền thoại, hai kẻ thủ truyền kiếp sẽ cùng bắt tay thực thi một sứ mệnh chung mang tính sống còn để bảo vệ nhân loại, và trận chiến gắn kết chúng với loài người mãi mãi sẽ bắt đầu.'
		, N'Adam Wingard', N'Rebecca Hall; Brian Tyree Henry; Dan Stevens; Kaylee Hottle; Alex Ferns; Fala Chen,...', 13, N'Hành Động, Phiêu Lưu')
select * from Phim

--Phong
insert into PhongChieu
values('A1', 40)
select * from PhongChieu

--SuatChieu
insert into SuatChieu
values('2024-4-23 6:0:0', 1, 1)

select * from SuatChieu

--Ghe
insert into Ghe
values('A',1,1)
select * from Ghe



go
--1: Lấy startTime
--2: lấy EndTime
create or alter function getTimeSuatChieu(@maSC int, @mode int)
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
--Function kiểm tra thời gian bắt đầu, kết thúc có nằm trong thời gian của một xuất chiếu nào không 
go
create or alter function isTimeBetweenSuatChieu(@maSC int, @startTime datetime, @endTime dateTime)
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
	if (DATEDIFF(MINUTE, @endTime,  dbo.getTimeSuatChieu(@maSC, 1)) < @prepareTime)
		return 0
	return 1
end

go
--function Check Giờ bắt đầu của suất chiếu
go
create or alter function isValidTimeSuatChieu(@startTime datetime, @phongChieu int, @maPhim int)
returns int
as
begin
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

go
select * from SuatChieu

declare @status int
set @status = dbo.isValidTimeSuatChieu('2024-4-23 7:0:0', 1, 1)
if @status = 1 print 'Oke deo trung'
else print 'Trung cmnr'

--Trigger insert cho Suất chiếu
go
create or alter trigger insertSuatChieu
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
--Test trigger
insert into SuatChieu values('2024-4-23 9:0:0', 1, 1)

--Trigger update cho Suất chiếu
go
create or alter trigger updateSuatChieu
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

--Test Trigger update

select * from SuatChieu
update SuatChieu
set GioBatDau = '2024-4-23 7:30:0'
where MaSuatChieu = 6
select dbo.isValidTimeSuatChieu('2024-4-23 5:30:0', 1,1)

