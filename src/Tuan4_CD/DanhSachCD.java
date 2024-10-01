package Tuan4_CD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class DanhSachCD {
	ArrayList<CD> DS;
	private final int MAX_SIZE = 100;
	public DanhSachCD() {
		DS = new ArrayList<>();
	}
	 public boolean themCD(CD cdMoi) {
		 if (DS.size() >= MAX_SIZE) {
			 System.out.println("Danh sách đã đầy, không thể thêm CD.");
			 return false;
		 }
		 for (CD cd : DS) {
			 if (cd.equals(cdMoi)) {
				 System.out.println("Mã CD đã tồn tại, không thể thêm CD.");
				 return false;
			 }
		 }
		 DS.add(cdMoi);	
		 return true;
	 }
	 public int tinhSoLuongCD() {
		return DS.size();
	}
	 public double tongGiaThanhCD() {
		double tong = 0;
		for (CD cd : DS) {
			tong += cd.getGiaThanh();
		}
		return tong;
	}
	 public void sapXepDSGiamDanTheoGia() {
		 Collections.sort(DS, new Comparator<CD>() {
			 @Override
			 public int compare(CD cd1, CD cd2) {
				 return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
	         }
	    });
		 System.out.println("Danh sách đã được sắp xếp giảm dần theo giá thành.");
	}
	 public void sapXepTheoTuaCDTangDan() {
		 Collections.sort(DS, new Comparator<CD>() {
			 @Override
			 public int compare(CD cd1, CD cd2) {
				 return cd1.getTuaCD().compareTo(cd2.getTuaCD());
	         }
	    });
	}
	 public void xuatDanhSach() {
		 System.out.printf("%-10s %-20s %-20s %-10s %-10s%n", "Mã CD", "Tựa CD","Ca sỹ","Số bài hát", "Giá thành");
		 for (CD cd : DS) {
			 System.out.printf("%-10s %-20s %-20s %-10s %-10s%n",cd.getMaCD(),cd.getTuaCD(),cd.getCaSy(),cd.getSoBaiHat(),cd.getGiaThanh());
		}
	}
	 public ArrayList<CD> getDanhSach() {
	        return DS;
	    }
}
