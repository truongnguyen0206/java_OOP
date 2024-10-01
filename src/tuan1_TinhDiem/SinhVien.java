package tuan1_TinhDiem;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private float diemLT,diemTh;
	public SinhVien(int maSV, String hoTen, float diemLT, float diemTh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTh = diemTh;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTh() {
		return diemTh;
	}
	public void setDiemTh(float diemTh) {
		this.diemTh = diemTh;
	}
	public float diemTB() {
		return (diemLT + diemTh)/2; 
	}
	@Override
	public String toString() {
		return String.format("%10d %-15s %10.1f %10.1f %10.1f", getMaSV(),getHoTen(),getDiemLT(),getDiemTh(),diemTB());
	}
}
