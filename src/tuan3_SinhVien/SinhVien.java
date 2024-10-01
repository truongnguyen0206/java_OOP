package tuan3_SinhVien;

public class SinhVien {
	private int maSV;
	private String hoTen,diaChi,soDT;
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) throws Exception{
		if (soDT.matches("\\d{7}")) {
            this.soDT = soDT;
        } else {
            throw new Exception("Số điện thoại phải gồm 7 chữ số.");
        }
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(int maSV, String hoTen, String diaChi, String soDT) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}
	@Override
	public String toString() {
		return String.format("%10d %20s %20s %10s", getMaSV(),getHoTen(),getDiaChi(),getSoDT());
	}
	
}
