package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.BarcodePostnet;

import database.KetNoidata;
import entities.CT_HoaDon;
import entities.DoDung;
import entities.HoaDon;
import entities.SanPham;

public class LapHoaDondoa {
	private Connection con;
	public LapHoaDondoa() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<CT_HoaDon> loadDuLieutableGioHang(String ma) {
		List<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
		try {
			PreparedStatement stmt = null;
			String sql = " select * from CT_HoaDon where maHoaDon=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// HoaDon a = new HoaDon();
				String mahoadon = rs.getString("maHoaDon");
				String masp = rs.getString("maSP");
				double dg = rs.getDouble("donGia");
				int sl = rs.getInt("soLuong");
				String dvt = rs.getString("donViTinh");
				float gg = rs.getFloat("giamGia");

				CT_HoaDon a = new CT_HoaDon(mahoadon, masp, dg, sl, dvt, gg);

				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CT_HoaDon> loadDuLieutableGioHangsp(String ma) {
		List<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
		try {
			PreparedStatement stmt = null;
			String sql = " select * from CT_HoaDon where maSP=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// HoaDon a = new HoaDon();
				String mahoadon = rs.getString("maHoaDon");
				String masp = rs.getString("maSP");
				double dg = rs.getDouble("donGia");
				int sl = rs.getInt("soLuong");
				String dvt = rs.getString("donViTinh");
				float gg = rs.getFloat("giamGia");

				CT_HoaDon a = new CT_HoaDon(mahoadon, masp, dg, sl, dvt, gg);

				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public CT_HoaDon loadDuLieutableGioHangspp(String ma) {
		CT_HoaDon hd = new CT_HoaDon();
		try {
			
			PreparedStatement stmt = null;
			String sql = " select * from CT_HoaDon where maSP=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// HoaDon a = new HoaDon();
				String mahoadon = rs.getString("maHoaDon");
				String masp = rs.getString("maSP");
				double dg = rs.getDouble("donGia");
				int sl = rs.getInt("soLuong");
				String dvt = rs.getString("donViTinh");
				float gg = rs.getFloat("giamGia");
				hd.setMaHD(mahoadon);
				hd.setMaSach(masp);
				hd.setDongia(dg);
				hd.setSoluong(sl);
				hd.setDonviTinh(dvt);
				hd.setGiamGia(gg);
				//a = new CT_HoaDon(mahoadon, masp, dg, sl, dvt, gg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hd;
	}
	
	public String maHDMAX() {
		String mahd = "";
		try {
			PreparedStatement stmt = null;
			String sql = "select max(maHoaDon) from [dbo].[HoaDon] where maHoaDon like N'HD%'";
			stmt = con.prepareStatement(sql);
			// stmt.setString(1, tenThuoc);
			// stmt.setString(2,donViTinh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mahd = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mahd;
	}
	
	public String maDDmax() {
		String mahd = "";
		try {
			PreparedStatement stmt = null;
			String sql = "select max(maHoaDon) from [dbo].[HoaDon] where maHoaDon like N'DDH%'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mahd = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mahd;
	}
	
	public String kiemTraTinhTrang(String ma) {
		String tt = "";
		try {
			PreparedStatement stmt = null;
			String sql = "select tinhTrang from HoaDon\n" + "where maHoaDon =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			// stmt.setString(2,donViTinh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tt = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return tt;
	}
	public String getTenSP(String ma) {
		String tt = "";
		try {
			PreparedStatement stmt = null;
			String sql = "SELECT        tenSP\n" + "FROM            SanPham\n" + "WHERE maSP=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			// stmt.setString(2,donViTinh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tt = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return tt;
	}
	
	public String getTenSPdd(String ma) {
		String tt = "";
		try {
			PreparedStatement stmt = null;
			String sql = "SELECT        tenSP\n" + "FROM            DoDungHocTap\n" + "WHERE maSP=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			// stmt.setString(2,donViTinh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tt = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return tt;
	}
	
	public SanPham timSanPhamTheoMa(String maSanPham) {
		SanPham sanPham = new SanPham();
		try {
			PreparedStatement stmt = null;
			String sql = " select * from SanPham where maSP like '"+maSanPham+"'";
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, maSanPham);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPhams = rs.getString("maSP");
				String tenSanPhams = rs.getString("tenSP");
				String tenTacGias = rs.getString("tenTG");
				String nhaXuatBans = rs.getString("nhaXB");
				String donViTinhs = rs.getString("donViTinh");
				int soluong = rs.getInt("soLuong");
				float donGias = rs.getFloat("donGia");
				sanPham.setMaSP(maSanPhams);
				sanPham.setTenSP(tenSanPhams);
				sanPham.setTenTG(tenTacGias);
				sanPham.setTenNSB(nhaXuatBans);
				sanPham.setDonVT(donViTinhs);
				sanPham.setDonGia(donGias);
				sanPham.setSoLuong(soluong);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	
//	public SanPham timSanPhamTheoMat(String maSanPham) {
//		SanPham sanPham = new SanPham();
//		try {
//			PreparedStatement stmt = null;
//			String sql = " select * from [dbo].[SanPham]\n" + " where maSP=?";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maSanPham);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				int maSanPhams = rs.getInt("maSP");
//				String tenSanPhams = rs.getString("tenSP");
//				String tenTacGias = rs.getString("tenTG");
//				String nhaXuatBans = rs.getString("nhaXB");
//				String donViTinhs = rs.getString("donViTinh");
//				float donGias = rs.getFloat("donGia");
//				sanPham.setMaSP(maSanPhams);
//				sanPham.setTenSP(tenSanPhams);
//				sanPham.setTenTG(tenTacGias);
//				sanPham.setTenNSB(nhaXuatBans);
//				sanPham.setDonVT(donViTinhs);
//				sanPham.setDonGia(donGias);
//
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return sanPham;
//	}

	
	public boolean addCT_HoaDonmoi(CT_HoaDon cthd)
	{
		String url = "insert into CT_HoaDon values(?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, cthd.getMaHD());
			stm.setString(2, cthd.getMaSach());
			stm.setDouble(3, cthd.getDongia());
			stm.setInt(4, cthd.getSoluong());
			stm.setString(5, cthd.getDonviTinh());
			stm.setFloat(6, cthd.getGiamGia());
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addHOADON(HoaDon hd)
	{
		String url = "insert into HoaDon values(?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, hd.getMaHD());
			stm.setString(2, hd.getMaNV());
			stm.setString(3, hd.getMaKH());
			stm.setDouble(4, hd.getTongTien());
			stm.setDate(5, hd.getNgayLap());
			stm.setString(6, hd.getTinhTrang());
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public DoDung timSanPhamTheoMadd(String maSanPham) {
		DoDung sanPham = new DoDung();
		try {
			PreparedStatement stmt = null;
			String sql = "select * from DoDungHocTap where maSP like '"+maSanPham+"'";
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, maSanPham);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPhams = rs.getString("maSP");
				String tenSanPhams = rs.getString("tenSP");
				String nhaXuatBans = rs.getString("nhaXB");
				String donViTinhs = rs.getString("donViTinh");
				int soluong = rs.getInt("soLuong");
				float donGias = rs.getFloat("donGia");
				sanPham.setMaSP(maSanPhams);
				sanPham.setTenSP(tenSanPhams);
				sanPham.setTenNSB(nhaXuatBans);
				sanPham.setDonVT(donViTinhs);
				sanPham.setDonGia(donGias);
				sanPham.setSoLuong(soluong);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	
	public boolean xoacthd(String maHD,String maSP) {
		String sql = "delete CT_HoaDon where maHoaDon like '"+maHD+"' and maSP like '"+maSP+"'";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maHD);
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
	public boolean updatehd(String maHD,double tien)
	{
		String sql = "update HoaDon set tongTien = ? where maHoaDon = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, tien);
			stm.setString(2, maHD);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatehdtt(String maHD,String tt)
	{
		String sql = "update HoaDon set TinhTrang = ? where maHoaDon = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, tt);
			stm.setString(2, maHD);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatecthd(String maHD,String maSP,int soluong)
	{
		String sql = "update CT_HoaDon set soLuong = ? where maHoaDon =? and maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, soluong);
			stm.setString(2, maHD);
			stm.setString(3,maSP);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean xoacthdtest(String maHD,String maSP) {
		String sql = "delete CT_HoaDon where maHoaDon = ? and maSP = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maHD);
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
	public boolean xoaCTHD(String maHD)
	{
		String url = "delete CT_HoaDon where maHoaDon = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, maHD);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
