package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.NhaCungCap;

public class NhaCungCapdao {
	private Connection con;
	public NhaCungCapdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public List<NhaCungCap> getallncc()
	{
		List<NhaCungCap> dsncc = new ArrayList<NhaCungCap>();
		String url = "select * from NhaCungCap";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				int ma = rs.getInt(1);
				String tenNCC = rs.getString(2);
				
				NhaCungCap ncc = new NhaCungCap(ma, tenNCC);
				dsncc.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsncc;
	}
	public boolean themNCC(int mancc,String tenNCC)
	{
		String url = "insert into NhaCungCap values(?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setInt(1, mancc);
			stm.setString(2, tenNCC);
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public int manccmax()
	{
		int manv =0;
		String url = "select MAX(maNCC) from NhaCungCap";
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
