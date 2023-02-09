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
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
import database.KetNoidata;
import entities.KhachHang;
import entities.NhanVien;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class GuiKhachHang extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnkhachhang;
	private JTextField txtma;
	private JTextField txtho;
	private JTextField txtten;
	private JTextField txtsdt;
	private JTextField txtdc;
	private JTable table;
	private DefaultTableModel model;
	private KhachHangdao khd;
	private JDateChooser txtngaysinh;
	private JComboBox cbxgt;
	private JRadioButton radma;
	private JRadioButton radten;
	private JRadioButton radsdt;
	private JButton btntimkiem;
	private JButton btnlammoitk;
	private ButtonGroup buttonGroupTim;
	private JTextField txtcmnd;
	private JButton btnlammoikh;
	private JButton btnxoa;
	private JButton btncapnhat;
	private JRadioButton radcmnd;
	private JTextField txttimkiem;
	private JButton btnthem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiKhachHang frame = new GuiKhachHang();
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
	public GuiKhachHang() {
		
		KetNoidata.getin().getcon();
		this.khd = new KhachHangdao();
		
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
		
		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(471, 10, 353, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 76, 1256, 228);
		pnkhachhang.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã KH");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(86, 30, 45, 16);
		panel_1.add(lblNewLabel_1);
		
		txtma = new JTextField();
		txtma.setBounds(141, 27, 435, 26);
		txtma.setEditable(false);
		panel_1.add(txtma);
		txtma.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Họ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(102, 64, 29, 13);
		panel_1.add(lblNewLabel_2);
		
		txtho = new JTextField();
		txtho.setBounds(141, 59, 435, 26);
		panel_1.add(txtho);
		txtho.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tên");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(95, 98, 36, 16);
		panel_1.add(lblNewLabel_3);
		
		txtten = new JTextField();
		txtten.setBounds(141, 95, 435, 26);
		panel_1.add(txtten);
		txtten.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày Sinh");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(62, 131, 69, 26);
		panel_1.add(lblNewLabel_4);
		
		txtngaysinh = new JDateChooser();
		txtngaysinh.getCalendarButton().setEnabled(false);
		txtngaysinh.setLocale(Locale.forLanguageTag("vi-VN"));
		txtngaysinh.setDateFormatString("dd-MM-yyyy");
		txtngaysinh.getCalendarButton().setEnabled(true);
		txtngaysinh.setBounds(141, 131, 435, 26);
		panel_1.add(txtngaysinh);
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(607, 98, 87, 16);
		panel_1.add(lblNewLabel_5);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(704, 95, 435, 26);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Địa Chỉ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(631, 30, 63, 18);
		panel_1.add(lblNewLabel_6);
		
		txtdc = new JTextField();
		txtdc.setBounds(704, 27, 435, 26);
		panel_1.add(txtdc);
		txtdc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Giới Tính");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(631, 64, 63, 19);
		panel_1.add(lblNewLabel_7);
		
		cbxgt = new JComboBox();
		cbxgt.setBackground(new Color(102, 153, 153));
		cbxgt.setForeground(new Color(0, 0, 0));
		cbxgt.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		cbxgt.setBounds(704, 59, 435, 26);
		panel_1.add(cbxgt);
		
		btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		btnxoa.setIcon(new ImageIcon("Img\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(402, 181, 141, 41);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(204, 204, 153));
		btncapnhat.setIcon(new ImageIcon("Img\\Users-Edit-User-icon (1).png"));
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(553, 181, 141, 41);
		panel_1.add(btncapnhat);
		
		btnlammoikh = new JButton("Làm Mới");
		btnlammoikh.setBackground(new Color(204, 204, 153));
		btnlammoikh.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoikh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoikh.setBounds(704, 181, 141, 41);
		panel_1.add(btnlammoikh);
		
		JLabel lblNewLabel_10 = new JLabel("Số CMND");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(620, 131, 74, 19);
		panel_1.add(lblNewLabel_10);
		
		txtcmnd = new JTextField();
		txtcmnd.setBounds(704, 133, 435, 26);
		panel_1.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		btnthem = new JButton("Thêm");
		btnthem.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Ecommerce-New-icon.png"));
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(251, 181, 141, 41);
		panel_1.add(btnthem);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 314, 1256, 298);
		pnkhachhang.add(panel_2);
		panel_2.setLayout(null);
		String[] tb = new String[] { "STT", "Mã KH", "Họ", "Tên", "Ngày Sinh", "Giới Tính", "Số Điện Thoại","Địa Chỉ","Số CMND" };
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1236, 266);
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
		pnkhachhang.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Thông Tin Tìm Kiếm:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(13, 28, 202, 31);
		panel_3.add(lblNewLabel_8);
		
		radma = new JRadioButton("Mã");
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(171, 89, 57, 21);
		panel_3.add(radma);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm Kiếm:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(64, 86, 102, 21);
		panel_3.add(lblNewLabel_9);
		
		radten = new JRadioButton("Tên");
		radten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radten.setBounds(230, 89, 57, 21);
		panel_3.add(radten);
		
		radsdt = new JRadioButton("Số Điện Thoại");
		radsdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radsdt.setBounds(289, 89, 113, 21);
		panel_3.add(radsdt);
		
		radcmnd = new JRadioButton("Số CMND");
		radcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radcmnd.setBounds(404, 89, 103, 21);
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
		txttimkiem.setBounds(207, 30, 300, 26);
		panel_3.add(txttimkiem);
		txttimkiem.setColumns(10);
//		scrollPane.setColumnHeaderView(table);
		docDuLieu();
		table.addMouseListener(this);
		btnlammoikh.addActionListener(this);
		btnxoa.addActionListener(this);
		btncapnhat.addActionListener(this);
		btntimkiem.addActionListener(this);
		btnlammoitk.addActionListener(this);
		btnthem.addActionListener(this);
	}
	private void docDuLieu() {
		try {
			List<KhachHang> list = khd.getallkhachhang();
			int i = 0;
			for (KhachHang khachHang : list) {
				i++;
				model.addRow(new Object[] { i + "", khachHang.getMaKH(), khachHang.getHoKH().trim(),
						khachHang.getTenKH().trim(), khachHang.getNgaySinh(), khachHang.getGioiTinh().trim(),khachHang.getsDT().trim(),
						khachHang.getDiaChi().trim(),khachHang.getSoCMND().trim()});
			}
			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void deleteAllDataTable() {
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
	}
	public void xoarong()
	{
		txtma.setText("");
		txtho.setText("");
		txtten.setText("");
		txtngaysinh.setDate(null);
		txtsdt.setText("");
		txtdc.setText("");
		txtcmnd.setText("");
	}
	public void themKH()
	{
//		if(txtho.getText().equals("")||txtten.getText().equals("")||txtsdt.getText().equals("")||txtdc.getText().equals("")||txtcmnd.getText().equals(""))
//		{
//			JOptionPane.showMessageDialog(this, "bạn phải nhập đủ các thông tin");
//		}
//		else
//		{
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
			String i = khd.maKHmax();
			System.out.println(i);
			String chuoi = i.substring(2);
			int ma = Integer.parseInt(chuoi);
			System.out.println(ma);
			int mamoi = ma+1;
			String chuoima = "";
			if(mamoi<10)
				chuoima += "KH0"+mamoi;
			else
				chuoima += "KH"+mamoi;
			String ho = txtho.getText().trim();
			String ten = txtten.getText().trim();
			String gt = (String) cbxgt.getSelectedItem();
			String sdt = txtsdt.getText().trim();
			String diachi = txtdc.getText().trim();
			String cmnd = txtcmnd.getText().trim();
			KhachHang kh = new KhachHang(chuoima, ho, ten, ngaySinhsql, gt, sdt, diachi, cmnd);
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
				dangbuoc += "Tên Khách Hàng Không Hợp Lệ ! \n";
			}
			
			if(year==null)
			{
				dangbuoc+="Vui Lòng Nhập Ngày Sinh !\n";
			}
			if(sdt.equalsIgnoreCase(""))
			{
				dangbuoc+= "vui lòng nhập số điện thoại!\n";
			}else if(!sdt.matches("^0[0-9]{9}$"))
			{
				dangbuoc += "Số điện thoại phải có 10 số và bắt đầu từ số 0!\n";
			}
			if(!cmnd.matches("^[0-9]{12}$"))
			{
				dangbuoc += "Số chứng minh nhân dân phải có 12 số !\n";
			}
			if(dangbuoc =="")
			{
				if(khd.themKH(kh)==true)
				{
					JOptionPane.showMessageDialog(this, "thêm thành công");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "thêm thất bại");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, dangbuoc, "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
			}
//		}
	}
	public void xoaKH()
	{
		String ma = txtma.getText();
		if(ma.equals(""))
		{
			JOptionPane.showMessageDialog(this, "bạn vui lòng chọn khách hàng cần xóa");
		}
		else {
			//int ma1 = Integer.parseInt(ma);
			if(JOptionPane.showConfirmDialog(this, "bạn có chắc xóa khách hàng này không ?", "Lựa Chọn Của Bạn!", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				if(khd.xoaKhachHang(ma)==true)
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
			String ma = txtma.getText().trim();
			String ho = txtho.getText().trim();
			String ten = txtten.getText().trim();
			String gt = (String) cbxgt.getSelectedItem();
			String sdt = txtsdt.getText().trim();
			String diachi = txtdc.getText().trim();
			String cmnd = txtcmnd.getText().trim();
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
				dangbuoc += "Tên Khách Hàng Không Hợp Lệ ! \n";
			}
			
			if(year==null)
			{
				dangbuoc+="Vui Lòng Nhập Ngày Sinh !\n";
			}
			if(sdt.equalsIgnoreCase(""))
			{
				dangbuoc+= "vui lòng nhập số điện thoại!\n";
			}else if(!sdt.matches("^0[0-9]{9}$"))
			{
				dangbuoc += "Số điện thoại phải có 10 số và bắt đầu từ số 0!\n";
			}
			if(!cmnd.matches("^[0-9]{12}$"))
			{
				dangbuoc += "Số chứng minh nhân dân phải có 12 số !\n";
			}
			if(dangbuoc =="")
			{
				if(khd.updatekhachhhang(ma, ho, ten, ngaySinhsql, gt, sdt, diachi, cmnd)==true)
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
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String maKH = model.getValueAt(row, 1).toString();
		try {
			KhachHang kh = khd.layThongTinKhachHang(maKH);
			txtma.setText(maKH + "");
			txtho.setText(kh.getHoKH());
			txtten.setText(kh.getTenKH());
			txtngaysinh.setDate(kh.getNgaySinh());
			cbxgt.getModel().setSelectedItem(kh.getGioiTinh());
			txtsdt.setText(kh.getsDT());
			txtdc.setText(kh.getDiaChi());
			txtcmnd.setText(kh.getSoCMND());

		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}
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
		if(gui.equals(btnthem))
		{
			themKH();
		}
		if(gui.equals(btnlammoikh))
		{
			xoarong();
			deleteAllDataTable();
			docDuLieu();
			
		}
		if(gui.equals(btnxoa))
		{
			xoaKH();
		}
		if(gui.equals(btncapnhat))
		{
			capnhat();
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
						if(!txtma.getText().equalsIgnoreCase(""))
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
		if(gui.equals(btnlammoitk))
		{
			txttimkiem.setText("");
			txttimkiem.selectAll();
			txttimkiem.requestFocus();
			deleteAllDataTable();
			docDuLieu();
		}
		// TODO Auto-generated method stub
		
	}
	public void getTimKiemKhachHangById(String ma) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khd.timkiemKhachHangByMa(ma);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
	
	public void getTimKiemKhachHangByTen(String ten) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khd.timkiemKhachHangByTen(ten);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangByCMND(String cmnd) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khd.timkiemKhachHangByCMND(cmnd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangBySoDT(String sdt) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khd.timkiemKhachHangBySDT(sdt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
}
