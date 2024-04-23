package huy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CapNhatPhong extends JPanel
{
	Color xanh = new Color (90, 170, 240);
	Color trang = new Color (225, 225, 225);
	Font arial = new Font("Arial", Font.BOLD, 14);
	private JLabel lbTieuDe;
	private JTextField tfMaPhong;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JTextField tfTenPhong;
	private JTextField tfSoGhe;
	private JTable tablePhong;
	private DefaultTableModel modelPhong;
	private JLabel lbMaPhong;
	private JLabel lbTenPhong;
	private JLabel lbSoGhe;

	public CapNhatPhong() 
	{
		super();
		setLayout(new BorderLayout());
		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
			// TieuDe
		JPanel pnTieuDe = new JPanel();
		lbTieuDe = new JLabel("Quản lý phòng - Cập nhập phòng");
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 24));
		lbTieuDe.setForeground(xanh);
		pnTieuDe.add(lbTieuDe);
		
		pnNorth.add(pnTieuDe, BorderLayout.NORTH);
			// Form
		JPanel pnForm = new JPanel();
		pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));
		pnForm.add(Box.createVerticalStrut(10));
				// MaPhong
		JPanel pnMaPhong = new JPanel();
		pnMaPhong.setLayout(new BoxLayout(pnMaPhong, BoxLayout.X_AXIS));
		pnMaPhong.add(Box.createHorizontalStrut(100));
		lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(arial);
		pnMaPhong.add(lbMaPhong);
		pnMaPhong.add(Box.createHorizontalStrut(56));
		pnMaPhong.add(tfMaPhong = new JTextField());
		tfMaPhong.setFont(arial);
		tfMaPhong.setEditable(false);
		pnMaPhong.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnMaPhong);
				// TenPhong
		JPanel pnTenPhong = new JPanel();
		pnTenPhong.setLayout(new BoxLayout(pnTenPhong, BoxLayout.X_AXIS));
		pnTenPhong.add(Box.createHorizontalStrut(100));
		lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(arial);
		pnTenPhong.add(lbTenPhong);
		pnTenPhong.add(Box.createHorizontalStrut(50));
		pnTenPhong.add(tfTenPhong = new JTextField());
		tfTenPhong.setFont(arial);
		tfTenPhong.setBackground(trang);
		tfTenPhong.setSelectionColor(Color.white);
		tfTenPhong.setForeground(xanh);
		pnTenPhong.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnTenPhong);
				// SoGhe
		JPanel pnSoGhe = new JPanel();
		pnSoGhe.setLayout(new BoxLayout(pnSoGhe, BoxLayout.X_AXIS));
		pnSoGhe.add(Box.createHorizontalStrut(100));
		lbSoGhe = new JLabel("Số ghế: ");
		lbSoGhe.setFont(arial);
		pnSoGhe.add(lbSoGhe);
		pnSoGhe.add(Box.createHorizontalStrut(76));
		pnSoGhe.add(tfSoGhe = new JTextField());
		tfSoGhe.setFont(arial);
		tfSoGhe.setBackground(trang);
		tfSoGhe.setSelectionColor(Color.white);
		tfSoGhe.setForeground(xanh);
		pnSoGhe.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnSoGhe);
		pnForm.add(Box.createVerticalStrut(20));
		
		pnNorth.add(pnForm, BorderLayout.CENTER);
			// ChucNang
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));;
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
		String[] cols= {"Mã phòng", "Tên phòng", "Số ghế"};
		modelPhong = new DefaultTableModel(cols,0);
		tablePhong = new JTable(modelPhong);
		pnTable.add(new JScrollPane(tablePhong));
		
		add(pnTable,BorderLayout.CENTER);
	}
}
