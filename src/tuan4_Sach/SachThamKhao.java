package tuan4_Sach;

import java.text.DecimalFormat;
import java.util.Date;

public class SachThamKhao extends Sach{
	private double thue;	
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) {
		this.thue = thue;
	}
	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}
	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}
	@Override
	double thanhTien() {
		return this.soLuong * this.donGia + this.thue;
	}
	@Override
	public String toString() {
		DecimalFormat phanCach = new DecimalFormat("#,###.##");
		return String.format("%s %-10s %-10s",super.toString(), phanCach.format(thue),phanCach.format(thanhTien()));
	}
	
}
