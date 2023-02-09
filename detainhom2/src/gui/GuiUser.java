package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Userdao;
import database.KetNoidata;
import entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GuiUser extends JFrame implements ActionListener{

	public static JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpassword;
	private Userdao urd;
	private JButton btnlogin;
	private JButton btnexit;
	private JLabel tblsingup;
	public static User user;
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiUser frame = new GuiUser();
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
	public GuiUser() {
		setTitle("Login");
		
		KetNoidata.getin().connet();
		this.urd = new Userdao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 329);
//		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setIcon(new ImageIcon("Img\\secrecy-icon.png"));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(160, 10, 201, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setIcon(new ImageIcon("Img\\Users-Collaborator-icon.png"));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(170, 102, 83, 24);
		contentPane.add(lblNewLabel_1);
		
		txtuser = new JTextField();
		txtuser.setBounds(264, 103, 184, 24);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setIcon(new ImageIcon("Img\\Security-Password-2-icon.png"));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(170, 152, 93, 34);
		contentPane.add(lblNewLabel_2);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(264, 156, 184, 27);
		contentPane.add(txtpassword);
		
		btnlogin = new JButton("Đăng nhập");
		btnlogin.setIcon(new ImageIcon("Img\\key-icon.png"));
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnlogin.setBackground(Color.LIGHT_GRAY);
		btnlogin.setBounds(190, 208, 124, 34);
//	    btnlogin.setBounds(70,80,100,30);
	    //Round the button with radius = 15
//	    btnlogin.setBorder(new RoundBtn(15));   
		contentPane.add(btnlogin);
		
		btnexit = new JButton("Thoát");
		btnexit.setIcon(new ImageIcon("Img\\Users-Exit-icon.png"));
		btnexit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnexit.setBackground(Color.LIGHT_GRAY);
		btnexit.setBounds(324, 208, 121, 34);
		contentPane.add(btnexit);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("Img\\blue-user-icon.png"));
		lblNewLabel_3.setBounds(10, 70, 131, 172);
		contentPane.add(lblNewLabel_3);
		
		JLabel tblquenpass = new JLabel("Quên mật khẩu ?");
		tblquenpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GuiQuenMatKhau quenpass = new GuiQuenMatKhau();
				quenpass.setVisible(true);
			}
		});
		tblquenpass.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tblquenpass.setForeground(Color.BLUE);
		tblquenpass.setBounds(190, 252, 131, 30);
		contentPane.add(tblquenpass);
		btnlogin.addActionListener(this);
		btnexit.addActionListener(this);
	}
	
	public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
		 if (user.getTaikhoan().equalsIgnoreCase(tenDangNhap)
				&& user.getPassword().equalsIgnoreCase(matKhau)
				&& user.getLoaiTK().equalsIgnoreCase("NV")) {
			TrangThaiDangNhapNhanVien = true;
			return true;
		} else if (user.getTaikhoan().equalsIgnoreCase(tenDangNhap)
				&& user.getPassword().equalsIgnoreCase(matKhau)
				&& user.getLoaiTK().equalsIgnoreCase("QL")) {
			TrangThaiDangNhapQuanLy = true;
			return true;
		}

		return false;
	}
	
	public void loadTaiKhoan(String tenDangNhap, String matKhau) {
		try {
			Connection con = KetNoidata.getin().getcon();
			PreparedStatement stmt = null;
			String sql = "SELECT TaiKhoan.taikhoan, TaiKhoan.matkhau, NhanVien.loaiNV\r\n"
					+ "FROM     TaiKhoan INNER JOIN\r\n"
					+ "                  NhanVien ON TaiKhoan.taikhoan = NhanVien.tenTK\r\n"
					+ "				  where TaiKhoan.taikhoan = ? and TaiKhoan.matkhau = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, matKhau);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(1).trim();
				String mk = rs.getString(2).trim();
				String loaiTk = rs.getString(3).trim();
				user = new User(ten, mk, loaiTk);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void login()
	{
		if(txtuser.getText().equals("")||txtpassword.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "tài khoản và password không được bỏ trống");
		}
		else
		{
			String tendn = txtuser.getText().trim();
			String password = txtpassword.getText().trim();
			loadTaiKhoan(tendn, password);
			if(kiemTraDangNhap(tendn, password) && TrangThaiDangNhapQuanLy == true && TrangThaiDangNhapNhanVien == false)
			{
				GuiGiaoDien gui = new GuiGiaoDien();
				gui.setVisible(true);
				this.setVisible(false);
			}
			else if(kiemTraDangNhap(tendn, password) && TrangThaiDangNhapNhanVien == true && TrangThaiDangNhapQuanLy == false)
			{
				GuiGiaoDien gui = new GuiGiaoDien();
				gui.toolBar.remove(gui.menuBar_3);
				gui.setVisible(true);
				this.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(this, "tài khoản hoặc mật khẩu không đúng");
		}
	
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object gui = e.getSource();
		if(gui.equals(btnlogin))
		{
			login();
		}
		if(gui.equals(btnexit))
		{
			if(JOptionPane.showConfirmDialog(this, "bạn có chắc muốn thoát không", "nhập lựa chọn của bạn", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}
}
