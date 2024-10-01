package tuan4_QLGiaoDich;

import java.util.ArrayList;

public class DSGiaoDich {
	ArrayList<GiaoDich> DS;
	public DSGiaoDich() {
		DS = new ArrayList<>();
	}
	public void them(GiaoDich gd) throws Exception{
		if (gd != null && !DS.contains(gd)) {
			DS.add(gd);
		} else {
			throw new Exception("đã tồn tại mã giao dịch");
		}
	}
	public ArrayList<GiaoDich> getDS() {
		return DS;
	}
	public double tinhTongGiaoDichTienTe() {
		double tong = 0;
		for (GiaoDich gd : DS) {
			if (gd instanceof GiaoDichTienTe) {
				tong += gd.thanhTien();
			}
		}
		return tong;
	}
	public double tinhTongGiaoDichVang() {
		double tong = 0;
		for (GiaoDich gd : DS) {
			if (gd instanceof GiaoDichVang) {
				tong += gd.thanhTien();
			}
		}
		return tong;
	}
	public int soLuongGiaoDichTienTe() {
		int count = 0;
		for (GiaoDich gd : DS) {
			if (gd instanceof GiaoDichTienTe) {
				count++;
			}
		}
		return count;
	}
	public double tinhTrungBinhThanhTienCuaGiaoDichTienTe() {		
		return tinhTongGiaoDichTienTe()/soLuongGiaoDichTienTe();
	}
	public void giaoDichCoDonGiaHon1Ty() {
		for (GiaoDich giaoDich : DS) {
			if (giaoDich.donGia > 1000000000) {
				System.out.println(giaoDich);
			}
		}
	}
}
