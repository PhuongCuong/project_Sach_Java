package entities;

import java.sql.Date;
import java.util.Vector;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private Date ngaySinh;
	private String gioiTinh;
	private String sDt;
	private String diaChi;
	private String caLamViec;
	private String soCMND;
	private String loaiNV;
	private User tenTK;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
	public String getsDt() {
		return sDt;
	}
	public void setsDt(String sDt) {
		this.sDt = sDt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getCaLamViec() {
		return caLamViec;
	}
	public void setCaLamViec(String caLamViec) {
		this.caLamViec = caLamViec;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getLoaiNV() {
		return loaiNV;
	}
	public void setLoaiNV(String loaiNV) {
		this.loaiNV = loaiNV;
	}
	public User getTenTK() {
		return tenTK;
	}
	public void setTenTK(User tenTK) {
		this.tenTK = tenTK;
	}
	public NhanVien(String maNV, String hoNV, String tenNV, Date ngaySinh, String gioiTinh, String sDt, String diaChi,
			String caLamViec, String soCMND, String loaiNV, User tenTK) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sDt = sDt;
		this.diaChi = diaChi;
		this.caLamViec = caLamViec;
		this.soCMND = soCMND;
		this.loaiNV = loaiNV;
		this.tenTK = tenTK;
	}
	
	public NhanVien(String maNV, String hoNV, String tenNV, Date ngaySinh, String gioiTinh, String sDt, String diaChi,
			String caLamViec, String soCMND, String loaiNV) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sDt = sDt;
		this.diaChi = diaChi;
		this.caLamViec = caLamViec;
		this.soCMND = soCMND;
		this.loaiNV = loaiNV;
	}
	
	
	
	public NhanVien(String caLamViec) {
		super();
		this.caLamViec = caLamViec;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", sDt=" + sDt + ", diaChi=" + diaChi + ", caLamViec=" + caLamViec
				+ ", soCMND=" + soCMND + ", loaiNV=" + loaiNV + ", tenTK=" + tenTK + "]";
	}
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<>();
		v.add("");
		v.add(maNV);
		v.add(hoNV);
		v.add(tenNV);
		v.add(ngaySinh);
		v.add(gioiTinh);
		v.add(sDt);
		v.add(diaChi);
		v.add(caLamViec);
		v.add(soCMND);
		v.add(loaiNV);
		v.add(tenTK.getTaikhoan());
		return v;
		// TODO Auto-generated method stub
	}
	
	
}
