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

public class GuiUpdateDonDatHang extends JFrame implements ActionListener{

	public JPanel thongtinlaphoadon;
	public static JTextField txtmaKH;
	public static JTextField txtDiaChi;
	public static JTextField txtSDT;
	public static JTable table;
	public static DefaultTableModel model;
	public static DefaultTableModel model1;
	private ButtonGroup grouprad;
	private LapHoaDondoa lhdd;
	private ThongTinCaNhandao ttcnd;
	private SanPhamdao spd;
	private KhachHangdao khd;
	
	private JTable table_2;
	public static DefaultTableModel modelsp;
	public static JTextField txttongtien;
	public static JTable table_1;
	public static double tongmax;
	private double tientru;
	private double tong2;
	private double tong1;
	private JButton btnthemvaogio;
	private JButton btnxoakhoigio;
	public static JComboBox cbxtenKH;
	public static JTextField txtmadd;
//	int row = GuiUpdateDonDatHang.table.getSelectedRow();
//	String ma = GuiUpdateDonDatHang.model.getValueAt(row, 0).toString();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThemDonDatHang frame = new GuiThemDonDatHang();
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
	public GuiUpdateDonDatHang() {
		
		KetNoidata.getin().getcon();
		this.lhdd = new LapHoaDondoa();
		this.ttcnd = new ThongTinCaNhandao();
		this.spd = new SanPhamdao();
		this.khd = new KhachHangdao();
		
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
		
		JLabel lblNewLabel = new JLabel("Chỉnh Sửa Đơn Hàng");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(525, 10, 324, 46);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 76, 1256, 285);
		thongtinlaphoadon.add(panel_1);
		panel_1.setLayout(null);
		
		grouprad = new ButtonGroup();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBounds(0, 0, 1256, 257);
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
		
		JLabel lblNewLabel_9_1 = new JLabel("Tổng tiền");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9_1.setBounds(20, 144, 66, 16);
		panel_4.add(lblNewLabel_9_1);
		
		txttongtien = new JTextField();
		txttongtien.setEditable(false);
		txttongtien.setColumns(10);
		txttongtien.setBounds(111, 138, 180, 26);
		panel_4.add(txttongtien);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách sản phẩm trong giỏ");
		lblDanhSchSn.setForeground(new Color(153, 0, 0));
		lblDanhSchSn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDanhSchSn.setBounds(790, 3, 300, 46);
		panel_4.add(lblDanhSchSn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(612, 58, 644, 189);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(10, 10, 624, 169);
		panel_3.add(scrollPane_1_1);
		
		table_1 = new JTable(modelsp) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1_1.setViewportView(table_1);
		
		cbxtenKH = new JComboBox();
		List<KhachHang> dskh = khd.getallkhachhang();
		for (KhachHang kh : dskh) {
			cbxtenKH.addItem(kh.getTenKH());
		}
		cbxtenKH.setBounds(111, 48, 180, 26);
		panel_4.add(cbxtenKH);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("MÃ ĐƠN ĐẶT");
		lblNewLabel_9_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9_1_1.setBounds(10, 174, 96, 16);
		panel_4.add(lblNewLabel_9_1_1);
		
		txtmadd = new JTextField();
		txtmadd.setEditable(false);
		txtmadd.setColumns(10);
		txtmadd.setBounds(111, 171, 180, 26);
		panel_4.add(txtmadd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 360, 1246, 393);
		thongtinlaphoadon.add(panel_2);
		panel_2.setLayout(null);
		
		String []tb = new String[] {"Mã SP","Tên sản phẩm","Đơn giá","Số lượng","Nhà xuất bản"};
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 64, 533, 319);
		panel_2.add(scrollPane);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane.setViewportView(table);
		
		String []tb1 = new String[] {"Mã SP","Tên sản phẩm","Đơn giá","Số lượng","Nhà cung cấp"};
		model1 = new DefaultTableModel(tb1,0);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(703, 64, 533, 319);
		panel_2.add(scrollPane_1);
		
		table_2 = new JTable(model1) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblDanhSchSn_1 = new JLabel("Sách");
		lblDanhSchSn_1.setBounds(250, 8, 68, 40);
		panel_2.add(lblDanhSchSn_1);
		lblDanhSchSn_1.setForeground(new Color(153, 0, 0));
		lblDanhSchSn_1.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblDanhSchSn_1_1 = new JLabel("Sản phẩm khác");
		lblDanhSchSn_1_1.setBounds(884, 10, 151, 47);
		panel_2.add(lblDanhSchSn_1_1);
		lblDanhSchSn_1_1.setForeground(new Color(153, 0, 0));
		lblDanhSchSn_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		
		btnxoakhoigio = new JButton("");
		btnxoakhoigio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSPgio();
			}
		});
		btnxoakhoigio.setBounds(592, 216, 56, 41);
		panel_2.add(btnxoakhoigio);
		btnxoakhoigio.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Editing-Delete-icon.png"));
		btnxoakhoigio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoakhoigio.setBackground(new Color(204, 204, 153));
		
		btnthemvaogio = new JButton("");
		btnthemvaogio.setBackground(new Color(204, 204, 153));
		btnthemvaogio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSP();
			}
		});
		btnthemvaogio.setIcon(new ImageIcon("D:\\Java\\detainhom (1)\\Img\\Full-Cart-icon.png"));
		btnthemvaogio.setBounds(592, 170, 56, 41);
		panel_2.add(btnthemvaogio);
		loaddulieusach();
		loaddulieudodung();
		cbxtenKH.addActionListener(this);
		
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
	
	public void xoaTable() {
		model.addRow(new Object[] {

		});
		DefaultTableModel tbl = (DefaultTableModel) table.getModel();
		tbl.getDataVector().removeAllElements();	
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
				//JLabel txtmadd = null;
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
					lhdd.xoacthdtest(txtmadd.getText(), maSP);
					lhdd.updatehd(txtmadd.getText(), tongmax);
				}
				else
				{
					int soluongcon = soluongco-soluong;
					double dg = (double) table_1.getModel().getValueAt(row, 2);
					double tiensau = soluongcon*dg;
					modelsp.setValueAt(soluongcon, row, 3);
					modelsp.setValueAt(tiensau, row, 4);
					lhdd.updatecthd(txtmadd.getText(), maSP, soluongcon);
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
					lhdd.updatehd(txtmadd.getText(), tongmax);
				}
				//int soluong = (int) table_1.getModel().getValueAt(row, 3);
			} catch (Exception e) {
				System.out.println("Bạn chưa nhập số lượng để xóa");
				// TODO: handle exception
			}
			
			
			
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
					else
					{
						tong1 = sp.getDonGia()*soluong;
						modelsp.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getDonGia(),
										soluong,tong1 });
						CT_HoaDon cthd = new CT_HoaDon(txtmadd.getText(), sp.getMaSP(), sp.getDonGia(), soluong, sp.getDonVT(), 0);
						lhdd.addCT_HoaDonmoi(cthd);
						int soluongconlai = soluonghienco-soluong;
						spd.updatesoluong(maSP, soluongconlai);
						xoaTablesach();
						loaddulieusach();
						cleartable();
						tongmax += tong1;
						lhdd.updatehd(txtmadd.getText(), tongmax);
						DecimalFormat tien = new DecimalFormat("#,##0.00");
						txttongtien.setText(tien.format(tongmax) + "VND");
					}
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
						CT_HoaDon cthd = new CT_HoaDon(txtmadd.getText(), sp.getMaSP(), sp.getDonGia(), soluong, sp.getDonVT(), 0);
						lhdd.addCT_HoaDonmoi(cthd);
						int soluongconlai = soluonghienco-soluong;
						spd.updatesoluong(maSP, soluongconlai);
						xoaTabledodung();
						loaddulieudodung();
						cleartable();
						tongmax += tong2;
						lhdd.updatehd(txtmadd.getText(), tongmax);
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
		
	}
}
