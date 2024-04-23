package huy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CapNhatGhe extends JPanel
{
	Color xanh = new Color (90, 170, 240);
	Color trang = new Color (225, 225, 225);
	Font arial = new Font("Arial", Font.BOLD, 14);
	private JLabel lbTieuDe;
	private JLabel lbMaPhong;
	private JLabel lbMaGhe;
	private JTextField tfMaGhe;
	private JLabel lbHangGhe;
	private JTextField tfHangGhe;
	private JLabel lbSoGhe;
	private JTextField tfSoGhe;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private DefaultTableModel modelGhe;
	private JTable tableGhe;
	private JComboBox cbMaPhong;
	private JButton btnloc;

	public CapNhatGhe()
	{
		super();
		setLayout(new BorderLayout());
		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
			// TieuDe
		JPanel pnTieuDe = new JPanel();
		lbTieuDe = new JLabel("Quản lý ghế - Cập nhập ghế");
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 24));
		lbTieuDe.setForeground(xanh);
		pnTieuDe.add(lbTieuDe);
		
		pnNorth.add(pnTieuDe, BorderLayout.NORTH);
			// Form
		JPanel pnForm = new JPanel();
		pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));
		pnForm.add(Box.createVerticalStrut(10));
				// MaPhong
		JPanel pnMaPhim = new JPanel();
		pnMaPhim.setLayout(new BoxLayout(pnMaPhim, BoxLayout.X_AXIS));
		pnMaPhim.add(Box.createHorizontalStrut(100));
		pnMaPhim.add(lbMaPhong = new JLabel("Mã phòng: "));
		lbMaPhong.setFont(arial);
		pnMaPhim.add(Box.createHorizontalStrut(56));
		pnMaPhim.add(cbMaPhong = new JComboBox());
		cbMaPhong.setFont(arial);
		cbMaPhong.setBackground(trang);
		cbMaPhong.setForeground(xanh);
		pnMaPhim.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnMaPhim);
				// MaGhe
		JPanel pnTenPhong = new JPanel();
		pnTenPhong.setLayout(new BoxLayout(pnTenPhong, BoxLayout.X_AXIS));
		pnTenPhong.add(Box.createHorizontalStrut(100));
		pnTenPhong.add(lbMaGhe = new JLabel("Mã ghế: "));
		lbMaGhe.setFont(arial);
		pnTenPhong.add(Box.createHorizontalStrut(74));
		pnTenPhong.add(tfMaGhe = new JTextField());
		tfMaGhe.setFont(arial);
		tfMaGhe.setBackground(trang);
		tfMaGhe.setSelectionColor(Color.white);
		tfMaGhe.setForeground(xanh);
		pnTenPhong.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnTenPhong);
				// HangGhe
		JPanel pnHangGhe = new JPanel();
		pnHangGhe.setLayout(new BoxLayout(pnHangGhe, BoxLayout.X_AXIS));
		pnHangGhe.add(Box.createHorizontalStrut(100));
		pnHangGhe.add(lbHangGhe = new JLabel("Hàng ghế: "));
		lbHangGhe.setFont(arial);
		pnHangGhe.add(Box.createHorizontalStrut(58));
		pnHangGhe.add(tfHangGhe = new JTextField());
		tfHangGhe.setFont(arial);
		tfHangGhe.setBackground(trang);
		tfHangGhe.setSelectionColor(Color.white);
		tfHangGhe.setForeground(xanh);
		pnHangGhe.add(Box.createHorizontalStrut(100));
		pnForm.add(Box.createVerticalStrut(10));
		pnForm.add(pnHangGhe);
				// SoGhe
		JPanel pnSoGhe = new JPanel();
		pnSoGhe.setLayout(new BoxLayout(pnSoGhe, BoxLayout.X_AXIS));
		pnSoGhe.add(Box.createHorizontalStrut(100));
		pnSoGhe.add(lbSoGhe = new JLabel("Số ghế: "));
		lbSoGhe.setFont(arial);
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
		pnChucNang.add(btnloc = new JButton("Lọc"));
		btnloc.setForeground(trang);
		btnloc.setBackground(xanh);
		btnloc.setFont(arial);
		
		pnNorth.add(pnChucNang, BorderLayout.SOUTH);
		
		add(pnNorth, BorderLayout.NORTH);
		// Table: Center
		JPanel pnTable = new JPanel(new BorderLayout());
		String[] cols= {"Mã phòng", "Mã ghế", "Hàng ghế", "Số ghế"};
		modelGhe = new DefaultTableModel(cols,0);
		tableGhe = new JTable(modelGhe);
		pnTable.add(new JScrollPane(tableGhe));
		
		add(pnTable,BorderLayout.CENTER);
	}
}
