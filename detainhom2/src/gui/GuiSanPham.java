package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dao.NhaCungCapdao;
import dao.SanPhamdao;
import dao.TheLoaidao;
import database.KetNoidata;
import entities.SanPham;
import entities.TheLoai;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class GuiSanPham extends JFrame implements MouseListener{

	public JPanel thontinsanpham;
	private JTextField txtmasp;
	private JTextField txttensp;
	private JTextField txtsoluong;
	private JTextField txtdongia;
	private JTextField txttacgia;
	private JTextField txtnxb;
	private JTextField txtgianhap;
	private DefaultTableModel model;
	private JTable table;
	private JRadioButton radma;
	private JRadioButton radtensp;
	private JRadioButton radnhacungcap;
	private JRadioButton radtheloai;
	private ButtonGroup buttonGroupTim;
	private String filename = null;
	private JLabel lblanh;
	private byte[] imageSanPham;
	public static JComboBox cbxtl;
	public JComboBox cbxdvt;
	public static JComboBox cbxncc;
	
	private DefaultComboBoxModel cboModeNCC= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeDonViTinh= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTheLoai= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTimTheLoai= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeNhapTTTK= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeMaSP= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTenSP= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTimNCC= new DefaultComboBoxModel();
	
	private List<String> listDonViTinh= new ArrayList<>();
	private List<String> listNCC= new ArrayList<>();
	private List<String> listTheLoai= new ArrayList<>();
	private List<String> listTimNCC= new ArrayList<>();
	private List<String> listTimTheLoai= new ArrayList<>();
	private List<String> listMaSP= new ArrayList<>();
	private List<String> listTenSP= new ArrayList<>();
	private SanPhamdao spd = new SanPhamdao();
	private NhaCungCapdao nccd;
	private TheLoaidao tld;
	private JButton btnchonanh;
	private GuiTheLoai guitl = new GuiTheLoai();
	private GuiNhaCungCap guincc = new GuiNhaCungCap();
	private JComboBox cbxtimkiem;
	private int trangthaithem;
	private int trangthaisua;
	private JButton btndvt;
	private JButton btntheloai;
	private JButton btnncc;
	private JButton btncapnhat;
	private JButton btnluu;
	private JButton btnthem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSanPham frame = new GuiSanPham();
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
	public GuiSanPham() {
		
		KetNoidata.getin().getcon();
		this.spd = new SanPhamdao();
		this.nccd = new NhaCungCapdao();
		this.tld = new TheLoaidao();
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		thontinsanpham = new JPanel();
		thontinsanpham.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setLocationRelativeTo(null);
		setContentPane(thontinsanpham);
		thontinsanpham.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1285, 66);
		thontinsanpham.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Sách");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(534, 10, 210, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 76, 1266, 293);
		thontinsanpham.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SP");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(308, 19, 45, 18);
		panel_1.add(lblNewLabel_1);
		
		txtmasp = new JTextField();
		txtmasp.setEditable(false);
		txtmasp.setBounds(401, 17, 200, 26);
		panel_1.add(txtmasp);
		txtmasp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên SP");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(626, 22, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		txttensp = new JTextField();
		txttensp.setEditable(false);
		txttensp.setBounds(699, 17, 200, 26);
		panel_1.add(txttensp);
		txttensp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số Lượng");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(921, 19, 68, 18);
		panel_1.add(lblNewLabel_3);
		
		txtsoluong = new JTextField();
		txtsoluong.setEditable(false);
		txtsoluong.setBounds(1022, 17, 200, 26);
		panel_1.add(txtsoluong);
		txtsoluong.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đơn Giá");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(308, 128, 58, 13);
		panel_1.add(lblNewLabel_4);
		
		txtdongia = new JTextField();
		txtdongia.setEditable(false);
		txtdongia.setBounds(401, 123, 498, 26);
		panel_1.add(txtdongia);
		txtdongia.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tên tác giả");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(308, 53, 73, 23);
		panel_1.add(lblNewLabel_5);
		
		txttacgia = new JTextField();
		txttacgia.setEditable(false);
		txttacgia.setBounds(401, 53, 200, 26);
		panel_1.add(txttacgia);
		txttacgia.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Đơn vị tính");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(626, 55, 68, 18);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Thể loại");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(921, 55, 48, 18);
		panel_1.add(lblNewLabel_7);
		
		btndvt = new JButton("");
		btndvt.setEnabled(false);
		btndvt.setIcon(new ImageIcon("Img\\Button-Add-icon.png"));
		btndvt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxdvt.setEditable(true);
				themDonViTinh();
				cbxdvt.setEditable(false);
				
			}
		});
		btndvt.setBounds(869, 53, 30, 26);
		panel_1.add(btndvt);
		
		btntheloai = new JButton("");
		btntheloai.setEnabled(false);
		btntheloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guitl.setVisible(true);
			}
		});
		btntheloai.setIcon(new ImageIcon("Img\\Button-Add-icon.png"));
		btntheloai.setBounds(1192, 53, 30, 26);
		panel_1.add(btntheloai);
		
		JLabel lblNhXutBn = new JLabel("Nhà xuất bản");
		lblNhXutBn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNhXutBn.setBounds(308, 86, 82, 26);
		panel_1.add(lblNhXutBn);
		
		txtnxb = new JTextField();
		txtnxb.setEditable(false);
		txtnxb.setBounds(401, 87, 498, 26);
		panel_1.add(txtnxb);
		txtnxb.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nhà cung cấp");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(921, 86, 82, 26);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Giá nhập");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(921, 121, 58, 26);
		panel_1.add(lblNewLabel_9);
		
		txtgianhap = new JTextField();
		txtgianhap.setEditable(false);
		txtgianhap.setBounds(1022, 123, 200, 26);
		panel_1.add(txtgianhap);
		txtgianhap.setColumns(10);
		
		btnncc = new JButton("");
		btnncc.setEnabled(false);
		btnncc.setIcon(new ImageIcon("Img\\Button-Add-icon.png"));
		btnncc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guincc.setVisible(true);
			}
		});
		btnncc.setBounds(1192, 89, 30, 26);
		panel_1.add(btnncc);
		
//		btnthem = new JButton("Thêm");
//		btnthem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(trangthaithem==0)
//				{
//					themmoi();
//				}
//				else
//				{
//					btnthem.setText("Thêm");
//					lamMoi();
//					trangthaithem=0;
//					btncapnhat.setEnabled(true);
//					btnluu.setEnabled(false);
//				}
//			}
//		});
//		btnthem.setBackground(new Color(204, 204, 153));
//		btnthem.setIcon(new ImageIcon("Img\\Ecommerce-New-icon.png"));
//		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		btnthem.setBounds(252, 225, 141, 41);
//		panel_1.add(btnthem);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSP();
				
			}
		});
		btnxoa.setIcon(new ImageIcon("Img\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(552, 174, 141, 41);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmasp.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để sửa!");
				}
				else
				{
					if(trangthaisua==0)
					{
						suamoi();
					}
					else
					{
						btncapnhat.setText("Cập nhật");
						lamMoi();
						trangthaisua=0;
						btnthem.setEnabled(true);
						btnluu.setEnabled(false);
					}
				}
			}
		});
		btncapnhat.setBackground(new Color(204, 204, 153));
		btncapnhat.setIcon(new ImageIcon("Img\\Users-Edit-User-icon (1).png"));
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(553, 225, 141, 41);
		panel_1.add(btncapnhat);
		
		JButton btnNewButton_4_3 = new JButton("Làm Mới");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnNewButton_4_3.setBackground(new Color(204, 204, 153));
		btnNewButton_4_3.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnNewButton_4_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_4_3.setBounds(699, 174, 141, 41);
		panel_1.add(btnNewButton_4_3);
		
		JButton btnNewButton_4_4 = new JButton("Thoát");
		btnNewButton_4_4.setBackground(new Color(204, 204, 153));
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton_4_4.setIcon(new ImageIcon("Img\\Close-icon.png"));
		btnNewButton_4_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_4_4.setBounds(699, 225, 141, 41);
		panel_1.add(btnNewButton_4_4);
		
		cbxdvt = new JComboBox();
		cbxdvt.setEditable(false);
		cbxdvt.setBounds(699, 52, 160, 26);
		panel_1.add(cbxdvt);
		
		cbxtl = new JComboBox();
		cbxtl.setEditable(false);
		cbxtl.setBounds(1022, 52, 160, 26);
		panel_1.add(cbxtl);
		
		cbxncc = new JComboBox();
		cbxncc.setEditable(false);
		cbxncc.setBounds(1022, 87, 160, 26);
		panel_1.add(cbxncc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(31, 17, 211, 266);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblanh = new JLabel("");
		lblanh.setBounds(10, 10, 189, 246);
		panel_2.add(lblanh);
		
		btnchonanh = new JButton("Chọn ảnh");
		btnchonanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser ch = new JFileChooser("D:\\Java\\detainhom\\Imgsanpham");
					ch.showOpenDialog(null);
					File f = ch.getSelectedFile();
					filename = f.getAbsolutePath();
					ImageIcon img = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH));
					lblanh.setIcon(img);
					try {
						File image=new File(filename);
						FileInputStream fis = new FileInputStream(image);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						byte[] b = new byte[2014];
						for(int readNum; (readNum = fis.read(b)) != -1;) {
							bos.write(b, 0, readNum);
						}
						imageSanPham= bos.toByteArray();
					} catch (Exception e1) {
//						 TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception e2) {
					System.out.println("Bạn chưa chọn ảnh");
					// TODO: handle exception
				}
				
			}
		});
		btnchonanh.setBackground(new Color(204, 204, 153));
		btnchonanh.setIcon(new ImageIcon("Img\\add-icon.png"));
		btnchonanh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnchonanh.setBounds(252, 174, 141, 41);
		panel_1.add(btnchonanh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBounds(0, 379, 1256, 250);
		thontinsanpham.add(panel_3);
		panel_3.setLayout(null);
		String [] tb = new String [] {"STT","Mã SP","Thể loại","Tên sản phẩm","Tên tác giả","Nhà xuất bản","Nhà cung cấp","Đơn vị tính","Giá nhập","Đơn giá","Số lượng"};
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 20, 1236, 220);
		panel_3.add(scrollPane);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 153, 153));
		panel_4.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(0, 635, 1256, 118);
		thontinsanpham.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Thông tin tìm kiếm:");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11.setBounds(10, 20, 192, 26);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Tìm Kiếm:");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_12.setBounds(94, 56, 99, 26);
		panel_4.add(lblNewLabel_12);
		
		radma = new JRadioButton("Mã");
		radma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeMaSP);
			}
		});
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(202, 62, 51, 21);
		panel_4.add(radma);
		
		radtensp = new JRadioButton("Tên sản phẩm");
		radtensp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeTenSP);
			}
		});
		radtensp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radtensp.setBounds(255, 62, 114, 21);
		panel_4.add(radtensp);
		
		radnhacungcap = new JRadioButton("Nhà cung cấp");
		radnhacungcap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeNCC);
			}
		});
		radnhacungcap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radnhacungcap.setBounds(371, 62, 121, 21);
		panel_4.add(radnhacungcap);
		
		radtheloai = new JRadioButton("Thể loại");
		radtheloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeTheLoai);
			}
		});
		radtheloai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radtheloai.setBounds(494, 62, 81, 21);
		panel_4.add(radtheloai);
		
		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radma);
		buttonGroupTim.add(radtheloai);
		buttonGroupTim.add(radnhacungcap);
		buttonGroupTim.add(radtensp);
		
		JButton btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(647, 39, 141, 41);
		panel_4.add(btntimkiem);
		
		JButton btnNewButton_5_1 = new JButton("Làm Mới");
		btnNewButton_5_1.setBackground(new Color(204, 204, 153));
		btnNewButton_5_1.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_5_1.setBounds(817, 39, 141, 41);
		panel_4.add(btnNewButton_5_1);
		
		cbxtimkiem = new JComboBox();
		cbxtimkiem.setEditable(true);
		cbxtimkiem.setBounds(202, 24, 300, 26);
		panel_4.add(cbxtimkiem);
		
		AutoCompleteDecorator.decorate(cbxdvt);
		AutoCompleteDecorator.decorate(cbxncc);
		AutoCompleteDecorator.decorate(cbxtl);
		
		btnluu = new JButton("Lưu");
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luu();
			}
		});
		btnluu.setIcon(new ImageIcon("Img\\save-icon.png"));
		btnluu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnluu.setBackground(new Color(204, 204, 153));
		btnluu.setBounds(401, 225, 141, 41);
		panel_1.add(btnluu);
		
		btnthem = new JButton("Thêm ");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(trangthaithem==0)
				{
					themmoi();
				}
				else
				{
					btnthem.setText("Thêm");
					lamMoi();
					trangthaithem=0;
					btncapnhat.setEnabled(true);
					btnluu.setEnabled(false);
				}
			}
		});
		btnthem.setIcon(new ImageIcon("D:\\Java\\detainhom\\Img\\Ecommerce-New-icon.png"));
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(401, 174, 141, 41);
		panel_1.add(btnthem);
		AutoCompleteDecorator.decorate(cbxtimkiem);
		docDuLieu();
		table.addMouseListener(this);
		
	}
	public void hienTable() {
		int row;
		int rowCount = table.getSelectedColumn();
//		System.out.println(rowCount);
		row = table.getSelectedRow();
//		System.out.println(row);
		String ma = model.getValueAt(row, 1).toString();
		SanPham sp = new SanPham();
		sp = spd.getSanPham(ma);
		//txtmasp.setText(model.getValueAt(row, 1).toString());
		txtmasp.setText(sp.getMaSP());
		//cbxtl.setSelectedItem(model.getValueAt(row, 2).toString());
		cbxtl.setSelectedItem(sp.getTheLoai().getTenTL());
		//txttensp.setText(model.getValueAt(row, 3).toString());
		txttensp.setText(sp.getTenSP());
		//txttacgia.setText(model.getValueAt(row, 4).toString());
		txttacgia.setText(sp.getTenTG());
		//txtnxb.setText(model.getValueAt(row, 5).toString());
		txtnxb.setText(sp.getTenNSB());
		//cbxncc.setSelectedItem(model.getValueAt(row, 6).toString());
		cbxncc.setSelectedItem(sp.getTenNCC().getTenNCC());
		//cbxdvt.setSelectedItem(model.getValueAt(row, 7).toString());
		cbxdvt.setSelectedItem(sp.getDonVT());
//		txtgianhap.setText(model.getValueAt(row, 7).toString());
//		txtgianhap.setText(tien.format(Double.parseDouble(txtgianhap.getText())) + "VND");
		//txtdongia.setText(model.getValueAt(row, 8).toString());
		txtdongia.setText(""+sp.getDonGia());
		txtgianhap.setText(""+sp.getGiaNhap());
		//txtsoluong.setText(model.getValueAt(row, 9).toString());
		txtsoluong.setText(""+sp.getSoLuong());
		try {
			byte[] img = sp.getHinhAnh();
			ImageIcon ima = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH));
			lblanh.setIcon(ima);
			imageSanPham=img;
		} catch (Exception e) {
			// TODO: handle exception
		}	
	
	}
	
	
//	public void clicktable()
//	{
//		List<SanPham> dssp = spd.getallsanpham();
//		DefaultTableModel modell = (DefaultTableModel) table.getModel();
//		Object[] row = new Object()[]
//		
//	}
	public void docDuLieu() {
		int d=1;
		List<SanPham> list = spd.getallsanphamsp();
		for(SanPham x:list) {
			model.addRow(new Object[] {
					d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
					x.getTenSP(), x.getTenTG(), x.getTenNSB(),
					x.getTenNCC().getTenNCC(), x.getDonVT(), 
					x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
			});
			if(listDonViTinh.contains(x.getDonVT())==false) {
				cboModeDonViTinh.addElement(x.getDonVT());
				cbxdvt.setModel(cboModeDonViTinh);	
				listDonViTinh.add(x.getDonVT());
			}
			if(listMaSP.contains(String.valueOf(x.getMaSP()))==false) {
				cboModeMaSP.addElement(x.getMaSP());
				listMaSP.add(String.valueOf(x.getMaSP()));
			}
			if(listTenSP.contains(x.getTenSP())==false) {
				cboModeTenSP.addElement(x.getTenSP());
				listTenSP.add(x.getTenSP());
			}
		}
		spd.getTenCungCaps().forEach(x->{
			if(listNCC.contains(x)==false) {
				cboModeNCC.addElement(x);
				cbxncc.setModel(cboModeNCC);	
				listNCC.add(x);
			}
			if(listTimNCC.contains(x)==false) {
				cboModeTimNCC.addElement(x);
				listTimNCC.add(x);
			}
		});
		spd.getTheLoais().forEach(x->{
			if(listTheLoai.contains(x)==false) {
				cboModeTheLoai.addElement(x);
				cbxtl.setModel(cboModeTheLoai);	
				listTheLoai.add(x);
			}
			if(listTimTheLoai.contains(x)==false) {
				cboModeTimTheLoai.addElement(x);
				listTimTheLoai.add(x);
			}
		});
	}
	public void themDonViTinh() {
		String moi= JOptionPane.showInputDialog(this, "Đơn vị tính mới");
		cbxdvt.setSelectedItem(moi);
	}
	public void luu()
	{
		SanPham sp = new SanPham();
		String i = spd.maSPmax();
		System.out.println(i);
		String chuoi = i.substring(2);
		int ma = Integer.valueOf(chuoi);
		System.out.println(ma);
		int mamoi = ma+1;
		String chuoima = "";
		if(mamoi<10)
			chuoima += "SP0"+mamoi;
		else
			chuoima += "SP"+mamoi;
		String maSanPham = txtmasp.getText().toString();
		String tenTheLoai = (String) cbxtl.getSelectedItem();
		String tenSanPham = txttensp.getText().toString();
		String tenTacGia = txttacgia.getText().toString();
		String nhaXuatBan = txtnxb.getText().toString();
		String tenNCC = (String) cbxncc.getSelectedItem();
		String donViTinh = (String) cbxdvt.getSelectedItem();
		String giaNhap = txtgianhap.getText().toString();
		String donGia = txtdongia.getText().toString();
		String soLuong = txtsoluong.getText().toString();
		if(trangthaithem !=0 && trangthaisua ==0)
		{
			if(kiemTra()==true)
			{
				spd.themSP(chuoima,spd.getMaTheLoai(tenTheLoai) ,tenSanPham, tenTacGia, nhaXuatBan, spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap), Float.parseFloat(donGia), Integer.valueOf(soLuong), imageSanPham);
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				btnthem.setText("Thêm");
				btncapnhat.setEnabled(true);
				btnluu.setEnabled(false);
				trangthaithem=0;
			}
			else
				return;
		}
		else if(trangthaithem ==0 && trangthaisua !=0)
		{
			String ma1 = txtmasp.getText().trim();
			if(kiemTra()==true)
			{
				spd.capNhatSP(ma1, spd.getMaTheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan,spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap),Float.parseFloat(donGia), Integer.valueOf(soLuong), imageSanPham);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				btnthem.setEnabled(true);
				btncapnhat.setText("Cập nhật");
				btnluu.setEnabled(false);
				trangthaisua=0;
			}
			else 
				return;
		}
		else
			return;
		
		
	}
	
	public boolean kiemTra() {
		try {
			String maSanPham = txtmasp.getText().toString();
			String tenTheLoai = (String) cbxtl.getSelectedItem();
			String tenSanPham = txttensp.getText().toString();
			String tenTacGia = txttacgia.getText().toString();
			String nhaXuatBan = txtnxb.getText().toString();
			String tenNCC = (String) cbxncc.getSelectedItem();
			String donViTinh = (String) cbxdvt.getSelectedItem();
			String giaNhap = txtgianhap.getText().toString();
			String donGia = txtdongia.getText().toString();
			String soLuong = txtsoluong.getText().toString();
			if(tenTheLoai.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thể loại của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (tenSanPham.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txttensp.requestFocus();
				txttensp.selectAll();
				return false;
			}
			else if (tenTacGia.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tác giả của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txttacgia.requestFocus();
				txttacgia.selectAll();
				return false;
			}
			else if (nhaXuatBan.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà xuất bản của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtnxb.requestFocus();
				txtnxb.selectAll();
				return false;
			}
			else if (tenNCC.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (donViTinh.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (giaNhap.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtgianhap.requestFocus();
				txtgianhap.selectAll();
				return false;
			}
			else if (giaNhap.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập bằng số !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtgianhap.requestFocus();
				txtgianhap.selectAll();
				return false;
			}
			else if (donGia.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtdongia.requestFocus();
				txtdongia.selectAll();
				return false;
			}
			else if (donGia.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá bằng số !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtdongia.requestFocus();
				txtdongia.selectAll();
				return false;
			}
			else if (soLuong.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng nhập !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Hinh\\warning.png"));
				txtsoluong.requestFocus();
				txtsoluong.selectAll();
				return false;
			}
			else if (soLuong.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng bằng số !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Hinh\\warning.png"));
				txtsoluong.requestFocus();
				txtsoluong.selectAll();
				return false;
			}
			else if (imageSanPham==null) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh của sản phẩm !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Hinh\\warning.png"));
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	public void xoaTable() {
		model.addRow(new Object[] {

		});
		DefaultTableModel tbl = (DefaultTableModel) table.getModel();
		tbl.getDataVector().removeAllElements();	
	}
	
	public void xoaSP()
	{
		if(txtmasp.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "bạn vui lòng chọn sản phẩm cần xóa");
		}
		else
		{
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này không?", "Lựa chọn của bạn", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				spd.xoaSPN(txtmasp.getText());
				JOptionPane.showMessageDialog(this,"Xóa thành công!");
				lamMoi();
				
			}
		}
		
	}
	
//	public void capnhatSP()
//	{
//		
//		if(txtmasp.getText().equals(""))
//		{
//			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để sửa");
//		}
//		else {
//			int ma = Integer.valueOf(txtmasp.getText());
////			String maSanPham = txtmasp.getText().toString();
//			String tenTheLoai = (String) cbxtl.getSelectedItem();
//			String tenSanPham = txttensp.getText().toString();
//			String tenTacGia = txttacgia.getText().toString();
//			String nhaXuatBan = txtnxb.getText().toString();
//			String tenNCC = (String) cbxncc.getSelectedItem();
//			String donViTinh = (String) cbxdvt.getSelectedItem();
//			String giaNhap = txtgianhap.getText().toString();
//			String donGia = txtdongia.getText().toString();
//			String soLuong = txtsoluong.getText().toString();
//			SanPham sp = new SanPham(ma, spd.getMaTheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap), Float.parseFloat(donGia), Integer.valueOf(soLuong), imageSanPham);
//			if(kiemTra()==true)
//			{
//		//		spd.capNhatSP(ma, spd.getMaTheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan,spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap),Float.parseFloat(donGia), Integer.valueOf(soLuong), imageSanPham);
//				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
//				lamMoi();
//			}
//		}
//	}
	
	public void lamMoi() {
		txtmasp.setText("");
//		cbxtl.setSelectedItem("");
		txttensp.setText("");
		txttacgia.setText("");
		txtnxb.setText("");
//		cbxncc.setSelectedItem("");
//		cbxdvt.setSelectedItem("");
		txtgianhap.setText("");
		txtdongia.setText("");
		txtsoluong.setText("");
//		txtMaSP.setEditable(false);
//		txtTenSP.setEditable(false);
//		txtTacGia.setEditable(false);
//		txtNhaXuatBan.setEditable(false);
//		txtGiaNhap.setEditable(false);
//		txtDonGia.setEditable(false);
//		txtSoLuong.setEditable(false);		
		xoaTable();
		docDuLieu();
		lblanh.setIcon(null);
//		btnSua.setText("Sửa");
//		btnSua.setEnabled(true);
//		trangThaiSua=0;
//		btnThem.setText("Thêm");
//		trangThaiThem=0;
//		btnThem.setEnabled(true);
//		btnThemDVT.setEnabled(false);
//		btnThemNCC.setEnabled(false);
//		btnThemTheLoai.setEnabled(false);
	}
	public void themmoi()
	{
		lamMoi();
		btndvt.setEnabled(true);
		btnncc.setEnabled(true);
		btntheloai.setEnabled(true);
		txttensp.setEditable(true);
		txttacgia.setEditable(true);
		txtnxb.setEditable(true);
		txtgianhap.setEditable(true);
		txtdongia.setEditable(true);
		txtsoluong.setEditable(true);
		btnthem.setText("Hủy");
		trangthaithem=1;
		btncapnhat.setEnabled(false);
		btnluu.setEnabled(true);
	}
	public void suamoi()
	{
		btndvt.setEnabled(true);
		btnncc.setEnabled(true);
		btntheloai.setEnabled(true);
		txttensp.setEditable(true);
		txttacgia.setEditable(true);
		txtnxb.setEditable(true);
		txtgianhap.setEditable(true);
		txtdongia.setEditable(true);
		txtsoluong.setEditable(true);
		btncapnhat.setText("Hủy");
		trangthaisua=1;
		btnthem.setEnabled(false);
		btnluu.setEnabled(true);
	}
	public void timkiem()
	{
		lamMoi();
		int d = 0;
		String tim = "";
		try {
			tim = cbxtimkiem.getSelectedItem().toString();
		} catch (Exception e) {
		}
		if(tim.equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(this, "Vui lòng không để trống");
			return;
		}
		if(radma.isSelected()){
		xoaTable();
				List<SanPham> list = spd.getSanPhamByMa(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(), x.getTenTG(), x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radnhacungcap.isSelected()){
				xoaTable();
				List<SanPham> list = spd.getSanPhambynhaCungCap(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(), x.getTenTG(), x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radtensp.isSelected()){
				xoaTable();
				List<SanPham> list = spd.getSanPhambyTen(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(), x.getTenTG(), x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radtheloai.isSelected()) {
				xoaTable();
				List<SanPham> list = spd.getSanPhambyTheLoai(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(), x.getTenTG(), x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			hienTable();
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
//		try {
//			List<SanPham> dssp = spd.getallsanpham();
//			int row = table.getSelectedRow();
//			if(row>0 && row<dssp.size())
//			{
//				SanPham sp = dssp.get(row);
//				napsanpham(sp);
//			}
//		} catch (Exception e2) {
//			// TODO: handle exception
//		}
		
		
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
}
