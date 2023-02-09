package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import database.KetNoidata;
import entities.KhachHang;
import entities.NhanVien;
import entities.User;

public class ThongTinCaNhandao {
	private Connection con;
	public ThongTinCaNhandao() {
		con = KetNoidata.getin().getcon();
		// TODO Auto-generated constructor stub
	}
	public NhanVien loadnhanvien(String tendn)
	{
		NhanVien nv = new NhanVien();
		String url = "SELECT NhanVien.maNV, NhanVien.hoNV, NhanVien.tenNV, NhanVien.ngaySinh, NhanVien.gioiTinh, NhanVien.soDienThoai, NhanVien.diaChi, NhanVien.caLamViec, NhanVien.soCMND, NhanVien.loaiNV, NhanVien.tenTK, TaiKhoan.taikhoan, \r\n"
				+ "                  TaiKhoan.matkhau\r\n"
				+ "FROM     TaiKhoan INNER JOIN\r\n"
				+ "                  NhanVien ON TaiKhoan.taikhoan = NhanVien.tenTK\r\n"
				+ "WHERE  TaiKhoan.taikhoan = ?";
		try {
			PreparedStatement stm = con.prepareStatement(url);
			stm.setString(1, tendn);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				nv.setMaNV(rs.getString(1));
				nv.setHoNV(rs.getString(2));
				nv.setTenNV(rs.getString(3));
				nv.setNgaySinh(rs.getDate(4));
				nv.setGioiTinh(rs.getString(5));
				nv.setsDt(rs.getString(6));
				nv.setDiaChi(rs.getString(7));
				nv.setCaLamViec(rs.getString(8));
				nv.setSoCMND(rs.getString(9));
				nv.setLoaiNV(rs.getString(10));
				User ur = new User();
				ur.setTaikhoan(rs.getString(11));
				ur.setPassword(rs.getString(12));
				nv.setTenTK(ur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}

}
