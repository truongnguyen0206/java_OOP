package tuan2_Vahicle;

public class Vahicle {
	private String tenChuXe,loaiXe;
	private int dungTich;
	private double giaXe;
	public Vahicle(String tenChuXe, String loaiXe, int dungTich, double giaXe) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.giaXe = giaXe;
	}
	public Vahicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenChuXe() {
		return tenChuXe;
	}
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	public double getGiaXe() {
		return giaXe;
	}
	public void setGiaXe(double giaXe) {
		this.giaXe = giaXe;
	}
	public double thueXe() {
		if (dungTich < 100) {
			return giaXe*1/100;
		} else {
			if (dungTich > 200) {
				return giaXe*5/100;
			} else {
				return giaXe*3/100;
			}
		}
	}
	@Override
	public String toString() {
		return String.format("%-15s %14s %10d %20.2f %15.2f", getTenChuXe(),getLoaiXe(),getDungTich(),getGiaXe(),thueXe());
	}
	
}
