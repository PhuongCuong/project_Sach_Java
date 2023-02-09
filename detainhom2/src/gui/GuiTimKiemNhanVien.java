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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCapdao;
import dao.NhanViendao;
import entities.NhanVien;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class GuiTimKiemNhanVien extends JFrame implements ActionListener{

	public JPanel pntimnv;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private NhanViendao nvd;
	private JTextField txtma;
	private JTextField txtsdt;
	private JTextField txtten;
	private JTextField txtsocmnd;
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
					GuiTimKiemNhanVien frame = new GuiTimKiemNhanVien();
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
	public GuiTimKiemNhanVien() {
		
		this.nvd = new NhanViendao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pntimnv = new JPanel();
		pntimnv.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setContentPane(pntimnv);
		pntimnv.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pntimnv.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Nhân Viên");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(473, 0, 303, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimnv.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 492, 1246, 182);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo mã");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 28, 174, 31);
		panel_2.add(lblNewLabel_1);
		buttonGroupTim = new ButtonGroup();
		
		txtma = new JTextField();
		txtma.setEditable(false);
		txtma.setBounds(212, 32, 293, 27);
		panel_2.add(txtma);
		txtma.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tìm kiếm theo tên");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 105, 174, 31);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tìm kiếm theo số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(647, 28, 223, 31);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tìm kiếm theo số CMND");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(647, 109, 211, 31);
		panel_2.add(lblNewLabel_1_1_1_1);
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
		cbxma.setBounds(511, 32, 21, 27);
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
		cbxten.setBounds(511, 113, 21, 27);
		panel_2.add(cbxten);
		
		cbxtheloai = new JCheckBox("");
		cbxtheloai.addItemListener(new ItemListener() {
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
		cbxtheloai.setBounds(1179, 32, 21, 27);
		panel_2.add(cbxtheloai);
		
		cbxncc = new JCheckBox("");
		cbxncc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
				{
					txtsocmnd.setEditable(true);
				}
				else
				{
					txtsocmnd.setEditable(false);
				}
			}
		});
		cbxncc.setBounds(1179, 109, 21, 27);
		panel_2.add(cbxncc);
		
txtma.getDocument().addDocumentListener(new DocumentListener() {
				
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
					if(!txtma.getText().equals("")) {
						timkiembyma(txtma.getText());
					}
				}
			});
txtsdt = new JTextField();
txtsdt.setEditable(false);
txtsdt.setColumns(10);
txtsdt.setBounds(880, 32, 293, 27);
panel_2.add(txtsdt);
			txtsdt.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					try {
						warn();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					try {
						warn();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					try {
						warn();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				public void warn() throws ClassNotFoundException, SQLException
				{
					if(!txtsdt.getText().equals(""))
					{
						timkiembysdt(txtsdt.getText());
					}
				}
			});
//txtsdt.getDocument().addDocumentListener(new DocumentListener() {
//				
//				@Override
//				public void removeUpdate(DocumentEvent e) {
//					warn();
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void insertUpdate(DocumentEvent e) {
//					warn();
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void changedUpdate(DocumentEvent e) {
//					warn();
//					// TODO Auto-generated method stub
//					
//				}
//				@SuppressWarnings("deprecation")
//				public void warn()
//				{
//					if(!txtsdt.getText().equals("")) {
//						timkiembyten(txtsdt.getText()); 
//					}
//				}
//			});
txtten = new JTextField();
txtten.setEditable(false);
txtten.setColumns(10);
txtten.setBounds(212, 113, 293, 27);
panel_2.add(txtten);
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

txtsocmnd = new JTextField();
txtsocmnd.setEditable(false);
txtsocmnd.setColumns(10);
txtsocmnd.setBounds(880, 109, 293, 27);
panel_2.add(txtsocmnd);
txtsocmnd.getDocument().addDocumentListener(new DocumentListener() {
				
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
					if(!txtsocmnd.getText().equals("")) {
						timkiembycmnd(txtsocmnd.getText());
					}
				}
			});

				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 0, 1246, 482);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		String[] tb = new String[] { "STT", "Mã NV", "Họ NV", "Tên NV", "Ngày Sinh", "Giới Tính", "Số Điện Thoại","Địa Chỉ","Ca Làm Việc","Số CMND","Loại Nhân Viên","Tên Tài Khoản" };
		
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
		List<NhanVien> dsnv = nvd.getallnhanvienbyma(ma);
		for (NhanVien nv : dsnv) {
						model.addRow(new Object[] { d ++, nv.getMaNV(), nv.getHoNV().trim(),
						nv.getTenNV().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDt().trim(),
						nv.getDiaChi().trim(),nv.getCaLamViec().trim(),nv.getSoCMND().trim(),nv.getLoaiNV().trim(),nv.getTenTK().getTaikhoan()});
					}
		
	}
	
	public void timkiembyten(String ten)
	{
		deleteAllDataTable();
		int d =0;
		List<NhanVien> dsnv = nvd.getallnhanvienbyten(ten);
		for (NhanVien nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaNV(), nv.getHoNV().trim(),
					nv.getTenNV().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDt().trim(),
					nv.getDiaChi().trim(),nv.getCaLamViec().trim(),nv.getSoCMND().trim(),nv.getLoaiNV().trim(),nv.getTenTK().getTaikhoan()});
		}
		
	}
	
	public void timkiembysdt(String sdt)
	{
		deleteAllDataTable();
		int d =0;
		List<NhanVien> dsnv = nvd.getallnhanvienbysdt(sdt);
		for (NhanVien nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaNV(), nv.getHoNV().trim(),
					nv.getTenNV().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDt().trim(),
					nv.getDiaChi().trim(),nv.getCaLamViec().trim(),nv.getSoCMND().trim(),nv.getLoaiNV().trim(),nv.getTenTK().getTaikhoan()});
		}
		
	}
	
	public void timkiembycmnd(String cmnd)
	{
		deleteAllDataTable();
		int d =0;
		List<NhanVien> dsnv = nvd.getallnhanvienbyscmd(cmnd);
		for (NhanVien nv : dsnv) {
			model.addRow(new Object[] { d ++, nv.getMaNV(), nv.getHoNV().trim(),
					nv.getTenNV().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDt().trim(),
					nv.getDiaChi().trim(),nv.getCaLamViec().trim(),nv.getSoCMND().trim(),nv.getLoaiNV().trim(),nv.getTenTK().getTaikhoan()});
		}
		
	}
	public static void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
//	public void getTimKiemKhachHangById(String ma) {
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) nvd.timkiemnvma(ma);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//	
//	public void getTimKiemKhachHangById1(String ma) {
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) nvd.timkiemnvma1(ma);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//	
//	public void getTimKiemKhachHangByTen(String ten) {
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) nvd.timkiemnvten(ten);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemKhachHangByCMND(String cmnd) {
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) nvd.timkiemnvcmnd(cmnd);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien khachhang : list) {
//			model.addRow(khachhang.toVector());
//		}
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.setValueAt(i + 1, i, 0);
//		}
//	}
//
//	public void getTimKiemKhachHangBySoDT(String sdt) {
//		ArrayList<NhanVien> list = null;
//		try {
//			list = (ArrayList<NhanVien>) nvd.timkiemnvsdt(sdt);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		for (NhanVien khachhang : list) {
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
