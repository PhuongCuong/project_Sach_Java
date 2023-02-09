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

import dao.SanPhamdao;
import entities.DoDung;
import entities.SanPham;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GuiTimKiemDoDung extends JFrame implements ActionListener{

	public JPanel pntimdd;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private JTextField txttimkiem;
	private SanPhamdao ddd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox cbxncc;
	private JCheckBox cbxtheloai;
	private JCheckBox cbxten;
	private JCheckBox cbxma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTimKiemDoDung frame = new GuiTimKiemDoDung();
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
	public GuiTimKiemDoDung() {
		
		this.ddd = new SanPhamdao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pntimdd = new JPanel();
		pntimdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setContentPane(pntimdd);
		pntimdd.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pntimdd.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Sản Phẩm Khác");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(461, 0, 388, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimdd.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(10, 492, 1246, 182);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo mã");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 35, 174, 31);
		panel_2.add(lblNewLabel_1);
		buttonGroupTim = new ButtonGroup();
		
		txttimkiem = new JTextField();
		txttimkiem.setEditable(false);
		txttimkiem.setBounds(255, 39, 293, 27);
		panel_2.add(txttimkiem);
		txttimkiem.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tìm kiếm theo tên sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 119, 235, 31);
		panel_2.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(255, 123, 293, 27);
		panel_2.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tìm kiếm theo tên thể loại");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(641, 35, 222, 31);
		panel_2.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(891, 39, 293, 27);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tìm kiếm theo nhà cung cấp");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(641, 119, 235, 31);
		panel_2.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(891, 123, 293, 27);
		panel_2.add(textField_2);
		
		cbxma = new JCheckBox("");
		cbxma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					txttimkiem.setEditable(true);
				}
				else
				{
					txttimkiem.setEditable(false);
				}
			}
		});
		cbxma.setBounds(554, 39, 21, 27);
		panel_2.add(cbxma);
		
		cbxten = new JCheckBox("");
		cbxten.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					textField.setEditable(true);
				}
				else
				{
					textField.setEditable(false);
				}
			}
		});
		cbxten.setBounds(554, 123, 21, 27);
		panel_2.add(cbxten);
		
		cbxtheloai = new JCheckBox("");
		cbxtheloai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					textField_1.setEditable(true);
				}
				else
				{
					textField_1.setEditable(false);
				}
			}
		});
		cbxtheloai.setBounds(1190, 39, 21, 27);
		panel_2.add(cbxtheloai);
		
		cbxncc = new JCheckBox("");
		cbxncc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					textField_2.setEditable(true);
				}
				else
				{
					textField_2.setEditable(false);
				}
			}
		});
		cbxncc.setBounds(1190, 123, 21, 27);
		panel_2.add(cbxncc);
		txttimkiem.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			public void warn()
			{
				if(!txttimkiem.getText().equals("")) {
					timkiembyma(txttimkiem.getText());
				}
			}
		});
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			public void warn()
			{
				
				if(!textField.getText().equals("")) {
					
					timkiembyten(textField.getText());
				}
			}
		});
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			public void warn()
			{
				
				if(!textField_1.getText().equals("")) {
					timkiembytheloai(textField_1.getText());
				}
			}
		});
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
				// TODO Auto-generated method stub
				
			}
			public void warn()
			{
				if(!textField_2.getText().equals("")) {
					timkiembyncc(textField_2.getText());
				}
			}
		});
		
				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 0, 1246, 482);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		String[] tb = new String[] { "STT", "Mã Sản Phẩm", "Thể Loại", "Tên Sản Phẩm","Nhà Xuất Bản", "Nhà Cung Cấp","Đơn Vị Tính","Đơn Giá","Số Lượng"};
		
		model = new DefaultTableModel(tb,0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1226, 457);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		txttimkiem.addActionListener(this);
	}
	
	
	
	public void timkiembyma(String ma)
	{
		deleteAllDataTable();
		int d =0;
		List<SanPham> dsdd = ddd.getDoDungByMa(ma);
		for (SanPham dd : dsdd) {
			model.addRow(new Object[] { d ++, dd.getMaSP(), dd.getTheLoai().getTenTL(),
					dd.getTenSP().trim(), dd.getTenNSB(), dd.getTenNCC().getTenNCC(),dd.getDonVT().trim(),dd.getDonGia(),
					dd.getSoLuong()});
					}
		
	}
	
	public void timkiembyten(String ten)
	{
		deleteAllDataTable();
		int d =0;
		List<SanPham> dsdd = ddd.getDoDungbyTen(ten);
		for (SanPham dd : dsdd) {
			model.addRow(new Object[] { d ++, dd.getMaSP(), dd.getTheLoai().getTenTL(),
					dd.getTenSP().trim(), dd.getTenNSB(), dd.getTenNCC().getTenNCC(),dd.getDonVT().trim(),dd.getDonGia(),
					dd.getSoLuong()});
					}
		
	}
	
	public void timkiembytheloai(String theloai)
	{
		deleteAllDataTable();
		int d =0;
		List<SanPham> dsdd = ddd.getDoDungbyTheLoai(theloai);
		for (SanPham dd : dsdd) {
			model.addRow(new Object[] { d ++, dd.getMaSP(), dd.getTheLoai().getTenTL(),
					dd.getTenSP().trim(), dd.getTenNSB(), dd.getTenNCC().getTenNCC(),dd.getDonVT().trim(),dd.getDonGia(),
					dd.getSoLuong()});
					}		
	}
	
	public void timkiembyncc(String ncc)
	{
		deleteAllDataTable();
		int d =0;
		List<SanPham> dsdd = ddd.getDoDungbynhaCungCap(ncc);
		for (SanPham dd : dsdd) {
			model.addRow(new Object[] { d ++, dd.getMaSP(), dd.getTheLoai().getTenTL(),
					dd.getTenSP().trim(), dd.getTenNSB(), dd.getTenNCC().getTenNCC(),dd.getDonVT().trim(),dd.getDonGia(),
					dd.getSoLuong()});
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
