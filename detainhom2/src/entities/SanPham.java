package entities;

import java.util.Arrays;

public class SanPham {
	private String maSP;
	private TheLoai theLoai;
	private String tenSP;
	private String tenTG;
	private String tenNSB;
	private NhaCungCap tenNCC;
	private String donVT;
	private double giaNhap;
	private double donGia;
	private int soLuong;
	private byte[] hinhAnh;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public String getTenNSB() {
		return tenNSB;
	}
	public void setTenNSB(String tenNSB) {
		this.tenNSB = tenNSB;
	}
	public NhaCungCap getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(NhaCungCap tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDonVT() {
		return donVT;
	}
	public void setDonVT(String donVT) {
		this.donVT = donVT;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public SanPham(String maSP, TheLoai theLoai, String tenSP, String tenTG, String tenNSB, NhaCungCap tenNCC, String donVT,
			double giaNhap, double donGia, int soLuong, byte[] hinhAnh) {
		super();
		this.maSP = maSP;
		this.theLoai = theLoai;
		this.tenSP = tenSP;
		this.tenTG = tenTG;
		this.tenNSB = tenNSB;
		this.tenNCC = tenNCC;
		this.donVT = donVT;
		this.giaNhap = giaNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
	}
	
	
	
	public SanPham(String maSP, TheLoai theLoai, String tenSP, String tenNSB, NhaCungCap tenNCC, String donVT,
			double donGia, int soLuong) {
		super();
		this.maSP = maSP;
		this.theLoai = theLoai;
		this.tenSP = tenSP;
		this.tenNSB = tenNSB;
		this.tenNCC = tenNCC;
		this.donVT = donVT;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	
	
	public SanPham(TheLoai theLoai) {
		super();
		this.theLoai = theLoai;
	}
	
	
	public SanPham(NhaCungCap tenNCC) {
		super();
		this.tenNCC = tenNCC;
	}
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", theLoai=" + theLoai + ", tenSP=" + tenSP + ", tenTG=" + tenTG + ", tenNSB="
				+ tenNSB + ", tenNCC=" + tenNCC + ", donVT=" + donVT + ", giaNhap=" + giaNhap + ", donGia=" + donGia
				+ ", soLuong=" + soLuong + ", hinhAnh=" + Arrays.toString(hinhAnh) + "]";
	}
	
}
