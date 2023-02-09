package entities;

public class User {
	private String taikhoan;
	private String password;
	private String loaiTK;
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}
	
	public User(String taikhoan, String password, String loaiTK) {
		super();
		this.taikhoan = taikhoan;
		this.password = password;
		this.loaiTK = loaiTK;
	}
	public User(String taikhoan, String password) {
		super();
		this.taikhoan = taikhoan;
		this.password = password;
	}
	
	public User(String taikhoan) {
		super();
		this.taikhoan = taikhoan;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [taikhoan=" + taikhoan + ", password=" + password + "]";
	}
	
}
