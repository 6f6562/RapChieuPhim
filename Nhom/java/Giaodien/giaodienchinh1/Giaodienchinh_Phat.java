package giaodienchinh1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Giaodienchinh_Phat {
	JFrame jf = new JFrame();
	
	
	public Giaodienchinh_Phat() {
		this.view();
	}
	
	
	public void view() {
		jf.setTitle("Hệ thống quản lý rạp chiếu phim");
		jf.setSize(900,600);
		jf.setLocationRelativeTo(null);
		
		String tennhanvien = "Tèo";
		String manhanvien = "123234";
		String chucvu = "Nhân viên";
		
		// title
		JPanel header_pn = new JPanel();
		header_pn.setBackground(Color.BLUE);
		header_pn.setLayout(new GridLayout(0,2));
		JPanel thongtin_pn = new JPanel();
		thongtin_pn.setBackground(Color.getHSBColor(207 / 360f, 70 / 100f, 92 / 100f));
		
		
		JLabel tennhanvien_lb = new JLabel("Tên nhân viên: " + tennhanvien);
		tennhanvien_lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		tennhanvien_lb.setForeground(Color.WHITE);
		
		JLabel manhanvien_lb  = new JLabel("Mã nhân viên: " + manhanvien);
		manhanvien_lb.setForeground(Color.WHITE);
		manhanvien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel chucvu_lb = new JLabel("Chức vụ: "+ chucvu);
		chucvu_lb.setForeground(Color.WHITE);
		chucvu_lb.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		JPanel dangxuat_pn  = new JPanel();
		dangxuat_pn.setBackground(Color.getHSBColor(207 / 360f, 70 / 100f, 92 / 100f));
		JButton dangxuat_btn = new JButton("Đăng Xuất");
		dangxuat_btn.setBackground(Color.RED);
		dangxuat_btn.setForeground(Color.WHITE);
			
		thongtin_pn.setLayout(new BorderLayout());
		thongtin_pn.add(tennhanvien_lb, BorderLayout.NORTH);
		thongtin_pn.add(manhanvien_lb, BorderLayout.CENTER);
		thongtin_pn.add(chucvu_lb, BorderLayout.SOUTH);
		
		dangxuat_pn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dangxuat_pn.setBorder(BorderFactory.createEmptyBorder(10, 0,10, 0));
		dangxuat_pn.add(dangxuat_btn);
		
		header_pn.add(thongtin_pn,new BorderLayout().WEST);
		header_pn.add(dangxuat_pn,new BorderLayout().EAST);
	
		
		// menu 
		
		JPanel menu_pn = new JPanel();
		menu_pn.setLayout(new BoxLayout(menu_pn, BoxLayout.Y_AXIS));
		menu_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		menu_pn.setPreferredSize(new Dimension(200,100));
		
		JPanel phim_pn = new JPanel();
		JPanel Pchieu_pn = new JPanel();
		JPanel Ghe_pn = new JPanel();
		JPanel datve_pn = new JPanel();
		JPanel hinh_pn = new JPanel();
		JLabel hinh_lb = new JLabel();
		
		phim_pn.setBorder(BorderFactory.createEmptyBorder(10,10,-60,10));
		Pchieu_pn.setBorder(BorderFactory.createEmptyBorder(0,10,-60,10));
		Ghe_pn.setBorder(BorderFactory.createEmptyBorder(0,10,-60,10));
		datve_pn.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		hinh_pn.setBorder(BorderFactory.createEmptyBorder(0,0,-70,10));
		hinh_lb.setIcon(new ImageIcon(Giaodienchinh_Phat.class.getResource("/image/phim (1).jpg")));
		
		
		phim_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		Pchieu_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		Ghe_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		datve_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		hinh_pn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		
		JButton phim_btn = new JButton("Phim");
		JButton Pchieu_btn = new JButton("Phòng chiếu");
		JButton Ghe_btn = new JButton("Ghế");
		JButton datve_btn = new JButton("Đặt vé phim");
		
		phim_btn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		Pchieu_btn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		Ghe_btn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		datve_btn.setBackground(Color.getHSBColor(0.6f, 0.65f, 0.68f));
		

		phim_btn.setPreferredSize(new Dimension(300,100));
		Pchieu_btn.setPreferredSize(new Dimension(300,100));
		Ghe_btn.setPreferredSize(new Dimension(300,100));
		datve_btn.setPreferredSize(new Dimension(300,100));
	
		phim_btn.setBorder(BorderFactory.createEmptyBorder());
		Pchieu_btn.setBorder(BorderFactory.createEmptyBorder());
		Ghe_btn.setBorder(BorderFactory.createEmptyBorder());
		datve_btn.setBorder(BorderFactory.createEmptyBorder());
		
		phim_btn.setForeground(Color.WHITE);
		Pchieu_btn.setForeground(Color.WHITE);
		Ghe_btn.setForeground(Color.WHITE);
		datve_btn.setForeground(Color.WHITE);
		
		phim_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		Pchieu_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		Ghe_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		datve_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	
		
		phim_pn.add(phim_btn);
		Pchieu_pn.add(Pchieu_btn);
		Ghe_pn.add(Ghe_btn);
		datve_pn.add(datve_btn);
		hinh_pn.add(hinh_lb);		
		
		menu_pn.add(phim_pn);
		menu_pn.add(Pchieu_pn);
		menu_pn.add(Ghe_pn);
		menu_pn.add(datve_pn);
		menu_pn.add(hinh_pn);
		
		
		
		
		
		jf.add(header_pn,new BorderLayout().NORTH);
		jf.add(menu_pn,new BorderLayout().WEST);
		jf.setVisible(true);
	}
	
	
}
