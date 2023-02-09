package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.KetNoidata;
import entities.User;

public class Userdao {
	private Connection con;
	public Userdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public boolean dangnhap(User ur)
	{
		String url = "select * from TaiKhoan where taikhoan = ? and matkhau = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ur.getTaikhoan());
			stm.setString(2, ur.getPassword());
			ResultSet rs = stm.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean themuser(User ur)
	{
		String url = "insert into TaiKhoan values(?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ur.getTaikhoan());
			stm.setString(2, ur.getPassword());
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
