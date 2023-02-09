package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.NhaCungCap;
import entities.SanPham;
import entities.TheLoai;

public class ThongKeSachdao {
	private Connection con;
	public ThongKeSachdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<SanPham> getthongkengayhomqua()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  (YEAR(HoaDon.ngayLap) = YEAR(GETDATE())) AND (MONTH(HoaDon.ngayLap) = MONTH(GETDATE())) AND (DAY(GETDATE()) - DAY(HoaDon.ngayLap) = 1) AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<SanPham> getthongkengayhomnay()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  (YEAR(HoaDon.ngayLap) = YEAR(GETDATE())) AND (MONTH(HoaDon.ngayLap) = MONTH(GETDATE())) AND (DAY(GETDATE()) = DAY(HoaDon.ngayLap) ) AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<SanPham> getthongketheo7ngayqua()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  (YEAR(HoaDon.ngayLap) = YEAR(GETDATE())) AND (MONTH(HoaDon.ngayLap) = MONTH(GETDATE())) AND (DAY(GETDATE()) - DAY(HoaDon.ngayLap) <7) AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<SanPham> getthongketungaynayquangaykhac(String ngaynay,String ngaytoi)
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  ngayLap between N'"+ngaynay+"' and N'"+ngaytoi+"' AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<SanPham> getthongketheothang()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<SanPham> getthongketheonam()
	{
		List<SanPham> dssp = new ArrayList<SanPham>();
		String url = "SELECT TOP (3)  SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SUM(CT_HoaDon.soLuong) AS 'soluong'\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP INNER JOIN\r\n"
				+ "                  TheLoai ON SanPham.theLoai = TheLoai.maTL INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.nhaCC = NhaCungCap.maNCC\r\n"
				+ "WHERE  YEAR(ngayLap) = YEAR(GETDATE()) AND (SanPham.maSP LIKE N'%SP%')\r\n"
				+ "GROUP BY SanPham.maSP, TheLoai.tenTL, SanPham.tenSP, SanPham.nhaXB, NhaCungCap.tenNCC, SanPham.donViTinh, SanPham.donGia, SanPham.soLuong\r\n"
				+ "ORDER BY soluong DESC";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String theloai = rs.getString(2);
				String tensp = rs.getString(3);
				String tenNXB = rs.getString(4);
				String tenNCC = rs.getString(5);
				String donVT = rs.getString(6);
				double dongia = rs.getDouble(7);
				int soluong = rs.getInt(8);
				SanPham sp = new SanPham(ma, new TheLoai(theloai), tensp, tenNXB, new NhaCungCap(tenNCC), donVT, dongia, soluong);
				dssp.add(sp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
}
