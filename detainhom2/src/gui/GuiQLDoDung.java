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
import entities.DoDung;
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
import java.awt.event.MouseAdapter;

public class GuiQLDoDung extends JFrame implements MouseListener{

	public JPanel thongtinqldodung;
	private JTextField txtmasp;
	private JTextField txttensp;
	private JTextField txtsoluong;
	private JTextField txtdongia;
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
	public static JComboBox cbxtll;
	public JComboBox cbxdvtl;
	public static JComboBox cbxnccl;
	
	private DefaultComboBoxModel cboModeNCCl= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeDonViTinhl= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTheLoail= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTimTheLoail= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeNhapTTTKl= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeMaSPl= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTenSPl= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeTimNCCl= new DefaultComboBoxModel();
	
	private List<String> listDonViTinhl= new ArrayList<>();
	private List<String> listNCCl= new ArrayList<>();
	private List<String> listTheLoail= new ArrayList<>();
	private List<String> listTimNCCl= new ArrayList<>();
	private List<String> listTimTheLoail= new ArrayList<>();
	private List<String> listMaSPl= new ArrayList<>();
	private List<String> listTenSPl= new ArrayList<>();
	private NhaCungCapdao nccd;
	private TheLoaidao tld;
	private SanPhamdao spd;
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
					GuiQLDoDung frame = new GuiQLDoDung();
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
	public GuiQLDoDung() {
		
		KetNoidata.getin().getcon();
		this.nccd = new NhaCungCapdao();
		this.tld = new TheLoaidao();
		this.spd = new SanPhamdao();
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		thongtinqldodung = new JPanel();
		thongtinqldodung.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1270, 790);
		setLocationRelativeTo(null);
		setContentPane(thongtinqldodung);
		thongtinqldodung.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1285, 66);
		thongtinqldodung.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th??ng Tin S???n Ph???m");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(534, 10, 353, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 76, 1266, 293);
		thongtinqldodung.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M?? SP");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(308, 19, 45, 18);
		panel_1.add(lblNewLabel_1);
		
		txtmasp = new JTextField();
		txtmasp.setEditable(false);
		txtmasp.setBounds(401, 17, 200, 26);
		panel_1.add(txtmasp);
		txtmasp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T??n SP");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(626, 22, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		txttensp = new JTextField();
		txttensp.setEditable(false);
		txttensp.setBounds(699, 17, 200, 26);
		panel_1.add(txttensp);
		txttensp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("S??? L?????ng");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(921, 19, 68, 18);
		panel_1.add(lblNewLabel_3);
		
		txtsoluong = new JTextField();
		txtsoluong.setEditable(false);
		txtsoluong.setBounds(1022, 17, 200, 26);
		panel_1.add(txtsoluong);
		txtsoluong.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("????n Gi??");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(921, 93, 58, 13);
		panel_1.add(lblNewLabel_4);
		
		txtdongia = new JTextField();
		txtdongia.setEditable(false);
		txtdongia.setBounds(1022, 88, 200, 26);
		panel_1.add(txtdongia);
		txtdongia.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("????n v??? t??nh");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(308, 55, 68, 18);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Th??? lo???i");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(626, 55, 48, 18);
		panel_1.add(lblNewLabel_7);
		
		btndvt = new JButton("");
		btndvt.setEnabled(false);
		btndvt.setIcon(new ImageIcon("Img\\Button-Add-icon.png"));
		btndvt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxdvtl.setEditable(true);
				themDonViTinh();
				cbxdvtl.setEditable(false);
				
			}
		});
		btndvt.setBounds(571, 53, 30, 26);
		panel_1.add(btndvt);
		
		btntheloai = new JButton("");
		btntheloai.setEnabled(false);
		btntheloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guitl.setVisible(true);
			}
		});
		btntheloai.setIcon(new ImageIcon("Img\\Button-Add-icon.png"));
		btntheloai.setBounds(869, 53, 30, 26);
		panel_1.add(btntheloai);
		
		JLabel lblNhXutBn = new JLabel("Nh?? xu???t b???n");
		lblNhXutBn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNhXutBn.setBounds(308, 86, 82, 26);
		panel_1.add(lblNhXutBn);
		
		txtnxb = new JTextField();
		txtnxb.setEditable(false);
		txtnxb.setBounds(401, 87, 200, 26);
		panel_1.add(txtnxb);
		txtnxb.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nh?? cung c???p");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(921, 51, 82, 26);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Gi?? nh???p");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(626, 87, 58, 26);
		panel_1.add(lblNewLabel_9);
		
		txtgianhap = new JTextField();
		txtgianhap.setEditable(false);
		txtgianhap.setBounds(699, 88, 200, 26);
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
		btnncc.setBounds(1192, 53, 30, 26);
		panel_1.add(btnncc);
		
		btnthem = new JButton("Th??m");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(trangthaithem==0)
				{
					themmoi();
				}
				else
				{
					btnthem.setText("Th??m");
					lamMoi();
					trangthaithem=0;
					btncapnhat.setEnabled(true);
					btnluu.setEnabled(false);
				}
			}
		});
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setIcon(new ImageIcon("Img\\Ecommerce-New-icon.png"));
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBounds(401, 174, 141, 41);
		panel_1.add(btnthem);
		
		JButton btnxoa = new JButton("X??a");
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
		
		btncapnhat = new JButton("C???p Nh???t");
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmasp.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Vui l??ng ch???n s???n ph???m ????? s???a!");
				}
				else
				{
					if(trangthaisua==0)
					{
						suamoi();
					}
					else
					{
						btncapnhat.setText("C???p nh???t");
						lamMoi();
						trangthaisua=0;
						//btnthem.setEnabled(true);
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
		
		JButton btnNewButton_4_3 = new JButton("L??m M???i");
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
		
		JButton btnNewButton_4_4 = new JButton("Tho??t");
		btnNewButton_4_4.setBackground(new Color(204, 204, 153));
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton_4_4.setIcon(new ImageIcon("Img\\Close-icon.png"));
		btnNewButton_4_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_4_4.setBounds(699, 225, 141, 41);
		panel_1.add(btnNewButton_4_4);
		
		cbxdvtl = new JComboBox();
		cbxdvtl.setEditable(false);
		cbxdvtl.setBounds(401, 53, 160, 26);
		panel_1.add(cbxdvtl);
		
		cbxtll = new JComboBox();
		List<SanPham> dssp = spd.getalltl();
		for (SanPham sp : dssp) {
			cbxtll.addItem(sp.getTheLoai().getTenTL());
		}
		
		cbxtll.setEditable(false);
		cbxtll.setBounds(699, 52, 160, 26);
		panel_1.add(cbxtll);
		
		cbxnccl = new JComboBox();
		cbxnccl.setEditable(false);
		cbxnccl.setBounds(1022, 52, 160, 26);
		panel_1.add(cbxnccl);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(31, 17, 211, 266);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblanh = new JLabel("");
		lblanh.setBounds(10, 10, 189, 246);
		panel_2.add(lblanh);
		
		btnchonanh = new JButton("Ch???n ???nh");
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
					System.out.println("B???n ch??a ch???n ???nh");
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
		thongtinqldodung.add(panel_3);
		panel_3.setLayout(null);
		String [] tb = new String [] {"STT","M?? SP","Th??? lo???i","T??n s???n ph???m","Nh?? xu???t b???n","Nh?? cung c???p","????n v??? t??nh","Gi?? nh???p","????n gi??","S??? l?????ng"};
		
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
		thongtinqldodung.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Th??ng tin t??m ki???m:");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11.setBounds(10, 20, 192, 26);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("T??m Ki???m:");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_12.setBounds(94, 56, 99, 26);
		panel_4.add(lblNewLabel_12);
		
		radma = new JRadioButton("M??");
		radma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeMaSPl);
			}
		});
		radma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radma.setBounds(202, 62, 51, 21);
		panel_4.add(radma);
		
		radtensp = new JRadioButton("T??n s???n ph???m");
		radtensp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeTenSPl);
			}
		});
		radtensp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radtensp.setBounds(255, 62, 114, 21);
		panel_4.add(radtensp);
		
		radnhacungcap = new JRadioButton("Nh?? cung c???p");
		radnhacungcap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeNCCl);
			}
		});
		radnhacungcap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radnhacungcap.setBounds(371, 62, 121, 21);
		panel_4.add(radnhacungcap);
		
		radtheloai = new JRadioButton("Th??? lo???i");
		radtheloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxtimkiem.setModel(cboModeTheLoail);
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
		
		JButton btntimkiem = new JButton("T??m Ki???m");
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
		
		JButton btnNewButton_5_1 = new JButton("L??m M???i");
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
		
		AutoCompleteDecorator.decorate(cbxdvtl);
		AutoCompleteDecorator.decorate(cbxnccl);
		AutoCompleteDecorator.decorate(cbxtll);
		
		btnluu = new JButton("L??u");
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
		cbxtll.setSelectedItem(sp.getTheLoai().getTenTL());
		//txttensp.setText(model.getValueAt(row, 3).toString());
		txttensp.setText(sp.getTenSP());
		//txtnxb.setText(model.getValueAt(row, 5).toString());
		txtnxb.setText(sp.getTenNSB());
		//cbxncc.setSelectedItem(model.getValueAt(row, 6).toString());
		cbxnccl.setSelectedItem(sp.getTenNCC().getTenNCC());
		//cbxdvt.setSelectedItem(model.getValueAt(row, 7).toString());
		cbxdvtl.setSelectedItem(sp.getDonVT());
//		txtgianhap.setText(model.getValueAt(row, 7).toString());
//		txtgianhap.setText(tien.format(Double.parseDouble(txtgianhap.getText())) + "VND");
		//txtdongia.setText(model.getValueAt(row, 8).toString());
		txtdongia.setText(""+sp.getDonGia());
		txtgianhap.setText(""+sp.getGiaNhap());
		//txtdongia.setText(tien.format(Double.parseDouble(txtdongia.getText())) + " VND");
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
	
	public void docDuLieu() {
		int d=1;
		List<SanPham> list = spd.getallsanphamdd();
		for(SanPham x:list) {
			model.addRow(new Object[] {
					d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
					x.getTenSP(), x.getTenNSB(),
					x.getTenNCC().getTenNCC(), x.getDonVT(), 
					x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
			});
			if(listDonViTinhl.contains(x.getDonVT())==false) {
				cboModeDonViTinhl.addElement(x.getDonVT());
				cbxdvtl.setModel(cboModeDonViTinhl);	
				listDonViTinhl.add(x.getDonVT());
			}
			if(listMaSPl.contains(String.valueOf(x.getMaSP()))==false) {
				cboModeMaSPl.addElement(x.getMaSP());
				listMaSPl.add(String.valueOf(x.getMaSP()));
			}
			if(listTenSPl.contains(x.getTenSP())==false) {
				cboModeTenSPl.addElement(x.getTenSP());
				listTenSPl.add(x.getTenSP());
			}
		}
		spd.getTenCungCaps().forEach(x->{
			if(listNCCl.contains(x)==false) {
				cboModeNCCl.addElement(x);
				cbxnccl.setModel(cboModeNCCl);	
				listNCCl.add(x);
			}
			if(listTimNCCl.contains(x)==false) {
				cboModeTimNCCl.addElement(x);
				listTimNCCl.add(x);
			}
		});
		spd.getTheLoais().forEach(x->{
			if(listTheLoail.contains(x)==false) {
				cboModeTheLoail.addElement(x);
				cbxtll.setModel(cboModeTheLoail);	
				listTheLoail.add(x);
			}
			if(listTimTheLoail.contains(x)==false) {
				cboModeTimTheLoail.addElement(x);
				listTimTheLoail.add(x);
			}
		});
	}
	public void themDonViTinh() {
		String moi= JOptionPane.showInputDialog(this, "????n v??? t??nh m???i");
		cbxdvtl.setSelectedItem(moi);
	}
	public void luu()
	{
		SanPham sp = new SanPham();
		String i = spd.maDDmax();
		System.out.println(i);
		String chuoi = i.substring(2);
		int ma = Integer.parseInt(chuoi);
		System.out.println(ma);
		int mamoi = ma+1;
		String chuoima = "";
		if(mamoi<10)
			chuoima += "DD0"+mamoi;
		else
			chuoima += "DD"+mamoi;
		String maSanPham = txtmasp.getText().toString();
		String tenTheLoai = (String) cbxtll.getSelectedItem();
		String tenSanPham = txttensp.getText().toString();
		String nhaXuatBan = txtnxb.getText().toString();
		String tenNCC = (String) cbxnccl.getSelectedItem();
		String donViTinh = (String) cbxdvtl.getSelectedItem();
		String giaNhap = txtgianhap.getText().toString();
		String donGia = txtdongia.getText().toString();
		String soLuong = txtsoluong.getText().toString();
		if(trangthaithem !=0 && trangthaisua ==0)
		{
			try {
				if(kiemTra()==true)
				{
					spd.themSP(chuoima,spd.getMaTheLoai(tenTheLoai) ,tenSanPham, "", nhaXuatBan, spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap), Float.parseFloat(donGia), Integer.parseInt(soLuong), imageSanPham);
					JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
					btnthem.setText("Th??m");
					btncapnhat.setEnabled(true);
					btnluu.setEnabled(false);
					trangthaithem=0;
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Vui l??ng ??i???n ?????y ????? th??ng tin");
			}
		}
		else if(trangthaithem ==0 && trangthaisua !=0)
		{
			String ma1 = txtmasp.getText().trim();
			try {
				if(kiemTra()==true)
				{
					spd.capNhatSP(ma1, spd.getMaTheLoai(tenTheLoai), tenSanPham, "", nhaXuatBan,spd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap),Float.parseFloat(donGia), Integer.parseInt(soLuong), imageSanPham);
					JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
					btnthem.setEnabled(true);
					btncapnhat.setText("C???p nh???t");
					btnluu.setEnabled(false);
					trangthaisua=0;
				}
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this, "Vui l??ng ??i???n ?????y ????? th??ng tin");
			}
		}
		else
			return;
		
		
	}
	
	public boolean kiemTra() {
		try {
			String maSanPham = txtmasp.getText().toString();
			String tenTheLoai = (String) cbxtll.getSelectedItem();
			String tenSanPham = txttensp.getText().toString();
			String nhaXuatBan = txtnxb.getText().toString();
			String tenNCC = (String) cbxnccl.getSelectedItem();
			String donViTinh = (String) cbxdvtl.getSelectedItem();
			String giaNhap = txtgianhap.getText().toString();
			String donGia = txtdongia.getText().toString();
			String soLuong = txtsoluong.getText().toString();
			if(tenTheLoai.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n th??? lo???i c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (tenSanPham.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txttensp.requestFocus();
				txttensp.selectAll();
				return false;
			}
			else if (nhaXuatBan.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p nh?? xu???t b???n c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtnxb.requestFocus();
				txtnxb.selectAll();
				return false;
			}
			else if (tenNCC.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n nh?? cung c???p c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (donViTinh.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ????n v??? t??nh !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				return false;
			}
			else if (giaNhap.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p gi?? nh???p c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtgianhap.requestFocus();
				txtgianhap.selectAll();
				return false;
			}
			else if (giaNhap.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p gi?? nh???p b???ng s??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtgianhap.requestFocus();
				txtgianhap.selectAll();
				return false;
			}
			else if (donGia.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ????n gi?? c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtdongia.requestFocus();
				txtdongia.selectAll();
				return false;
			}
			else if (donGia.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ????n gi?? b???ng s??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Img\\warning.png"));
				txtdongia.requestFocus();
				txtdongia.selectAll();
				return false;
			}
			else if (soLuong.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? l?????ng nh???p !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Hinh\\warning.png"));
				txtsoluong.requestFocus();
				txtsoluong.selectAll();
				return false;
			}
			else if (soLuong.matches("^[0-9]*") == false) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? l?????ng b???ng s??? !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("Hinh\\warning.png"));
				txtsoluong.requestFocus();
				txtsoluong.selectAll();
				return false;
			}
			else if (imageSanPham==null) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ???nh c???a s???n ph???m !", "Th??ng b??o !", JOptionPane.ERROR_MESSAGE,
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
			JOptionPane.showMessageDialog(this, "b???n vui l??ng ch???n s???n ph???m c???n x??a");
		}
		else
		{
			if(JOptionPane.showConfirmDialog(this, "B???n c?? mu???n x??a s???n ph???m n??y kh??ng?", "L???a ch???n c???a b???n", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				spd.xoaSPN(txtmasp.getText());
				JOptionPane.showMessageDialog(this,"X??a th??nh c??ng!");
				lamMoi();
				
			}
		}
		
	}
	
//	public void capnhatSP()
//	{
//		
//		if(txtmasp.getText().equals(""))
//		{
//			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n s???n ph???m ????? s???a");
//		}
//		else {
//			int ma = Integer.parseInt(txtmasp.getText());
////			String maSanPham = txtmasp.getText().toString();
//			String tenTheLoai = (String) cbxtll.getSelectedItem();
//			String tenSanPham = txttensp.getText().toString();
//			String tenTacGia = txttacgia.getText().toString();
//			String nhaXuatBan = txtnxb.getText().toString();
//			String tenNCC = (String) cbxnccl.getSelectedItem();
//			String donViTinh = (String) cbxdvtl.getSelectedItem();
//			String giaNhap = txtgianhap.getText().toString();
//			String donGia = txtdongia.getText().toString();
//			String soLuong = txtsoluong.getText().toString();
//			SanPham sp = new SanPham(ma, spdd.getMaTheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, spdd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap), Float.parseFloat(donGia), Integer.parseInt(soLuong), imageSanPham);
//			if(kiemTra()==true)
//			{
//		//		spdd.capNhatSP(ma, spdd.getMaTheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan,spdd.getmaNCC(tenNCC), donViTinh, Float.parseFloat(giaNhap),Float.parseFloat(donGia), Integer.parseInt(soLuong), imageSanPham);
//				JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
//				lamMoi();
//			}
//		}
//	}
	
	public void lamMoi() {
		txtmasp.setText("");
//		cbxtll.setSelectedItem("");
		txttensp.setText("");
		txtnxb.setText("");
//		cbxnccl.setSelectedItem("");
//		cbxdvtl.setSelectedItem("");
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
//		btnSua.setText("S???a");
//		btnSua.setEnabled(true);
//		trangThaiSua=0;
//		btnThem.setText("Th??m");
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
		txtnxb.setEditable(true);
		txtgianhap.setEditable(true);
		txtdongia.setEditable(true);
		txtsoluong.setEditable(true);
		btnthem.setText("H???y");
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
		txtnxb.setEditable(true);
		txtgianhap.setEditable(true);
		txtdongia.setEditable(true);
		txtsoluong.setEditable(true);
		btncapnhat.setText("H???y");
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
			JOptionPane.showMessageDialog(this, "Vui l??ng kh??ng ????? tr???ng");
			return;
		}
		if(radma.isSelected()){
		xoaTable();
				List<SanPham> list = spd.getDoDungByMa(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(),x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radnhacungcap.isSelected()){
				xoaTable();
				List<SanPham> list = spd.getDoDungbynhaCungCap(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(),  x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radtensp.isSelected()){
				xoaTable();
				List<SanPham> list = spd.getDoDungbyTen(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(),  x.getTenNSB(),
							x.getTenNCC().getTenNCC(), x.getDonVT(), 
							x.getGiaNhap(), x.getDonGia(), x.getSoLuong()
					});
				}
			}
			else if(radtheloai.isSelected()) {
				xoaTable();
				List<SanPham> list = spd.getDoDungbyTheLoai(tim);
				for(SanPham x:list) {
					model.addRow(new Object[] {
							d++,x.getMaSP(), x.getTheLoai().getTenTL(), 
							x.getTenSP(),  x.getTenNSB(),
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
