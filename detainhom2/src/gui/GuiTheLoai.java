package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SanPhamdao;
import dao.TheLoaidao;
import database.KetNoidata;
import entities.SanPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class GuiTheLoai extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private TheLoaidao tld;
	private SanPhamdao spd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTheLoai frame = new GuiTheLoai();
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
	public GuiTheLoai() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KetNoidata.getin().getcon();
		this.tld = new TheLoaidao();
		this.spd = new SanPhamdao();
		
		setBounds(100, 100, 576, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 562, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm thể loại");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(178, 10, 188, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 75, 562, 202);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tên thể loại");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(99, 45, 79, 26);
		panel_1.add(lblNewLabel_2);
		
		txtTen = new JTextField();
		txtTen.setBounds(188, 47, 200, 26);
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
		btnNewButton.setBounds(86, 101, 141, 41);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(204, 204, 153));
		btnNewButton_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Close-icon.png"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(272, 101, 141, 41);
		panel_1.add(btnNewButton_1);
	}
	public void them()
	{
		if(kiemTra()==true)
		{
			int c = tld.matlmax()+1;
			String ten = txtTen.getText().trim();
			tld.them(c,ten);
			JOptionPane.showMessageDialog(this, "Thêm Thành công");
			this.setVisible(false);
			GuiSanPham.cbxtl.setSelectedItem(ten);
			GuiSanPham.cbxtl.addItem(ten);
			GuiQLDoDung.cbxtll.setSelectedItem(ten);
			GuiQLDoDung.cbxtll.addItem(ten);
		}
		else
			return;
	}
	public boolean kiemTra() {
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thể loại !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Img\\warning.png"));
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}
		return true;
	}
}
