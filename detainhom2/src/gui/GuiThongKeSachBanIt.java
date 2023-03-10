package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangdao;
import dao.NhaCungCapdao;
import dao.KhachHangdao;
import entities.KhachHang;
import entities.KhachHang;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class GuiThongKeSachBanIt extends JFrame implements ActionListener{

	public JPanel pnsachit;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private KhachHangdao khd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThongKeSachBanIt frame = new GuiThongKeSachBanIt();
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
	public GuiThongKeSachBanIt() {
		
		this.khd = new KhachHangdao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnsachit = new JPanel();
		pnsachit.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setContentPane(pnsachit);
		pnsachit.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pnsachit.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th???ng K?? S??ch ???? H???t ");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(461, 0, 340, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pnsachit.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 598, 1246, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("T???ng S??? S??ch ???? B??n:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(251, 23, 190, 32);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("...");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(451, 23, 101, 32);
		panel_2.add(lblNewLabel_3_1);
		
		JButton btnInBoCo = new JButton("In B??o C??o");
		btnInBoCo.setBackground(new Color(204, 204, 153));
		btnInBoCo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInBoCo.setBounds(567, 23, 140, 35);
		panel_2.add(btnInBoCo);
		buttonGroupTim = new ButtonGroup();
		
				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 70, 1246, 518);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		String[] tb = new String[] { "STT", "M?? S???n Ph???m", "Th??? Lo???i", "T??n S???n Ph???m","Nh?? Xu???t B???n", "Nh?? Cung C???p","????n V??? T??nh","????n Gi??","S??? L?????ng"};
		
		model = new DefaultTableModel(tb,0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1226, 498);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(0, 0, 1246, 63);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Th???ng K?? Theo T??y Ch???nh:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(82, 10, 172, 29);
		panel_4.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T??y Ch???nh", "Ng??y H??m Nay", "Ng??y H??m Qua", "7 Ng??y Qua", "Theo Th??ng", "Theo N??m"}));
		comboBox.setBounds(264, 11, 138, 29);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("T??? Ng??y:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(412, 11, 64, 29);
		panel_4.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(481, 10, 138, 29);
		panel_4.add(dateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("T???i Ng??y:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(629, 10, 64, 29);
		panel_4.add(lblNewLabel_2_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(703, 10, 138, 29);
		panel_4.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Th???ng K??");
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(867, 8, 140, 35);
		panel_4.add(btnNewButton);
		
		JButton btnLmMi = new JButton("L??m M???i");
		btnLmMi.setBackground(new Color(204, 204, 153));
		btnLmMi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLmMi.setBounds(1032, 8, 140, 35);
		panel_4.add(btnLmMi);
	}
	
	
	
	public void timkiembyma(String ma)
	{
		int d =0;
		List<KhachHang> dsnv = khd.getallkhachhangbyma(ma);
		for (KhachHang nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaKH(), nv.getHoKH().trim(),
					nv.getTenKH().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDT().trim(),
					nv.getDiaChi().trim(),nv.getSoCMND().trim()});
					}
		
	}
	
	public void timkiembyten(String ten)
	{
		int d =0;
		List<KhachHang> dsnv = khd.getallkhachhangbyten(ten);
		for (KhachHang nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaKH(), nv.getHoKH().trim(),
					nv.getTenKH().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDT().trim(),
					nv.getDiaChi().trim(),nv.getSoCMND().trim()});
		}
		
	}
	
	public void timkiembysdt(String sdt)
	{
		int d =0;
		List<KhachHang> dsnv = khd.getallkhachhangbysdt(sdt);
		for (KhachHang nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaKH(), nv.getHoKH().trim(),
					nv.getTenKH().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDT().trim(),
					nv.getDiaChi().trim(),nv.getSoCMND().trim()});
		}
		
	}
	
	public void timkiembycmnd(String cmnd)
	{
		int d =0;
		List<KhachHang> dsnv = khd.getallkhachhangbycmnd(cmnd);
		for (KhachHang nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaKH(), nv.getHoKH().trim(),
					nv.getTenKH().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDT().trim(),
					nv.getDiaChi().trim(),nv.getSoCMND().trim()});
		}
		
	}
	public static void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
//	public void getTimKiemKhachHangById(String ma) {
//		ArrayList<KhachHang> list = null;
//		try {
//			list = (ArrayList<KhachHang>) nvd.timkiemnvma(ma);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (KhachHang khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//	
//	public void getTimKiemKhachHangById1(String ma) {
//		ArrayList<KhachHang> list = null;
//		try {
//			list = (ArrayList<KhachHang>) nvd.timkiemnvma1(ma);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (KhachHang khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//	
//	public void getTimKiemKhachHangByTen(String ten) {
//		ArrayList<KhachHang> list = null;
//		try {
//			list = (ArrayList<KhachHang>) nvd.timkiemnvten(ten);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (KhachHang khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemKhachHangByCMND(String cmnd) {
//		ArrayList<KhachHang> list = null;
//		try {
//			list = (ArrayList<KhachHang>) nvd.timkiemnvcmnd(cmnd);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (KhachHang khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemKhachHangBySoDT(String sdt) {
//		ArrayList<KhachHang> list = null;
//		try {
//			list = (ArrayList<KhachHang>) nvd.timkiemnvsdt(sdt);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (KhachHang khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		//txttimkiem = (JTextField) e.getSource();
		//System.out.println(txttimkiem);
		// TODO Auto-generated method stub
//		if(gui.equals(txttimkiem))
//		{
//			if(radma.isSelected()==true)
//			{
//				try {
//					deleteAllDataTable();
//					String ma = txttimkiem.getText().trim();
//					timkiembyma(ma);
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//			}
//		}
		// TODO Auto-generated method stub
		
	}
}
