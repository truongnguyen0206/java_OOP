package tuan1_XuLyHCN;

public class HinhChuNhat {
	  private int chieuDai,chieuRong;

	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	//phuong thuc tinh dien tich
	public long tinhDienTich() {
		int cDai,cRong;
		long dienTich;
		cDai=this.chieuDai;
		cRong=this.chieuRong;
		dienTich= cDai*cRong;
		return dienTich;
	}
	//phuong thuc tinh chu vi
	public int tinhChuVi() {
		int chuVi;
		return chuVi= (this.chieuDai+this.chieuRong)*2;
	}

	@Override
	public String toString() {
		return String.format("%10d %10d %12d %12d",getChieuDai(),getChieuRong(),tinhChuVi(),tinhDienTich());
	}
	
	  
}
