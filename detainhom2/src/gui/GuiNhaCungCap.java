package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhaCungCapdao;
import database.KetNoidata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiNhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private NhaCungCapdao nccd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiNhaCungCap frame = new GuiNhaCungCap();
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
	public GuiNhaCungCap() {
		
		KetNoidata.getin().getcon();
		this.nccd = new NhaCungCapdao();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(576, 314);
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 564, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Nhà Cung Cấp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel.setBounds(132, 10, 331, 47);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 77, 564, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tên nhà cung cấp");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(78, 40, 117, 27);
		panel_1.add(lblNewLabel_2);
		
		txtTen = new JTextField();
		txtTen.setBounds(207, 42, 200, 26);
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Ecommerce-New-icon.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(103, 90, 141, 41);
		panel_1.add(btnNewButton);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnThot.setBackground(new Color(204, 204, 153));
		btnThot.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Close-icon.png"));
		btnThot.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThot.setBounds(295, 90, 141, 41);
		panel_1.add(btnThot);
	}
	public void them()
	{
		if(kiemTra()==true)
		{
			int c = nccd.manccmax()+1;
			String ten = txtTen.getText().trim();
			nccd.themNCC(c,ten);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			this.setVisible(false);
			GuiSanPham.cbxncc.setSelectedItem(ten);
			GuiSanPham.cbxncc.addItem(ten);
			GuiQLDoDung.cbxnccl.setSelectedItem(ten);
			GuiQLDoDung.cbxnccl.addItem(ten);
		}
		else 
			return;
	}
	public boolean kiemTra() {
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Img\\warning.png"));
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}
		return true;
	}
}
