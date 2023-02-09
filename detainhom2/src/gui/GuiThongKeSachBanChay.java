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
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.SQLException;
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
import dao.ThongKeSachdao;
import dao.KhachHangdao;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhaCungCap;
import entities.SanPham;
import entities.TheLoai;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import entities.KhachHang;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.toedter.calendar.JDateChooser;

public class GuiThongKeSachBanChay extends JFrame implements ActionListener{

	public JPanel pnsachchay;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private KhachHangdao khd;
	private JComboBox cbxtuychon;
	private ThongKeSachdao tksd;
	private JButton btnthongke;
	private JDateChooser txtngaynay;
	private JDateChooser txtngaykia;
	private JLabel lblsosach;
	private JButton btninbaocao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThongKeSachBanChay frame = new GuiThongKeSachBanChay();
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
	public GuiThongKeSachBanChay() {
		
		this.khd = new KhachHangdao();
		this.tksd = new ThongKeSachdao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnsachchay = new JPanel();
		pnsachchay.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setContentPane(pnsachchay);
		pnsachchay.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pnsachchay.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Sách Bán Chạy");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(461, 0, 388, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pnsachchay.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 598, 1246, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Số Sách Đã Bán:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(251, 23, 190, 32);
		panel_2.add(lblNewLabel_3);
		
		lblsosach = new JLabel("...");
		lblsosach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblsosach.setBounds(451, 23, 101, 32);
		panel_2.add(lblsosach);
		
		btninbaocao = new JButton("In Báo Cáo");
		btninbaocao.setBackground(new Color(204, 204, 153));
		btninbaocao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btninbaocao.setBounds(567, 23, 140, 35);
		panel_2.add(btninbaocao);
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
		
		table = new JTable(model);
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
		
		cbxtuychon = new JComboBox();
		cbxtuychon.setModel(new DefaultComboBoxModel(new String[] {"Tùy Chỉnh", "Ngày Hôm Nay", "Ngày Hôm Qua", "7 Ngày Qua", "Theo Tháng", "Theo Năm"}));
		cbxtuychon.setBounds(264, 11, 138, 29);
		panel_4.add(cbxtuychon);
		
		JLabel lblNewLabel_2 = new JLabel("Từ Ngày:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(412, 11, 64, 29);
		panel_4.add(lblNewLabel_2);
		
		txtngaynay = new JDateChooser();
		//txtngaykia.setEnabled(false);
		txtngaynay.getCalendarButton().setEnabled(false);
		txtngaynay.setLocale(Locale.forLanguageTag("vi-VN"));
		txtngaynay.setDateFormatString("dd-MM-yyyy");
		txtngaynay.getCalendarButton().setEnabled(true);
		txtngaynay.setBounds(481, 10, 138, 29);
		panel_4.add(txtngaynay);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tới Ngày:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(629, 10, 64, 29);
		panel_4.add(lblNewLabel_2_1);
		
		txtngaykia = new JDateChooser();
		//txtngaykia.setEnabled(false);
		txtngaykia.getCalendarButton().setEnabled(false);
		txtngaykia.setLocale(Locale.forLanguageTag("vi-VN"));
		txtngaykia.setDateFormatString("dd-MM-yyyy");
		txtngaykia.getCalendarButton().setEnabled(true);
		txtngaykia.setBounds(703, 10, 138, 29);
		panel_4.add(txtngaykia);
		
		btnthongke = new JButton("Thống Kê");
		btnthongke.setBackground(new Color(204, 204, 153));
		btnthongke.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthongke.setBounds(867, 8, 140, 35);
		panel_4.add(btnthongke);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllDataTable();
			}
		});
		btnLmMi.setBackground(new Color(204, 204, 153));
		btnLmMi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLmMi.setBounds(1032, 8, 140, 35);
		panel_4.add(btnLmMi);
		btnthongke.addActionListener(this);
		btninbaocao.addActionListener(this);
	}
	
	
	
	
	public static void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	
	public void thongkehomqua()
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongkengayhomqua();
			for (SanPham sp : dssp) {
				model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
						sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
						sp.getSoLuong()});
				tong += sp.getSoLuong();
			}
			lblsosach.setText(tong+"Quyển");
	}
	
	public void thongkengayhomnay()
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongkengayhomnay();
		for (SanPham sp : dssp) {
			model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
					sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
					sp.getSoLuong()});
			tong += sp.getSoLuong();
		}
		lblsosach.setText(tong+"Quyển");
	}
	public void thongketheo7ngay()
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongketheo7ngayqua();
		for (SanPham sp : dssp) {
			model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
					sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
					sp.getSoLuong()});
			tong += sp.getSoLuong();
		}
		lblsosach.setText(tong+"Quyển");
	}
	
	public void thongkechon(String n1, String n2)
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongketungaynayquangaykhac(n1,n2);
		for (SanPham sp : dssp) {
			model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
					sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
					sp.getSoLuong()});
			tong += sp.getSoLuong();
		}
		lblsosach.setText(tong+"Quyển");
	}
	
	public void thongkethang()
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongketheothang();
		for (SanPham sp : dssp) {
			model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
					sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
					sp.getSoLuong()});
			tong += sp.getSoLuong();
		}
		lblsosach.setText(tong+"Quyển");
	}
	
	public void thongkenam()
	{
		deleteAllDataTable();
		int i =1;
		int tong = 0;
		List<SanPham> dssp = tksd.getthongketheonam();
		for (SanPham sp : dssp) {
			model.addRow(new Object[] {i++,sp.getMaSP(),sp.getTheLoai().getTenTL(),
					sp.getTenSP().trim(), sp.getTenNSB().trim(), sp.getTenNCC().getTenNCC(),sp.getDonVT(),sp.getDonGia(),
					sp.getSoLuong()});
			tong += sp.getSoLuong();
		}
		lblsosach.setText(tong+"Quyển");
	}
	
	public void inthongketheonam()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongketheonam();
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inthongketheo7ngay()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongketheo7ngayqua();
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inthongkehomqua()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongkengayhomqua();
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inthongkehomnay()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongkengayhomnay();
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inthongketuychinh(String n1, String n2)
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongketungaynayquangaykhac(n1,n2);
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inthongketheothang()
	{
		try {
			List<Map<String, ?>> datasource = new ArrayList<Map<String, ?>>();
			List<SanPham> dssp = tksd.getthongketheothang();
			for (SanPham sp : dssp) {
				Map<String, Object> m = new HashMap<String , Object>();
				m.put("thongke", "THỐNG KÊ SÁCH BÁN CHẠY");
				m.put("sosach", lblsosach.getText());
				m.put("COLUMN_0", sp.getMaSP());
				m.put("COLUMN_1", sp.getTheLoai().getTenTL());
				m.put("COLUMN_2", sp.getTenSP());
				m.put("COLUMN_3", sp.getTenNSB());
				m.put("COLUMN_4", sp.getTenNCC().getTenNCC());
				m.put("COLUMN_5", sp.getDonVT());
				m.put("COLUMN_6", sp.getDonGia());
				m.put("COLUMN_7", sp.getSoLuong());
				
				datasource.add(m);
			}
			JRDataSource frdatasource = new JRBeanCollectionDataSource(datasource);
			String link = "src/gui/thongkesach.jrxml";
			JasperReport report = JasperCompileManager.compileReport(link);
			JasperPrint jasperprint = JasperFillManager.fillReport(report, null,frdatasource);
			JasperViewer.viewReport(jasperprint, false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		if(gui.equals(btnthongke))
		{
			if(cbxtuychon.getSelectedItem().toString()=="")
			{
				JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn loại thống kê!");
			}
			else if(cbxtuychon.getSelectedItem().equals("Ngày Hôm Qua"))
			{
				thongkehomqua();
			}
			else if(cbxtuychon.getSelectedItem().equals("Ngày Hôm Nay"))
			{
				thongkengayhomnay();
			}
			else if(cbxtuychon.getSelectedItem().equals("7 Ngày Qua"))
			{
				thongketheo7ngay();
			}
			else if(cbxtuychon.getSelectedItem().equals("Tùy Chỉnh"))
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date ngaynay = txtngaynay.getDate();
				String ngaynays = dateFormat.format(ngaynay);
				System.out.println(ngaynays);
				java.util.Date ngaykia = txtngaykia.getDate();
				String ngaykias = dateFormat.format(ngaykia);
				System.out.println(ngaykias);
				thongkechon(ngaynays, ngaykias);
			}
			else if(cbxtuychon.getSelectedItem().equals("Theo Tháng"))
			{
				thongkethang();
			}
			else if(cbxtuychon.getSelectedItem().equals("Theo Năm"))
			{
				thongkenam();
			}
		}
		if(gui.equals(btninbaocao))
		{
			if(cbxtuychon.getSelectedItem().toString()=="")
			{
				JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn loại thống kê!");
			}
			else if(cbxtuychon.getSelectedItem().equals("Ngày Hôm Qua"))
			{
				inthongkehomqua();
			}
			else if(cbxtuychon.getSelectedItem().equals("Ngày Hôm Nay"))
			{
				inthongkehomnay();
			}
			else if(cbxtuychon.getSelectedItem().equals("7 Ngày Qua"))
			{
				inthongketheo7ngay();
			}
			else if(cbxtuychon.getSelectedItem().equals("Tùy Chỉnh"))
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date ngaynay = txtngaynay.getDate();
				String ngaynays = dateFormat.format(ngaynay);
				System.out.println(ngaynays);
				java.util.Date ngaykia = txtngaykia.getDate();
				String ngaykias = dateFormat.format(ngaykia);
				System.out.println(ngaykias);
				inthongketuychinh(ngaynays, ngaykias);
			}
			else if(cbxtuychon.getSelectedItem().equals("Theo Tháng"))
			{
				inthongketheothang();
			}
			else if(cbxtuychon.getSelectedItem().equals("Theo Năm"))
			{
				inthongketheonam();
			}
		}
	}
}
