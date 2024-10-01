package tuan3_HangThucPham;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class HangThucPham {
	private String maHang,tenHang;
	private double donGia;
	private Date ngaySX,ngayHH;
	public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySX, Date ngayHH) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;	
	}
	
	public HangThucPham(String maHang) {
		super();
		this.maHang = maHang;
	}

	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		if (this.maHang == null) {
			this.maHang = "TP001";
		} else 
			this.maHang = maHang;		
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if (this.tenHang == null) {
			this.tenHang = "luong thuc";
		} else 
			this.tenHang = tenHang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if (this.donGia <= 0) {
			this.donGia = 1000;
		} else 
			this.donGia = donGia;
	}
	public Date getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(Date ngaySX) {
		if (this.ngaySX == null) {
			this.ngaySX = java.sql.Date.valueOf(LocalDate.now());
		}
		this.ngaySX = ngaySX;
	}
	public Date getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(Date ngayHH) throws Exception{
		if (this.ngayHH == null) {
			// Chuyển đổi Date -> LocalDate
	        LocalDate localDateSX = this.ngaySX.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
	        LocalDate localDateHH = localDateSX.plusYears(1);//Cộng thêm 1 năm
	        this.ngayHH = java.sql.Date.valueOf(localDateHH);
		}else {
			 LocalDate localDateSX = this.ngaySX.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		     LocalDate localDateHH = ngayHH.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		     if (!localDateHH.isAfter(localDateSX)) {
				throw new Exception("Ngày hết hạn phải sau ngày sản xuất.");
		     }
	       this.ngayHH = ngayHH;
	}
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat phanCach = new DecimalFormat("#,###.##");
		return String.format("%10s %20s %15.2f %15s %15s", getMaHang(),getTenHang(),phanCach.format(getDonGia()),dateFormat.format(getNgaySX()),dateFormat.format(getNgayHH()));
	}
	
}

