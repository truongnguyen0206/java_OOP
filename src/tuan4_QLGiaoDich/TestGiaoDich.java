package tuan4_QLGiaoDich;

import java.sql.Date;
import java.util.Scanner;

public class TestGiaoDich {
	public static Scanner sc = new Scanner(System.in);
	public static DSGiaoDich dsGiaoDich = new DSGiaoDich();

	public static void nhapCung() throws Exception {
		try {			
			dsGiaoDich.them(new GiaoDichVang("GDV001", Date.valueOf("2024-01-01"), 1000000, 10, "Vàng SJC"));
			dsGiaoDich.them(new GiaoDichVang("GDV002", Date.valueOf("2024-02-01"), 1500000, 15, "Vàng PNJ"));
			dsGiaoDich.them(new GiaoDichVang("GDV003", Date.valueOf("2024-03-01"), 1200000, 20, "Vàng SJC"));
			dsGiaoDich.them(new GiaoDichVang("GDV004", Date.valueOf("2024-04-01"), 1300000, 25, "Vàng PNJ"));
			dsGiaoDich.them(new GiaoDichVang("GDV005", Date.valueOf("2024-05-01"), 1400000, 30, "Vàng SJC"));			
			dsGiaoDich.them(new GiaoDichTienTe("GDT001", Date.valueOf("2024-01-01"), 23000, 1000, 1.0f, 1)); // VND
			dsGiaoDich.them(new GiaoDichTienTe("GDT002", Date.valueOf("2024-02-01"), 1.1, 1000, 23000, 2)); // USD
			dsGiaoDich.them(new GiaoDichTienTe("GDT003", Date.valueOf("2024-03-01"), 1.2, 1500, 27000, 3)); // EURO
			dsGiaoDich.them(new GiaoDichTienTe("GDT004", Date.valueOf("2024-04-01"), 24000, 500, 1.0f, 1)); // VND
			dsGiaoDich.them(new GiaoDichTienTe("GDT005", Date.valueOf("2024-05-01"), 1.15, 1200, 25000, 2)); // USD
			System.out.println("nhập cứng thành công");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void themGiaoDich() {
		sc.nextLine(); 
		System.out.print("Nhập mã giao dịch: ");
		String maGD = sc.nextLine();
		System.out.print("Nhập ngày giao dịch (yyyy-mm-dd): ");
		Date ngayGD = Date.valueOf(sc.nextLine());
		System.out.print("Nhập đơn giá: ");
		double donGia = sc.nextDouble();
		System.out.print("Nhập số lượng: ");
		int soLuong = sc.nextInt();
		sc.nextLine(); 
		System.out.print("Chọn loại giao dịch (1: Giao dịch vàng, 2: Giao dịch tiền tệ): ");
		int loaiGD = sc.nextInt();
		sc.nextLine(); 
		try {
			
			if (loaiGD == 1) {
				System.out.print("Nhập loại vàng: ");
				String loaiVang = sc.nextLine();
				GiaoDichVang gdVang = new GiaoDichVang(maGD, ngayGD, donGia, soLuong, loaiVang);
				dsGiaoDich.them(gdVang);
			} else if (loaiGD == 2) {
				System.out.print("Nhập tỷ giá: ");
				float tiGia = sc.nextFloat();
				System.out.print("Nhập loại tiền (1: VND, 2: USD, 3: EURO): ");
				int loaiTien = sc.nextInt();
				GiaoDichTienTe gdTienTe = new GiaoDichTienTe(maGD, ngayGD, donGia, soLuong, tiGia, loaiTien);
				dsGiaoDich.them(gdTienTe);
			} else {
				System.out.println("Loại giao dịch không hợp lệ!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void xuatDSGiaoDich() {
		System.out.println("--- Giao Dịch Vàng ---");
		System.out.printf("%-10s %-15s %-15s %-10s %-15s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Số Lượng",
				"Loại Vàng", "Thành Tiền");
		System.out.println("------------------------------------------------------------------------------------");
		for (GiaoDich gd : dsGiaoDich.getDS()) {
			if (gd instanceof GiaoDichVang) {
				System.out.println(gd);
			}
		}
		System.out.println("\n--- Giao Dịch Tiền Tệ ---");
		System.out.printf("%-10s %-15s %-15s %-10s %-10s %-15s %-15s\n", "Mã GD", "Ngày GD", "Đơn Giá", "Số Lượng",
				"Tỷ Giá", "Loại Tiền", "Thành Tiền");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		for (GiaoDich gd : dsGiaoDich.getDS()) {
			if (gd instanceof GiaoDichTienTe) {
				System.out.println(gd);
			}
		}
	}
	public static void tinhTong() {
		int tongVang = 0, tongTienTe = 0;
		for (GiaoDich gd : dsGiaoDich.getDS()) {
			if (gd instanceof GiaoDichVang) {
				tongVang += gd.getSoLuong();
			} else if (gd instanceof GiaoDichTienTe) {
				tongTienTe += gd.getSoLuong();
			}
		}
		System.out.println("Tổng số lượng giao dịch vàng: " + tongVang);
		System.out.println("Tổng số lượng giao dịch tiền tệ: " + tongTienTe);
	}
	public static void trungBinh() {
		double trungBinhTienTe = dsGiaoDich.tinhTrungBinhThanhTienCuaGiaoDichTienTe();
		System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + trungBinhTienTe);
	}
	public static void giaoDichHon1Ty() {
		System.out.println("Các giao dịch có đơn giá > 1 tỷ:");
		dsGiaoDich.giaoDichCoDonGiaHon1Ty();
	}
	public static void main(String[] args) throws Exception {
		int choice;
		do {
			System.out.println("---- MENU ----");
			System.out.println("1. Nhập cứng");
			System.out.println("2. Thêm 1 giao dịch mới");
			System.out.println("3. Xuất danh sách các giao dịch thành 2 bảng");
			System.out.println("4. Tính tổng số lượng từng loại giao dịch");
			System.out.println("5. Tính trung bình thành tiền của giao dịch tiền tệ");
			System.out.println("6. Xuất ra các giao dịch có đơn giá > 1 tỷ");
			System.out.println("0. Thoát");
			System.out.println("==============================");
			System.out.print("Chọn một chức năng: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				nhapCung();
				break;
			case 2:
				themGiaoDich();
				break;
			case 3: 
				xuatDSGiaoDich();
				break;
			case 4: 
				tinhTong();
				break;
			case 5: 
				trungBinh();
				break;
			case 6:
				giaoDichHon1Ty();
				break;
			case 0: 
				System.out.println("Thoát chương trình.");
				break;
			default:
				System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
			}
		} while (choice != 0);
		sc.close();
	}
}
