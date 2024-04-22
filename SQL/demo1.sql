create DataBase RapChieuPhim
use RapChieuPhim

create table Phim
(
	maPhim int primary key identity,
	tenPhim nvarchar(50),
	quocGia nvarchar(50),
	ngayPhatHanh date,
	thoiLuong int,
	moTa nvarchar(MAX),
	daoDien nvarchar(50),
	dienVien nvarchar(50),
	doTuoi int,
	loaiPhim nvarchar(50)
)

create table XuatChieu(
	maXuatChieu int primary key identity,
	gioBatDau date,
	phongChieu int,
	foreign key(phongChieu) references PhongChieu(maPhong)
)

create table PhongChieu(
	maPhong int primary key identity,
	tenPhong nvarchar(10)
)

create table Ghe(
	maGhe int primary key identity,
	hangGhe nvarchar(5),
	soGhe int
)

create table veXemPhim(
	maVe int primary key identity,
	nhanVien int,
	xuatChieu int,
	phim int,
	ghe int,
	phongChieu int,
)

create table KhachHang(
	CCCD nvarchar(20) primary key,
	sdt nvarchar(20),
	tuoi int
)

create table NhanVien(
	maNhanVien int primary key identity,
	tenNhanVien nvarchar(50),
	chucVu nvarchar(50),
	moTaCongViec nvarchar(50),
	ngaySinh date,
	taiKhoan nvarchar(50),
	matKhau nvarchar(50)
)

create table DanhSachXuatChieu(
	maXuatChieu int,
	maPhim int,
	gia float,
	primary key(maXuatChieu, maphim),
)

create table Ghe_PhongChieu(
	maPhong int,
	maGhe int,
	primary key(maPhong, maGhe),
	tinhTrang bit
)

create table DanhSachVe(
	ngayDatVe date,
	thanhTien float,
	khuyenMai float,
	khachHang nvarchar(20),
	vePhim int,
	foreign key(khachHang) references KhachHang(CCCD),
	foreign key(vePhim) references veXemPhim(maVe)
)

alter table [dbo].[DanhSachXuatChieu]
add constraint FK_DSXC_XC foreign key(maXuatChieu) references XuatChieu(maXuatChieu)

alter table [dbo].[DanhSachXuatChieu]
add constraint FK_DSXC_P foreign key(maphim) references Phim(maPhim)

alter table Ghe_PhongChieu
add constraint FK_GPC_G foreign key(maPhong) references PhongChieu(maPhong)

alter table Ghe_PhongChieu
add constraint FK_GPC_PC foreign key(maGhe) references Ghe(maGhe)

alter table VeXemPhim
add constraint FK_VXP_NV foreign key(nhanVien) references NhanVien(maNhanVien)

alter table VeXemPhim
add constraint FK_VXP_XC foreign key(xuatChieu) references XuatChieu(maXuatChieu)

alter table VeXemPhim
add constraint FK_VXP_P foreign key(phim) references Phim(maPhim)

xuatChieu int,
	phim int,
	ghe int,
	phongChieu int,