package tuan5_QuanLyKho;

import java.text.DecimalFormat;

public class HangDienMay extends HangHoa{
	private int thoiGianBaoHanh;
	private int congXuat;
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) throws Exception {
		if (this.thoiGianBaoHanh >= 0) {
			this.thoiGianBaoHanh = thoiGianBaoHanh;
		} else {
			throw new Exception("Thời gian bảo hành lớn hơn hoặc bằng 0");
		}
		
	}
	public int getCongXuat() {
		return congXuat;
	}
	public void setCongXuat(int congXuat) throws Exception {
		if (congXuat <= 0) {
	        throw new Exception("Công xuất lớn hơn 0");
	    }
	    this.congXuat = congXuat;
	}
	public HangDienMay(String maHang, int thoiGianBaoHanh, int congXuat) throws Exception {
		super(maHang);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.congXuat = congXuat;
	}
	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia) {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}
	public HangDienMay(String maHang) throws Exception {
		super(maHang);
		// TODO Auto-generated constructor stub
	}
	@Override
	double VAT() {
		// TODO Auto-generated method stub
		return this.donGia * 0.1;
	}
	@Override
	String danhGiaMucDoBuonBan() {
		if (this.soLuongTon < 3) {
			return "bán được";
		} else {
			return "không đánh giá";
		}
		
	}
	@Override
	public String toString() {
		DecimalFormat tien = new DecimalFormat("#,###.##");
		return String.format("%s %-10d %-15d %-10s %-15s",super.toString(),getThoiGianBaoHanh(),getCongXuat(),tien.format(VAT()),danhGiaMucDoBuonBan());
	}
	
}
