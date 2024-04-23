package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.Database;
import model.Phim;

public class PhimDao {
	private ArrayList<Phim> list;
	
	public PhimDao()
	{
		list = new ArrayList();
	}
	
	public void getAll() {
		try {
			Database.getInstance().connect();
			Connection con = Database.getConnection();
			
			String sql = "select * from Phim";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()){
				int maPhim = rs.getInt(1);
				String tenPhim = rs.getString(2);
				String quocGia = rs.getString(3);
				Date ngayPhatHanh = rs.getDate(4);
				int thoiLuong = rs.getInt(5);
				String moTa = rs.getString(6);
				String daoDien = rs.getString(7);
				String dienVien = rs.getString(8);
				int doTuoi = rs.getInt(9);
				String loaiPhim = rs.getString(10);
				
				Phim p = new Phim(maPhim, tenPhim, quocGia, ngayPhatHanh, thoiLuong, moTa, daoDien, dienVien, doTuoi, loaiPhim);
				System.out.println(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
