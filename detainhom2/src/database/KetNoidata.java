package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoidata {
	public static Connection con;
	private static KetNoidata in = new KetNoidata();
	public static KetNoidata getin()
	{
		return in;
	}
	public void connet()
	{
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLTest";
		try {
			con = DriverManager.getConnection(url,"sa","1234567");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void diss()
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static Connection getcon()
	{
		return con;
	}
}
