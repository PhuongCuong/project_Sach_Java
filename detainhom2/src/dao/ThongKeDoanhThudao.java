package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.KetNoidata;

public class ThongKeDoanhThudao {
	private Connection con;
	public ThongKeDoanhThudao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public int soluonghdhomnay()
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ " where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(ngayLap) = DAY(GETDATE())";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int soluonghd7ngayqua()
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ " where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) < 7";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int soluonghdthangqua()
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ "	  where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE())";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int soluonghdnamqua()
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ "	  where YEAR(ngayLap) = YEAR(GETDATE())";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int soluonghdhomqua()
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ "where YEAR(ngayLap) = YEAR(GETDATE()) and MONTH(ngayLap) = MONTH(GETDATE()) and DAY(GETDATE()) - DAY(ngayLap) = 1";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
	
	public int soluonghdtuychon(String n1, String n2)
	{
		int tong = 0;
		String url = "select COUNT(maHoaDon) as 'số hóa đơn'\r\n"
				+ "from HoaDon\r\n"
				+ " where ngayLap between N'"+n1+"' and N'"+n2+"'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				tong = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tong;
	}
}
