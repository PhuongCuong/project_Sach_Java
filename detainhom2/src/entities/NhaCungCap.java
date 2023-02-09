package entities;

public class NhaCungCap {
	private int maNCC;
	private String tenNCC;
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public NhaCungCap(int maNCC, String tenNCC) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
	}
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhaCungCap(String tenNCC) {
		super();
		this.tenNCC = tenNCC;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maNCC;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		if (maNCC != other.maNCC)
			return false;
		return true;
	}
	
}
