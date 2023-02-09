package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.KhachHangdao;
import dao.NhanViendao;
import dao.ThongTinCaNhandao;
import dao.Userdao;
import database.KetNoidata;
import entities.KhachHang;
import entities.NhanVien;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class GuiThongTinCaNhan extends JFrame implements ActionListener{

	private static final String String = null;
	public static JPanel thongtincanhan;
	private JTextField txtho;
	private JTextField txtsdt;
	private JTextField txtdc;
	private JTextField txtten;
	private JTextField txttaikhoan;
	private JDateChooser txtngaysinh;
	private JComboBox cboboc;
	private KhachHangdao khd;
	private ThongTinCaNhandao thongtin;
	private NhanViendao nvd;
	private JTextField txtmaKH;
	private JButton btncapnhat;
	private JButton btnClear;
	private JTextField txtsocmnd;
	private JTextField txtcalamviec;
	private JTextField txtloainv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThongTinCaNhan frame = new GuiThongTinCaNhan();
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
	public GuiThongTinCaNhan() {
		
		KetNoidata.getin().connet();
		this.nvd = new NhanViendao();
		this.khd = new KhachHangdao();
		this.thongtin = new ThongTinCaNhandao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 700);
		this.setLocationRelativeTo(null);
		this.setSize(1270, 790);
		thongtincanhan = new JPanel();
		thongtincanhan.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(thongtincanhan);
		thongtincanhan.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(10, 83, 1246, 660);
		thongtincanhan.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblho = new JLabel("Họ");
		lblho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblho.setBounds(63, 124, 56, 20);
		panel_1.add(lblho);
		
		txtho = new JTextField();
		txtho.setBounds(227, 122, 333, 30);
		panel_1.add(txtho);
		txtho.setColumns(10);
		
		JLabel lblten = new JLabel("Tên");
		lblten.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblten.setBounds(649, 125, 67, 18);
		panel_1.add(lblten);
		
		JLabel lblngaysinh = new JLabel("Ngày Sinh");
		lblngaysinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblngaysinh.setBounds(63, 182, 113, 26);
		panel_1.add(lblngaysinh);
		
		
		
		txtngaysinh = new JDateChooser();
		txtngaysinh.getCalendarButton().setEnabled(false);
		txtngaysinh.setLocale(Locale.forLanguageTag("vi-VN"));
		txtngaysinh.setDateFormatString("dd-MM-yyyy");
		txtngaysinh.getCalendarButton().setEnabled(true);
		txtngaysinh.setBounds(227, 182, 333, 30);
		panel_1.add(txtngaysinh);
		
		JLabel lblgt = new JLabel("Giới Tính");
		lblgt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblgt.setBounds(66, 247, 110, 18);
		panel_1.add(lblgt);
		
		cboboc = new JComboBox();
		cboboc.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		cboboc.setBackground(new Color(230, 230, 250));
		cboboc.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		cboboc.setToolTipText("Chọn Giới Tính\r\n ");
		cboboc.setToolTipText(" ");
		cboboc.setBounds(227, 241, 333, 30);
		panel_1.add(cboboc);
	
		JLabel lblsdt = new JLabel("Số Điện Thoại");
		lblsdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblsdt.setBounds(649, 175, 119, 41);
		panel_1.add(lblsdt);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(822, 178, 333, 30);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lbldc = new JLabel("Địa Chỉ");
		lbldc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbldc.setBounds(649, 241, 103, 30);
		panel_1.add(lbldc);
		
		txtdc = new JTextField();
		txtdc.setBounds(822, 243, 333, 30);
		panel_1.add(txtdc);
		txtdc.setColumns(10);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(822, 122, 333, 30);
		panel_1.add(txtten);
		
		btnClear = new JButton("Làm Mới");
		btnClear.setBounds(649, 435, 141, 41);
		panel_1.add(btnClear);
		btnClear.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnClear.setBackground(new Color(204, 204, 153));
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBounds(399, 435, 141, 41);
		panel_1.add(btncapnhat);
		btncapnhat.setIcon(new ImageIcon("Img\\Database-Add-icon.png"));
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBackground(new Color(204, 204, 153));
		
		JLabel lblma = new JLabel("Mã NV");
		lblma.setBounds(63, 25, 113, 24);
		panel_1.add(lblma);
		lblma.setIcon(new ImageIcon("Img\\bar-code-icon.png"));
		lblma.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtmaKH = new JTextField();
		txtmaKH.setBounds(227, 19, 67, 30);
		panel_1.add(txtmaKH);
		txtmaKH.setEditable(false);
		txtmaKH.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(649, 62, 81, 37);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("Img\\user-icon.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(822, 67, 333, 30);
		panel_1.add(txttaikhoan);
		txttaikhoan.setEditable(false);
		txttaikhoan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Số CMND");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(63, 301, 110, 22);
		panel_1.add(lblNewLabel_1);
		
		txtsocmnd = new JTextField();
		txtsocmnd.setBounds(227, 300, 333, 30);
		panel_1.add(txtsocmnd);
		txtsocmnd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ca Làm Việc");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(649, 292, 130, 41);
		panel_1.add(lblNewLabel_2);
		
		txtcalamviec = new JTextField();
		txtcalamviec.setBounds(822, 300, 333, 30);
		panel_1.add(txtcalamviec);
		txtcalamviec.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Loại Nhân Viên");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(64, 71, 135, 19);
		panel_1.add(lblNewLabel_3);
		
		txtloainv = new JTextField();
		txtloainv.setBounds(227, 65, 135, 30);
		panel_1.add(txtloainv);
		txtloainv.setColumns(10);
		btncapnhat.addActionListener(this);
		btnClear.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 153));
		panel_2.setBounds(10, 0, 1246, 83);
		thongtincanhan.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblthongtin = new JLabel("THÔNG TIN CÁ NHÂN ");
		lblthongtin.setForeground(new Color(153, 0, 0));
		lblthongtin.setFont(new Font("Dialog", Font.BOLD, 30));
		lblthongtin.setBounds(493, 10, 334, 63);
		panel_2.add(lblthongtin);
		loadthongtin();
		
		
	}
	public void loadthongtin()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		thongtin = new ThongTinCaNhandao();
		NhanVien khachhang = thongtin.loadnhanvien(GuiUser.user.getTaikhoan());
		txtmaKH.setText(khachhang.getMaNV()+"");
		String ngaySinh = "";
		if(khachhang.getNgaySinh() != null) {
			ngaySinh += dateFormat.format(khachhang.getNgaySinh());
		}
		cboboc.setSelectedItem(khachhang.getGioiTinh().toString());
//		System.out.println("giới tính là: " + khachhang.getGioiTinh());
		txtho.setText(khachhang.getHoNV());
		txtten.setText(khachhang.getTenNV());
		txtdc.setText(khachhang.getDiaChi());
		txtngaysinh.setDate(khachhang.getNgaySinh());
		txtsdt.setText(khachhang.getsDt());
		txttaikhoan.setText(khachhang.getTenTK().getTaikhoan());
		txtcalamviec.setText(khachhang.getCaLamViec());
		txtsocmnd.setText(khachhang.getSoCMND());
		txtloainv.setText(khachhang.getLoaiNV());
		
	}
	public void capnhat()
	{
		if(txtho.getText().equals("")||txtten.getText().equals("")||txtsdt.getText().equals("")||txtdc.getText().equals("")||txtsocmnd.getText().equals("")||txtcalamviec.getText().equals("")||txtloainv.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "bạn phải nhập đủ thông tin để cập nhật");
		}
		else
		{
			String ho = txtho.getText().trim();
			String ten = txtten.getText().trim();
			Date ngaySinhsql = null;
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String ngaySinhtxt = dateFormat.format(txtngaysinh.getDate());
				java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
				ngaySinhsql = new Date(ngaySinh.getTime());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
//			String gt = ;
			String sdt = txtsdt.getText().trim();
			String diachi = txtdc.getText().trim();
			String cmnd = txtsocmnd.getText().trim();
			String lnv = txtloainv.getText().trim();
			String calv = txtcalamviec.getText().trim();
			if(nvd.updatenhanvien(txtmaKH.getText(), ho, ten, ngaySinhsql, cboboc.getSelectedItem().toString(), sdt, diachi, calv, cmnd , lnv)==true)
			{
				JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công!");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Cập Nhật Thất Bại!");
			}
		}
		
		
	}
	public void lammoi()
	{
		txtho.setText("");
		txtten.setText("");
		txtsdt.setText("");
		txtdc.setText("");
		txtngaysinh.setDate(null);
		txtsocmnd.setText("");
		txtloainv.setText("");
		txtcalamviec.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		if(gui.equals(btncapnhat))
		{
			capnhat();
		}
		if(gui.equals(btnClear))
		{
			lammoi();
		}
		// TODO Auto-generated method stub
		
	}
}
