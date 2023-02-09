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
import entities.NhanVien;
import entities.User;

public class NhanViendao {
	private Connection con;
	public NhanViendao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public boolean themNV(NhanVien nv)
	{
		String url = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, nv.getMaNV());
			stm.setString(2, nv.getHoNV());
			stm.setString(3, nv.getTenNV());
			stm.setDate(4, nv.getNgaySinh());
			stm.setString(5, nv.getGioiTinh());
			stm.setString(6, nv.getsDt());
			stm.setString(7, nv.getDiaChi());
			stm.setString(8, nv.getCaLamViec());
			stm.setString(9, nv.getSoCMND());
			stm.setString(10, nv.getLoaiNV());
			stm.setString(11, nv.getTenTK().getTaikhoan());
			int n = stm.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<NhanVien> getallnhanvien()
	{
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		String url = "select * from NhanVien";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maNV");
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaysinh = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String cmnd = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");		
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				NhanVien dto = new NhanVien(ma, ho, ten, ngaysinh, gt, sdt, diachi, calv, cmnd, loainv, ur);
//				kh.setTenTK(ur);
				dsnv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public List<NhanVien> getallnhanvienbyma(String ma1)
	{
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		String url = "select * from NhanVien where maNV like N'%"+ma1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maNV");
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaysinh = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String cmnd = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");		
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				NhanVien dto = new NhanVien(ma, ho, ten, ngaysinh, gt, sdt, diachi, calv, cmnd, loainv, ur);
//				kh.setTenTK(ur);
				dsnv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public List<NhanVien> getallnhanvienbyten(String ten1)
	{
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		String url = "select * from NhanVien where tenNV like N'"+ten1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maNV");
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaysinh = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String cmnd = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");		
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				NhanVien dto = new NhanVien(ma, ho, ten, ngaysinh, gt, sdt, diachi, calv, cmnd, loainv, ur);
//				kh.setTenTK(ur);
				dsnv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public List<NhanVien> getallnhanvienbysdt(String sdt1)
	{
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		String url = "select * from NhanVien where soDienThoai like N'"+sdt1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maNV");
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaysinh = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String cmnd = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");		
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				NhanVien dto = new NhanVien(ma, ho, ten, ngaysinh, gt, sdt, diachi, calv, cmnd, loainv, ur);
//				kh.setTenTK(ur);
				dsnv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public List<NhanVien> getallnhanvienbyscmd(String cmnd1)
	{
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		String url = "select * from NhanVien where soCMND like N'%"+cmnd1+"%'";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{				
				String ma = rs.getString("maNV");
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaysinh = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String sdt = rs.getString("soDienThoai");
				String diachi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String cmnd = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");		
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				NhanVien dto = new NhanVien(ma, ho, ten, ngaysinh, gt, sdt, diachi, calv, cmnd, loainv, ur);
//				kh.setTenTK(ur);
				dsnv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public String getmatkhau(String sdt , String cmnd)
	{
		String matkhau = null;
		String url = "SELECT TaiKhoan.matkhau\r\n"
				+ "FROM     NhanVien INNER JOIN\r\n"
				+ "                  TaiKhoan ON NhanVien.tenTK = TaiKhoan.taikhoan\r\n"
				+ "where NhanVien.soDienThoai = ? and NhanVien.soCMND = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, sdt);
			stm.setString(2, cmnd);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				matkhau = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error!");
		}
		return matkhau;
	}
	public String gettaikhoan(String sdt , String cmnd)
	{
		String taikhoan = null;
		String url = "SELECT TaiKhoan.taikhoan\r\n"
				+ "FROM     NhanVien INNER JOIN\r\n"
				+ "                  TaiKhoan ON NhanVien.tenTK = TaiKhoan.taikhoan\r\n"
				+ "where NhanVien.soDienThoai = ? and NhanVien.soCMND = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, sdt);
			stm.setString(2, cmnd);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				taikhoan = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error!");
		}
		return taikhoan;
	}
	public String maNVmax()
	{
		String manv ="";
		String url = "select MAX(maNV) from NhanVien";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				manv = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manv;
	}
	public boolean updatenhanvien(String ma,String ho, String ten,Date ngaysinh, String gioit, String sdt, String diachi,String calamviec,String cmnd ,String loaiNV)
	{
		boolean check = false;
		String url = "Update NhanVien set hoNV = ? , tenNV = ?,ngaySinh = ?,gioiTinh = ?,soDienThoai = ?,diaChi = ? ,caLamViec = ?,soCMND = ?,loaiNV = ? where maNV = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, ho);
			stm.setString(2, ten);
			stm.setDate(3, ngaysinh);
			stm.setString(4, gioit);
			stm.setString(5, sdt);
			stm.setString(6, diachi);
			stm.setString(7, calamviec);
			stm.setString(8, cmnd);
			stm.setString(9, loaiNV);
			stm.setString(10, ma);
			check = stm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public NhanVien layThongTinnhanvien(String maNV) throws ClassNotFoundException, SQLException {
		NhanVien dto = null;
		try {
			String sql = "Select * from NhanVien where maNV = ?";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setString(1, maNV);
			ResultSet rs = preStm.executeQuery();
			if (rs.next()) {
				String ho = rs.getString("hoNV");
				String ten = rs.getString("tenNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String cmnd = rs.getString("soCMND");
				String calamviec = rs.getString("caLamViec");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User ur = new User();
				ur.setTaikhoan(tentk);
				dto = new NhanVien(maNV, ho, ten, ngaySinh, gioiTinh, soDT, diaChi, calamviec, cmnd, loainv, ur);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<String> getAllTenTaiKhoan() throws Exception {
		List<String> result = null;
		try {
			String sql = "select [taikhoan] from [dbo].[TaiKhoan]";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String taiKhoan = rs.getString(1);
				result.add(taiKhoan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	public boolean addTaiKhoan(User tk) throws ClassNotFoundException, SQLException {
		int n = 0;
		try {
			PreparedStatement stm = con.prepareStatement("insert into TaiKhoan values\r\n" + "(?,?)");
			stm.setString(1, tk.getTaikhoan());
			stm.setString(2, tk.getPassword());
			n = stm.executeUpdate();
		} catch (Exception e3) {
			e3.printStackTrace();
		} finally {
		}
		return n > 0;
	}
	public boolean xoanhanvien(String maNV) {
		boolean check = false;
		String sql = "delete NhanVien where maNV=?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			check = stm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}
	
	public List<NhanVien> timkiemnvma(String ma) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien where maNV like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + ma + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				String ho = rs.getString("hoNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String soCMND = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User tk = new User();
				tk.setTaikhoan(tentk);
				dto = new NhanVien(ma, ho, tentk, ngaySinh, gioiTinh, soDT, diaChi, calv, soCMND, loainv, tk);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	
	public List<NhanVien> timkiemnvma1(String ma) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien where maNV like N'%"+ma+"%'";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				String ho = rs.getString("hoNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String calv = rs.getString("caLamViec");
				String soCMND = rs.getString("soCMND");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User tk = new User();
				tk.setTaikhoan(tentk);
				dto = new NhanVien(ma, ho, tentk, ngaySinh, gioiTinh, soDT, diaChi, calv, soCMND, loainv, tk);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	
	public List<NhanVien> timkiemnvten(String tenn) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien where tenNV like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + tenn + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				String ho = rs.getString("hoNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				String calv = rs.getString("caLamViec");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User tk = new User();
				tk.setTaikhoan(tentk);
				dto = new NhanVien(maKH, ho, tenn, ngaySinh, gioiTinh, soDT, diaChi, calv, soCMND, loainv, tk);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return result;
	}
	
	
	
	public List<NhanVien> timkiemnvsdt(String sdt) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien where soDienThoai like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + sdt + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				String ho = rs.getString("hoNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				String calv = rs.getString("caLamViec");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User tk = new User();
				tk.setTaikhoan(tentk);
				dto = new NhanVien(maKH, ho, tentk, ngaySinh, gioiTinh, sdt, diaChi, calv, soCMND, loainv, tk);
				result.add(dto);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Loi tim khachhang theo sdt sql");
		} finally {
		}
		return result;
	}
	public List<NhanVien> timkiemnvcmnd(String cmnd) throws ClassNotFoundException, SQLException {
		List<NhanVien> result = null;
		NhanVien dto;
		try {
			String sql = "select * from NhanVien where soCMND like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + cmnd + "%");
			ResultSet rs = stm.executeQuery();
			result = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				String ho = rs.getString("hoNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				String soCMND = rs.getString("soCMND");
				String calv = rs.getString("caLamViec");
				String loainv = rs.getString("loaiNV");
				String tentk = rs.getString("tenTK");
				User tk = new User();
				tk.setTaikhoan(tentk);
				dto = new NhanVien(maKH, ho, tentk, ngaySinh, gioiTinh, soDT, diaChi, calv, soCMND, loainv, tk);
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
