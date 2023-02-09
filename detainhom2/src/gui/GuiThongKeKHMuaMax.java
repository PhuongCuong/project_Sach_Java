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
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangdao;
import dao.NhaCungCapdao;
import dao.ThongKeKhachHangdao;
import dao.KhachHangdao;
import entities.HoaDon;
import entities.KhachHang;
import entities.SanPham;
import entities.KhachHang;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class GuiThongKeKHMuaMax extends JFrame implements ActionListener{

	public JPanel pntimkh;
	private static JTable table;
	private static DefaultTableModel model;
	private ButtonGroup buttonGroupTim;
	private KhachHangdao khd;
	private ThongKeKhachHangdao tkkhd;
	private JComboBox cbxtuychon;
	private JButton btnthongke;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThongKeKHMuaMax frame = new GuiThongKeKHMuaMax();
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
	public GuiThongKeKHMuaMax() {
		
		this.khd = new KhachHangdao();
		this.tkkhd = new ThongKeKhachHangdao();
		
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
		
		JLabel lblNewLabel = new JLabel("Thống Kê Khách Hàng Mua Nhiều Nhất");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(358, 0, 587, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 1256, 684);
		pntimkh.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 598, 1246, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Số Tiền Mua Hàng:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(427, 23, 217, 32);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("...");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(654, 23, 192, 32);
		panel_2.add(lblNewLabel_3_1);
		
		JButton btnInBoCo = new JButton("In Báo Cáo");
		btnInBoCo.setBackground(new Color(204, 204, 153));
		btnInBoCo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInBoCo.setBounds(856, 23, 140, 35);
		panel_2.add(btnInBoCo);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng Số Lần Mua Hàng:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(115, 23, 200, 32);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("...");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(325, 23, 45, 32);
		panel_2.add(lblNewLabel_5);
		buttonGroupTim = new ButtonGroup();
		
				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 70, 1246, 518);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		String[] tb = new String[] { "STT", "Mã KH", "Tên KH", "Số Điện Thoại","Địa Chỉ", "Số Lần Mua Hàng","Số Tiền Mua Hàng"};
		
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(481, 10, 138, 29);
		panel_4.add(dateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tới Ngày:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(629, 10, 64, 29);
		panel_4.add(lblNewLabel_2_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(703, 10, 138, 29);
		panel_4.add(dateChooser_1);
		
		btnthongke = new JButton("Thống Kê");
		btnthongke.setBackground(new Color(204, 204, 153));
		btnthongke.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthongke.setBounds(867, 8, 140, 35);
		panel_4.add(btnthongke);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBackground(new Color(204, 204, 153));
		btnLmMi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLmMi.setBounds(1032, 8, 140, 35);
		panel_4.add(btnLmMi);
		btnthongke.addActionListener(this);
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
		List<HoaDon> dssp = tkkhd.getthongkengayhomqua();
			for (HoaDon hd : dssp) {
				model.addRow(new Object[] {i++,hd.getMaKH(),hd.getTenKH(),hd.getsDT(),hd.getDiaChi(),hd.getSolan(),hd.getTongTien()});
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
		}
		// TODO Auto-generated method stub
		
	}
}
