package tuan5_QuanLyKho;

import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat;
	private Date ngayNhapKho;

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public Date getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(Date ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	public HangSanhSu(String maHang, String nhaSanXuat, Date ngayNhapKho) throws Exception {
		super(maHang);
		this.nhaSanXuat = nhaSanXuat;
		this.ngayNhapKho = ngayNhapKho;
	}

	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia) {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}

	public HangSanhSu(String maHang) throws Exception {
		super(maHang);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat tien = new DecimalFormat("#,###.##");
		return String.format("%s %-20s %-15s %-10s %-15s", super.toString(), getNhaSanXuat(),
				dateFormat.format(getNgayNhapKho()), tien.format(VAT()),danhGiaMucDoBuonBan());
	}

	@Override
	double VAT() {
		// TODO Auto-generated method stub
		return this.donGia * 0.1;
	}

	@Override
	String danhGiaMucDoBuonBan() {
		Date today = new Date();
		long thoiGianLuuTru = today.getTime() - ngayNhapKho.getTime();
		long soNgayNhapKho = thoiGianLuuTru / (1000 * 60 * 60 * 24);
		if (this.soLuongTon > 50 && soNgayNhapKho > 10) {
			return"bán chậm";
		} else {
			return"không đánh giá";
		}

	}

}
