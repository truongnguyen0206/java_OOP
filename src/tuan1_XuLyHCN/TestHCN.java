package tuan1_XuLyHCN;

import java.util.Scanner;

public class TestHCN {
	public static int nhapSoNguyen(String thongbao) {
		int a;
		System.out.println(thongbao);
		Scanner scr = new Scanner(System.in);
		a = scr.nextInt();
		return a;
	}
	public static HinhChuNhat nhapThongTinDoiTuong() {
		int cd,cr;
		HinhChuNhat cn;
		cd =nhapSoNguyen("nhap chieu dai");
		cr =nhapSoNguyen("nhap chieu rong");
		cn = new HinhChuNhat(cd,cr);
		return cn;
	}
	static String tieude() {
		return String.format("%10s %10s %12s %12s", "Chieu Dai","Chieu Rong","Chu Vi","Dien Tich");
	}
	public static void nhapCung() {
		HinhChuNhat cn1,cn2,cn3;
		cn1 = new HinhChuNhat(20, 10);
		cn2 = new HinhChuNhat(15, 12);
		cn3 = new HinhChuNhat(8,3);
		System.out.println(cn1);
		System.out.println(cn2);
		System.out.println(cn3);
	}
	public static void main(String[] args) {
		System.out.println("Chuong trinh xu ly hinh chu nhat");
		//System.out.println(tieude());
		//nhapCung();
		HinhChuNhat cn1,cn2;
		cn1 = nhapThongTinDoiTuong();
		cn2 = nhapThongTinDoiTuong();
		System.out.println(tieude());
		System.out.println(cn1);
		System.out.println(cn2);
	}
}
