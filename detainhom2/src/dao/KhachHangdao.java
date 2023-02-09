package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.KetNoidata;
import entities.KhachHang;
import entities.SanPham;
import entities.User;

public class KhachHangdao {
	private Connection con;
	public KhachHangdao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public boolean themKH(KhachHang kh)
	{
		String url = "insert into KhachHang values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, kh.getMaKH());
			stm.setString(2, kh.getHoKH());
			stm.setString(3, kh.getTenKH());
			stm.setDate(4, kh.getNgaySinh());
			stm.setString(5, kh.getGioiTinh());
			stm.setString(6, kh.getsDT());
			stm.setString(7, kh.getDiaChi());
			stm.setString(8, kh.getSoCMND());
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<KhachHang> getallkhachhang()
	{
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String url = "select * from KhachHang";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maKH");
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gt = rs.getString("gioitinh");
				String sdt = rs.getString("SDT");
				String dt = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				KhachHang kh = new KhachHang(ma, ho, ten, ngaysinh, gt, sdt, dt, cmnd);
//				User ur = new User(rs.getString("tenTK"));
//				kh.setTenTK(ur);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	
	public List<KhachHang> getallkhachhangbyma(String ma1)
	{
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String url = "select * from KhachHang where maKH like N'%"+ma1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maKH");
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gt = rs.getString("gioitinh");
				String sdt = rs.getString("SDT");
				String dt = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				KhachHang kh = new KhachHang(ma, ho, ten, ngaysinh, gt, sdt, dt, cmnd);
//				User ur = new User(rs.getString("tenTK"));
//				kh.setTenTK(ur);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	
	public List<KhachHang> getallkhachhangbyten(String ten1)
	{
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String url = "select * from KhachHang where tenKH like N'%"+ten1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maKH");
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gt = rs.getString("gioitinh");
				String sdt = rs.getString("SDT");
				String dt = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				KhachHang kh = new KhachHang(ma, ho, ten, ngaysinh, gt, sdt, dt, cmnd);
//				User ur = new User(rs.getString("tenTK"));
//				kh.setTenTK(ur);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	
	public List<KhachHang> getallkhachhangbysdt(String sdt1)
	{
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String url = "select * from KhachHang where SDT like N'"+sdt1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maKH");
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gt = rs.getString("gioitinh");
				String sdt = rs.getString("SDT");
				String dt = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				KhachHang kh = new KhachHang(ma, ho, ten, ngaysinh, gt, sdt, dt, cmnd);
//				User ur = new User(rs.getString("tenTK"));
//				kh.setTenTK(ur);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	
	public List<KhachHang> getallkhachhangbycmnd(String cmnd1)
	{
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String url = "select * from KhachHang where soCMND like N'"+cmnd1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maKH");
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaysinh = rs.getDate("ngaysinh");
				String gt = rs.getString("gioitinh");
				String sdt = rs.getString("SDT");
				String dt = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				KhachHang kh = new KhachHang(ma, ho, ten, ngaysinh, gt, sdt, dt, cmnd);
//				User ur = new User(rs.getString("tenTK"));
//				kh.setTenTK(ur);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	
//	public String getmatkhau(String sdt , String tentk)
//	{
//		String matkhau = null;
//		String url = "SELECT TaiKhoan.matkhau, KhachHang.tentaikhoan FROM     "
//				+ "KhachHang INNER JOIN TaiKhoan ON KhachHang.tentaikhoan = TaiKhoan.taikhoan "
//				+ "where KhachHang.SDT = ? and KhachHang.tentaikhoan = ?";
//		try {
//			PreparedStatement stm = con.prepareStatement(url);
//			stm.setString(1, sdt);
//			stm.setString(2, tentk);
//			ResultSet rs = stm.executeQuery();
//			while(rs.next())
//			{
//				matkhau = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Error!");
//		}
//		return matkhau;
//	}
//	public List<KhachHang> getidall()
//	{
//		List<KhachHang> dskh = new ArrayList<KhachHang>();
//		String url = "select maKH from KhachHang";
//		try {
//			PreparedStatement stm = con.prepareStatement(url);
//			ResultSet rs = stm.executeQuery();
//			while(rs.next())
//			{
//				KhachHang kh = new KhachHang(rs.getInt("maKH"));
//				dskh.add(kh);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dskh;
//	}
	public String maKHmax()
	{
		String makh ="";
		String url = "select MAX(maKH) from KhachHang";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				makh = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return makh;
	}
	public boolean updatekhachhhang(String ma,String ho, String ten,Date ngaysinh, String gioit, String sdt, String diachi,String cmnd)
	{
		boolean check = false;
		String url = "Update KhachHang set hoKH = ? , tenKH = ?,ngaysinh = ?,gioitinh = ?,SDT = ?,diaChi = ? , soCMND = ? where maKH = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ho);
			stm.setString(2, ten);
			stm.setDate(3, ngaysinh);
			stm.setString(4, gioit);
			stm.setString(5, sdt);
			stm.setString(6, diachi);
			stm.setString(7, cmnd);
			stm.setString(8, ma);
			check = stm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public KhachHang layThongTinKhachHang(String maKH) throws ClassNotFoundException, SQLException {
		KhachHang dto = null;
		try {
			String sql = "Select * from KhachHang where maKH = ?";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setString(1, maKH);
			ResultSet rs = preStm.executeQuery();
			if (rs.next()) {
				String ho = rs.getString("hoKH");
				String ten = rs.getString("tenKH");
				Date ngaySinh = rs.getDate("ngaysinh");
				String gioiTinh = rs.getString("gioitinh");
				String soDT = rs.getString("SDT");
				String diaChi = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				dto = new KhachHang(maKH, ho, ten, ngaySinh, gioiTinh, soDT, diaChi,cmnd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public KhachHang timKHtheoTen(String tenKH) {
		KhachHang kh = new KhachHang();
		try {
			PreparedStatement stmt = null;
			String sql = " select * from KhachHang where tenKH like N'"+tenKH+"'";
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, maSanPham);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String sdt = rs.getString("SDT");
				String diachi = rs.getString("diaChi");
				kh.setMaKH(maKH);
				kh.setsDT(sdt);
				kh.setDiaChi(diachi);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}
	
	public boolean xoaKhachHang(String maKH) {
		boolean check = false;
		String sql = "delete KhachHang where maKH=?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maKH);
			check = stm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}
	public List<KhachHang> timkiemKhachHangByMa(String ma) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			String sql = "select * from KhachHang where maKH like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + ma + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String ten = rs.getString("tenKH");
				String ho = rs.getString("hoKH");
				Date ngaySinh = rs.getDate("ngaysinh");
				String gioiTinh = rs.getString("gioitinh");
				String soDT = rs.getString("SDT");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				dto = new KhachHang(maKH, ho, ten, ngaySinh, gioiTinh, soDT,diaChi,soCMND);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	public List<KhachHang> timkiemKhachHangByTen(String tenn) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			String sql = "select * from KhachHang where tenKH like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + tenn + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String ten = rs.getString("tenKH");
				String ho = rs.getString("hoKH");
				Date ngaySinh = rs.getDate("ngaysinh");
				String gioiTinh = rs.getString("gioitinh");
				String soDT = rs.getString("SDT");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				dto = new KhachHang(maKH, ho, ten, ngaySinh, gioiTinh, soDT,diaChi,soCMND);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	public List<KhachHang> timkiemKhachHangBySDT(String sdt) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			String sql = "select * from KhachHang where SDT like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + sdt + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String ten = rs.getString("tenKH");
				String ho = rs.getString("hoKH");
				Date ngaySinh = rs.getDate("ngaysinh");
				String gioiTinh = rs.getString("gioitinh");
				String soDT = rs.getString("SDT");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				dto = new KhachHang(maKH, ho, ten, ngaySinh, gioiTinh, soDT,diaChi,soCMND);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim khachhang theo sdt sql");
		} finally {
		}
		return result;
	}
	public List<KhachHang> timkiemKhachHangByCMND(String cmnd) throws ClassNotFoundException, SQLException {
		List<KhachHang> result = null;
		KhachHang dto;
		try {
			String sql = "select * from KhachHang where soCMND like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + cmnd + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String ten = rs.getString("tenKH");
				String ho = rs.getString("hoKH");
				Date ngaySinh = rs.getDate("ngaysinh");
				String gioiTinh = rs.getString("gioitinh");
				String soDT = rs.getString("SDT");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				dto = new KhachHang(maKH, ho, ten, ngaySinh, gioiTinh, soDT,diaChi,soCMND);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim khachhang theo cmnd sql");
		} finally {
		}
		return result;
	}

}
