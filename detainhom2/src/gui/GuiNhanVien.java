package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import dao.NhanViendao;
import database.KetNoidata;
import entities.KhachHang;
import entities.NhanVien;
import entities.User;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class GuiNhanVien extends JFrame implements MouseListener,ActionListener{

	public static JPanel pnnhanvien;
	private JTextField txtmanv;
	private static JTextField txthonv;
	private static JTextField txttennv;
	private static JTextField txtsdt;
	private static JTextField txtdiachi;
	private static JTextField txtsocmnd;
	private static DefaultTableModel model;
	private static JTable table;
	private JRadioButton radma;
	private JRadioButton radten;
	private JRadioButton radsdt;
	private JButton btntimkiem;
	private ButtonGroup buttonGroupTim;
	private JButton btnlammoitk;
	private JRadioButton radcmnd;
	private static NhanViendao nvd;
	private static JDateChooser txtngaysinh;
	private static JComboBox cbxgt;
	private static JComboBox cbxclv;
	private static JComboBox cbxlnv;
	private JButton btnxoa;
	private JButton btnlammoi;
	private JButton btncapnhat;
	public static JTextField txtk;
	private JTextField txttimkiem;
	public static JButton btnthem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiNhanVien frame = new GuiNhanVien();
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
	public GuiNhanVien() {
		
		KetNoidata.getin().getcon();
		this.nvd = new NhanViendao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnnhanvien = new JPanel();
		pnnhanvien.setBorder(new EmptyBorder(5, 5, 5, 5));
//		this.setLocationRelativeTo(this);
		this.setSize(1270, 790);
		setContentPane(pnnhanvien);
		pnnhanvien.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 66);
		pnnhanvien.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(494, 10, 353, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 69, 1256, 234);
		pnnhanvien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(88, 17, 45, 18);
		panel_1.add(lblNewLabel_1);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(143, 15, 161, 26);
		txtmanv.setEditable(false);
		panel_1.add(txtmanv);
		txtmanv.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Họ NV");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(646, 20, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		txthonv = new JTextField();
		txthonv.setBounds(701, 15, 450, 26);
		panel_1.add(txthonv);
		txthonv.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tên NV");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(83, 56, 56, 13);
		panel_1.add(lblNewLabel_3);
		
		txttennv = new JTextField();
		txttennv.setBounds(143, 51, 450, 26);
		panel_1.add(txttennv);
		txttennv.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(622, 53, 69, 18);
		panel_1.add(lblNewLabel_4);
		
		txtngaysinh = new JDateChooser();
		txtngaysinh.getCalendarButton().setEnabled(false);
		txtngaysinh.setLocale(Locale.forLanguageTag("vi-VN"));
		txtngaysinh.setDateFormatString("dd-MM-yyyy");
		txtngaysinh.getCalendarButton().setEnabled(true);
		txtngaysinh.setBounds(701, 51, 450, 26);
		panel_1.add(txtngaysinh);
		
		JLabel lblNewLabel_5 = new JLabel("Giới Tính");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(633, 128, 58, 13);
		panel_1.add(lblNewLabel_5);
		
		cbxgt = new JComboBox();
		cbxgt.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ ", "Khác"}));
		cbxgt.setBounds(701, 122, 69, 26);
		panel_1.add(cbxgt);
		
		JLabel lblNewLabel_6 = new JLabel("Số Điện Thoại");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(603, 92, 88, 13);
		panel_1.add(lblNewLabel_6);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(701, 87, 450, 26);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Địa Chỉ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(81, 92, 58, 13);
		panel_1.add(lblNewLabel_7);
		
		txtdiachi = new JTextField();
		txtdiachi.setBounds(143, 87, 450, 26);
		panel_1.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ca Làm Việc");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(973, 128, 88, 13);
		panel_1.add(lblNewLabel_8);
		
		cbxclv = new JComboBox();
		cbxclv.setModel(new DefaultComboBoxModel(new String[] {"6h-12h", "12h-18h", "18h-22h"}));
		cbxclv.setBounds(1071, 122, 80, 26);
		panel_1.add(cbxclv);
		
		JLabel lblNewLabel_9 = new JLabel("Số CMND");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(70, 125, 69, 18);
		panel_1.add(lblNewLabel_9);
		
		txtsocmnd = new JTextField();
		txtsocmnd.setBounds(143, 123, 450, 26);
		panel_1.add(txtsocmnd);
		txtsocmnd.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Loại Nhân Viên");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(785, 128, 99, 13);
		panel_1.add(lblNewLabel_10);
		
		cbxlnv = new JComboBox();
		cbxlnv.setModel(new DefaultComboBoxModel(new String[] {"QL ", "NV"}));
		cbxlnv.setBounds(894, 122, 69, 26);
		panel_1.add(cbxlnv);
		
		btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		btnxoa.setIcon(new ImageIcon("Img\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(423, 172, 141, 41);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(204, 204, 153));
		btncapnhat.setIcon(new ImageIcon("Img\\Users-Edit-User-icon (1).png"));
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(578, 172, 141, 41);
		panel_1.add(btncapnhat);
		
		btnlammoi = new JButton("Làm Mới");
		btnlammoi.setBackground(new Color(204, 204, 153));
		btnlammoi.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoi.setBounds(729, 172, 141, 41);
		panel_1.add(btnlammoi);
		
		JLabel lblNewLabel_11 = new JLabel("Tên Tài Khoản");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(314, 17, 99, 18);
		panel_1.add(lblNewLabel_11);
		
		txtk = new JTextField();
		txtk.setEditable(false);
		txtk.setBounds(423, 15, 170, 26);
		panel_1.add(txtk);
		txtk.setColumns(10);
		
		btnthem = new JButton("Thêm");
		btnthem.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Ecommerce-New-icon.png"));
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(272, 172, 141, 41);
		panel_1.add(btnthem);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 314, 1256, 298);
		pnnhanvien.add(panel_2);
		panel_2.setLayout(null);
		String[] tb = new String[] { "STT", "Mã NV", "Họ NV", "Tên NV", "Ngày Sinh", "Giới Tính", "Số Điện Thoại","Địa Chỉ","Ca Làm Việc","Số CMND","Loại Nhân Viên","Tên Tài Khoản" };
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1250, 266);
		panel_2.add(scrollPane);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 622, 1256, 131);
		pnnhanvien.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbltimkiem = new JLabel("Thông Tin Tìm Kiếm:");
		lbltimkiem.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbltimkiem.setBounds(10, 28, 202, 31);
		panel_3.add(lbltimkiem);
		
		radma = new JRadioButton("Mã");
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(187, 80, 57, 21);
		panel_3.add(radma);
		
		JLabel lbltimkiemnv = new JLabel("Tìm Kiếm:");
		lbltimkiemnv.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbltimkiemnv.setBounds(89, 77, 92, 21);
		panel_3.add(lbltimkiemnv);
		
		radten = new JRadioButton("Tên");
		radten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radten.setBounds(246, 80, 57, 21);
		panel_3.add(radten);
		
		radsdt = new JRadioButton("Số Điện Thoại");
		radsdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radsdt.setBounds(305, 80, 122, 21);
		panel_3.add(radsdt);
		
		radcmnd = new JRadioButton("Số CMND");
		radcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radcmnd.setBounds(429, 80, 92, 21);
		panel_3.add(radcmnd);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(549, 26, 141, 41);
		panel_3.add(btntimkiem);
		
		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radma);
		buttonGroupTim.add(radsdt);
		buttonGroupTim.add(radten);
		buttonGroupTim.add(radcmnd);
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(714, 26, 141, 41);
		panel_3.add(btnlammoitk);
		
		JButton btnthoat = new JButton("Thoát");
		btnthoat.setBackground(new Color(204, 204, 153));
		btnthoat.setIcon(new ImageIcon("Img\\Close-icon.png"));
		btnthoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthoat.setBounds(873, 26, 141, 41);
		panel_3.add(btnthoat);
		
		txttimkiem = new JTextField();
		txttimkiem.setBounds(201, 30, 320, 26);
		panel_3.add(txttimkiem);
		txttimkiem.setColumns(10);
		docDuLieu();
		table.addMouseListener(this);
		btnlammoi.addActionListener(this);
		btnxoa.addActionListener(this);
		btncapnhat.addActionListener(this);
		btntimkiem.addActionListener(this);
		btnlammoitk.addActionListener(this);
		btnthem.addActionListener(this);
	}
	
	public static void docDuLieu() {
		try {
			List<NhanVien> list = nvd.getallnhanvien();
			int i = 0;
			for (NhanVien nv : list) {
				i++;
				model.addRow(new Object[] { i + "", nv.getMaNV(), nv.getHoNV().trim(),
						nv.getTenNV().trim(), nv.getNgaySinh(), nv.getGioiTinh().trim(),nv.getsDt().trim(),
						nv.getDiaChi().trim(),nv.getCaLamViec().trim(),nv.getSoCMND().trim(),nv.getLoaiNV().trim(),nv.getTenTK().getTaikhoan()});
			}
			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static void themnhanvien()
	{
		String i = nvd.maNVmax();
		System.out.println(i);
		String chuoi = i.substring(2);
		int ma = Integer.parseInt(chuoi);
		System.out.println(ma);
		int mamoi = ma+1;
		String chuoima = "";
		if(mamoi<10)
			chuoima += "NV0"+mamoi;
		else
			chuoima += "NV"+mamoi;
		String honv = txthonv.getText().trim();
		String tennv = txttennv.getText().trim();
		Date ngaySinhsql = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(txtngaysinh.getDate());
			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		String gt = cbxgt.getSelectedItem().toString();
		String sdt = txtsdt.getText().trim();
		String dc = txtdiachi.getText().trim();
		String calv = cbxclv.getSelectedItem().toString();
		String socmnd = txtsocmnd.getText().trim();
		String lnv = cbxlnv.getSelectedItem().toString();
		User tk = new User();
		tk.setTaikhoan(txtk.getText());
		NhanVien nv = new NhanVien(chuoima, honv, tennv, ngaySinhsql, gt, sdt, dc, calv, socmnd, lnv);
		nv.setTenTK(tk);
		nvd.themNV(nv);
	}
	
	
	public void themNV()
	{
		Date ngaySinhsql = null;
		String dangbuoc = "";
		String honv = txthonv.getText().trim();
		String tennv = txttennv.getText().trim();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ngaySinhtxt = null;
		java.util.Date ngaySinh = null;
		int yearsql = 0;
		String year = null;
		try {
			ngaySinhtxt = dateFormat.format(txtngaysinh.getDate());
			ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());

			year = ngaySinhsql.toString().substring(0, 4);
			yearsql = Integer.parseInt(year);

		} catch (Exception e2) {
			// TODO: handle exception
		}

		String gt = (String) cbxgt.getSelectedItem();
		String sdt = txtsdt.getText().trim();
		String dc = txtdiachi.getText().trim();
		String calv = (String) cbxclv.getSelectedItem();
		String cmnd = txtsocmnd.getText().trim();
		String lnv = (String) cbxlnv.getSelectedItem();
		if(honv.equalsIgnoreCase(""))
		{
			dangbuoc += "Vui Lòng Nhập Họ!\n";
		}
		else if(honv.length()>30)
		{
			dangbuoc += "Họ Không Hợp Lệ !\n";
		}
		if(tennv.equalsIgnoreCase(""))
		{
			dangbuoc += "Vui Lòng Nhập Tên !\n";
		}else if(tennv.length()>10)
		{
			dangbuoc += "Tên Nhân Viên Không Hợp Lệ ! \n";
		}
		if(year==null)
		{
			dangbuoc+="Vui Lòng Nhập Ngày Sinh !\n";
		}else if(LocalDate.now().getYear() - yearsql >60 || LocalDate.now().getYear() - yearsql <18)
		{
			dangbuoc += "Tuổi Nhân Viên Phải Từ 18-60 tuổi !\n";
		}
		if(sdt.equalsIgnoreCase(""))
		{
			dangbuoc+= "vui lòng nhập số điện thoại!\n";
		}else if(!sdt.matches("^0[0-9]{9}$"))
		{
			dangbuoc += "Số điện thoại phải có 10 số và bắt đầu từ số 0!\n";
		}
		if(cmnd.equalsIgnoreCase(""))
		{
			dangbuoc +="Vui lòng nhập số chứng minh nhân dân !\n";
		}
		else if(!cmnd.matches("^[0-9]{12}$"))
		{
			dangbuoc += "Số chứng minh nhân dân phải có 12 số !\n";
		}
		if(dangbuoc =="")
		{
			new GuiDangKy().setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(this, dangbuoc, "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Img\\warning.png"));
		}
	}

	public static void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		String maNV = model.getValueAt(row, 1).toString();
		try {
			NhanVien nv = nvd.layThongTinnhanvien(maNV);
			txtmanv.setText(maNV + "");
			txthonv.setText(nv.getHoNV());
			txttennv.setText(nv.getTenNV());
			txtngaysinh.setDate(nv.getNgaySinh());
			cbxgt.getModel().setSelectedItem(nv.getGioiTinh());
			txtsdt.setText(nv.getsDt());
			txtdiachi.setText(nv.getDiaChi());
			cbxclv.getModel().setSelectedItem(nv.getCaLamViec());
			txtsocmnd.setText(nv.getSoCMND());
			cbxlnv.getModel().setSelectedItem(nv.getLoaiNV());
			txtk.setText(nv.getTenTK().getTaikhoan());

		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
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
		Object gui = e.getSource();
		if(gui.equals(btnthem))
		{
			themNV();
		}
		if(gui.equals(btnlammoi))
		{
			deleteAllDataTable();
			docDuLieu();
		}
		if(gui.equals(btnxoa))
		{
			xoaNV();
			deleteAllDataTable();
			docDuLieu();
		}
		if(gui.equals(btncapnhat))
		{
			capnhat();
		}
		if(gui.equals(btnlammoitk))
		{
			txttimkiem.setText("");
			txttimkiem.selectAll();
			txttimkiem.requestFocus();
			deleteAllDataTable();
			docDuLieu();
		}
		if(gui.equals(btntimkiem))
		{
			if(radma.isSelected()==false && radten.isSelected() == false && radsdt.isSelected() ==false && radcmnd.isSelected()==false && txttimkiem.getText().trim().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm!");
			}
			else if (radma.isSelected()==false && radten.isSelected() == false && radsdt.isSelected()==false && radcmnd.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm!");
			}
			else if(txttimkiem.getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
			}
			else {
				if(radma.isSelected()==true)
				{
					try {
						String ma = txttimkiem.getText().trim();
						getTimKiemKhachHangById(ma);
					} catch (Exception e2) {
						if(!txtmanv.getText().equalsIgnoreCase(""))
						{
							JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi!");
							txttimkiem.requestFocus();
							txttimkiem.selectAll();
							
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
							txttimkiem.requestFocus();
							txttimkiem.selectAll();
						}
						// TODO: handle exception
					}
			
					
				}
				if(radten.isSelected()==true)
				{
					String ten = txttimkiem.getText().trim();
					getTimKiemKhachHangByTen(ten);
				}
				if(radsdt.isSelected()==true)
				{
					String sdt = txttimkiem.getText().trim();
					getTimKiemKhachHangBySoDT(sdt);
				}
				if(radcmnd.isSelected()==true)
				{
					String cmnd = txttimkiem.getText().trim();
					getTimKiemKhachHangByCMND(cmnd);
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	public void xoaNV()
	{
		String ma = txtmanv.getText();
		if(ma.equals(""))
		{
			JOptionPane.showMessageDialog(this, "bạn vui lòng chọn khách hàng cần xóa");
		}
		else {
			if(JOptionPane.showConfirmDialog(this, "bạn có chắc xóa khách hàng này không ?", "Lựa Chọn Của Bạn!", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				if(nvd.xoanhanvien(ma)==true)
				{
					JOptionPane.showMessageDialog(this, "Xóa Thành Công");
					deleteAllDataTable();
					docDuLieu();
				}
				else
					JOptionPane.showMessageDialog(this, "Xóa Thất bại");
			}
		}
	}
	public void capnhat()
	{
		int row = table.getSelectedRow();
		if(row !=-1)
		{
			Date ngaySinhsql = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = null;
			java.util.Date ngaySinh = null;
			int yearsql = 0;
			String year = null;
			try {
				ngaySinhtxt = dateFormat.format(txtngaysinh.getDate());
				ngaySinh = dateFormat.parse(ngaySinhtxt);
				ngaySinhsql = new Date(ngaySinh.getTime());

				year = ngaySinhsql.toString().substring(0, 4);
				yearsql = Integer.parseInt(year);

			} catch (Exception e2) {
				// TODO: handle exception
			}
			String ma = txtmanv.getText().trim();
			String ho = txthonv.getText().trim();
			String ten = txttennv.getText().trim();
			String gt = (String) cbxgt.getSelectedItem();
			String sdt = txtsdt.getText().trim();
			String diachi = txtdiachi.getText().trim();
			String cmnd = txtsocmnd.getText().trim();
			String clv = (String) cbxclv.getSelectedItem();
			String loainv = (String) cbxlnv.getSelectedItem();
			String dangbuoc = "";
			if(ho.equalsIgnoreCase(""))
			{
				dangbuoc += "Vui Lòng Nhập Họ!\n";
			}
			else if(ho.length()>30)
			{
				dangbuoc += "Họ Không Hợp Lệ !\n";
			}
			if(ten.equalsIgnoreCase(""))
			{
				dangbuoc += "Vui Lòng Nhập Tên !\n";
			}else if(ten.length()>10)
			{
				dangbuoc += "Tên Nhân Viên Không Hợp Lệ ! \n";
			}
			
			if(year==null)
			{
				dangbuoc+="Vui Lòng Nhập Ngày Sinh !\n";
			}
			else if(LocalDate.now().getYear() - yearsql >60 || LocalDate.now().getYear() - yearsql <18)
			{
				dangbuoc += "Tuổi Nhân Viên Phải Từ 18-60 tuổi !\n";
			}
			if(sdt.equalsIgnoreCase(""))
			{
				dangbuoc+= "vui lòng nhập số điện thoại!\n";
			}else if(!sdt.matches("^0[0-9]{9}$"))
			{
				dangbuoc += "Số điện thoại phải có 10 số và bắt đầu từ số 0!\n";
			}
			if(cmnd.equalsIgnoreCase(""))
			{
				dangbuoc +="Vui lòng nhập số chứng minh nhân dân !\n";
			}
			else if(!cmnd.matches("^[0-9]{12}$"))
			{
				dangbuoc += "Số chứng minh nhân dân phải có 12 số !\n";
			}
			if(dangbuoc =="")
			{
				if(nvd.updatenhanvien(ma, ho, ten, ngaySinhsql, gt, sdt, diachi, clv, cmnd, loainv))
				{
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					deleteAllDataTable();
					docDuLieu();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "cập nhật thất bại");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, dangbuoc, "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Bạn Phải Chọn Một Dòng Để Cập Nhật !");
		}
	}
	public void getTimKiemKhachHangById(String ma) {
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) nvd.timkiemnvma(ma);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
	
	public void getTimKiemKhachHangByTen(String ten) {
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) nvd.timkiemnvten(ten);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangByCMND(String cmnd) {
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) nvd.timkiemnvcmnd(cmnd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangBySoDT(String sdt) {
		ArrayList<NhanVien> list = null;
		try {
			list = (ArrayList<NhanVien>) nvd.timkiemnvsdt(sdt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NhanVien khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
}
