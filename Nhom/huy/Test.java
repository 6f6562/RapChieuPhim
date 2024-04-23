package huy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) 
	{
		JFrame a = new JFrame("Demo");
		a.setSize(700,500);
		a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
//		a.setResizable(false);
		a.setLocationRelativeTo(null);
		a.add(new CapNhatSuatChieu());
		a.setVisible(true);
		
//		SQL add data
//		for(int phong=1; phong<=6; phong++)
//			{
//				Random random = new Random();
//				Set<Integer> dsGioChieu = new HashSet<>();
//				while (dsGioChieu.size() < 5) // max 5
//				{
//					int randomNumber = random.nextInt(24); // Sinh số ngẫu nhiên từ 0 đến 23
//					if (isSeparatedEnough(dsGioChieu, randomNumber)) 
//						dsGioChieu.add(randomNumber); // Thêm số vào tập hợp nếu thỏa mãn điều kiện
//				}
//				for(int gio: dsGioChieu)
//				{
//					int phim = random.nextInt(6)+1;
//					System.out.println("insert into SuatChieu values('2024-4-25 " + gio + ":0:0', "
//							+ phong + ", " + phim + ")");
//				}
//					
//			}
		
	}
	    
	    // Kiểm tra xem số mới sinh ra có cách các số trong tập hợp ít nhất 3 không
//	    private static boolean isSeparatedEnough(Set<Integer> numbers, int newNumber) 
//	    {
//	        for (int number : numbers)
//	            if (Math.abs(newNumber - number) < 3)
//	                return false;
//	        return true;
//	    }
}
