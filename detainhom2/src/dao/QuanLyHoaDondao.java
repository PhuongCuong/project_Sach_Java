package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import database.KetNoidata;
import entities.CT_HoaDon;
import entities.HoaDon;
import entities.NhanVien;
import entities.User;

public class QuanLyHoaDondao {
	private Connection con;
	public QuanLyHoaDondao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<HoaDon> getallthongtinhd()
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where HoaDon.maHoaDon like N'HD%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD, maKH, tenKH, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getallthongtindd()
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where HoaDon.maHoaDon like N'DD%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD, maKH, tenKH, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	
	public List<CT_HoaDon> getallcthd(String maHD)
	{
		List<CT_HoaDon> dscthd = new ArrayList<CT_HoaDon>();
		String url = "SELECT CT_HoaDon.maSP, SanPham.tenSP, CT_HoaDon.donGia, CT_HoaDon.soLuong\r\n"
				+ "FROM     CT_HoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  SanPham ON CT_HoaDon.maSP = SanPham.maSP\r\n"
				+ "				  where CT_HoaDon.maHoaDon like N'"+maHD+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				Double donG = rs.getDouble(3);
				int soluong = rs.getInt(4);
				CT_HoaDon cthd = new CT_HoaDon(maSP, tenSP, donG, soluong);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscthd;
	}
	
	public HoaDon getallthongtinhdkh(String maHD)
	{
		HoaDon hd = null;
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where HoaDon.maHoaDon like N'"+maHD+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				hd = new HoaDon(maHD1, maKH, tenKH, sdt, diaChi, tongTien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hd;
	}
	
	public boolean xoaHD(String maHD)
	{
		String url = "delete HoaDon where maHoaDon = ?";
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
	
	public List<HoaDon> getspbyma(String maHD)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and maHoaDon like N'"+maHD+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbyten(String tenKH)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and KhachHang.tenKH like N'"+tenKH+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	public List<HoaDon> getspbysdt(String sdt)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and KhachHang.SDT like N'"+sdt+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt1 = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt1, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbyngay(int nam,int thang,int ngay)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and YEAR(ngayLap) = "+nam+" and MONTH(ngayLap) = "+thang+" and DAY(ngayLap) = "+ngay+"";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getallthongtinDD()
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.TinhTrang, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "	WHERE  HoaDon.maHoaDon LIKE N'DDH%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				String tinhTrang = rs.getString(7);
				java.sql.Date ngayLap = rs.getDate(8);
				HoaDon hd = new HoaDon(maHD, maKH, tenKH, sdt, diaChi, tongTien, tinhTrang, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbymas(String maHD)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien,HoaDon.TinhTrang , HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'DDH%' and maHoaDon like N'"+maHD+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				String tinhtrang = rs.getString(7);
				java.sql.Date ngayLap = rs.getDate(8);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH, sdt, diaChi, tongTien, tinhtrang,ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbytens(String tenKH)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.TinhTrang , HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'DDH%' and KhachHang.tenKH like N'"+tenKH+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				String tinhtrang = rs.getString(7);
				java.sql.Date ngayLap = rs.getDate(8);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt, diaChi, tongTien, tinhtrang,ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	public List<HoaDon> getspbysdts(String sdt)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien,HoaDon.TinhTrang , HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'DDH%' and KhachHang.SDT like N'"+sdt+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdtt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				String tinhtrang = rs.getString(7);
				java.sql.Date ngayLap = rs.getDate(8);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH, sdtt, diaChi, tongTien, tinhtrang,ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbyngays(int nam,int thang,int ngay)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien,HoaDon.TinhTrang , HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'DDH%' and YEAR(ngayLap) = "+nam+" and MONTH(ngayLap) = "+thang+" and DAY(ngayLap) = "+ngay+"";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				String tinhtrang = rs.getString(7);
				java.sql.Date ngayLap = rs.getDate(8);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH, sdt, diaChi, tongTien, tinhtrang,ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	
	public List<HoaDon> getspbymass(String maHD)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and maHoaDon like N'%"+maHD+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getspbytenss(String tenKH)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and KhachHang.tenKH like N'%"+tenKH+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	public List<HoaDon> getspbysdtss(String sdt)
	{
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String url = "SELECT HoaDon.maHoaDon, KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, HoaDon.tongTien, HoaDon.ngayLap\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where maHoaDon like N'HD%' and KhachHang.SDT like N'%"+sdt+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String maHD1 = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH1 = rs.getString(3);
				String sdt1 = rs.getString(4);
				String diaChi = rs.getString(5);
				Double tongTien = rs.getDouble(6);
				java.sql.Date ngayLap = rs.getDate(7);
				HoaDon hd = new HoaDon(maHD1, maKH, tenKH1, sdt1, diaChi, tongTien, ngayLap);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}

}
