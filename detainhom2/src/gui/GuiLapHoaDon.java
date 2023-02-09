package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.management.modelmbean.ModelMBean;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

import dao.KhachHangdao;
import dao.LapHoaDondoa;
import dao.SanPhamdao;
import dao.ThongTinCaNhandao;
import database.KetNoidata;
import entities.CT_HoaDon;
import entities.DoDung;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.SanPham;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class GuiLapHoaDon extends JFrame implements ActionListener{

	public JPanel thongtinlaphoadon;
	private JTextField txtmaKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private ButtonGroup grouprad;
	private SanPhamdao spd;
	private LapHoaDondoa lhdd;
	private KhachHangdao khd;
	private ThongTinCaNhandao ttcnd;
//	private List<String> listtenKH = new ArrayList<String>();
//	private DefaultComboBoxModel cbotenKH = new DefaultComboBoxModel();
	
	
	private JTable table_2;
	private JTable table_1;
	private DefaultTableModel modelsp;
	private JTextField txttongtien;
	private JComboBox cbxtenKH;
	private double tong1;
	private double tong2;
	private double tongmax;
	private double tientru;
	private JButton btnlaphd;
	private JButton btnthemvaogio;
	private JButton btnxoakhoigio;
	private JButton btnlammoi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLapHoaDon frame = new GuiLapHoaDon();
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
	public GuiLapHoaDon() {
		
		KetNoidata.getin().getcon();
		this.spd = new SanPhamdao();
		this.lhdd = new LapHoaDondoa();
		this.khd = new KhachHangdao();
		this.ttcnd = new ThongTinCaNhandao();
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		thongtinlaphoadon = new JPanel();
		thongtinlaphoadon.setBackground(Color.LIGHT_GRAY);
		thongtinlaphoadon.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setLocationRelativeTo(null);
		setContentPane(thongtinlaphoadon);
		thongtinlaphoadon.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1285, 66);
		thongtinlaphoadon.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lập Hóa Đơn");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(525, 10, 220, 46);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 76, 1256, 285);
		thongtinlaphoadon.add(panel_1);
		panel_1.setLayout(null);
		
		grouprad = new ButtonGroup();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(10, 10, 1215, 257);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã KH");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(26, 23, 50, 13);
		panel_4.add(lblNewLabel_4);
		
		txtmaKH = new JTextField();
		txtmaKH.setEditable(false);
		txtmaKH.setBounds(111, 18, 180, 26);
		panel_4.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tên KH");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(20, 50, 56, 23);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Địa Chỉ");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(20, 111, 66, 16);
		panel_4.add(lblNewLabel_9);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(111, 108, 180, 26);
		panel_4.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Số Điện Thoại");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(10, 83, 96, 17);
		panel_4.add(lblNewLabel_12);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setBounds(111, 78, 180, 26);
		panel_4.add(txtSDT);
		txtSDT.setColumns(10);
		
		String []tbsp = new String[] {"Mã SP","Tên sản phẩm","Đơn giá","Số lượng","Thành Tiền"};
		modelsp = new DefaultTableModel(tbsp,0);
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(562, 49, 691, 195);
		panel_4.add(scrollPane_1_1);
		
		table_1 = new JTable(modelsp) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1_1.setViewportView(table_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Tổng tiền");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9_1.setBounds(20, 141, 66, 16);
		panel_4.add(lblNewLabel_9_1);
		
		txttongtien = new JTextField();
		txttongtien.setEditable(false);
		txttongtien.setColumns(10);
		txttongtien.setBounds(111, 138, 180, 26);
		panel_4.add(txttongtien);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách sản phẩm trong giỏ");
		lblDanhSchSn.setForeground(new Color(153, 0, 0));
		lblDanhSchSn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDanhSchSn.setBounds(726, 3, 300, 46);
		panel_4.add(lblDanhSchSn);
		
		cbxtenKH = new JComboBox();
		List<KhachHang> dskh = khd.getallkhachhang();
		for (KhachHang kh : dskh) {
			cbxtenKH.addItem(kh.getTenKH());
		}
		cbxtenKH.setBounds(111, 48, 180, 26);
		panel_4.add(cbxtenKH);
		
		btnlaphd = new JButton("Lập Hóa Đơn");
		btnlaphd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmaKH.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btnlaphd, "Vui lòng thêm thông tin khách hàng để lập hóa đơn");
				}
				else
				{
					JOptionPane.showMessageDialog(btnlaphd, "Hóa đơn đã được thêm mới!");
					btnthemvaogio.setEnabled(true);
					btnxoakhoigio.setEnabled(true);
					themHDmoi();
				}
			}
		});
		btnlaphd.setBackground(new Color(204, 204, 153));
		btnlaphd.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\order.png"));
		btnlaphd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlaphd.setBounds(26, 191, 180, 39);
		panel_4.add(btnlaphd);
		
		btnlammoi = new JButton("Làm Mới");
		btnlammoi.setIcon(new ImageIcon("C:\\Users\\84356\\Documents\\Zalo Received Files\\detainhom2 (1)\\detainhom2\\Img\\Refresh-icon (1).png"));
		btnlammoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoi.setBackground(new Color(204, 204, 153));
		btnlammoi.setBounds(227, 191, 180, 39);
		panel_4.add(btnlammoi);
		
		JLabel lblDanhSchSn_1_1 = new JLabel("Sản phẩm khác");
		lblDanhSchSn_1_1.setForeground(new Color(153, 0, 0));
		lblDanhSchSn_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDanhSchSn_1_1.setBounds(884, 237, 151, 75);
		panel_1.add(lblDanhSchSn_1_1);
		
		JLabel lblDanhSchSn_1 = new JLabel("Sách");
		lblDanhSchSn_1.setBounds(251, 251, 68, 46);
		panel_1.add(lblDanhSchSn_1);
		lblDanhSchSn_1.setForeground(new Color(153, 0, 0));
		lblDanhSchSn_1.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 360, 1246, 393);
		thongtinlaphoadon.add(panel_2);
		panel_2.setLayout(null);
		
		String []tb = new String[] {"Mã SP","Tên sản phẩm","Nhà xuất bản","Số lượng","Đơn Giá"};
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 20, 533, 319);
		panel_2.add(scrollPane);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane.setViewportView(table);
		
		String []tb1 = new String[] {"Mã SP","Tên sản phẩm","Nhà cung cấp","Số lượng","Đơn Giá"};
		model1 = new DefaultTableModel(tb1,0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(683, 20, 553, 319);
		panel_2.add(scrollPane_1);
		
		table_2 = new JTable(model1) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1.setViewportView(table_2);
		
		btnxoakhoigio = new JButton("");
		btnxoakhoigio.setEnabled(false);
		btnxoakhoigio.setBounds(583, 174, 56, 41);
		panel_2.add(btnxoakhoigio);
		btnxoakhoigio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSPgio();
			}
		});
		btnxoakhoigio.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Editing-Delete-icon.png"));
		btnxoakhoigio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoakhoigio.setBackground(new Color(204, 204, 153));
		
		btnthemvaogio = new JButton("");
		btnthemvaogio.setEnabled(false);
		btnthemvaogio.setBounds(583, 123, 56, 41);
		panel_2.add(btnthemvaogio);
		btnthemvaogio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSP();
			}
		});
		btnthemvaogio.setBackground(new Color(204, 204, 153));
		btnthemvaogio.setIcon(new ImageIcon("Img\\Full-Cart-icon.png"));
		btnthemvaogio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		loaddulieusach();
		loaddulieudodung();
		cbxtenKH.addActionListener(this);
		btnlammoi.addActionListener(this);
	}
	
	public void xoaTablesach() {
		model.addRow(new Object[] {

		});
		DefaultTableModel tbl = (DefaultTableModel) table.getModel();
		tbl.getDataVector().removeAllElements();	
	}
	
	public void xoaTabledodung() {
		model1.addRow(new Object[] {

		});
		DefaultTableModel tbl = (DefaultTableModel) table_2.getModel();
		tbl.getDataVector().removeAllElements();	
	}
	
	public void xoaTablesp() {
		modelsp.addRow(new Object[] {

		});
		DefaultTableModel tbl = (DefaultTableModel) table_1.getModel();
		tbl.getDataVector().removeAllElements();	
	}
	
	public void loaddulieusach()
	{
		try {
			List<SanPham> dssp = spd.getallsanphamsp();
			for (SanPham sp : dssp) {
				model.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getTenNSB() ,
						sp.getSoLuong(), sp.getDonGia()});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void loaddulieudodung()
	{
		try {
			List<SanPham> dssp = spd.getallsanphamdd();
			for (SanPham sp : dssp) {
				model1.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getTenNCC().getTenNCC(),
						sp.getSoLuong(), sp.getDonGia()});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void themSP()
	{
		int row = table.getSelectedRow();
		int rowdd = table_2.getSelectedRow();
		if(row<0 && rowdd<0)
		{
			JOptionPane.showMessageDialog(this, "Bạn Phải chọn sản phẩm để thêm vào giỏ hàng");
		}
		else if(row >=0 && rowdd<0)
		{
			if(txtmaKH.getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(this, "Bạn phải nhập thông tin của khác hàng");
			}
			else
			{
				try {
					String maSP = model.getValueAt(row, 0).toString();
					String sl = JOptionPane.showInputDialog("Nhập số lượng cần thêm");
					SanPham sp = lhdd.timSanPhamTheoMa(maSP);
					int soluong = Integer.valueOf(sl);
					int soluonghienco = sp.getSoLuong();
					if(soluong >soluonghienco)
					{
						JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ!");
					}
					else {
							tong1 = sp.getDonGia()*soluong;
							modelsp.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getDonGia(),
											soluong,tong1 });
							CT_HoaDon cthd = new CT_HoaDon(lhdd.maHDMAX(), sp.getMaSP(), sp.getDonGia(), soluong, sp.getDonVT(), 0);
							lhdd.addCT_HoaDonmoi(cthd);
							int soluongconlai = soluonghienco-soluong;
							spd.updatesoluong(maSP, soluongconlai);
							xoaTablesach();
							loaddulieusach();
							cleartable();
							tongmax += tong1;
							lhdd.updatehd(lhdd.maHDMAX(), tongmax);
							DecimalFormat tien = new DecimalFormat("#,##0.00");
							txttongtien.setText(tien.format(tongmax) + "VND");
						}
							
								
					
//								int soluongcon = soluonghienco-soluong;
//								int soluongld = (int) table_1.getModel().getValueAt(i, 3);
//								int soluonglucsau = soluongld+soluong;
//								double dg = (double) table_1.getModel().getValueAt(i, 2);
//								double tiensau = soluonglucsau*dg;
//								modelsp.setValueAt(soluonglucsau, row, 3);
//								modelsp.setValueAt(tiensau, row, 4);
//								lhdd.updatecthd(lhdd.maHDMAX(), maSP, soluonglucsau);
//								tientru = soluong*dg;
//								tongmax += tientru;
//								DecimalFormat tien = new DecimalFormat("#,##0.00");
//								txttongtien.setText(tien.format(tongmax) + "VND");
//								int soluongconlai = sp.getSoLuong();
//								int soluongmoi = sp.getSoLuong()-soluong;
//								spd.updatesoluong(maSP, soluongmoi);
//								xoaTablesach();
//								loaddulieusach();
//								xoaTabledodung();
//								loaddulieudodung();
//								cleartable();
//								lhdd.updatehd(lhdd.maHDMAX(), tongmax);
					//System.out.println(sp);
					
					//model.removeRow(row);
				} catch (Exception e) {
					System.out.println("Số lượng không được để trống");
					// TODO: handle exception
				}
			}
			
		}
		else if(row<0 && rowdd>=0)
		{
			if(txtmaKH.getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(this, "Bạn phải nhập thông tin của khác hàng");
			}
			else
			{
				try {
					String sl = JOptionPane.showInputDialog("Nhập số lượng cần thêm");
					int soluong = Integer.valueOf(sl);
					String maSP = model1.getValueAt(rowdd, 0).toString();
					SanPham sp = lhdd.timSanPhamTheoMa(maSP);
					int soluonghienco = sp.getSoLuong();
					if(soluong >soluonghienco)
					{
						JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ!");
					}
					else
					{
						tong2 = sp.getDonGia()*soluong;
						modelsp.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getDonGia(),
								soluong,tong2 });
						CT_HoaDon cthd = new CT_HoaDon(lhdd.maHDMAX(), sp.getMaSP(), sp.getDonGia(), soluong, sp.getDonVT(), 0);
						lhdd.addCT_HoaDonmoi(cthd);
						int soluongconlai = soluonghienco-soluong;
						spd.updatesoluong(maSP, soluongconlai);
						xoaTabledodung();
						loaddulieudodung();
						cleartable();
						tongmax += tong2;
						lhdd.updatehd(lhdd.maHDMAX(), tongmax);
						DecimalFormat tien = new DecimalFormat("#,##0.00");
						txttongtien.setText(tien.format(tongmax) + "VND");
					}
					//System.out.println(sp);
					
					//model1.removeRow(rowdd);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		//laymasp();
	}
	
	public void themHDmoi()
	{
		String maHD = lhdd.maHDMAX();
		System.out.println(maHD);
		String tt ="Đã Thanh Toán";
		String sohd = maHD.substring(2);
		int sohdd = Integer.valueOf(sohd)+1;
		String maHDmoi = "";
		if(sohdd<10)
			maHDmoi += "HD0"+sohdd;
		else
			maHDmoi += "HD"+sohdd;
		System.out.println(maHDmoi);
		LocalDate ngay = LocalDate.now();
		System.out.println(ngay);
		String maKH = txtmaKH.getText();
		System.out.println(maKH);
		NhanVien nv = ttcnd.loadnhanvien(GuiUser.user.getTaikhoan());
		String maNV = nv.getMaNV();
		System.out.println(maNV);
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println(date);  
		HoaDon hd = new HoaDon(maHDmoi, maNV, maKH, tongmax, date, tt);
		lhdd.addHOADON(hd);
	}
	
	public void cleartable()
	{
		table.clearSelection();
		table_1.clearSelection();
		table_2.clearSelection();
	}
	
	
	public void xoaSPgio()
	{
		int row = table_1.getSelectedRow();
		if(row <0)
		{
			JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 sản phẩm để xóa khỏi giỏ!");
			//themHDmoi();
			cleartable();
			
		}
		else
		{
			try {
				
				String maSP = modelsp.getValueAt(row, 0).toString();
				SanPham sp = lhdd.timSanPhamTheoMa(maSP);
				//int rowcont = modelsp.getRowCount();
				String sl = JOptionPane.showInputDialog("Nhập số lượng cần xóa khỏi table");
				int soluong = Integer.valueOf(sl);
				System.out.println(soluong);
				int soluongco = (int) table_1.getModel().getValueAt(row, 3);
				if(soluong>soluongco)
				{
					JOptionPane.showMessageDialog(this, "Số lượng bạn nhập không đúng");
					cleartable();
				}
				else if(soluong==soluongco)
				{
					double dg = (double) table_1.getModel().getValueAt(row, 2);
					tientru = soluong*dg;
					tongmax -= tientru;
					DecimalFormat tien = new DecimalFormat("#,##0.00");
					txttongtien.setText(tien.format(tongmax) + "VND");
					modelsp.removeRow(row);
					int soluongconlai = sp.getSoLuong();
					int soluongmoi = sp.getSoLuong()+soluong;
					spd.updatesoluong(maSP, soluongmoi);
					xoaTablesach();
					loaddulieusach();
					xoaTabledodung();
					loaddulieudodung();
					cleartable();
					lhdd.xoacthdtest(lhdd.maHDMAX(), maSP);
					lhdd.updatehd(lhdd.maHDMAX(), tongmax);
				}
				else
				{
					int soluongcon = soluongco-soluong;
					double dg = (double) table_1.getModel().getValueAt(row, 2);
					double tiensau = soluongcon*dg;
					modelsp.setValueAt(soluongcon, row, 3);
					modelsp.setValueAt(tiensau, row, 4);
					lhdd.updatecthd(lhdd.maHDMAX(), maSP, soluongcon);
					tientru = soluong*dg;
					tongmax -= tientru;
					DecimalFormat tien = new DecimalFormat("#,##0.00");
					txttongtien.setText(tien.format(tongmax) + "VND");
					int soluongconlai = sp.getSoLuong();
					int soluongmoi = sp.getSoLuong()+soluong;
					spd.updatesoluong(maSP, soluongmoi);
					xoaTablesach();
					loaddulieusach();
					xoaTabledodung();
					loaddulieudodung();
					cleartable();
					lhdd.updatehd(lhdd.maHDMAX(), tongmax);
				}
				//int soluong = (int) table_1.getModel().getValueAt(row, 3);
			} catch (Exception e) {
				System.out.println("Bạn chưa nhập số lượng để xóa");
				// TODO: handle exception
			}
			
			
			
		}
		
	}
	
	public void laymasp()
	{
		int row = table_1.getRowCount();
		String ma = "";
		for(int i = 0;i<row;i++)
		{
			ma = (String) table_1.getModel().getValueAt(i, 0);
		}
		System.out.println(ma);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object gui = e.getSource();
		if(gui.equals(cbxtenKH))
		{
			String ten = (String) cbxtenKH.getSelectedItem();
				KhachHang kh = khd.timKHtheoTen(ten);
				txtmaKH.setText(kh.getMaKH());
				txtSDT.setText(kh.getsDT());
				txtDiaChi.setText(kh.getDiaChi());
				//System.out.println(kh);
				
		// TODO Auto-generated method stub
		}
		else if(gui.equals(btnlammoi))
		{
			txtmaKH.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
			txttongtien.setText("");
			xoaTablesp();
		}
	}
}
