package thongtinphim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import giaodienchinh1.Giaodienchinh;

public class Thôngtinphim {
	JFrame jf = new JFrame();
	
	// dữ liệu
	String linkhinhanh = "god-x-kong-500_1711942287737.jpg";
	String tenphim = "Godzilla vs Kong";
	String daodien = "Josh Hutterson";
	String dienvien = "Rebecca Hall ,Dan Stevens ,Rachel House";
	String theloai = "Giả Tưởng Hành động phiêu lưu";
	String khoichieu = new Date() + "";
	String thoiluong = "115 phút";
	String ngonngu = "Tiếng anh";
	String dotuoi = "18 tuổi trở lên";
	
	
	public Thôngtinphim() {
		jf.setTitle("Hệ thống quản lý rạp chiếu phim");
		jf.setSize(1000,600);
		jf.setLocationRelativeTo(null);
		
		
		//tiêu đề
//	JPanel	pnTieude = new JPanel();
//	JLabel lbTieude = new JLabel("Thông tin phim");
//	lbTieude.setFont(new Font("Arial",Font.BOLD,35));
//	pnTieude.setBackground(Color.getHSBColor(207 / 360f, 70 / 100f, 92 / 100f));
//	lbTieude.setForeground(Color.WHITE);
//	pnTieude.add(lbTieude);
	
		//giao diện chính
	JPanel pnGiaodien = new JPanel();
	JPanel pnHinhanh = new JPanel();
	JPanel pnThongtinphim =  new JPanel();
	pnThongtinphim.setLayout(new BoxLayout(pnThongtinphim,BoxLayout.Y_AXIS));

	
	//hình ảnh
	JLabel lbhinhanh = new JLabel();
	lbhinhanh.setIcon(new ImageIcon(Giaodienchinh.class.getResource("/image/" + linkhinhanh)));
	
	pnHinhanh.add(lbhinhanh);
	pnGiaodien.add(pnHinhanh,new FlowLayout().LEFT);
	
	
	
	// thông tin phim
	
	
	JPanel pnTenphim = new JPanel();
	JLabel lbTenphim = new JLabel(tenphim);
	lbTenphim.setFont(new Font("Arial",Font.BOLD,30));
	pnTenphim.setBorder(BorderFactory.createEmptyBorder(5,10,15,10));
	
	
	
	JPanel pnDaodien = new JPanel();
	JLabel lbDaodien = new JLabel("Đạo diễn: ");
	JLabel lbthongtinDaodien = new JLabel(daodien);
	lbthongtinDaodien.setFont(new Font("Arial",Font.ITALIC,15));
	lbDaodien.setFont(new Font("Arial",Font.BOLD,18));
	pnDaodien.setBorder(BorderFactory.createEmptyBorder(5,15,15,10));
	
	
	JPanel pnDienvien = new JPanel(new GridBagLayout());
	JLabel lbDienvien = new JLabel("Diễn viên: " );
	 GridBagConstraints gbc = new GridBagConstraints();
	JLabel lbthongtinDienvien = new JLabel(dienvien);
	lbthongtinDienvien.setFont(new Font("Arial",Font.ITALIC,15));
	lbDienvien.setFont(new Font("Arial",Font.BOLD,18));
	pnDienvien.setPreferredSize(new Dimension(500,50));
	pnDienvien.setBorder(BorderFactory.createEmptyBorder(5,95,15,10));
	
	
	JPanel pnTheloai = new JPanel();
	JLabel lbTheloai = new JLabel("Thể loại: ");
	JLabel lbthongtinTheloai = new JLabel(theloai);
	lbthongtinTheloai.setFont(new Font("Arial",Font.ITALIC,15));
	lbTheloai.setFont(new Font("Arial",Font.BOLD,20));
	pnTheloai.setBorder(BorderFactory.createEmptyBorder(5,20,15,10));
	
	
	JPanel pnKhoichieu = new JPanel();
	JLabel lbKhoichieu = new JLabel("Khởi chiếu: ");
	JLabel lbthongtinKhoichieu = new JLabel(khoichieu);
	lbthongtinKhoichieu.setFont(new Font("Arial",Font.ITALIC,15));
	lbKhoichieu.setFont(new Font("Arial",Font.BOLD,20));
	pnKhoichieu.setBorder(BorderFactory.createEmptyBorder(5,30,15,10));
	
	JPanel pnThoiluong = new JPanel();
	JLabel lbThoiluong = new JLabel("Thời lượng: ");
	JLabel lbthongtinThoiluong = new JLabel(thoiluong);
	lbthongtinThoiluong.setFont(new Font("Arial",Font.ITALIC,15));
	lbThoiluong.setFont(new Font("Arial",Font.BOLD,20));
	pnThoiluong.setBorder(BorderFactory.createEmptyBorder(5,10,15,10));
		
	
	JPanel pnNgongu = new JPanel();
	JLabel lbNgonngu = new JLabel("Ngôn ngữ: ");
	JLabel lbthongtinNgonngu = new JLabel(ngonngu);
	lbthongtinNgonngu.setFont(new Font("Arial",Font.ITALIC,15));
	lbNgonngu.setFont(new Font("Arial",Font.BOLD,20));
	pnNgongu.setBorder(BorderFactory.createEmptyBorder(5,10,15,10));
	
	JPanel pnDotuoi = new JPanel();
	JLabel lbDotuoi = new JLabel("Độ tuổi: ");
	JLabel lbthongtinDotuoi = new JLabel(dotuoi);
	lbthongtinDotuoi.setFont(new Font("Arial",Font.ITALIC,15));
	lbDotuoi.setFont(new Font("Arial",Font.BOLD,20));
	pnDotuoi.setBorder(BorderFactory.createEmptyBorder(5,10,15,10));
	
	
	pnTenphim.add(lbTenphim);
	
	pnDaodien.setLayout(new BoxLayout(pnDaodien, BoxLayout.X_AXIS));
	pnDaodien.add(lbDaodien);
	pnDaodien.add(Box.createHorizontalStrut(110));
	pnDaodien.add(lbthongtinDaodien);

    
	pnDienvien.setLayout(new BoxLayout(pnDienvien, BoxLayout.X_AXIS));
	pnDienvien.add(lbDienvien);
	 pnDienvien.add(Box.createHorizontalStrut(0));
	pnDienvien.add(lbthongtinDienvien);

	pnTheloai.setLayout(new BoxLayout(pnTheloai, BoxLayout.X_AXIS));
	pnTheloai.add(lbTheloai);
	pnTheloai.add(Box.createHorizontalStrut(5));
	pnTheloai.add(lbthongtinTheloai);
	
	
	pnKhoichieu.setLayout(new BoxLayout(pnKhoichieu, BoxLayout.X_AXIS));
	pnKhoichieu.add(lbKhoichieu);
	pnKhoichieu.add(Box.createHorizontalStrut(0));
	pnKhoichieu.add(lbthongtinKhoichieu);
	
	pnThoiluong.setLayout(new BoxLayout(pnThoiluong, BoxLayout.X_AXIS));
	pnThoiluong.add(lbThoiluong);
	pnThoiluong.add(Box.createHorizontalStrut(125));
	pnThoiluong.add(lbthongtinThoiluong);
	
	
	pnNgongu.setLayout(new BoxLayout(pnNgongu, BoxLayout.X_AXIS));
	pnNgongu.add(lbNgonngu);
	pnNgongu.add(Box.createHorizontalStrut(125));
	pnNgongu.add(lbthongtinNgonngu);
	
	pnDotuoi.setLayout(new BoxLayout(pnDotuoi, BoxLayout.X_AXIS));
	pnDotuoi.add(lbDotuoi);
	pnDotuoi.add(Box.createHorizontalStrut(130));
	pnDotuoi.add(lbthongtinDotuoi);
	
	
	// Nút đặt vé
	JPanel PnNutdatve = new JPanel();
	JButton BtnĐatve = new JButton("Đặt vé");
	BtnĐatve.setBackground(Color.RED);
	BtnĐatve.setForeground(Color.WHITE);
	BtnĐatve.setFont(new Font("Arial",Font.BOLD,20));
	
	
	BtnĐatve.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
	PnNutdatve.setBorder(BorderFactory.createEmptyBorder(5,10,15,10));
	PnNutdatve.add(BtnĐatve);
	
	
	
	
	pnThongtinphim.add(PnNutdatve,new FlowLayout().LEFT);
	pnThongtinphim.add(pnDotuoi,new FlowLayout().LEFT);
	pnThongtinphim.add(pnDienvien,new FlowLayout().LEFT);
	pnThongtinphim.add(pnKhoichieu,new FlowLayout().LEFT);
	pnThongtinphim.add(pnTheloai,new FlowLayout().LEFT);
	pnThongtinphim.add(pnThoiluong,new FlowLayout().LEFT);
	pnThongtinphim.add(pnNgongu,new FlowLayout().LEFT);
	pnThongtinphim.add(pnDaodien,new FlowLayout().LEFT);
	pnThongtinphim.add(pnTenphim,new FlowLayout().LEFT);

	
	pnGiaodien.add(pnThongtinphim);	
		
		
		
//		jf.add(pnTieude,new BorderLayout().NORTH);
		jf.add(pnGiaodien,new BorderLayout().CENTER);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Thôngtinphim test = new Thôngtinphim();
	}
	
	
}
