package tuan5_QuanLyKho;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class HangHoa {
	protected final String maHang;
	protected String tenHang;
	protected int soLuongTon;
	protected double donGia;

	abstract double VAT();

	abstract String danhGiaMucDoBuonBan();

	public String getMaHang() {
		return maHang;
	}
	
	public HangHoa(String maHang) throws Exception {
		if (maHang != null && !maHang.isEmpty()) {
			this.maHang = maHang;
		} else {
			throw new Exception("Mã hàng không được để trống");
		}
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if (this.tenHang != null && !tenHang.isEmpty()) {
			this.tenHang = tenHang;
		} else {
			throw new Exception("Tên không được rỗng");
		}
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) throws Exception {
		if (this.soLuongTon >= 0) {
			this.soLuongTon = soLuongTon;
		} else {
			throw new Exception("Số lượng tồn phải lớn hơn hoặc bằng 0");
		}
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (this.donGia > 0) {
			this.donGia = donGia;
		} else {
			throw new Exception("Đơn giá phải lớn hơn 0");
		}
	}

	public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}

	@Override
	public String toString() {
		DecimalFormat tien = new DecimalFormat("#,###.##");
		return String.format("%-10s %-20s %-10d %-15s", getMaHang(), getTenHang(), getSoLuongTon(),
				tien.format(getDonGia()));
	}

}
