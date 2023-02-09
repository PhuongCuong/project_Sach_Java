package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import dao.KhachHangdao;
import database.KetNoidata;
import entities.KhachHang;
import entities.NhanVien;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class GuiDoiMatKhau extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnkhachhang;
	private DefaultTableModel model;
	private KhachHangdao khd;
	private JButton btnlammoitk;
	private ButtonGroup buttonGroupTim;
	private JTextField txttimkiem;
	private DefaultTableModel model1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDoiMatKhau frame = new GuiDoiMatKhau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiDoiMatKhau() {
		
		KetNoidata.getin().getcon();
		this.khd = new KhachHangdao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 706);
		pnkhachhang = new JPanel();
		
		pnkhachhang.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnkhachhang);
		this.setLocationRelativeTo(null);
		this.setSize(1270, 790);
		pnkhachhang.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pnkhachhang.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi Mật Khẩu");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(563, 10, 353, 49);
		panel.add(lblNewLabel);
		String[] tb = new String[] { "MÃ ĐƠN ĐẶT HÀNG", "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "TỔNG TIỀN", "TÌNH TRẠNG","THỜI GIAN ĐẶT"};
		
		model = new DefaultTableModel(tb,0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 69, 1256, 684);
		pnkhachhang.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Mật khẩu hiện tại");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(348, 183, 202, 31);
		panel_3.add(lblNewLabel_8);
		
		buttonGroupTim = new ButtonGroup();
		
		btnlammoitk = new JButton("Hủy");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("D:\\Users\\Asus\\eclipse-workspace\\detainhom\\Img\\Close-icon.png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(392, 423, 186, 41);
		panel_3.add(btnlammoitk);
		
		txttimkiem = new JTextField();
		txttimkiem.setBounds(661, 190, 300, 26);
		panel_3.add(txttimkiem);
		txttimkiem.setColumns(10);
		
		JButton btnSa = new JButton("Thay đổi");
		btnSa.setIcon(new ImageIcon("D:\\Users\\Asus\\eclipse-workspace\\detainhom\\Img\\edit-validated-icon.png"));
		btnSa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSa.setBackground(new Color(204, 204, 153));
		btnSa.setBounds(700, 423, 186, 41);
		panel_3.add(btnSa);
		
		lblNewLabel_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(348, 245, 202, 31);
		panel_3.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(348, 313, 236, 31);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(661, 252, 300, 26);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(661, 320, 300, 26);
		panel_3.add(textField_1);
		
		lblNewLabel_3 = new JLabel("Lưu ý:Mật khẩu bao gồm chữ kèm theo số , tối thiểu 8 ký tự và tối đa 32 ký tự");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(262, 77, 758, 54);
		panel_3.add(lblNewLabel_3);
		
		String[] tb1 = new String[] { "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SỐ LƯỢNG", "THÀNH TIỀN"};
		
		model1 = new DefaultTableModel(tb1,0);
//		scrollPane.setColumnHeaderView(table);
		docDuLieu();
		btnlammoitk.addActionListener(this);
	}
	private void docDuLieu() {
		try {
			List<KhachHang> list = khd.getallkhachhang();
			int i = 0;
			for (KhachHang khachHang : list) {
				i++;
				model.addRow(new Object[] { i + "", khachHang.getMaKH(), khachHang.getHoKH().trim(),
						khachHang.getTenKH().trim(), khachHang.getNgaySinh(), khachHang.getGioiTinh().trim(),khachHang.getsDT().trim(),
						khachHang.getDiaChi().trim(),khachHang.getSoCMND().trim()});
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}