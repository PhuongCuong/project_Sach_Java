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
import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangdao;
import dao.LapHoaDondoa;
import dao.NhaCungCapdao;
import dao.QuanLyHoaDondao;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhachHang;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GuiTimKiemHoaDon extends JFrame implements ActionListener{

	public JPanel pntimkh;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private QuanLyHoaDondao hdd;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtsdt;
	private JCheckBox cbxma;
	private JCheckBox cbxten;
	private JCheckBox cbxsdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTimKiemHoaDon frame = new GuiTimKiemHoaDon();
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
	public GuiTimKiemHoaDon() {
		
		this.hdd = new QuanLyHoaDondao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pntimkh = new JPanel();
		pntimkh.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setContentPane(pntimkh);
		pntimkh.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pntimkh.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Hóa Đơn");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(504, 0, 275, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimkh.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 492, 1246, 182);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 35, 216, 31);
		panel_2.add(lblNewLabel_1);
		buttonGroupTim = new ButtonGroup();
		
		JLabel lblNewLabel_1_1 = new JLabel("Tìm kiếm theo tên khách hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 76, 242, 31);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tìm kiếm theo số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 118, 242, 31);
		panel_2.add(lblNewLabel_1_1_1);
		
		txtma = new JTextField();
		txtma.setBounds(271, 35, 293, 31);
		txtma.setEditable(false);
		panel_2.add(txtma);
		txtma.setColumns(10);
		
		
		txtten = new JTextField();
		txtten.setEditable(false);
		txtten.setColumns(10);
		txtten.setBounds(271, 76, 293, 31);
		panel_2.add(txtten);
		
	
		

		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setEditable(false);
		txtsdt.setBounds(271, 120, 293, 31);
		panel_2.add(txtsdt);
			txtma.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				public void warn()
				{
					if(!txtma.getText().equals(""))
					{
						timkiembyma(txtma.getText());
					}
				}
			});
		txtten.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				public void warn()
				{
					if(!txtten.getText().equals(""))
					{
						timkiembyten(txtten.getText());
					}
				}
			});
			txtsdt.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					warn();
				}
				public void warn()
				{
					if(!txtsdt.getText().equals(""))
					{
						timkiembysdt(txtsdt.getText());
					}
				}
			});
		
		
		
		
		cbxma = new JCheckBox("");
		cbxma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					txtma.setEditable(true);
				}
				else
				{
					txtma.setEditable(false);
				}
			}
		});
		cbxma.setBounds(570, 38, 21, 28);
		panel_2.add(cbxma);
		
		cbxten = new JCheckBox("");
		cbxten.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					txtten.setEditable(true);
				}
				else
				{
					txtten.setEditable(false);
				}
			}
		});
		cbxten.setBounds(570, 76, 21, 28);
		panel_2.add(cbxten);
		
		cbxsdt = new JCheckBox("");
		cbxsdt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					txtsdt.setEditable(true);
				}
				else
				{
					txtsdt.setEditable(false);
				}
			}
		});
		cbxsdt.setBounds(570, 121, 21, 28);
		panel_2.add(cbxsdt);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 0, 1246, 482);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		String[] tb = new String[] { "STT", "Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Ngày Lập", "Tổng Tiền"};
		
		model = new DefaultTableModel(tb,0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1226, 457);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		txtma.addActionListener(this);
	}
	
	
	
	public void timkiembyma(String ma)
	{
		deleteAllDataTable();
		int d =0;
		List<HoaDon> dshd = hdd.getspbymass(ma);
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] { d ++, hd.getMaHD(), hd.getMaKH().trim(),
					hd.getTenKH().trim(), hd.getsDT(), hd.getDiaChi().trim(),hd.getNgayLap(),
					hd.getTongTien()});
					}
		
	}
	
	public void timkiembyten(String ten)
	{
		deleteAllDataTable();
		int d =0;
		List<HoaDon> dshd = hdd.getspbytenss(ten);
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] { d ++, hd.getMaHD(), hd.getMaKH().trim(),
					hd.getTenKH().trim(), hd.getsDT(), hd.getDiaChi().trim(),hd.getNgayLap(),
					hd.getTongTien()});
					}
		
	}
	
	public void timkiembysdt(String sdt)
	{
		deleteAllDataTable();
		int d =0;
		List<HoaDon> dshd = hdd.getspbysdtss(sdt);
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] { d ++, hd.getMaHD(), hd.getMaKH().trim(),
					hd.getTenKH().trim(), hd.getsDT(), hd.getDiaChi().trim(),hd.getNgayLap(),
					hd.getTongTien()});
					}
		
	}
	
	public void timkiembyngay(int y,int m,int day)
	{
		int d =0;
		List<HoaDon> dshd = hdd.getspbyngay(y, m, day);
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] { d ++, hd.getMaHD(), hd.getMaKH().trim(),
					hd.getTenKH().trim(), hd.getsDT(), hd.getDiaChi().trim(),hd.getNgayLap(),
					hd.getTongTien()});
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
