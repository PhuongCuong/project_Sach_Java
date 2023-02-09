package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.TheLoai;

public class TheLoaidao {
	private Connection con;
	public TheLoaidao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<TheLoai> getalltheloai()
	{
		List<TheLoai> dstl = new ArrayList<TheLoai>();
		String url = "select * from TheLoai";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				int ma = rs.getInt(1);
				String tentl = rs.getString(2);
				
				TheLoai tl = new TheLoai(ma, tentl);
				dstl.add(tl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dstl;
	}
	public boolean them(int matl,String tentl)
	{
		String url = "insert into TheLoai values(?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setInt(1, matl);
			stm.setString(2, tentl);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public int matlmax()
	{
		int manv =0;
		String url = "select MAX(maTL) from TheLoai";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				manv = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manv;
	}
}
