package tuan1_TinhDiem;

import java.util.Scanner;

public class TestSinhVien {
	public static int nhapSoNguyen(String thongbao) {
		int a;
		System.out.println(thongbao);
		Scanner scr = new Scanner(System.in);
		a = scr.nextInt();
		return a;
	}
	public static String nhapChuoi(String thongbao) {
		String b;
		System.out.println(thongbao);
		Scanner scr = new Scanner(System.in);
		b = scr.nextLine();
		return b;
	}
	public static float nhapSoThuc(String thongbao) {
		float c;
		System.out.println(thongbao);
		Scanner scr = new Scanner(System.in);
		c = scr.nextFloat();
		return c;
	}
	public static SinhVien nhapThongTinSinhVien() {
		int maSV;
		String tenSV;
		float diemTH,diemLT;
		SinhVien sv;
		maSV = nhapSoNguyen("nhap ma sinh vien");
		tenSV = nhapChuoi("nhap ten sinh vien");
		diemLT = nhapSoThuc("nhap diem ly thuyet");
		diemTH = nhapSoThuc("nhap diem thuc hanh");
		sv = new SinhVien(maSV, tenSV, diemLT, diemTH);
		return sv;
	}
	static String tieude() {
		return String.format("%10s %10s %20s %12s %12s", "Ma SV","Ten SV","Diem LT","Diem TH","Diem TB");
	}
	public static void nhapCung() {
		SinhVien sv1, sv2;
		sv1 = new SinhVien(1, "Nguyen Van Nhat Truong", 9, 6);
		sv2 = new SinhVien(2, "nguyen van a", 3, 4);
		System.out.println(sv1);
		System.out.println(sv2);
	}
	public static void main(String[] args) {
		System.out.println("CHUONG TRINH XU LY SINH VIEN");
//		SinhVien sv3;
//		sv3 = nhapThongTinSinhVien();
		System.out.println(tieude());
		nhapCung();
//		System.out.println(sv3);
	}
}
