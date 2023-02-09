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
import dao.SanPhamdao;
import dao.KhachHangdao;
import entities.KhachHang;
import entities.SanPham;
import entities.KhachHang;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class GuiThongKeDoDungHet extends JFrame implements ActionListener{

	public JPanel pntimkh;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private KhachHangdao khd;
	private SanPhamdao spd;

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
	public GuiThongKeDoDungHet() {
		
		this.khd = new KhachHangdao();
		this.spd= new SanPhamdao();
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
		
		JLabel lblNewLabel = new JLabel("Thống Kê Đồ Dùng Đã Hết ");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(461, 0, 399, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimkh.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 598, 1246, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Số Đồ Dùng Đã Bán:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(215, 23, 226, 32);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("...");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(451, 23, 101, 32);
		panel_2.add(lblNewLabel_3_1);
		
		JButton btnInBoCo = new JButton("In Báo Cáo");
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
		String[] tb = new String[] { "STT", "Mã Sản Phẩm", "Thể Loại", "Tên Sản Phẩm","Nhà Xuất Bản", "Nhà Cung Cấp","Đơn Vị Tính","Đơn Giá","Số Lượng"};
		
		model = new DefaultTableModel(tb,0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1226, 498);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		table = new JTable(model)
				{
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
				};
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(0, 0, 1246, 63);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Theo Tùy Chỉnh:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(82, 10, 172, 29);
		panel_4.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tùy Chỉnh", "Ngày Hôm Nay", "Ngày Hôm Qua", "7 Ngày Qua", "Theo Tháng", "Theo Năm"}));
		comboBox.setBounds(264, 11, 138, 29);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Từ Ngày:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(412, 11, 64, 29);
		panel_4.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(481, 10, 138, 29);
		panel_4.add(dateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tới Ngày:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(629, 10, 64, 29);
		panel_4.add(lblNewLabel_2_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(703, 10, 138, 29);
		panel_4.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Thống Kê");
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(867, 8, 140, 35);
		panel_4.add(btnNewButton);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBackground(new Color(204, 204, 153));
		btnLmMi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLmMi.setBounds(1032, 8, 140, 35);
		panel_4.add(btnLmMi);
		docDuLieu();
	}
	
	public void docDuLieu() {
		int d=1;
		List<SanPham> list = spd.getallsanphamdd();
		for(SanPham x:list) {
			if(x.getSoLuong()==0) {
				model.addRow(new Object[] {
						d++,
						x.getMaSP(),
						x.getTheLoai().getTenTL(), 
						x.getTenSP(),
						x.getTenNSB(),
						x.getTenNCC().getTenNCC(),
						x.getDonVT(), 					
						x.getDonGia(),
						x.getSoLuong()
				});
			}
			else continue;
			
			
		};
		
		
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
