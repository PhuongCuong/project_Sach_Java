package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import dao.KhachHangdao;
import dao.LapHoaDondoa;
import dao.QuanLyHoaDondao;
import database.KetNoidata;
import entities.CT_HoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.SanPham;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class GuiQuanLyHoaDon extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnkhachhang;
	private DefaultTableModel model;
	private KhachHangdao khd;
	private JRadioButton radma;
	private JRadioButton radten;
	private JRadioButton radsdt;
	private JButton btntimkiem;
	private JButton btnlammoitk;
	private ButtonGroup buttonGroupTim;
	private JRadioButton radngaylap;
	private DefaultTableModel model1;
	private JLabel lblNewLabel_1;
	private JTextField txtmaHD;
	private JLabel lblNewLabel_2;
	private JTextField txttenKH;
	private JLabel lblNewLabel_3;
	private JTextField txtmaKH;
	private JLabel lblNewLabel_4;
	private JTextField txttongTien;
	private JLabel lblNewLabel_5;
	private JTextField txtsDt;
	private JLabel lblNewLabel_6;
	private JTextField txtdiaChi;
	private JButton btnInHan;
	private JButton btnxoa;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_4;
	private QuanLyHoaDondao qlhd;
	private LapHoaDondoa lhd;
	private JComboBox cbxtimkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyHoaDon frame = new GuiQuanLyHoaDon();
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
	public GuiQuanLyHoaDon() {
		
		KetNoidata.getin().getcon();
		this.khd = new KhachHangdao();
		this.qlhd = new QuanLyHoaDondao();
		this.lhd = new LapHoaDondoa();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 706);
		pnkhachhang = new JPanel();
		
		pnkhachhang.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnkhachhang);
		this.setLocationRelativeTo(null);
		this.setSize(1270, 790);
		pnkhachhang.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pnkhachhang.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Hóa Đơn");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(471, 10, 353, 49);
		panel.add(lblNewLabel);
		String[] tb = new String[] { "MÃ HÓA ĐƠN", "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "TỔNG TIỀN","NGÀY LẬP"};
		
		model = new DefaultTableModel(tb,0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 64, 1256, 198);
		pnkhachhang.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Thông Tin Tìm Kiếm:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(10, 23, 202, 31);
		panel_3.add(lblNewLabel_8);
		
		radma = new JRadioButton("Mã");
		radma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtinhd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getMaHD());
				}
			}
		});
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(109, 78, 57, 21);
		panel_3.add(radma);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm Kiếm:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 75, 102, 21);
		panel_3.add(lblNewLabel_9);
		
		radten = new JRadioButton("Tên");
		radten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtinhd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getTenKH());
				}
			}
		});
		radten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radten.setBounds(283, 78, 57, 21);
		panel_3.add(radten);
		
		radsdt = new JRadioButton("Số Điện Thoại");
		radsdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtinhd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getsDT());
				}
			}
		});
		radsdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radsdt.setBounds(168, 78, 113, 21);
		panel_3.add(radsdt);
		
		radngaylap = new JRadioButton("Ngày Lập");
		radngaylap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtinhd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getNgayLap());
				}
				
				
			}
		});
		radngaylap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radngaylap.setBounds(342, 78, 103, 21);
		panel_3.add(radngaylap);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(10, 138, 141, 41);
		panel_3.add(btntimkiem);
		
		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radma);
		buttonGroupTim.add(radsdt);
		buttonGroupTim.add(radten);
		buttonGroupTim.add(radngaylap);
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(155, 138, 141, 41);
		panel_3.add(btnlammoitk);
		
		txttongTien = new JTextField();
		txttongTien.setEditable(false);
		txttongTien.setColumns(10);
		txttongTien.setBounds(1104, 77, 132, 26);
		panel_3.add(txttongTien);
		
		btnInHan = new JButton("Xuất Hóa Đơn");
		btnInHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String maHD = model.getValueAt(row, 0).toString();
				System.out.println(maHD);
				xuatHD(maHD);
			}
		});
		btnInHan.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\invoice-icon (1).png"));
		btnInHan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInHan.setBackground(new Color(204, 204, 153));
		btnInHan.setBounds(459, 138, 164, 41);
		panel_3.add(btnInHan);
		
		btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHD();
			}
		});
		btnxoa.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBackground(new Color(204, 204, 153));
		btnxoa.setBounds(304, 138, 141, 41);
		panel_3.add(btnxoa);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(723, 10, 523, 178);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1.setBounds(10, 20, 95, 31);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtmaHD = new JTextField();
		txtmaHD.setEditable(false);
		txtmaHD.setBounds(139, 25, 135, 26);
		panel_4.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tên khách hàng");
		lblNewLabel_3.setBounds(10, 61, 114, 31);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txttenKH = new JTextField();
		txttenKH.setEditable(false);
		txttenKH.setBounds(139, 66, 135, 26);
		panel_4.add(txttenKH);
		txttenKH.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Mã khách hàng:");
		lblNewLabel_2.setBounds(10, 105, 114, 31);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtmaKH = new JTextField();
		txtmaKH.setEditable(false);
		txtmaKH.setBounds(139, 110, 135, 26);
		panel_4.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Địa chỉ:");
		lblNewLabel_5.setBounds(284, 20, 64, 31);
		panel_4.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtdiaChi = new JTextField();
		txtdiaChi.setEditable(false);
		txtdiaChi.setBounds(381, 25, 132, 26);
		panel_4.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Tổng tiền");
		lblNewLabel_6.setBounds(284, 61, 64, 31);
		panel_4.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setBounds(284, 110, 88, 26);
		panel_4.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtsDt = new JTextField();
		txtsDt.setEditable(false);
		txtsDt.setBounds(381, 110, 132, 26);
		panel_4.add(txtsDt);
		txtsDt.setColumns(10);
		
		cbxtimkiem = new JComboBox();
		cbxtimkiem.setEditable(true);
		cbxtimkiem.setBounds(202, 29, 239, 26);
		panel_3.add(cbxtimkiem);
		
		String[] tb1 = new String[] { "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SỐ LƯỢNG"};
		
		model1 = new DefaultTableModel(tb1,0);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 272, 1256, 221);
		pnkhachhang.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 1236, 201);
		panel_1.add(scrollPane);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 503, 1256, 250);
		pnkhachhang.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 10, 1236, 230);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable(model1) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1.setViewportView(table_1);
//		scrollPane.setColumnHeaderView(table);
		btntimkiem.addActionListener(this);
		btnlammoitk.addActionListener(this);
		docdulieu();
		table.addMouseListener(this);
	}
	
	public void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void deleteAllDataTable1() {
		model1 = (DefaultTableModel) table_1.getModel();
		model1.getDataVector().removeAllElements();
	}
	
	public void docdulieu()
	{
		List<HoaDon> dshd = qlhd.getallthongtinhd();
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] {hd.getMaHD(),hd.getMaKH(),hd.getTenKH(),
					hd.getsDT(),hd.getDiaChi(),hd.getTongTien(),hd.getNgayLap()});
		}
	}
	
	public void loaddulieutext()
	{
		int row = table.getSelectedRow();
		String maHD = model.getValueAt(row,0).toString();
		HoaDon hd = qlhd.getallthongtinhdkh(maHD);
		txtmaHD.setText(hd.getMaHD());
		txtmaKH.setText(hd.getMaKH());
		txttenKH.setText(hd.getTenKH());
		txtsDt.setText(hd.getsDT());
		txtdiaChi.setText(hd.getDiaChi());
		txttongTien.setText(hd.getTongTien()+"");
	}
	
	public void loadallsptheoma()
	{
		int row = table.getSelectedRow();
		String maHD = model.getValueAt(row,0).toString();
		List<CT_HoaDon> cthd = qlhd.getallcthd(maHD);
		for (CT_HoaDon ct : cthd) {
			model1.addRow(new Object[] {ct.getMaSach(),ct.getTenSP(),ct.getDongia(),
					ct.getSoluong()});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		deleteAllDataTable1();
		loadallsptheoma();
		loaddulieutext();
		// TODO Auto-generated method stub
		
	}

		
	public void xoaHD()
	{
		String maHD = txtmaHD.getText().trim();
		if(maHD.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xóa!");
		}
		else
		{
			if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Lựa chọn của bạn", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				if(lhd.xoaCTHD(maHD)==true && qlhd.xoaHD(maHD)==true)
				{
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
					deleteAllDataTable();
					docdulieu();
				}
				else if(lhd.xoaCTHD(maHD)==false && qlhd.xoaHD(maHD)==true)
				{
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
					deleteAllDataTable();
					docdulieu();
				}
				else 
				{
					JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}
			}
		}
	}
	
	public void timkiembyma(String ma)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbyma(ma);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getNgayLap()});
					}
		
	}
	
	public void timkiembyten(String ten)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbyten(ten);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getNgayLap()});
					}
		
	}
	
	public void timkiembysdt(String sdt)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbysdt(sdt);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getNgayLap()});
					}
		
	}
	
	public void timkiembyngaylap(int nam,int thang,int ngay)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbyngay(nam, thang, ngay);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getNgayLap()});
					}
		
	}
	public void xuatHD(String maHD)
	{
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLTest";
		Connection con;
		try {
			con = DriverManager.getConnection(url,"sa","1234567");
			Hashtable map = new Hashtable<>();
			try {
				JasperReport report = JasperCompileManager.compileReport("src/gui/reporthoadon.jrxml");
				map.put("maHoaDon", maHD);
				JasperPrint p = JasperFillManager.fillReport(report,map,con);
				JasperViewer.viewReport(p,false);
				JasperExportManager.exportReportToPdfFile(p, "test.pdf");
			} catch (JRException e1) {
				System.out.println("xuất");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("Xuất");
		
	}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object gui = e.getSource();
		if(gui.equals(btnlammoitk))
		{
			deleteAllDataTable();
			docdulieu();
		}
		if(gui.equals(btntimkiem))
		{
			if(radma.isSelected()==false && radten.isSelected() == false && radsdt.isSelected() ==false && radngaylap.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm!");
			}
			else if (radma.isSelected()==false && radten.isSelected() == false && radsdt.isSelected()==false && radngaylap.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm!");
			}
			else
			{
				if(radma.isSelected()==true)
				{
					String ma = cbxtimkiem.getSelectedItem().toString();
					deleteAllDataTable();
					timkiembyma(ma);
				}
				else if(radten.isSelected()==true)
				{
					String ma = cbxtimkiem.getSelectedItem().toString();
					deleteAllDataTable();
					timkiembyten(ma);
				}
				else if(radsdt.isSelected()==true)
				{
					String ma = cbxtimkiem.getSelectedItem().toString();
					deleteAllDataTable();
					timkiembysdt(ma);
				}
				else if(radngaylap.isSelected()==true)
				{
					String ma = cbxtimkiem.getSelectedItem().toString();
					System.out.println(ma);
					String nam = ma.substring(0, 4);
					int nam1 = Integer.valueOf(nam);
					String thang = ma.substring(5, 7);
					int thang1 = Integer.valueOf(thang);
					String ngay = ma.substring(8, 10);
					int ngay1 = Integer.valueOf(ngay);
					deleteAllDataTable();
					timkiembyngaylap(nam1, thang1, ngay1);
				}
				else
					return;
			}
		}
	}
}