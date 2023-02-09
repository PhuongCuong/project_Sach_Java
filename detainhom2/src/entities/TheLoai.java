package entities;

public class TheLoai {
	private int maTL;
	private String tenTL;
	public int getMaTL() {
		return maTL;
	}
	public void setMaTL(int maTL) {
		this.maTL = maTL;
	}
	public String getTenTL() {
		return tenTL;
	}
	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	public TheLoai(int maTL, String tenTL) {
		super();
		this.maTL = maTL;
		this.tenTL = tenTL;
	}
	public TheLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TheLoai(String tenTL) {
		super();
		this.tenTL = tenTL;
	}
	@Override
	public String toString() {
		return "TheLoai [maTL=" + maTL + ", tenTL=" + tenTL + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maTL;
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
		TheLoai other = (TheLoai) obj;
		if (maTL != other.maTL)
			return false;
		return true;
	}  
	
}
