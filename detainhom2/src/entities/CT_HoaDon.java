package entities;

public class CT_HoaDon {
	private String maHD;
	private String maSach;
	private String tenSP;
	private double dongia;
	private int soluong;
	private String donviTinh;
	private float giamGia;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDonviTinh() {
		return donviTinh;
	}
	public void setDonviTinh(String donviTinh) {
		this.donviTinh = donviTinh;
	}
	public float getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	public CT_HoaDon(String maHD, String maSach,double dongia, int soluong, String donviTinh, float giamGia) {
		super();
		this.maHD = maHD;
		this.maSach = maSach;
		this.dongia = dongia;
		this.soluong = soluong;
		this.donviTinh = donviTinh;
		this.giamGia = giamGia;
	}
	
	
	
	public CT_HoaDon(String maSach, String tenSP, double dongia, int soluong) {
		super();
		this.maSach = maSach;
		this.tenSP = tenSP;
		this.dongia = dongia;
		this.soluong = soluong;
	}
	public CT_HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CT_HoaDon [maHD=" + maHD + ", maSach=" + maSach +", dongia=" + dongia
				+ ", soluong=" + soluong + ", donviTinh=" + donviTinh + ", giamGia=" + giamGia + "]";
	}
	
	
	
}
