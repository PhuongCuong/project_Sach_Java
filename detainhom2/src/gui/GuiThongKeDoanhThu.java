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
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangdao;
import dao.NhaCungCapdao;
import dao.ThongKeDoanhThud;
import dao.KhachHangdao;
import entities.HoaDon;
import entities.KhachHang;
import entities.SanPham;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import entities.KhachHang;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;

public class GuiThongKeDoanhThu extends JFrame implements ActionListener{

	public JPanel pntimkh;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private KhachHangdao khd;
	private JDateChooser ngaykia;
	private JDateChooser ngaynay;
	private JButton btnin;
	private JButton btnthongke;
	private JLabel lblngaynay;
	private JLabel lblNewLabel_3_1;
	private JLabel lblngaykia;
	private JComboBox cbxcalv;
	private JLabel lblcalv;
	private ThongKeDoanhThud tkdt;
	private JLabel lbltongsohd;
	private JLabel lbltongsotien;
	private JComboBox cbxtuychon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThongKeDoanhThu frame = new GuiThongKeDoanhThu();
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
	public GuiThongKeDoanhThu() {
		
		this.khd = new KhachHangdao();
		this.tkdt = new ThongKeDoanhThud();
		
		
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
		
		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(475, 0, 330, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimkh.add(panel_1);
		panel_1.setLayout(null);
		buttonGroupTim = new ButtonGroup();
		
				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Th\u1ED1ng K\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 70, 1246, 604);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Từ Ngày:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(238, 20, 86, 31);
		panel_3.add(lblNewLabel_3);
		
		lblngaynay = new JLabel("");
		lblngaynay.setForeground(Color.RED);
		lblngaynay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblngaynay.setBounds(456, 20, 173, 31);
		panel_3.add(lblngaynay);
		
		lblNewLabel_3_1 = new JLabel("Tới Ngày:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(238, 61, 86, 31);
		panel_3.add(lblNewLabel_3_1);
		
		lblngaykia = new JLabel("");
		lblngaykia.setForeground(Color.RED);
		lblngaykia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblngaykia.setBounds(456, 61, 173, 31);
		panel_3.add(lblngaykia);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ca:");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(238, 102, 86, 31);
		panel_3.add(lblNewLabel_3_1_1);
		
		lblcalv = new JLabel("");
		lblcalv.setForeground(Color.RED);
		lblcalv.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblcalv.setBounds(456, 102, 173, 31);
		panel_3.add(lblcalv);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Tổng Số Lần Bán Hàng:");
		lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBounds(238, 143, 194, 31);
		panel_3.add(lblNewLabel_3_1_1_1);
		
		lbltongsohd = new JLabel("");
		lbltongsohd.setForeground(Color.RED);
		lbltongsohd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltongsohd.setBounds(456, 143, 173, 31);
		panel_3.add(lbltongsohd);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Tổng Tiền Thu Được:");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1_1_1.setBounds(238, 190, 194, 31);
		panel_3.add(lblNewLabel_3_1_1_1_1_1);
		
		lbltongsotien = new JLabel("");
		lbltongsotien.setForeground(Color.RED);
		lbltongsotien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltongsotien.setBounds(456, 190, 173, 31);
		panel_3.add(lbltongsotien);
		String[] tb = new String[] { "STT", "Mã KH", "Tên KH", "Số Điện Thoại","Địa Chỉ", "Số Lần Mua Hàng","Số Tiền Mua Hàng"};
		
		model = new DefaultTableModel(tb,0);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(0, 0, 1246, 63);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Theo Tùy Chỉnh:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 10, 172, 29);
		panel_4.add(lblNewLabel_1);
		
		cbxtuychon = new JComboBox();
		cbxtuychon.setModel(new DefaultComboBoxModel(new String[] {"Tùy Chỉnh", "Ngày Hôm Nay", "Ngày Hôm Qua", "7 Ngày Qua", "Theo Tháng", "Theo Năm"}));
		cbxtuychon.setBounds(202, 11, 138, 29);
		panel_4.add(cbxtuychon);
		
		JLabel lblNewLabel_2 = new JLabel("Từ Ngày:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(350, 10, 64, 29);
		panel_4.add(lblNewLabel_2);
		
		ngaynay = new JDateChooser();
		ngaynay.getCalendarButton().setEnabled(false);
		ngaynay.setLocale(Locale.forLanguageTag("vi-VN"));
		ngaynay.setDateFormatString("dd-MM-yyyy");
		ngaynay.getCalendarButton().setEnabled(true);
		ngaynay.setBounds(413, 10, 138, 29);
		panel_4.add(ngaynay);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tới Ngày:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(561, 10, 64, 29);
		panel_4.add(lblNewLabel_2_1);
		
		ngaykia = new JDateChooser();
		ngaykia.getCalendarButton().setEnabled(false);
		ngaykia.setLocale(Locale.forLanguageTag("vi-VN"));
		ngaykia.setDateFormatString("dd-MM-yyyy");
		ngaykia.getCalendarButton().setEnabled(true);
		ngaykia.setBounds(630, 10, 138, 29);
		panel_4.add(ngaykia);
		
		btnthongke = new JButton("Thống Kê");
		btnthongke.setBackground(new Color(204, 204, 153));
		btnthongke.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthongke.setBounds(946, 7, 140, 35);
		panel_4.add(btnthongke);
		
		btnin = new JButton("In Báo Cáo");
		btnin.setBackground(new Color(204, 204, 153));
		btnin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnin.setBounds(1096, 7, 140, 35);
		panel_4.add(btnin);
		
		JLabel lblNewLabel_6 = new JLabel("Ca:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(778, 10, 31, 29);
		panel_4.add(lblNewLabel_6);
		
		cbxcalv = new JComboBox();
		cbxcalv.setModel(new DefaultComboBoxModel(new String[] {"6h-12h", "12h-18h", "18h-22h"}));
		cbxcalv.setBounds(819, 11, 115, 29);
		panel_4.add(cbxcalv);
		btnthongke.addActionListener(this);
		btnin.addActionListener(this);
	}
	
	
	public int tongsolanhomnay()
	{
		int tong;
		tong = tkdt.sohdhomnay(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public double tongsotienhomnay()
	{
		double tong;
		tong = tkdt.tienhdhomnay(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	
	public int tongsolanhomqua()
	{
		int tong;
		tong = tkdt.sohdhomqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public double tongsotienhomqua()
	{
		double tong;
		tong = tkdt.tienhdhomqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public int tongsohd7qua()
	{
		int tong;
		tong = tkdt.sohd7qua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public double tongsotien7qua()
	{
		double tong;
		tong = tkdt.tienhd7qua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public int tongsohdthangqua()
	{
		int tong;
		tong = tkdt.sohdthangqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public double tongsotienthangqua()
	{
		double tong;
		tong = tkdt.tienhdthangqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	public int tongsohdnamqua()
	{
		int tong;
		tong = tkdt.sohdnamqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public double tongsotiennamqua()
	{
		double tong;
		tong = tkdt.tienhdnamqua(cbxcalv.getSelectedItem().toString());
		return tong;
	}
	
	public int tongsohdtuychon()
	{
		int tong;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ngaynays = ngaynay.getDate();
		String ngaynayss = dateFormat.format(ngaynays);
		System.out.println(ngaynayss);
		java.util.Date ngaykias = ngaykia.getDate();
		String ngaykiass = dateFormat.format(ngaykias);
		System.out.println(ngaykiass);
		tong = tkdt.sohdtuychon(cbxcalv.getSelectedItem().toString(),ngaynayss,ngaykiass);
		return tong;
	}
	
	public double tongsotientuychon()
	{
		double tong;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ngaynays = ngaynay.getDate();
		String ngaynayss = dateFormat.format(ngaynays);
		System.out.println(ngaynayss);
		java.util.Date ngaykias = ngaykia.getDate();
		String ngaykiass = dateFormat.format(ngaykias);
		System.out.println(ngaykiass);
		tong = tkdt.tienhdtuychon(cbxcalv.getSelectedItem().toString(),ngaynayss,ngaykiass);
		return tong;
	}
	
	public void inthongketheonam()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("ngaynay", lblngaynay.getText());
				m.put("ngaykia", lblngaykia.getText());
				m.put("calv", lblcalv.getText());
				m.put("tongsohd", lbltongsohd.getText());
				m.put("tongsotien", lbltongsotien.getText());
				datasource.add(m);
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/reportthongkedoanhthu.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	public void inthongketheo7ngay()
//	{
//		try {
//			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
//			List<SanPham> dssp = tksd.getthongketheo7ngayqua();
//			for (SanPham sp : dssp) {
//				Map<String, Object> m = new HashMap<String , Object>();
//				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
//				m.put("sosach", lblsosach.getText());
//				m.put("COLUMN_0", sp.getMaSP());
//				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
//				m.put("COLUMN_2", sp.getTenSP());
//				m.put("COLUMN_3", sp.getTenNSB());
//				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
//				m.put("COLUMN_5", sp.getDonVT());
//				m.put("COLUMN_6", sp.getDonGia());
//				m.put("COLUMN_7", sp.getSoLuong());
//				
//				datasource.add(m);
//			}
//			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
//			String link = "src/gui/thongkesach.jrxml";
//			JasperReport report = JasperCompileManager.compileReport(link);
//			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
//			JasperViewer.viewReport(jasperprint, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	public void inthongkehomqua()
//	{
//		try {
//			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
//			List<SanPham> dssp = tksd.getthongkengayhomqua();
//			for (SanPham sp : dssp) {
//				Map<String, Object> m = new HashMap<String , Object>();
//				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
//				m.put("sosach", lblsosach.getText());
//				m.put("COLUMN_0", sp.getMaSP());
//				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
//				m.put("COLUMN_2", sp.getTenSP());
//				m.put("COLUMN_3", sp.getTenNSB());
//				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
//				m.put("COLUMN_5", sp.getDonVT());
//				m.put("COLUMN_6", sp.getDonGia());
//				m.put("COLUMN_7", sp.getSoLuong());
//				
//				datasource.add(m);
//			}
//			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
//			String link = "src/gui/thongkesach.jrxml";
//			JasperReport report = JasperCompileManager.compileReport(link);
//			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
//			JasperViewer.viewReport(jasperprint, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	public void inthongkehomnay()
//	{
//		try {
//			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
//			List<SanPham> dssp = tksd.getthongkengayhomnay();
//			for (SanPham sp : dssp) {
//				Map<String, Object> m = new HashMap<String , Object>();
//				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
//				m.put("sosach", lblsosach.getText());
//				m.put("COLUMN_0", sp.getMaSP());
//				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
//				m.put("COLUMN_2", sp.getTenSP());
//				m.put("COLUMN_3", sp.getTenNSB());
//				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
//				m.put("COLUMN_5", sp.getDonVT());
//				m.put("COLUMN_6", sp.getDonGia());
//				m.put("COLUMN_7", sp.getSoLuong());
//				
//				datasource.add(m);
//			}
//			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
//			String link = "src/gui/thongkesach.jrxml";
//			JasperReport report = JasperCompileManager.compileReport(link);
//			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
//			JasperViewer.viewReport(jasperprint, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	public void inthongketuychinh(String n1, String n2)
//	{
//		try {
//			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
//			List<SanPham> dssp = tksd.getthongketungaynayquangaykhac(n1,n2);
//			for (SanPham sp : dssp) {
//				Map<String, Object> m = new HashMap<String , Object>();
//				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
//				m.put("sosach", lblsosach.getText());
//				m.put("COLUMN_0", sp.getMaSP());
//				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
//				m.put("COLUMN_2", sp.getTenSP());
//				m.put("COLUMN_3", sp.getTenNSB());
//				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
//				m.put("COLUMN_5", sp.getDonVT());
//				m.put("COLUMN_6", sp.getDonGia());
//				m.put("COLUMN_7", sp.getSoLuong());
//				
//				datasource.add(m);
//			}
//			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
//			String link = "src/gui/thongkesach.jrxml";
//			JasperReport report = JasperCompileManager.compileReport(link);
//			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
//			JasperViewer.viewReport(jasperprint, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	public void inthongketheothang()
//	{
//		try {
//			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
//			List<SanPham> dssp = tksd.getthongketheothang();
//			for (SanPham sp : dssp) {
//				Map<String, Object> m = new HashMap<String , Object>();
//				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
//				m.put("sosach", lblsosach.getText());
//				m.put("COLUMN_0", sp.getMaSP());
//				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
//				m.put("COLUMN_2", sp.getTenSP());
//				m.put("COLUMN_3", sp.getTenNSB());
//				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
//				m.put("COLUMN_5", sp.getDonVT());
//				m.put("COLUMN_6", sp.getDonGia());
//				m.put("COLUMN_7", sp.getSoLuong());
//				
//				datasource.add(m);
//			}
//			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
//			String link = "src/gui/thongkesach.jrxml";
//			JasperReport report = JasperCompileManager.compileReport(link);
//			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
//			JasperViewer.viewReport(jasperprint, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		if(gui.equals(btnthongke))
		{
			if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Ngày Hôm Nay"))
			{
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsolanhomnay()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsotienhomnay())+" VND");
			}
			else if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Ngày Hôm Qua"))
			{
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsolanhomqua()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsotienhomqua())+" VND");
			}
			else if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("7 Ngày Qua"))
			{
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsohd7qua()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsotien7qua())+" VND");
			}
			else if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Theo Tháng"))
			{
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsohdthangqua()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsohdthangqua())+" VND");
			}
			else if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Theo Năm"))
			{
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsohdnamqua()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsotiennamqua())+" VND");
			}
			else if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Tùy Chỉnh"))
			{
				Date ngaySinhsqlnay = null;
				Date ngaySinhsqlkia = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String ngaySinhtxtnay = dateFormat.format(ngaynay.getDate());
					java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxtnay);
					ngaySinhsqlnay = new Date(ngaySinh.getTime());
					String ngaySinhtxtkia = dateFormat.format(ngaykia.getDate());
					java.util.Date ngaySinhs = dateFormat.parse(ngaySinhtxtkia);
					ngaySinhsqlkia = new Date(ngaySinhs.getTime());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				lblngaynay.setText(ngaySinhsqlnay+"");
				lblngaykia.setText(ngaySinhsqlkia+"");
				lblcalv.setText(cbxcalv.getSelectedItem().toString());
				lbltongsohd.setText(tongsohdtuychon()+"");
				DecimalFormat tien = new DecimalFormat("#,##0.00");
				lbltongsotien.setText(tien.format(tongsotientuychon())+" VND");
			}
		}
		else if(gui.equals(btnin))
		{
			if(cbxtuychon.getSelectedItem().toString().equalsIgnoreCase("Theo Năm"))
			{
				inthongketheonam();
			}
		}
		
	}
}
