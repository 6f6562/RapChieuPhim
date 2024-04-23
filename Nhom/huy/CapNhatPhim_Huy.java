package huy;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CapNhatPhim extends JPanel
{
	private JLabel lbTieuDe;
	private JTextField tfMaPhim;
	private JTextField tfTenPhim;
	private JTextField tfTuoi;
	private JTextField tfNgayPhatHanh;
	private JTextField tfDaoDien;
	private JTextField tfThoiLuong;
	private JTextField tfDienVien;
	private JTextField tfQuocGia;
	private JTextField tfLoaiPhim;
	private JTextArea taMoTa;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private DefaultTableModel modelPhim;
	private JTable tablePhim;
	Color xanh = new Color (90, 170, 240);
	Color trang = new Color (225, 225, 225);
	Font arial = new Font("Arial", Font.BOLD, 14);

	public CapNhatPhim() 
	{
		super();
		setLayout(new BorderLayout());
		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
			// TieuDe
		JPanel pnTieuDe = new JPanel();
		lbTieuDe = new JLabel("Quản lý phim - Cập nhập phim");
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 24));
		lbTieuDe.setForeground(xanh);
		pnTieuDe.add(lbTieuDe);
		
		pnNorth.add(pnTieuDe, BorderLayout.NORTH);
			// Form
		JPanel pnForm = new JPanel();
		pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));
				// MaPhim
		JPanel pnMaPhim = new JPanel();
		pnMaPhim.setLayout(new BoxLayout(pnMaPhim, BoxLayout.X_AXIS));
		pnMaPhim.add(Box.createHorizontalStrut(5));
		JLabel lbMaPhim = new JLabel("Mã phim: ");
		lbMaPhim.setFont(arial);
		pnMaPhim.add(lbMaPhim );
		pnMaPhim.add(Box.createHorizontalStrut(50));
		pnMaPhim.add(tfMaPhim = new JTextField());
		tfMaPhim.setEditable(false);
		tfMaPhim.setFont(arial);
		pnMaPhim.add(Box.createHorizontalStrut(413));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnMaPhim);
				// TenPhim - DoTuoi
		JPanel pnTenTuoi = new JPanel();
		pnTenTuoi.setLayout(new BoxLayout(pnTenTuoi, BoxLayout.X_AXIS));
		pnTenTuoi.add(Box.createHorizontalStrut(5));
		JLabel lbTenPhim = new JLabel("Tên phim: ");
		lbTenPhim.setFont(arial);
		pnTenTuoi.add(lbTenPhim);
		pnTenTuoi.add(Box.createHorizontalStrut(45));
		pnTenTuoi.add(tfTenPhim = new JTextField());
		tfTenPhim.setFont(arial);
		tfTenPhim.setBackground(trang);
		tfTenPhim.setSelectionColor(Color.white);
		tfTenPhim.setForeground(xanh);
		pnTenTuoi.add(Box.createHorizontalStrut(80));
		JLabel lbDoTuoi = new JLabel("Độ tuổi: ");
		lbDoTuoi.setFont(arial);
		pnTenTuoi.add(lbDoTuoi);
		pnTenTuoi.add(Box.createHorizontalStrut(90));
		pnTenTuoi.add(tfTuoi = new JTextField());
		tfTuoi.setFont(arial);
		tfTuoi.setBackground(trang);
		tfTuoi.setSelectionColor(Color.white);
		tfTuoi.setForeground(xanh);
		pnTenTuoi.add(Box.createHorizontalStrut(32));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnTenTuoi);
				// NgayPhatHanh - DaoDien
		JPanel pnNgayPHvaDaoDien = new JPanel();
		pnNgayPHvaDaoDien.setLayout(new BoxLayout(pnNgayPHvaDaoDien, BoxLayout.X_AXIS));
		pnNgayPHvaDaoDien.add(Box.createHorizontalStrut(5));
		JLabel lbNgayPH = new JLabel("Ngày phát hành: ");
		lbNgayPH.setFont(arial);
		pnNgayPHvaDaoDien.add(lbNgayPH);
		pnNgayPHvaDaoDien.add(Box.createHorizontalStrut(2));
		pnNgayPHvaDaoDien.add(tfNgayPhatHanh = new JTextField());
		tfNgayPhatHanh.setFont(arial);
		tfNgayPhatHanh.setBackground(trang);
		tfNgayPhatHanh.setSelectionColor(Color.white);
		tfNgayPhatHanh.setForeground(xanh);
		pnNgayPHvaDaoDien.add(Box.createHorizontalStrut(80));
		JLabel lbDaoDien = new JLabel("Đạo diễn: ");
		lbDaoDien.setFont(arial);
		pnNgayPHvaDaoDien.add(lbDaoDien);
		pnNgayPHvaDaoDien.add(Box.createHorizontalStrut(80));
		pnNgayPHvaDaoDien.add(tfDaoDien = new JTextField());
		tfDaoDien.setFont(arial);
		tfDaoDien.setBackground(trang);
		tfDaoDien.setSelectionColor(Color.white);
		tfDaoDien.setForeground(xanh);
		pnNgayPHvaDaoDien.add(Box.createHorizontalStrut(32));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnNgayPHvaDaoDien);
				// ThoiLuong - DienVien
		JPanel pnThoiLuongvaDienVien = new JPanel();
		pnThoiLuongvaDienVien.setLayout(new BoxLayout(pnThoiLuongvaDienVien, BoxLayout.X_AXIS));
		pnThoiLuongvaDienVien.add(Box.createHorizontalStrut(5));
		JLabel lbThoiLuong = new JLabel("Thời lượng: ");
		lbThoiLuong.setFont(arial);
		pnThoiLuongvaDienVien.add(lbThoiLuong);
		pnThoiLuongvaDienVien.add(Box.createHorizontalStrut(32));
		pnThoiLuongvaDienVien.add(tfThoiLuong = new JTextField());
		tfThoiLuong.setFont(arial);
		tfThoiLuong.setBackground(trang);
		tfThoiLuong.setSelectionColor(Color.white);
		tfThoiLuong.setForeground(xanh);
		pnThoiLuongvaDienVien.add(Box.createHorizontalStrut(74));
		JLabel lbDienVien = new JLabel("Diễn Viên: ");
		lbDienVien.setFont(arial);
		pnThoiLuongvaDienVien.add(lbDienVien);
		pnThoiLuongvaDienVien.add(Box.createHorizontalStrut(78));
		pnThoiLuongvaDienVien.add(tfDienVien = new JTextField());
		tfDienVien.setFont(arial);
		tfDienVien.setBackground(trang);
		tfDienVien.setSelectionColor(Color.white);
		tfDienVien.setForeground(xanh);
		pnThoiLuongvaDienVien.add(Box.createHorizontalStrut(32));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnThoiLuongvaDienVien);
				// QuocGia - LoaiPhim
		JPanel pnQuocGiavaLoaiPhim = new JPanel();
		pnQuocGiavaLoaiPhim.setLayout(new BoxLayout(pnQuocGiavaLoaiPhim, BoxLayout.X_AXIS));
		pnQuocGiavaLoaiPhim.add(Box.createHorizontalStrut(5));
		JLabel lbQuocGia = new JLabel("Quốc gia: ");
		lbQuocGia.setFont(arial);
		pnQuocGiavaLoaiPhim.add(lbQuocGia);
		pnQuocGiavaLoaiPhim.add(Box.createHorizontalStrut(49));
		pnQuocGiavaLoaiPhim.add(tfQuocGia = new JTextField());
		tfQuocGia.setFont(arial);
		tfQuocGia.setBackground(trang);
		tfQuocGia.setSelectionColor(Color.white);
		tfQuocGia.setForeground(xanh);
		pnQuocGiavaLoaiPhim.add(Box.createHorizontalStrut(74));
		JLabel lbLoaiPhim = new JLabel("Loại phim: ");
		lbLoaiPhim.setFont(arial);
		pnQuocGiavaLoaiPhim.add(lbLoaiPhim);
		pnQuocGiavaLoaiPhim.add(Box.createHorizontalStrut(78));
		pnQuocGiavaLoaiPhim.add(tfLoaiPhim = new JTextField());
		tfLoaiPhim.setFont(arial);
		tfLoaiPhim.setBackground(trang);
		tfLoaiPhim.setSelectionColor(Color.white);
		tfLoaiPhim.setForeground(xanh);
		pnQuocGiavaLoaiPhim.add(Box.createHorizontalStrut(32));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnQuocGiavaLoaiPhim);
				// MoTa
		JPanel pnMoTa = new JPanel();
		pnMoTa.setLayout(new BoxLayout(pnMoTa, BoxLayout.X_AXIS));
		pnMoTa.add(Box.createHorizontalStrut(5));
		JLabel lbMoTa = new JLabel("Mô tả:   ");
		lbMoTa.setFont(arial);
		pnMoTa.add(lbMoTa);
		pnMoTa.add(taMoTa = new JTextArea());
		taMoTa.setFont(arial);
		taMoTa.setBackground(trang);
		taMoTa.setSelectionColor(Color.white);
		taMoTa.setForeground(xanh);
		taMoTa.setRows(3);
		pnMoTa.add(Box.createHorizontalStrut(32));
		pnForm.add(Box.createVerticalStrut(5));
		pnForm.add(pnMoTa);
		
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
		pnNorth.add(pnChucNang, BorderLayout.SOUTH);

		add(pnNorth, BorderLayout.NORTH);
		// Table: Center
		JPanel pnTable = new JPanel(new BorderLayout());
		String[] cols= {"Mã phim", "Tên phim", "Quốc gia", "Ngày phát hành", "Thời lượng", "Mô tả",
						"Đạo diễn", "Diễn viên", "Độ tuổi"};
		modelPhim = new DefaultTableModel(cols,0);
		tablePhim = new JTable(modelPhim);
		pnTable.add(new JScrollPane(tablePhim));
		
		add(pnTable,BorderLayout.CENTER);
	}
}
