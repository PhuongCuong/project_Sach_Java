package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.KhachHangdao;
import dao.NhanViendao;
import dao.Userdao;
import database.KetNoidata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuiQuenMatKhau extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtcmnd;
	private JTextField txtsdt;
	private JButton btnquenpasss;
	private JButton btnthoat;
	private KhachHangdao khd;
	private NhanViendao nvd;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GuiQuenMatKhau frame = new GuiQuenMatKhau();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GuiQuenMatKhau() {
		
		KetNoidata.getin().connet();
		this.khd = new KhachHangdao();
		this.nvd = new NhanViendao();
		
		setTitle("Forgot your password");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 300);
		this.setLocationRelativeTo(null);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot your password");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 25, 208, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số CMND");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(59, 135, 75, 13);
		contentPane.add(lblNewLabel_1);
		
		txtcmnd = new JTextField();
		txtcmnd.setBounds(136, 128, 186, 26);
		contentPane.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("số điện thoại");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(61, 92, 75, 13);
		contentPane.add(lblNewLabel_2);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(136, 84, 186, 26);
		contentPane.add(txtsdt);
		txtsdt.setColumns(10);
		
		btnquenpasss = new JButton("Quên mật khẩu");
		btnquenpasss.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnquenpasss.setBounds(57, 180, 156, 29);
		contentPane.add(btnquenpasss);
		
		btnthoat = new JButton("Exit");
		btnthoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthoat.setBounds(240, 180, 156, 29);
		contentPane.add(btnthoat);
		btnquenpasss.addActionListener(this);
		btnthoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object gui = e.getSource();
		if(gui.equals(btnquenpasss))
		{
			if(txtcmnd.getText().equals("")||txtsdt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "bạn phải nhập đủ thông tin yêu cầu");
			}
			else
			{
				String cmnd = txtcmnd.getText().trim();
				String sdt = txtsdt.getText().trim();
				String mk = nvd.getmatkhau(sdt, cmnd);
				String tk = nvd.gettaikhoan(sdt, cmnd);
				if(mk!=null)
				{
					JOptionPane.showMessageDialog(this, "Tài Khoản của bạn là :" +tk+ "\n Mật Khẩu của bạn là :" +mk);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "không tìm thấy mật khẩu");
				}
			}
		}
		if(gui.equals(btnthoat))
		{
			this.dispose();
		}
	}
}
