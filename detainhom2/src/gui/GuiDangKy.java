package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanViendao;
import database.KetNoidata;
import entities.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GuiDangKy extends JFrame implements ActionListener{

	/**
	 * 
	 */

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	public JTextField txttaikhoan;
	private JPasswordField txtpasswourd;
	private NhanViendao nvd;
	private JButton btndangky;
	private JButton btnhuy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDangKy frame = new GuiDangKy();
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
	public GuiDangKy() {
		
		KetNoidata.getin().getcon();
		this.nvd = new NhanViendao();
		
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 575, 77);
		getContentPane().add(panel);
		panel.setLayout(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 349);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel_1.setBackground(new Color(107, 142, 35));
		panel_1.setBounds(0, 0, 600, 76);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Ký Tài Khoản");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(174, 10, 249, 56);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(63, 118, 96, 24);
		contentPane.add(lblNewLabel_1);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(186, 118, 224, 30);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(63, 169, 96, 24);
		contentPane.add(lblNewLabel_2);
		
		txtpasswourd = new JPasswordField();
		txtpasswourd.setBounds(186, 169, 224, 30);
		contentPane.add(txtpasswourd);
		
		btndangky = new JButton("Đăng Ký");
		btndangky.setBackground(Color.LIGHT_GRAY);
		btndangky.setIcon(new ImageIcon("Img\\Ecommerce-Cash-Register-icon.png"));
		btndangky.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btndangky.setBounds(109, 232, 141, 41);
		contentPane.add(btndangky);
		
		btnhuy = new JButton("Hủy");
		btnhuy.setBackground(Color.LIGHT_GRAY);
		btnhuy.setIcon(new ImageIcon("Img\\Close-icon.png"));
		btnhuy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnhuy.setBounds(301, 232, 141, 41);
		contentPane.add(btnhuy);
		btndangky.addActionListener(this);
	}
	public boolean kiemtradulieu()
	{
		if(txttaikhoan.getText().equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
			txttaikhoan.selectAll();
			txttaikhoan.requestFocus();
			return false;
		}else if(!txttaikhoan.getText().matches("^[A-Za-z0-9]{2,}"))
		{
			JOptionPane.showMessageDialog(this, "Tải khoản phải có ít nhất 2 kí tự bao gồm cả chữ vào số!");
			txttaikhoan.selectAll();
			txttaikhoan.requestFocus();
			return false;
		}
		GuiNhanVien.txtk.setText(txttaikhoan.getText());
		String pass = String.valueOf(txtpasswourd.getPassword());
		if(txtpasswourd.getPassword().toString().equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập mật khẩu!");
			txtpasswourd.selectAll();
			txtpasswourd.requestFocus();
			return false;
		}else if(pass.length() <6)
		{
			JOptionPane.showMessageDialog(this, "Mật khẩu phải có từ 6 kí tự trở lên!");
			txtpasswourd.selectAll();
			txtpasswourd.requestFocus();
			return false;
		}
		return true;
//		if(dangbuoc == "" && kiemtrauser() == true)
//		{
//			String password = String.valueOf(txtpasswourd.getPassword());
//			User tk = new User(txttaikhoan.getText().trim(), password);
//			try {
//				if(nvd.addTaiKhoan(tk)==true)
//				{
//					guinv.txtk.setText(txttaikhoan.getText().trim());
//					JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
//					guinv.themnhanvien();
//					JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
//					guinv.deleteAllDataTable();
//					guinv.docDuLieu();
//					guinv.btnthem.setEnabled(true);
//					this.setVisible(false);
//				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(this, "Thêm tài khoản bị lỗi !");
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		else {
//			JOptionPane.showMessageDialog(this, dangbuoc, "Thông báo !", JOptionPane.ERROR_MESSAGE,
//					new ImageIcon("Img\\warning.png"));
//		}
		
	}
	public boolean kiemtrauser()
	{
		List<String> listTenTaiKhoan = new ArrayList<String>();
		try {
			nvd.getAllTenTaiKhoan().forEach(x -> listTenTaiKhoan.add(x));
			
			for (String tenTk : listTenTaiKhoan) {
				if (tenTk.equals(txttaikhoan.getText().trim())) {
					JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !");
					txttaikhoan.selectAll();
					txttaikhoan.requestFocus();
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		if(gui.equals(btndangky))
		{
			if(kiemtradulieu())
			{
				if(kiemtrauser())
				{
					String passw = String.valueOf(txtpasswourd.getPassword());
					User ur = new User(txttaikhoan.getText(), passw);
					try {
						if(nvd.addTaiKhoan(ur)==true)
						{
							GuiNhanVien.txtk.setText(txttaikhoan.getText().trim());
							JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
							GuiNhanVien.themnhanvien();
							JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
							GuiNhanVien.deleteAllDataTable();
							GuiNhanVien.docDuLieu();
							GuiNhanVien.btnthem.setEnabled(true);
							this.setVisible(false);
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
}
