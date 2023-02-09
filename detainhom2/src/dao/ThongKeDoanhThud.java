package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.HoaDon;
import entities.NhanVien;

public class ThongKeDoanhThud {
	private Connection con;
	public ThongKeDoanhThud() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public int sohdhomnay(String calv)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) = DAY(ngayLap) and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhdhomnay(String calv)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) = DAY(ngayLap) and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int sohdhomqua(String calv)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) = 1 and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhdhomqua(String calv)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) = 1 and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int sohd7qua(String calv)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) < 7 and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhd7qua(String calv)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) < 7 and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int sohdthangqua(String calv)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhdthangqua(String calv)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int sohdnamqua(String calv)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhdnamqua(String calv)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and YEAR(ngayLap) = YEAR(GETDATE()) and NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int sohdtuychon(String calv,String ngaynay,String ngaykia)
	{
		int tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and ngayLap between '"+ngaynay+"' and '"+ngaykia+"' and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public double tienhdtuychon(String calv,String ngaynay,String ngaykia)
	{
		double tong = 0;
		String url = "SELECT sum( HoaDon.tongTien) as N'tổng tiền',count(HoaDon.maHoaDon) as N'tổng số hóa đơn'\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "				  where HoaDon.TinhTrang like N'Đã Thanh Toán' and ngayLap between '"+ngaynay+"' and '"+ngaykia+"' and  NhanVien.caLamViec like N'"+calv+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
}
