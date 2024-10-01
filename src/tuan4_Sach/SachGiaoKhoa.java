package tuan4_Sach;

import java.text.DecimalFormat;
import java.util.Date;

public class SachGiaoKhoa extends Sach{
private boolean tinhTrang;
	
	
	public boolean getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}
	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}
	@Override
	double thanhTien() {
		double thanhTien;
		if (this.tinhTrang) {
			thanhTien = this.soLuong * this.donGia;
			return thanhTien;
		} else {
			thanhTien = this.soLuong * this.donGia * 0.5;
			return thanhTien;
		}		
	}
	@Override
	public String toString() {
		DecimalFormat phanCach = new DecimalFormat("#,###.##");
		return String.format("%s %-10s %-10s",super.toString(),getTinhTrang() ? "mới":"cũ",phanCach.format(thanhTien()));
	}
	
}

