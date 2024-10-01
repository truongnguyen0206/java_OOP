package Tuan4_CD;

import java.util.Scanner;

public class TestCD {
	private static void nhapCungCD(DanhSachCD danhSachCD) {
		danhSachCD.themCD(new CD(1, "Album A", "Ca Sĩ A", 10, 150.0));
		danhSachCD.themCD(new CD(2, "Album B", "Ca Sĩ B", 12, 200.0));
		danhSachCD.themCD(new CD(3, "Album C", "Ca Sĩ C", 8, 100.0));
		danhSachCD.themCD(new CD(4, "Album D", "Ca Sĩ D", 15, 250.0));
		danhSachCD.themCD(new CD(5, "Album E", "Ca Sĩ E", 9, 300.0));
		System.out.println("Nhập cứng thành công!");
	}

	private static void themCD(DanhSachCD danhSachCD, Scanner scanner) {
		System.out.print("Nhập mã CD: ");
		int maCD = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhập tựa CD: ");
		String tuaCD = scanner.nextLine();
		System.out.print("Nhập ca sỹ: ");
		String caSy = scanner.nextLine();
		System.out.print("Nhập số bài hát: ");
		int soBaiHat = scanner.nextInt();
		System.out.print("Nhập giá thành CD: ");
		double giaThanh = scanner.nextDouble();
		CD cdMoi = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
		if (danhSachCD.themCD(cdMoi)) {
			System.out.println("Thêm CD thành công.");
		} else {
			System.out.println("Thêm CD thất bại.");
		}
	}

	public static void main(String[] args) {
		DanhSachCD danhSachCD = new DanhSachCD();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("========== MENU ==========");
			System.out.println("1. Nhập cứng");
			System.out.println("2. Thêm 1 CD");
			System.out.println("3. Tính số lượng CD");
			System.out.println("4. Tính tổng giá thành của CD");
			System.out.println("5. Sắp xếp danh sách giá thành giảm dần và xuất ra");
			System.out.println("6. Sắp xếp danh sách tăng dần theo tựa CD và xuất ra");
			System.out.println("7. Xuất toàn bộ danh sách");
			System.out.println("0. Thoát");
			System.out.print("Mời bạn chọn: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				nhapCungCD(danhSachCD);
				break;
			case 2:
				themCD(danhSachCD, scanner);
				break;
			case 3:
				System.out.println("Số lượng CD trong danh sách: " + danhSachCD.tinhSoLuongCD());
				break;
			case 4:
				System.out.println("Tổng giá thành của CD: " + danhSachCD.tongGiaThanhCD());
				break;
			case 5:
				danhSachCD.sapXepDSGiamDanTheoGia();
				System.out.println("Danh sách sau khi sắp xếp giảm dần theo giá thành:");
				danhSachCD.xuatDanhSach();
				break;
			case 6:
				danhSachCD.sapXepTheoTuaCDTangDan();
				System.out.println("Danh sách sau khi sắp xếp tăng dần theo tựa CD:");
				danhSachCD.xuatDanhSach();
				break;
			case 7:
				System.out.println("Danh sách CD:");
				danhSachCD.xuatDanhSach();
				break;
			case 0:
				System.out.println("Thoát chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
			System.out.println();
		} while (choice != 0);

		scanner.close();
	}
}
