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
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class GuiQuanLyDonDatHang extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnkhachhang;
	public static DefaultTableModel model;
	private KhachHangdao khd;
	private JRadioButton radma;
	private JRadioButton radten;
	private JRadioButton radsdt;
	private JButton btntimkiem;
	private JButton btnlammoitk;
	private ButtonGroup buttonGroupTim;
	private JRadioButton radngaylap;
	private DefaultTableModel model1;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private QuanLyHoaDondao qlhd;
	private JComboBox cbxtimkiem;
	private LapHoaDondoa lhd;
	private JButton btnxoa;
	private JButton btnthanhtoan;
	private JButton btnupdate;
	private JButton btnInPhiut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyDonDatHang frame = new GuiQuanLyDonDatHang();
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
	public GuiQuanLyDonDatHang() {
		
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
		
		JLabel lblNewLabel = new JLabel("Quản Lý Đơn Đặt Hàng");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(471, 10, 353, 49);
		panel.add(lblNewLabel);
		String[] tb = new String[] { "MÃ ĐƠN ĐẶT HÀNG", "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "TỔNG TIỀN", "TÌNH TRẠNG","THỜI GIAN ĐẶT"};
		
		model = new DefaultTableModel(tb,0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 64, 1256, 131);
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
				List<HoaDon> dshd = qlhd.getallthongtindd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getMaHD());
				}
			}
		});
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(155, 78, 57, 21);
		panel_3.add(radma);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm Kiếm:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(47, 75, 102, 21);
		panel_3.add(lblNewLabel_9);
		
		radten = new JRadioButton("Tên");
		radten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtindd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getTenKH());
				}
			}
		});
		radten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radten.setBounds(329, 78, 57, 21);
		panel_3.add(radten);
		
		radsdt = new JRadioButton("Số Điện Thoại");
		radsdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtindd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getsDT());
				}
			}
		});
		radsdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radsdt.setBounds(214, 78, 113, 21);
		panel_3.add(radsdt);
		
		radngaylap = new JRadioButton("Ngày Lập");
		radngaylap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.removeAllItems();
				List<HoaDon> dshd = qlhd.getallthongtindd();
				for (HoaDon hd : dshd) {
					cbxtimkiem.addItem(hd.getNgayLap());
				}
			}
		});
		radngaylap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radngaylap.setBounds(388, 78, 103, 21);
		panel_3.add(radngaylap);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\detainhom2\\Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(538, 21, 141, 41);
		panel_3.add(btntimkiem);
		
		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radma);
		buttonGroupTim.add(radsdt);
		buttonGroupTim.add(radten);
		buttonGroupTim.add(radngaylap);
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\detainhom2\\Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(689, 21, 159, 41);
		panel_3.add(btnlammoitk);
		
		btnthanhtoan = new JButton("Thanh Toán");
		btnthanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thanhtoan();
			}
		});
		btnthanhtoan.setBackground(new Color(204, 204, 153));
		btnthanhtoan.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\detainhom2\\Img\\creditcard-icon.png"));
		btnthanhtoan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthanhtoan.setBounds(689, 68, 159, 41);
		panel_3.add(btnthanhtoan);
		
		btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHD();
			}
		});
		btnxoa.setIcon(new ImageIcon("D:\\Java\\detainhom (1)\\Img\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBackground(new Color(204, 204, 153));
		btnxoa.setBounds(538, 68, 141, 41);
		panel_3.add(btnxoa);
		
		btnInPhiut = new JButton("In Phiếu Đặt");
		btnInPhiut.setEnabled(false);
		btnInPhiut.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\detainhom2\\Img\\Ecommerce-Receipt-icon.png"));
		btnInPhiut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String maHD = model.getValueAt(row,0).toString();
				xuatHD(maHD);
			}
		});
		btnInPhiut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInPhiut.setBackground(new Color(204, 204, 153));
		btnInPhiut.setBounds(858, 21, 159, 41);
		panel_3.add(btnInPhiut);
		
		btnupdate = new JButton("Sửa Phiếu Đặt");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(btnupdate))
				{
					int row = table.getSelectedRow();
					String maHD = model.getValueAt(row,0).toString();
					if(trangthai(maHD).equalsIgnoreCase("Đã Thanh Toán"))
					{
						JOptionPane.showMessageDialog(btnupdate, "Đơn Đặt Đã Thanh Toán Không Thể Sửa");
					}
					else
					{
						GuiGiaoDien.tabbedPane.remove(GuiGiaoDien.tabbedPane.getSelectedComponent());
						GuiGiaoDien.tabbedPane.add(GuiGiaoDien.guiupdate.thongtinlaphoadon);
						loadkh();
						loadsp();
					}
				}
				
			}
		});
		btnupdate.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\detainhom2\\Img\\Apps-system-software-update-icon.png"));
		btnupdate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnupdate.setBackground(new Color(204, 204, 153));
		btnupdate.setBounds(858, 68, 159, 41);
		panel_3.add(btnupdate);
		
		cbxtimkiem = new JComboBox();
		cbxtimkiem.setBounds(202, 23, 277, 30);
		panel_3.add(cbxtimkiem);
		
		String[] tb1 = new String[] { "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SỐ LƯỢNG"};
		
		model1 = new DefaultTableModel(tb1,0);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 205, 1256, 262);
		pnkhachhang.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 1236, 242);
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
		panel_2.setBounds(0, 477, 1256, 276);
		pnkhachhang.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 10, 1236, 256);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable(model1) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1.setViewportView(table_1);
		docdulieu();
		btntimkiem.addActionListener(this);
		btnlammoitk.addActionListener(this);
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
	
	public void deleteallsp()
	{
		GuiUpdateDonDatHang.modelsp = (DefaultTableModel) GuiUpdateDonDatHang.table_1.getModel();
		GuiUpdateDonDatHang.modelsp.getDataVector().removeAllElements();
	}
	
	public void docdulieu()
	{
		List<HoaDon> dshd = qlhd.getallthongtinDD();
		for (HoaDon hd : dshd) {
			model.addRow(new Object[] {hd.getMaHD(),hd.getMaKH(),hd.getTenKH(),
					hd.getsDT(),hd.getDiaChi(),hd.getTongTien(),hd.getTinhTrang(),hd.getNgayLap()});
		}
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
		if(trangthai(maHD).equalsIgnoreCase("Đã Thanh Toán"))
		{
			btnInPhiut.setEnabled(true);
		}
		else
		{
			btnInPhiut.setEnabled(false);
		}
	}
	
	public void loadkh()
	{
		DecimalFormat tien = new DecimalFormat("#,##0.00");
		int row = table.getSelectedRow();
		GuiUpdateDonDatHang.txtmaKH.setText(model.getValueAt(row, 1).toString());
		GuiUpdateDonDatHang.txtSDT.setText(model.getValueAt(row, 3).toString());
		GuiUpdateDonDatHang.txtDiaChi.setText(model.getValueAt(row, 4).toString());
		GuiUpdateDonDatHang.txttongtien.setText(tien.format(model.getValueAt(row, 5)) + " VND");
		GuiUpdateDonDatHang.cbxtenKH.setSelectedItem(model.getValueAt(row, 2).toString());
		GuiUpdateDonDatHang.txtmadd.setText(model.getValueAt(row, 0).toString());
		GuiUpdateDonDatHang.tongmax = (double) model.getValueAt(row, 5);
	}
	
	public void loadsp()
	{
		deleteallsp();
		int row = table.getSelectedRow();
		String maHD = model.getValueAt(row,0).toString();
		List<CT_HoaDon> cthd = qlhd.getallcthd(maHD);
		for (CT_HoaDon ct : cthd) {
			GuiUpdateDonDatHang.modelsp.addRow(new Object[] {ct.getMaSach(),ct.getTenSP(),ct.getDongia(),
					ct.getSoluong(),ct.getDongia()*ct.getSoluong()});
		}
	}
	
	public void xoaHD()
	{
		int row = table.getSelectedRow();
		String maHD = model.getValueAt(row,0).toString();
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
		List<HoaDon> dsnv = qlhd.getspbymas(ma);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),nv.getTinhTrang(),
						nv.getNgayLap()});
					}
		
	}
	
	public double timkiemma(String ma)
	{
		double tongtien = 0;
		List<HoaDon> dshd = qlhd.getspbymas(ma);
		for (HoaDon hd : dshd)
			tongtien = hd.getTongTien();
		return tongtien;
	}
	
	public String trangthai(String ma)
	{
		String tt = "";
		List<HoaDon> dshd = qlhd.getspbymas(ma);
		for (HoaDon hd : dshd) 
			tt = hd.getTinhTrang();
		return tt;
	}
	
	public void timkiembyten(String ten)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbytens(ten);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getTinhTrang(),nv.getNgayLap()});
					}
		
	}
	
	public void timkiembysdt(String sdt)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbysdts(sdt);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getTinhTrang(),nv.getNgayLap()});
					}
		
	}
	
	public void timkiembyngaylap(int nam,int thang,int ngay)
	{
		int d =0;
		List<HoaDon> dsnv = qlhd.getspbyngays(nam, thang, ngay);
		for (HoaDon nv : dsnv) {
						model.addRow(new Object[] {nv.getMaHD(), nv.getMaKH().trim(),
						nv.getTenKH().trim(), nv.getsDT(), nv.getDiaChi().trim(),nv.getTongTien(),
						nv.getTinhTrang(),nv.getNgayLap()});
					}
		
	}
	
	public void thanhtoan()
	{
		int row = table.getSelectedRow();
		String maHD = model.getValueAt(row,0).toString();
		if(trangthai(maHD).equalsIgnoreCase("Đã Thanh Toán"))
		{
			JOptionPane.showMessageDialog(this, "Đơn Hàng Đã Được Thanh Toán");
		}
		else
		{
			String nhaptien = JOptionPane.showInputDialog("Nhập Số Tiền Thanh Toán");
			if(nhaptien.equals(""))
			{
				JOptionPane.showMessageDialog(btnthanhtoan, "Bạn không được để trống");
			}
			else
			{
				if(!nhaptien.matches("^[0-9]+$"))
				{
					JOptionPane.showMessageDialog(btnthanhtoan, "Số tiền bạn nhập không đúng");
				}
				else
				{
					double tientt = Double.parseDouble(nhaptien);
					if(tientt<timkiemma(maHD))
					{
						JOptionPane.showMessageDialog(btnthanhtoan, "số tiền bạn nhập không đủ");
					}
					else
					{
						double tienthua = tientt-timkiemma(maHD);
						String tt = "Đã Thanh Toán";
							JOptionPane.showMessageDialog(btnthanhtoan, "Thanh Toán thành công \n Số tiền còn thối lại là = "+tienthua+"");
							lhd.updatehdtt(maHD, tt);
					}
				}
			}
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
				JasperReport report = JasperCompileManager.compileReport("src/gui/reportdondathang.jrxml");
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
	public void mouseClicked(MouseEvent e) {
		deleteAllDataTable1();
		loadallsptheoma();
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
}