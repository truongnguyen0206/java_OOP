package tuan5_QuanLyKho;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HangThucPham extends HangHoa{
	private Date ngaySanXuat,ngayHethan;
	private String nhaCungCap;
	
	public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia) {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
	}

	public HangThucPham(String maHang, Date ngaySanXuat, Date ngayHethan, String nhaCungCap) throws Exception {
		super(maHang);
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHethan = ngayHethan;
		this.nhaCungCap = nhaCungCap;
	}

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getNgayHethan() {
		return ngayHethan;
	}

	public void setNgayHethan(Date ngayHethan) throws Exception {
		LocalDate localDateSX = this.ngaySanXuat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	     LocalDate localDateHH = ngayHethan.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	     if (!localDateHH.isAfter(localDateSX)) {
			throw new Exception("Ngày hết hạn phải sau ngày sản xuất.");
	     }
		this.ngayHethan = ngayHethan;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public HangThucPham(String maHang) throws Exception {
		super(maHang);
		// TODO Auto-generated constructor stub
	}

	@Override
	double VAT() {
		return this.getDonGia() * 0.05;
	}

	@Override
	String danhGiaMucDoBuonBan() {
		Date today = new Date();
		if (this.soLuongTon > 0 && ngayHethan.before(today)) {
			return "khó bán";
		} else {
			return "không đánh giá";		}
		
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat tien = new DecimalFormat("#,###.##");
		return String.format("%s %-15s %-15s %-15s %-15s %-15s",super.toString(),dateFormat.format(getNgaySanXuat()),dateFormat.format(getNgayHethan()),getNhaCungCap(),tien.format(VAT()),danhGiaMucDoBuonBan());
	}
	
}
