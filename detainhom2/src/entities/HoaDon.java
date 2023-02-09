package entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.crypto.Data;

public class HoaDon {
	private String maHD;
	private KhachHang kh;
	private NhanVien nv;
	private String maNV;
	private String maKH;
	private String tenKH;
	private String sDT;
	private String diaChi;
	private int solan;
	private double tongTien;
	private int sl;
	private String tinhTrang;
	private Date ngayLap;
	
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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
	
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	
	public int getSolan() {
		return solan;
	}
	public void setSolan(int solan) {
		this.solan = solan;
	}
	
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public HoaDon(String maHD, String maNV, String maKH, double tongTien, Date ngayLap, String tinhTrang) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
	}
	
	public HoaDon(String maHD, String maKH,String tenKH, String sDT, String diaChi,double tongTien, Date ngayLap) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;		
	}
	public HoaDon(String maHD, String maKH, String tenKH, String sDT, String diaChi, double tongTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.tongTien = tongTien;
	}
	
	
	
	public HoaDon(String maHD, String maKH, String tenKH, String sDT, String diaChi, double tongTien, String tinhTrang,
			Date ngayLap) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.tongTien = tongTien;
		this.tinhTrang = tinhTrang;
		this.ngayLap = ngayLap;
	}
	
	
	
	
	public HoaDon(String maKH, String tenKH, String sDT, String diaChi, int solan, double tongTien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.solan = solan;
		this.tongTien = tongTien;
	}
	
	
	
	public HoaDon(NhanVien nv, double tongTien, int sl, String tinhTrang) {
		super();
		this.nv = nv;
		this.tongTien = tongTien;
		this.sl = sl;
		this.tinhTrang = tinhTrang;
	}
	
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", tongTien=" + tongTien + ", ngayLap="
				+ ngayLap + ", tinhTrang=" + tinhTrang + "]";
	}
	
	
}
