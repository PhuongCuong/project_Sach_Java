package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.HoaDon;
import entities.NhaCungCap;
import entities.SanPham;
import entities.TheLoai;

public class ThongKeKhachHangdao {
	private Connection con;
	public ThongKeKhachHangdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<HoaDon> getthongkengayhomqua()
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) = 1\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public List<HoaDon> getthongkengayhomnay()
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				   where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(ngayLap) = DAY(GETDATE())\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<HoaDon> getthongke7ngayqua()
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) < 7\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<HoaDon> getthongketheothang()
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				 where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE())\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<HoaDon> getthongketheonam()
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where YEAR(ngayLap) = YEAR(GETDATE())\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public List<HoaDon> getthongketuychon(String ngaynay, String ngaytoi)
	{
		List<HoaDon> dssp = new ArrayList<HoaDon>();
		String url = "SELECT top 3 KhachHang.maKH, KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi, sum(HoaDon.tongTien) as N'tổng tiền', count(HoaDon.maKH) as N'số lần mua hàng'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "				  where ngayLap between N'"+ngaynay+"' and N'"+ngaytoi+"'\r\n"
				+ "				  group by KhachHang.maKH , KhachHang.tenKH, KhachHang.SDT, KhachHang.diaChi\r\n"
				+ "				  order by N'số lần mua hàng' DESC ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				double tongTien = rs.getDouble(5);
				int solan = rs.getInt(6);
				HoaDon hd = new HoaDon(ma, ten, sdt, diachi, solan, tongTien);
				dssp.add(hd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}

}
