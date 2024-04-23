package test;

import java.util.Date;

import model.Phim;

public class TestEntity {
	public static void main(String[] args) {
		Phim p1 = new Phim(1, "Kungfu Panda", "Trung Quoc", new java.sql.Date(2024, 4, 4), 120, "Suc dong vat đánh nhau", "Thình Vĩnh Phát", "Thình Vĩnh Phát", 16, "Kịch tính, Bạo lực");
		System.out.println(p1);
	}
}
