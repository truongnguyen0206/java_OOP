package Tuan4_CD;

import java.util.Objects;

public class CD {
	private int maCD;
	private String tuaCD,caSy;
	private int soBaiHat;
	private double giaThanh;
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	public String getCaSy() {
		return caSy;
	}
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) throws Exception{
		if (this.soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		} else {
			throw new Exception("Số bài hát phải lớn hơn 0");
		}		
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(float giaThanh) throws Exception{
		if (this.giaThanh > 0) {
			this.giaThanh = giaThanh;
		} else {
			throw new Exception("Giá thành phải lớn hơn 0");
		}
	}
	public CD(int maCD, String tuaCD, String caSy, int soBaiHat, Double giaThanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}
	public CD() {
}
	@Override
	public int hashCode() {
		return Objects.hash(maCD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		return maCD == other.maCD;
	}
	@Override
	public String toString() {
		return String.format("%10d %20s %15s %10d %15.1f", getMaCD(),getTuaCD(),getCaSy(),getSoBaiHat(),getGiaThanh());
	}
	
}
