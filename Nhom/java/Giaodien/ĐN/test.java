package ĐN;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.Point2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class test {
	JFrame jf = new JFrame();
	private JTextField tendangnhap_txt;
	private JTextField matkhau_txt;
	
	public test() {
		jf.setTitle("Hệ thống quản lý rạp chiếu phim");
		jf.setSize(700,600);
		jf.setLocationRelativeTo(null);
		
		
		// Tiêu đề
				JPanel tieude_panel = new GradientPanel();
				JLabel tieude_label = new JLabel("Đăng nhập");
				tieude_label.setForeground(Color.WHITE);
				tieude_label.setFont(new Font("Minion Pro Cond", Font.PLAIN, 45));
				tieude_panel.add(tieude_label);
				
				
				
				// form đăng nhập
				JPanel form_dangnhap = new GradientPanel();
				form_dangnhap.setLayout(new BoxLayout(form_dangnhap, 1));
					JPanel anh_dang_nhap_pn = new JPanel();
				JLabel anh_dang_nhap = new JLabel(" ");
				JPanel dangnhap_textfield = new GradientPanel();
				anh_dang_nhap.setBorder(BorderFactory.createEmptyBorder(30,120,30,250));
				anh_dang_nhap.setFont(new Font("Tahoma", Font.PLAIN, 6));
				anh_dang_nhap.setIcon(new ImageIcon(test.class.getResource("/image/tải xuống-Photoroom.png-Photoroom.png")));
				anh_dang_nhap_pn.add(anh_dang_nhap);
				
				form_dangnhap.add(anh_dang_nhap,new BorderLayout().NORTH);
				
			
				// tendangnhap và mật khẩu
				JPanel tendangnhap = new GradientPanel();
				JPanel matkhau = new GradientPanel();
				
				Listener ac = new Listener(this);
				JLabel tendangnhap_label = new JLabel("Tài khoản:");
				tendangnhap_label.setForeground(Color.WHITE);
				tendangnhap_label.setFont(new Font("Tahoma", Font.BOLD, 20));
				 tendangnhap_txt = new JTextField(30);
				tendangnhap_txt.setPreferredSize(new Dimension(100,35));
				
				tendangnhap.add(tendangnhap_label);
				tendangnhap_txt.requestFocus();
				tendangnhap.add(tendangnhap_txt);
				dangnhap_textfield.add(tendangnhap, new BorderLayout().NORTH);
			
				JLabel matkhau_label = new JLabel("Mật khẩu:");
				matkhau_label.setForeground(Color.WHITE);
				matkhau_label.setFont(new Font("Tahoma", Font.BOLD, 20));
				 matkhau_txt = new JTextField(30);
				matkhau_txt.setPreferredSize(new Dimension(100,35));
				matkhau.add(matkhau_label);
				matkhau.add(matkhau_txt);
				dangnhap_textfield.add(matkhau, new BorderLayout().SOUTH);
			
				
				
				// buttons
				
				JPanel nut_panel = new GradientPanel();
				
				JButton dangnhap_btn  = new JButton("Đăng nhập");
				dangnhap_btn.addActionListener(ac);
				dangnhap_btn.setIcon(new ImageIcon(test.class.getResource("/image/login.png")));
				JButton huy_btn  = new JButton("Hủy");
				huy_btn.addActionListener(ac);
				huy_btn.setIcon(new ImageIcon(test.class.getResource("/image/close.png")));
				
				
				nut_panel.add(dangnhap_btn);
				nut_panel.add(huy_btn);
				
				dangnhap_textfield.setPreferredSize(new Dimension(150,100));
				form_dangnhap.add(dangnhap_textfield,new BorderLayout().CENTER);
				form_dangnhap.add(nut_panel,new BorderLayout().NORTH);
				
				
		jf.add(tieude_panel,new BorderLayout().NORTH);
		jf.add(form_dangnhap,new BorderLayout().CENTER);
		jf.setVisible(true);
	}
	 static class GradientPanel extends JPanel {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);

	            Graphics2D g2d = (Graphics2D) g;

	        
	            Color color1 = new Color(30, 36, 46);
	            Color color2 = new Color(174, 45, 60);
	            GradientPaint gradient = new GradientPaint(
	                    new Point2D.Double(0, 0), color1,
	                    new Point2D.Double(getWidth(), getHeight()), color2);
	         
	            
	            g2d.setPaint(gradient);
	            g2d.fillRect(0, 0, getWidth(), getHeight());
	        }
	    }
	 
	 
	 public void dangnhap() {
		 
	 }
	 
	 public void huy() {
		 tendangnhap_txt.setText("");
		 matkhau_txt.setText("");
		 tendangnhap_txt.requestFocus();
	 }
         
         
         public static void main(String[] args){
         test test = new test();
         }
}
