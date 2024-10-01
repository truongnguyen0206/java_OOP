package tuan4_QLGiaoDich;

import java.sql.Date;
import java.text.DecimalFormat;

public class GiaoDichVang extends GiaoDich{
	private String loaiVang;
	
	public GiaoDichVang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichVang(String maGD, Date ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	public GiaoDichVang(String maGD, Date ngayGD, double donGia, int soLuong, String loaiVang) {
		super(maGD, ngayGD, donGia, soLuong);
		this.loaiVang = loaiVang;
	}

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}

	@Override
	double thanhTien() {
		return this.soLuong * this.donGia;
	}

	@Override
	public String toString() {
		DecimalFormat tien = new DecimalFormat("#,###.##");
		return String.format("%s %-15s %-20s", super.toString(),getLoaiVang(),tien.format(thanhTien()));
	}
	
}
