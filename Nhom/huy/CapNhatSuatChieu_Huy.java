package huy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CapNhatSuatChieu extends JPanel
{
	Color xanh = new Color (90, 170, 240);
	Color trang = new Color (225, 225, 225);
	Font arial = new Font("Arial", Font.BOLD, 14);
	private JLabel lbTieuDe;
	private JLabel lbTenPhim;
	private JTextField tfTenPhim;
	private JLabel lbPhongChieu;
	private JTextField tfPhongChieu;
	private JLabel lbGioChieu;
	private JTextField tfGioChieu;
	private JLabel lbLocTen;
	private JComboBox cbTenPhim;
	private JLabel lbLocPhong;
	private JComboBox cbPhong;
	private JLabel lbLocNgay;
	private JComboBox cbNgay;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnloc;
	private DefaultTableModel modelSuatChieu;
	private JTable tableSuatChieu;
	
	public CapNhatSuatChieu() 
	{
		super();
		setLayout(new BorderLayout());
		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
			// TieuDe
		JPanel pnTieuDe = new JPanel();
		lbTieuDe = new JLabel("Quản lý suất chiếu - Cập nhập suất chiếu");
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 24));
		lbTieuDe.setForeground(xanh);
		pnTieuDe.add(lbTieuDe);
		
		pnNorth.add(pnTieuDe, BorderLayout.NORTH);
			// Form
		JPanel pnForm = new JPanel();
		pnForm.setLayout(new GridLayout(1,2));
				// ThongTin
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		pnThongTin.add(Box.createVerticalStrut(15));
					// TenPhim
		JPanel pnTenPhim = new JPanel();
		pnTenPhim.setLayout(new BoxLayout(pnTenPhim, BoxLayout.X_AXIS));
		pnTenPhim.add(Box.createHorizontalStrut(20));
		lbTenPhim = new JLabel("Tên phim: ");
		lbTenPhim.setFont(arial);
		pnTenPhim.add(lbTenPhim);
		pnTenPhim.add(Box.createHorizontalStrut(42));
		pnTenPhim.add(tfTenPhim = new JTextField());
		pnTenPhim.add(Box.createHorizontalStrut(20));
		tfTenPhim.setFont(arial);
		tfTenPhim.setBackground(trang);
		tfTenPhim.setSelectionColor(Color.white);
		tfTenPhim.setForeground(xanh);
		pnThongTin.add(pnTenPhim);
		pnThongTin.add(Box.createVerticalStrut(20));
					// PhongChieu
		JPanel pnPhongChieu = new JPanel();
		pnPhongChieu.setLayout(new BoxLayout(pnPhongChieu, BoxLayout.X_AXIS));
		pnPhongChieu.add(Box.createHorizontalStrut(20));
		lbPhongChieu = new JLabel("Phòng chiếu: ");
		lbPhongChieu.setFont(arial);
		pnPhongChieu.add(lbPhongChieu);
		pnPhongChieu.add(Box.createHorizontalStrut(20));
		pnPhongChieu.add(tfPhongChieu = new JTextField());
		pnPhongChieu.add(Box.createHorizontalStrut(20));
		tfPhongChieu.setFont(arial);
		tfPhongChieu.setBackground(trang);
		tfPhongChieu.setSelectionColor(Color.white);
		tfPhongChieu.setForeground(xanh);
		pnThongTin.add(pnPhongChieu);
		pnThongTin.add(Box.createVerticalStrut(20));
					// GioChieu
		JPanel pnGioChieu = new JPanel();
		pnGioChieu.setLayout(new BoxLayout(pnGioChieu, BoxLayout.X_AXIS));
		pnGioChieu.add(Box.createHorizontalStrut(20));
		lbGioChieu = new JLabel("Giờ chiếu: ");
		lbGioChieu.setFont(arial);
		pnGioChieu.add(lbGioChieu);
		pnGioChieu.add(Box.createHorizontalStrut(38));
		pnGioChieu.add(tfGioChieu = new JTextField());
		pnGioChieu.add(Box.createHorizontalStrut(20));
		tfGioChieu.setFont(arial);
		tfGioChieu.setBackground(trang);
		tfGioChieu.setSelectionColor(Color.white);
		tfGioChieu.setForeground(xanh);
		pnThongTin.add(pnGioChieu);
		pnThongTin.add(Box.createVerticalStrut(20));
		
		pnForm.add(pnThongTin);
				// Filter
		JPanel pnFilter = new JPanel();
		pnFilter.setLayout(new BoxLayout(pnFilter, BoxLayout.Y_AXIS));
		pnFilter.add(Box.createVerticalStrut(15));
					// LocTheoTen
		JPanel pnLocTen = new JPanel();
		pnLocTen.setLayout(new BoxLayout(pnLocTen, BoxLayout.X_AXIS));
		pnLocTen.add(Box.createHorizontalStrut(20));
		lbLocTen = new JLabel("Lọc theo tên: ");
		lbLocTen.setFont(arial);
		pnLocTen.add(lbLocTen);
		pnLocTen.add(Box.createHorizontalStrut(41));
		pnLocTen.add(cbTenPhim = new JComboBox());
		pnLocTen.add(Box.createHorizontalStrut(20));
		cbTenPhim.setFont(arial);
		cbTenPhim.setBackground(trang);
		cbTenPhim.setForeground(xanh);
		pnFilter.add(pnLocTen);
		pnFilter.add(Box.createVerticalStrut(20));
					// LocTheoPhong
		JPanel pnLocPhong = new JPanel();
		pnLocPhong.setLayout(new BoxLayout(pnLocPhong, BoxLayout.X_AXIS));
		pnLocPhong.add(Box.createHorizontalStrut(20));
		lbLocPhong = new JLabel("Lọc theo phòng: ");
		lbLocPhong.setFont(arial);
		pnLocPhong.add(lbLocPhong);
		pnLocPhong.add(Box.createHorizontalStrut(20));
		pnLocPhong.add(cbPhong = new JComboBox());
		pnLocPhong.add(Box.createHorizontalStrut(20));
		cbPhong.setFont(arial);
		cbPhong.setBackground(trang);
		cbPhong.setForeground(xanh);
		pnFilter.add(pnLocPhong);
		pnFilter.add(Box.createVerticalStrut(20));
					// LocTheoNgay
		JPanel pnLocNgay = new JPanel();
		pnLocNgay.setLayout(new BoxLayout(pnLocNgay, BoxLayout.X_AXIS));
		pnLocNgay.add(Box.createHorizontalStrut(20));
		lbLocNgay = new JLabel("Lọc theo ngày: ");
		lbLocNgay.setFont(arial);
		pnLocNgay.add(lbLocNgay);
		pnLocNgay.add(Box.createHorizontalStrut(29));
		pnLocNgay.add(cbNgay = new JComboBox());
		pnLocNgay.add(Box.createHorizontalStrut(20));
		cbNgay.setFont(arial);
		cbNgay.setBackground(trang);
		cbNgay.setForeground(xanh);
		pnFilter.add(pnLocNgay);
		pnFilter.add(Box.createVerticalStrut(20));
		
		pnForm.add(pnFilter);
		
		pnNorth.add(pnForm, BorderLayout.CENTER);
			// ChucNang
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));;
		pnChucNang.add(btnThem = new JButton("Thêm"));
		btnThem.setForeground(trang);
		btnThem.setBackground(xanh);
		btnThem.setFont(arial);
		pnChucNang.add(btnSua = new JButton("Sửa"));
		btnSua.setForeground(trang);
		btnSua.setBackground(xanh);
		btnSua.setFont(arial);
		pnChucNang.add(btnXoa = new JButton("Xóa"));
		btnXoa.setForeground(trang);
		btnXoa.setBackground(xanh);
		btnXoa.setFont(arial);
		pnChucNang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnXoaTrang.setForeground(trang);
		btnXoaTrang.setBackground(xanh);
		btnXoaTrang.setFont(arial);
		pnChucNang.add(btnloc = new JButton("Lọc"));
		btnloc.setForeground(trang);
		btnloc.setBackground(xanh);
		btnloc.setFont(arial);
		pnNorth.add(pnChucNang, BorderLayout.SOUTH);
		
		add(pnNorth, BorderLayout.NORTH);
		// Table: Center
		JPanel pnTable = new JPanel(new BorderLayout());
		String[] cols= {"Mã xuất chiếu", "Phim", "Phòng chiếu", "Giờ chiếu"};
		modelSuatChieu = new DefaultTableModel(cols,0);
		tableSuatChieu = new JTable(modelSuatChieu);
		pnTable.add(new JScrollPane(tableSuatChieu));
		
		add(pnTable,BorderLayout.CENTER);
	}
}
