package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class GuiGiaoDien extends JFrame implements ActionListener,MenuListener{

	private JPanel contentPane;
	private GuiThongTinCaNhan guithongtin = new GuiThongTinCaNhan();
	private GuiKhachHang guikhachhang = new GuiKhachHang();
	private GuiNhanVien guinhanvien = new GuiNhanVien();
	private GuiSanPham guisanpham = new GuiSanPham();
	private GuiQLDoDung guiqldodung = new GuiQLDoDung();
	private GuiLapHoaDon guilaphoadon = new GuiLapHoaDon();
	private GuiTimKiemSach guitimsach = new GuiTimKiemSach();
	private GuiTimKiemNhanVien guitimnv = new GuiTimKiemNhanVien();
	private GuiTimKiemKhachHang guitimkh = new GuiTimKiemKhachHang();
	private GuiThongKeSachBanChay guisachbanchay = new GuiThongKeSachBanChay();
	private GuiThongKeSachBanIt guisachit = new GuiThongKeSachBanIt();
	private GuiTimKiemDoDung guitimkiemdd = new GuiTimKiemDoDung();
	private GuiThongKeSanPhamBanNhieu guispnhieu = new GuiThongKeSanPhamBanNhieu();
	private GuiThongKeDoDungHet guiddhet = new GuiThongKeDoDungHet();
	private GuiThongKeKHMuaMax guimuanhieu = new GuiThongKeKHMuaMax();
	private GuiThongKeDoanhThu guidoanhthu = new GuiThongKeDoanhThu();
	private GuiTimKiemHoaDon guitimhd = new GuiTimKiemHoaDon();
	private GuiDoiMatKhau guimk = new GuiDoiMatKhau();
	private GuiLapHoaDon guilaphd = new GuiLapHoaDon();
	private GuiQuanLyHoaDon guiqlhd = new GuiQuanLyHoaDon();
	private GuiQuanLyDonDatHang guiqlddh = new GuiQuanLyDonDatHang();
	public static GuiThemDonDatHang guithemddh = new GuiThemDonDatHang();
	public static GuiUpdateDonDatHang guiupdate = new GuiUpdateDonDatHang();
	
	
	
	
	
	
	private JMenuBar menuBar_1;
	private JMenuBar menuBar;
	private JMenuBar menuBar_2;
	public JMenuBar menuBar_3;
	private JMenuBar menuBar_5;
	private JMenuBar menuBar_4_1;
	public JMenu mnnhanvien_1;
	public JToolBar toolBar;
	static JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiGiaoDien frame = new GuiGiaoDien();
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
	/**
	 * 
	 */
	public GuiGiaoDien() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\Books-2-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	
		this.setSize(1400, 700);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(10, 0, 245, 798);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblanh = new JLabel("");
		lblanh.setBackground(new Color(255, 204, 204));
		lblanh.setIcon(new ImageIcon("Img\\fahasa_logo.png"));
		lblanh.setBounds(10, 49, 225, 92);
		panel.add(lblanh);
		
		toolBar = new JToolBar();
		toolBar.setBackground(new Color(204, 204, 153));
		toolBar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		toolBar.setLayout(new GridLayout(0,1));
		toolBar.setBounds(10, 170, 220, 336);
		panel.add(toolBar);
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setEnabled(false);
		menuBar_1.setBorderPainted(false);
		menuBar_1.setBackground(new Color(204, 204, 153));
		menuBar_1.setLayout(new GridLayout(0,1));
		menuBar_1.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar_1);
		
		JMenu mnhoadon_1 = new JMenu("Hóa Đơn");
		mnhoadon_1.setIcon(new ImageIcon("Img\\Data-View-Details-icon (1).png"));
		mnhoadon_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		mnhoadon_1.setBackground(new Color(204, 204, 153));
		menuBar_1.add(mnhoadon_1);
		
		JMenuItem mnlaphd_1 = new JMenuItem("Thêm Hóa Đơn");
		mnlaphd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mnlaphd_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guilaphd.thongtinlaphoadon);
				}
			}
		});
		mnlaphd_1.setIcon(new ImageIcon("Img\\Ecommerce-Receipt-icon.png"));
		mnlaphd_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnlaphd_1.setBackground(new Color(204, 204, 153));
		mnhoadon_1.add(mnlaphd_1);
		
		JMenuItem mnlaphd_1_1 = new JMenuItem("Tìm Kiếm Hóa Đơn");
		mnlaphd_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mnlaphd_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guitimhd.pntimkh);
				}
			}
		});
		mnlaphd_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\search-icon (2).png"));
		mnlaphd_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnlaphd_1_1.setBackground(new Color(204, 204, 153));
		mnhoadon_1.add(mnlaphd_1_1);
		
		JMenuItem mnlaphd_1_1_1 = new JMenuItem("Quản Lý Hóa Đơn");
		mnlaphd_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mnlaphd_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guiqlhd.pnkhachhang);
				}
			}
		});
		mnlaphd_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\License-manager-icon.png"));
		mnlaphd_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnlaphd_1_1_1.setBackground(new Color(204, 204, 153));
		mnhoadon_1.add(mnlaphd_1_1_1);
		
		menuBar = new JMenuBar();
		menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(204, 204, 153));
		menuBar.setLayout(new GridLayout(0,1));
		menuBar.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar);
		
		JMenu mnsanpham_1_1 = new JMenu("Sách");
		mnsanpham_1_1.setIcon(new ImageIcon("Img\\Ecommerce-Product-icon.png"));
		mnsanpham_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnsanpham_1_1.setBackground(new Color(204, 204, 153));
		menuBar.add(mnsanpham_1_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quản Lý Sách");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_2))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guisanpham.thontinsanpham);
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("Img\\Books-icon.png"));
		mntmNewMenuItem_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_2.setBackground(new Color(204, 204, 153));
		mnsanpham_1_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Tìm Kiếm Sách");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_4))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guitimsach.pntimsach);
				}
			}
		});
		mntmNewMenuItem_4.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_4.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\search-icon11.png"));
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnsanpham_1_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Thống Kê Sách Bán Chạy");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_7))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guisachbanchay.pnsachchay);
				}
			}
		});
		mntmNewMenuItem_7.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_7.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Ecommerce-Product-icon.png"));
		mntmNewMenuItem_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnsanpham_1_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_7_1 = new JMenuItem("Thống Kê Sách Đã Hết");
		mntmNewMenuItem_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_7_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guisachit.pnsachit);
				}
			}
		});
		mntmNewMenuItem_7_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\App-file-manager-icon.png"));
		mntmNewMenuItem_7_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_7_1.setBackground(new Color(204, 204, 153));
		mnsanpham_1_1.add(mntmNewMenuItem_7_1);
		
		menuBar_4_1 = new JMenuBar();
		menuBar_4_1.setEnabled(false);
		menuBar_4_1.setBorderPainted(false);
		menuBar_4_1.setBackground(new Color(204, 204, 153));
		menuBar_4_1.setLayout(new GridLayout(0,1));
		menuBar_4_1.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar_4_1);
		
		JMenu mnNewMenu_1 = new JMenu("Sản Phẩm Khác");
		mnNewMenu_1.setBackground(new Color(204, 204, 153));
		mnNewMenu_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\dodung.png"));
		mnNewMenu_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		menuBar_4_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_10_2_1 = new JMenuItem("Quản Lý Dụng Cụ Học Tập");
		mntmNewMenuItem_10_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_10_2_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guiqldodung.thongtinqldodung);
				}
				
			}
		});
		mntmNewMenuItem_10_2_1.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_10_2_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\product-icon.png"));
		mntmNewMenuItem_10_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_10_2_1);
		
		JMenuItem mntmNewMenuItem_10_2_1_1_1 = new JMenuItem("Tìm Kiếm Dụng Cụ Học Tập");
		mntmNewMenuItem_10_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_10_2_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guitimkiemdd.pntimdd);
				}
			}
		});
		mntmNewMenuItem_10_2_1_1_1.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_10_2_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\search-icon11.png"));
		mntmNewMenuItem_10_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_10_2_1_1_1);
		
		JMenuItem mntmNewMenuItem_10_1_1_1 = new JMenuItem("Thống Kê Dụng Cụ Bán Chạy");
		mntmNewMenuItem_10_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_10_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guispnhieu.pntimkh);
				}
				
			}
		});
		mntmNewMenuItem_10_1_1_1.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_10_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Apps-Gnome-Documents-icon.png"));
		mntmNewMenuItem_10_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_10_1_1_1);
		
		JMenuItem mntmNewMenuItem_10_1_2 = new JMenuItem("Thống Kê Dụng Cụ Đã Hết");
		mntmNewMenuItem_10_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_10_1_2))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guiddhet.pntimkh);
				}
			}
		});
		mntmNewMenuItem_10_1_2.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_10_1_2.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Apps-file-manager-archive-icon.png"));
		mntmNewMenuItem_10_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_10_1_2);
		
		menuBar_2 = new JMenuBar();
		menuBar_2.setEnabled(false);
		menuBar_2.setBorderPainted(false);
		menuBar_2.setBackground(new Color(204, 204, 153));
		menuBar_2.setLayout(new GridLayout(0,1));
		menuBar_2.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar_2);
		
		JMenu mnkhachhang_1 = new JMenu("Khách Hàng");
//		mnkhachhang_1.addMenuListener(new MenuListener() {
//			public void menuCanceled(MenuEvent e) {
//			}
//			public void menuDeselected(MenuEvent e) {
//			}
//			public void menuSelected(MenuEvent e) {
//				tabbedPane.remove(tabbedPane.getSelectedComponent());
//				tabbedPane.add(guikhachhang.pnkhachhang);
//				tabbedPane.setSelectedComponent(guikhachhang.pnkhachhang);
//			}
//		});
		mnkhachhang_1.setIcon(new ImageIcon("Img\\Users-Name-icon.png"));
		mnkhachhang_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnkhachhang_1.setBackground(new Color(204, 204, 153));
		menuBar_2.add(mnkhachhang_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Quản Lý Khách Hàng");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_5))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guikhachhang.pnkhachhang);
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Manager-icon.png"));
		mntmNewMenuItem_5.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnkhachhang_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1_1_2 = new JMenuItem("Tìm Kiếm Khách Hàng");
		mntmNewMenuItem_5_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(guitimkh.pntimkh);
			}
		});
		mntmNewMenuItem_5_1_1_2.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\search-icon11.png"));
		mntmNewMenuItem_5_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_5_1_1_2.setBackground(new Color(204, 204, 153));
		mnkhachhang_1.add(mntmNewMenuItem_5_1_1_2);
		
		JMenuItem mntmNewMenuItem_5_1_1_1 = new JMenuItem("Đơn Đặt Hàng");
		mntmNewMenuItem_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_5_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guiqlddh.pnkhachhang);
				}
			}
		});
		mntmNewMenuItem_5_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\order.png"));
		mntmNewMenuItem_5_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_5_1_1_1.setBackground(new Color(204, 204, 153));
		mnkhachhang_1.add(mntmNewMenuItem_5_1_1_1);
		
		JMenuItem mntmNewMenuItem_5_1_1_1_1 = new JMenuItem("Thêm Đơn Đặt Hàng");
		mntmNewMenuItem_5_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_5_1_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guithemddh.thongtinlaphoadon);
				}
			}
		});
		mntmNewMenuItem_5_1_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\addorder.png"));
		mntmNewMenuItem_5_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_5_1_1_1_1.setBackground(new Color(204, 204, 153));
		mnkhachhang_1.add(mntmNewMenuItem_5_1_1_1_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Thống Kê Khách Hàng Mua Nhiều Nhất");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_8))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guimuanhieu.pntimkh);
				}
			}
		});
		mntmNewMenuItem_8.setBackground(new Color(204, 204, 153));
		mntmNewMenuItem_8.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\sachbanhen.png"));
		mntmNewMenuItem_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnkhachhang_1.add(mntmNewMenuItem_8);
		
		menuBar_3 = new JMenuBar();
		menuBar_3.setEnabled(false);
		menuBar_3.setBorderPainted(false);
		menuBar_3.setBackground(new Color(204, 204, 153));
		menuBar_3.setLayout(new GridLayout(0,1));
		menuBar_3.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar_3);
		
		mnnhanvien_1 = new JMenu("Nhân Viên");
		mnnhanvien_1.setIcon(new ImageIcon("Img\\Users-Administrator-2-icon.png"));
		mnnhanvien_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnnhanvien_1.setBackground(new Color(204, 204, 153));
		menuBar_3.add(mnnhanvien_1);
		
		JMenuItem mntmNewMenuItem_6_1 = new JMenuItem("Quản Lý Nhân Viên");
		mntmNewMenuItem_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_6_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guinhanvien.pnnhanvien);
				}
			}
		});
		mntmNewMenuItem_6_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Manager-icon.png"));
		mntmNewMenuItem_6_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_6_1.setBackground(new Color(204, 204, 153));
		mnnhanvien_1.add(mntmNewMenuItem_6_1);
		
		JMenuItem mntmNewMenuItem_6_1_1_1 = new JMenuItem("Tìm Kiếm Nhân Viên");
		mntmNewMenuItem_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_6_1_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guitimnv.pntimnv);
				}
			}
		});
		mntmNewMenuItem_6_1_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\find-2-icon.png"));
		mntmNewMenuItem_6_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_6_1_1_1.setBackground(new Color(204, 204, 153));
		mnnhanvien_1.add(mntmNewMenuItem_6_1_1_1);
		
		JMenuItem mntmNewMenuItem_6_1_1 = new JMenuItem("Thống Kê Doanh Thu");
		mntmNewMenuItem_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mntmNewMenuItem_6_1_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guidoanhthu.pntimkh);
				}
			}
		});
		mntmNewMenuItem_6_1_1.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\statistics-icon (1).png"));
		mntmNewMenuItem_6_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntmNewMenuItem_6_1_1.setBackground(new Color(204, 204, 153));
		mnnhanvien_1.add(mntmNewMenuItem_6_1_1);
		
		menuBar_5 = new JMenuBar();
		menuBar_5.setEnabled(false);
		menuBar_5.setBorderPainted(false);
		menuBar_5.setBackground(new Color(204, 204, 153));
		menuBar_5.setLayout(new GridLayout(0,1));
		menuBar_5.setBounds(0, 0, 225, 336);
		toolBar.add(menuBar_5);
		
		JMenu mntaikhoan_1 = new JMenu("Tài Khoản");
		mntaikhoan_1.setIcon(new ImageIcon("Img\\Users-Lifecycle-icon.png"));
		mntaikhoan_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mntaikhoan_1.setBackground(new Color(204, 204, 153));
		menuBar_5.add(mntaikhoan_1);
		
		JMenuItem mnthongtin_1 = new JMenuItem("Thông Tin Cá Nhân");
		mnthongtin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mnthongtin_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guithongtin.thongtincanhan);
				}
			}
		});
		mnthongtin_1.setIcon(new ImageIcon("Img\\user2-info-icon.png"));
		mnthongtin_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnthongtin_1.setBackground(new Color(204, 204, 153));
		mntaikhoan_1.add(mnthongtin_1);
		
		JMenuItem mndoimk_1 = new JMenuItem("Đổi Mật Khẩu");
		mndoimk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mndoimk_1))
				{
					tabbedPane.remove(tabbedPane.getSelectedComponent());
					tabbedPane.add(guimk.pnkhachhang);
				}
			}
		});
		mndoimk_1.setIcon(new ImageIcon("Img\\Mail-Password-icon.png"));
		mndoimk_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mndoimk_1.setBackground(new Color(204, 204, 153));
		mntaikhoan_1.add(mndoimk_1);
		
		JMenuItem mndangxuat_1 = new JMenuItem("Đăng Xuất");
		mndangxuat_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object gui = e.getSource();
				if(gui.equals(mndangxuat_1))
				{
					dangxuat();
				}
			}
		});
		mndangxuat_1.setIcon(new ImageIcon("Img\\logout-icon (1).png"));
		mndangxuat_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		mndangxuat_1.setBackground(new Color(204, 204, 153));
		mntaikhoan_1.add(mndangxuat_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(255, 0, 1280, 798);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -18, 1278, 798);
		panel_2.add(tabbedPane);
	}
	public void dangxuat()
	{
		this.dispose();
		GuiUser ur = new GuiUser();
		ur.setVisible(true);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
