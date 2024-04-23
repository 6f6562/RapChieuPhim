package model;

import java.util.*;

public class Phim {
	
	private int maPhim;
	private String tenPhim;
	private String quocGia;
	private java.sql.Date ngayPhatHanh;
	private int thoiLuong;
	private String moTa;
	private String daoDien;
	private String dienVien;
	private int doTuoi;
	private String loaiPhim;
	public int getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(int maPhim) {
		this.maPhim = maPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}
	public void setNgayPhatHanh(java.sql.Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	public String getDienVien() {
		return dienVien;
	}
	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}
	public int getDoTuoi() {
		return doTuoi;
	}
	public void setDoTuoi(int doTuoi) {
		this.doTuoi = doTuoi;
	}
	public String getLoaiPhim() {
		return loaiPhim;
	}
	public void setLoaiPhim(String loaiPhim) {
		this.loaiPhim = loaiPhim;
	}
	@Override
	public String toString() {
		return "maPhim=" + maPhim + "| tenPhim=" + tenPhim + "| quocGia=" + quocGia + "| ngayPhatHanh=" + ngayPhatHanh
				+ "| thoiLuong=" + thoiLuong + "| moTa=" + moTa + "| daoDien=" + daoDien + "| dienVien=" + dienVien
				+ "| doTuoi=" + doTuoi + "| loaiPhim=" + loaiPhim;
	}
	public Phim(int maPhim, String tenPhim, String quocGia, java.sql.Date ngayPhatHanh, int thoiLuong, String moTa,
			String daoDien, String dienVien, int doTuoi, String loaiPhim) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.quocGia = quocGia;
		this.ngayPhatHanh = ngayPhatHanh;
		this.thoiLuong = thoiLuong;
		this.moTa = moTa;
		this.daoDien = daoDien;
		this.dienVien = dienVien;
		this.doTuoi = doTuoi;
		this.loaiPhim = loaiPhim;
	}
	public Phim() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}