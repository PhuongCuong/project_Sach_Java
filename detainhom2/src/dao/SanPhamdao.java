package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import database.KetNoidata;
import entities.NhaCungCap;
import entities.SanPham;
import entities.TheLoai;

public class SanPhamdao {
	private Connection con;
	public SanPhamdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<SanPham> getallsanpham()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url ="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
				+ "FROM     SanPham INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tentg = rs.getString(4);
				String tenNXB = rs.getString(5);
				String tenNCC = rs.getString(6);
				String donVT = rs.getString(7);
				double giaNhap = rs.getDouble(8);
				double dongia = rs.getDouble(9);
				int soluong = rs.getInt(10);
				byte[] hinhanh = rs.getBytes(11);
				
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tentg, tenNXB, new NhaCungCap(tenNCC), donVT, giaNhap, dongia, soluong, hinhanh);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<SanPham> getallsanphamdd()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url ="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
				+ "FROM     SanPham INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "				  where SanPham.maSP like N'DD%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tentg = rs.getString(4);
				String tenNXB = rs.getString(5);
				String tenNCC = rs.getString(6);
				String donVT = rs.getString(7);
				double giaNhap = rs.getDouble(8);
				double dongia = rs.getDouble(9);
				int soluong = rs.getInt(10);
				byte[] hinhanh = rs.getBytes(11);
				
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tentg, tenNXB, new NhaCungCap(tenNCC), donVT, giaNhap, dongia, soluong, hinhanh);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<SanPham> getallsanphamsp()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url ="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
				+ "FROM     SanPham INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "				  where SanPham.maSP like N'SP%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tentg = rs.getString(4);
				String tenNXB = rs.getString(5);
				String tenNCC = rs.getString(6);
				String donVT = rs.getString(7);
				double giaNhap = rs.getDouble(8);
				double dongia = rs.getDouble(9);
				int soluong = rs.getInt(10);
				byte[] hinhanh = rs.getBytes(11);
				
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tentg, tenNXB, new NhaCungCap(tenNCC), donVT, giaNhap, dongia, soluong, hinhanh);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	public boolean themSP(String ma,int theloai, String tenSP,String tenTG,String tenNXB, int tenNCC, String donVT, double giaNhap, double donGia, int soLuong, byte[] hinhAnh)
	{
		String url = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ma);
			stm.setString(2,String.valueOf(theloai));
			stm.setString(3, tenSP);
			stm.setString(4, tenTG);
			stm.setString(5, tenNXB);
			stm.setString(6, String.valueOf(tenNCC));
			stm.setString(7, donVT);
			stm.setString(8, String.valueOf(giaNhap));
			stm.setString(9, String.valueOf(donGia));
			stm.setString(10, String.valueOf(soLuong));
			stm.setBytes(11, hinhAnh);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean themSPp(SanPham sp)
	{
		String url = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, sp.getMaSP());
			stm.setString(2,String.valueOf(sp.getTheLoai()));
			stm.setString(3, sp.getTenSP());
			stm.setString(4, sp.getTenTG());
			stm.setString(5, sp.getTenNSB());
			stm.setString(6, String.valueOf(sp.getTenNCC().getTenNCC()));
			stm.setString(7, sp.getDonVT());
			stm.setString(8, String.valueOf(sp.getGiaNhap()));
			stm.setString(9, String.valueOf(sp.getDonGia()));
			stm.setString(10, String.valueOf(sp.getSoLuong()));
			stm.setBytes(11, sp.getHinhAnh());
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<String> getTenCungCaps(){
		List<String> list = new ArrayList<String>();
		try {
//			String sql="select [tenNCC]\r\n" + 
//					"from [dbo].[NhaCungCap]";\
			String sql="SELECT NhaCungCap.tenNCC\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String t= rs.getString(1);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<String> getTheLoais(){
		List<String> list = new ArrayList<String>();
		try {
//			String sql="select [tenTL]\r\n" + 
//					"from [dbo].[TheLoai]";
			String sql="SELECT TheLoai.tenTL\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String t= rs.getString(1);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public String maSPmax()
	{
		String manv ="";
		String url = "select MAX(maSP) from SanPham where maSP like N'SP%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				manv = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manv;
	}
	
	public String maDDmax()
	{
		String manv ="";
		String url = "select MAX(maSP) from SanPham where maSP like N'DD%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				manv = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manv;
	}
	
	public int getmaNCC(String ten){
		int ma=0;
		try {
			String sql="select [maNCC]\r\n" + 
					"from [dbo].[NhaCungCap]\r\n" + 
					"where [tenNCC] like N'"+ten+"'";
//			String sql="SELECT NhaCungCap.maNCC\r\n"
//					+ "FROM     SanPham INNER JOIN\r\n"
//					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
//					+ "				  where NhaCungCap.tenNCC like N'"+ten+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ma;
	}
	public int getMaTheLoai(String ten){
		int ma=0;
		try {
//			String sql="SELECT TheLoai.maTL\r\n"
//					+ "FROM     SanPham INNER JOIN\r\n"
//					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL\r\n"
//					+ "				  where TheLoai.tenTL like N'"+ten+"'";
			String sql="select [maTL]\r\n" + 
					"from [dbo].[TheLoai]\r\n" + 
					"where [tenTL] like N'"+ten+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int t= rs.getInt(1);
				ma=t;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ma;
	}
	public boolean xoaSPN(String ma)
	{
		String url = "delete from SanPham where maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ma);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean capNhatSP(String maSP,int matl,String tensp,String tentg, String nhaxb, int mancc, String donvitinh, float gianhap, float dongia, int soluong, byte[] hinhAnh)
	{
		String url = "update SanPham set theLoai = ?,tenSP = ?,tenTG = ?,nhaXB = ?,nhaCC = ?,donViTinh = ?,giaNhap = ?,donGia = ?,soLuong = ?,hinhAnh = ? where maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1,String.valueOf(matl));
			stm.setString(2, tensp);
			stm.setString(3, tentg);
			stm.setString(4, nhaxb);
			stm.setString(5, String.valueOf(mancc));
			stm.setString(6, donvitinh);
			stm.setString(7, String.valueOf(gianhap));
			stm.setString(8, String.valueOf(dongia));
			stm.setString(9, String.valueOf(soluong));
			stm.setBytes(10, hinhAnh);
			stm.setString(11, maSP);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updatesoluong(String maSP,int soluong)
	{
		String url = "update SanPham set soLuong = ? where maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, String.valueOf(soluong));
			stm.setString(2, maSP);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean capNhatSPp(SanPham sp, String maSP)
	{
		String url = "update SanPham set theLoai = ?,tenSP = ?,tenTG = ?,nhaXB = ?,nhaCC = ?,donViTinh = ?,giaNhap = ?,donGia = ?,soLuong = ?,hinhAnh = ? where maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1,String.valueOf(sp.getTheLoai().getTenTL()));
			stm.setString(2, sp.getTenSP());
			stm.setString(3, sp.getTenTG());
			stm.setString(4, sp.getTenNSB());
			stm.setString(5, String.valueOf(sp.getTenNCC().getTenNCC()));
			stm.setString(6, sp.getDonVT());
			stm.setString(7, String.valueOf(sp.getGiaNhap()));
			stm.setString(8, String.valueOf(sp.getDonGia()));
			stm.setString(9, String.valueOf(sp.getSoLuong()));
			stm.setBytes(10, sp.getHinhAnh());
			stm.setString(11, maSP);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<SanPham> getSanPhamByMa(String maTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL\r\n"
					+ "				  where SanPham.maSP like N'SP%'and SanPham.maSP like N'%"+maTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getSanPhambyTen(String tenTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'SP%'and SanPham.tenSP like  N'%"+tenTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getSanPhambyTheLoai(String theLoaiTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'SP%'and TheLoai.tenTL like  N'%"+theLoaiTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getSanPhambynhaCungCap(String nccTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'SP%'and NhaCungCap.tenNCC like N'%"+nccTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	
	public SanPham getSanPham(String maTim) {
		SanPham sanPham = null;
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL\r\n"
					+ "				  where SanPham.maSP like '"+maTim+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sanPham;
	}
	
	
	
	
	/*==============*/
	
	
	
	public List<SanPham> getDoDungByMa(String maTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL\r\n"
					+ "				  where SanPham.maSP like N'DD%'and SanPham.maSP like '%"+maTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getDoDungbyTen(String tenTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'DD%'and SanPham.tenSP like  N'%"+tenTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getDoDungbyTheLoai(String theLoaiTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'DD%'and TheLoai.tenTL like  N'%"+theLoaiTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getDoDungbynhaCungCap(String nccTim) {
		List<SanPham> list= new ArrayList<SanPham>();
		try {
			String sql="SELECT SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.tenTG, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.giaNhap, SanPham.donGia, SanPham.soLuong, SanPham.hinhAnh\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
					+ "		where SanPham.maSP like N'DD%'and NhaCungCap.tenNCC like N'%"+nccTim+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maSP");	
				String tenTheLoai= rs.getString("tenTL");
				String tenSanPham= rs.getString("tenSP");
				String tenTacGia = rs.getString("tenTG");
				String nhaXuatBan= rs.getString("nhaXB");
				String tenNCC= rs.getString("tenNCC");
				String donViTinh = rs.getString("donViTinh");
				float giaNhap = rs.getFloat("giaNhap");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				byte[] hinhAnh=rs.getBytes("hinhAnh");
								
				SanPham sanPham = new SanPham(ma, new TheLoai(tenTheLoai), tenSanPham, tenTacGia, nhaXuatBan, new NhaCungCap(tenNCC), donViTinh, giaNhap, donGia, soLuong, hinhAnh);
				list.add(sanPham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getalltl()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		
		try {
			String sql = "SELECT tenTL\r\n"
					+ "FROM     TheLoai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String ten = rs.getString("tenTL");
				SanPham sanPham = new SanPham(new TheLoai(ten));
				dssp.add(sanPham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<SanPham> getallncc()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		
		try {
			String sql = "SELECT tenNCC\r\n"
					+ "FROM     NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String ten = rs.getString("tenNCC");
				SanPham sanPham = new SanPham(new TheLoai(ten));
				dssp.add(sanPham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
}
