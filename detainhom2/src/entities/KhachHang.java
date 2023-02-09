package entities;

import java.sql.Date;
import java.util.Vector;

public class KhachHang {
	private String maKH;
	private String hoKH;
	private String tenKH;
	private Date ngaySinh;
	private String gioiTinh;
	private String sDT;
	private String diaChi;
//	private User tenTK;
	private String soCMND;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoKH() {
		return hoKH;
	}
	public void setHoKH(String hoKH) {
		this.hoKH = hoKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
//	public User getTenTK() {
//		return tenTK;
//	}
//	public void setTenTK(User tenTK) {
//		this.tenTK = tenTK;
//	}
	
//
	
	public String getSoCMND() {
		return soCMND;
	}
	public KhachHang(String maKH, String hoKH, String tenKH, Date ngaySinh, String gioiTinh, String sDT, String diaChi,
		String soCMND) {
	super();
	this.maKH = maKH;
	this.hoKH = hoKH;
	this.tenKH = tenKH;
	this.ngaySinh = ngaySinh;
	this.gioiTinh = gioiTinh;
	this.sDT = sDT;
	this.diaChi = diaChi;
	this.soCMND = soCMND;
}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoKH=" + hoKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", sDT=" + sDT + ", diaChi=" + diaChi + ", soCMND=" + soCMND + "]";
	}
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(maKH);
		v.add(hoKH);
		v.add(tenKH);
		v.add(ngaySinh);
		v.add(gioiTinh);
		v.add(sDT);
		v.add(diaChi);
		v.add(soCMND);
		return v;
		// TODO Auto-generated method stub
	}
	
}
