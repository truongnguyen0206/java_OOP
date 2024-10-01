package tuan3_PhanSo;

import java.util.Scanner;

public class TestPhanSo {
	static Scanner sn;
	public static int nhapSoNguyen(String thongbao) {
		int a;
		System.out.println(thongbao);
		sn = new Scanner(System.in);
		a = sn.nextInt();
		return a;
	}
	public static PhanSo nhapPhanSo() {
		int tuSo,mauSo;
		PhanSo ps;
		tuSo = nhapSoNguyen("Nhap tu so");
		mauSo = nhapSoNguyen("Nhap mau so");
		ps = new PhanSo(tuSo, mauSo);
		return ps;
	}
	public static PhanSo congPS(PhanSo ps1,PhanSo ps2) {
		int newTuSo = ps1.getTuSo()*ps2.getMauSo() + ps2.getTuSo()*ps1.getMauSo();
		int newMauSo = ps1.getMauSo()*ps2.getMauSo();
		return new PhanSo(newTuSo, newMauSo);
	}
	public static PhanSo truPS(PhanSo ps1,PhanSo ps2) {
		int newTuSo = ps1.getTuSo()*ps2.getMauSo() - ps2.getTuSo()*ps1.getMauSo();
		int newMauSo = ps1.getMauSo()*ps2.getMauSo();
		return new PhanSo(newTuSo, newMauSo);
	}
	public static PhanSo nhanPS(PhanSo ps1,PhanSo ps2) {
		int newTuSo = ps1.getTuSo() * ps2.getTuSo();
		int newMauSo = ps1.getMauSo()*ps2.getMauSo();
		return new PhanSo(newTuSo, newMauSo);
	}
	public static PhanSo chiaPS(PhanSo ps1,PhanSo ps2) {
		int newTuSo = ps1.getTuSo() * ps2.getMauSo();
		int newMauSo = ps1.getMauSo()*ps2.getTuSo();
		return new PhanSo(newTuSo, newMauSo);
	}
	public static int menu() {
	    String[] options = {
	        "Tối giản phân số",
	        "Nghịch đảo phân số",
	        "Cộng 2 phân số",
	        "Trừ 2 phân số",
	        "Nhân 2 phân số",
	        "Chia 2 phân số",
	        "so sánh 2 phân số, sử dụng sai số 0.0001 để so sánh",
	        "Thoát"
	    };
	    System.out.println("\n\t********************************");
	    System.out.println("\t** Chương Trình Quản lý **");
	    for (int i = 0; i < options.length; i++)
	    	System.out.printf("\t* %d. %s%n", i + 1, options[i]);
	    System.out.println("\t********************************");
	    int option = nhapSoNguyen("Chọn: ");
	    return option;
	}
	public static void main(String[] args) {
		int menu;
		do {
			menu= menu();
			PhanSo ps,ps1,ps2;
			switch (menu) {
			case 1: {
				ps = nhapPhanSo();
				System.out.println("phân số ban đầu: "+ ps);
				ps.toiGian();
				System.out.println("sau khi tối giản: "+ ps);
				break;
			}
			case 2: {
				ps = nhapPhanSo();
				System.out.println("phân số ban đầu: " + ps);
				ps1 = ps.ngichDao();
				System.out.println("sau khi nghịch đảo: " + ps1);
				break;
			}
			case 3: {
				System.out.println("nhập phan số thứ nhất");
				ps1 = nhapPhanSo();
				System.out.println("nhập phân số thứ 2");
				ps2 = nhapPhanSo();
				ps = congPS(ps1, ps2);
				ps.toiGian();
				System.out.println("Tổng 2 phân số là: "+ ps);
				break;
			}
			case 4: {
				System.out.println("nhập phan số thứ nhất");
				ps1 = nhapPhanSo();
				System.out.println("nhập phân số thứ 2");
				ps2 = nhapPhanSo();
				ps = truPS(ps1, ps2);
				ps.toiGian();
				System.out.println("Hiệu 2 phân số là: "+ ps);
				break;
			}
			case 5: {
				System.out.println("nhập phan số thứ nhất");
				ps1 = nhapPhanSo();
				System.out.println("nhập phân số thứ 2");
				ps2 = nhapPhanSo();
				ps = nhanPS(ps1, ps2);
				ps.toiGian();
				System.out.println("Hiệu 2 phân số là: "+ ps);
				break;
			}
			case 6: {
				System.out.println("nhập phan số thứ nhất");
				ps1 = nhapPhanSo();
				System.out.println("nhập phân số thứ 2");
				ps2 = nhapPhanSo();
				ps = chiaPS(ps1, ps2);
				ps.toiGian();
				System.out.println("Hiệu 2 phân số là: "+ ps);
				break;
			}
			case 7: {
				System.out.println("nhập phan số thứ nhất");
				ps1 = nhapPhanSo();
				System.out.println("nhập phân số thứ 2");
				ps2 = nhapPhanSo();
				if (ps1.equals(ps2)) {
                    System.out.println(ps1 + " và " + ps2 + " bằng nhau.");
                } else if (ps1.isGreaterThan(ps2)) {
                    System.out.println(ps1 + " lớn hơn " + ps2 + ".");
                } else if (ps1.isLessThan(ps2)) {
                    System.out.println(ps1 + " nhỏ hơn " + ps2 + ".");
                }
                break;
			}
			case 8: {
				System.out.println("Thoát chương trình.");
                break;
			}
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (menu != 8);
		System.out.println("Đã Kết Thúc Chương Trình!!!");
		sn.close();
	}
}
