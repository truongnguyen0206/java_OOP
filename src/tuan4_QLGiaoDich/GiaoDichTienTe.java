package tuan4_QLGiaoDich;

import java.sql.Date;
import java.text.DecimalFormat;

public class GiaoDichTienTe extends GiaoDich{
	private float tiGia;
	private int loaiTien;
	
	public GiaoDichTienTe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichTienTe(String maGD, Date ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	public GiaoDichTienTe(String maGD, Date ngayGD, double donGia, int soLuong, float tiGia, int loaiTien) {
		super(maGD, ngayGD, donGia, soLuong);
		this.tiGia = tiGia;
		this.loaiTien = loaiTien;
	}

	public float getTiGia() {
		return tiGia;
	}

	public void setTiGia(float tiGia) {
		this.tiGia = tiGia;
	}

	public int getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(int loaiTien) {
		this.loaiTien = loaiTien;
	}
	
	@Override
	double thanhTien() {
		if (this.loaiTien == 1  ) {
			return this.soLuong * this.donGia;
		}else
			return this.soLuong * this.donGia *this.tiGia;
	}

	@Override
	public String toString() {
		String temp;
		DecimalFormat tien = new DecimalFormat("#,###.##");
		if (loaiTien == 1) {
			temp = "VND";
		} else {if (loaiTien == 2) {
			temp = "USD";
		} else 
			temp = "EURO";
		}
		return String.format("%s %-10.1f %-15s %-20s", super.toString(),getTiGia(),temp,tien.format(thanhTien()));
	}	
}
