package tuan4_Sach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tuan3_SinhVien.DSSinhVien;

public class TestSach {
	private static Scanner scanner = new Scanner(System.in);
	private static ThuVien DS = new ThuVien();

	public static void nhapSachCung(ThuVien DS) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date ngayNhap1 = dateFormat.parse("01/09/2023");
			Date ngayNhap2 = dateFormat.parse("02/09/2023");
			Date ngayNhap3 = dateFormat.parse("03/09/2023");
			Date ngayNhap4 = dateFormat.parse("04/09/2023");
			Date ngayNhap5 = dateFormat.parse("05/09/2023");
			Date ngayNhap6 = dateFormat.parse("06/09/2023");

			SachGiaoKhoa sachGiaoKhoa1 = new SachGiaoKhoa("GK1", ngayNhap1, 51000, 10, "NXB A", true);
			SachGiaoKhoa sachGiaoKhoa2 = new SachGiaoKhoa("GK2", ngayNhap2, 52000, 10, "NXB A", false);
			SachGiaoKhoa sachGiaoKhoa3 = new SachGiaoKhoa("GK3", ngayNhap3, 53000, 10, "NXB A", true);
			SachGiaoKhoa sachGiaoKhoa4 = new SachGiaoKhoa("GK4", ngayNhap4, 54000.0, 10, "NXB A", false);
			SachGiaoKhoa sachGiaoKhoa5 = new SachGiaoKhoa("GK5", ngayNhap5, 55000.0, 10, "NXB B", true);
			SachGiaoKhoa sachGiaoKhoa6 = new SachGiaoKhoa("GK6", ngayNhap6, 56000.0, 10, "NXB A", false);

			DS.themSach(sachGiaoKhoa1);
			DS.themSach(sachGiaoKhoa2);
			DS.themSach(sachGiaoKhoa3);
			DS.themSach(sachGiaoKhoa4);
			DS.themSach(sachGiaoKhoa5);
			DS.themSach(sachGiaoKhoa6);
		} catch (ParseException e) {
			System.out.println("Định dạng ngày tháng không hợp lệ: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Date ngayNhap1 = dateFormat.parse("01/09/2023");
			Date ngayNhap2 = dateFormat.parse("02/09/2023");
			Date ngayNhap3 = dateFormat.parse("03/09/2023");
			Date ngayNhap4 = dateFormat.parse("04/09/2023");
			Date ngayNhap5 = dateFormat.parse("05/09/2023");
			Date ngayNhap6 = dateFormat.parse("06/09/2023");

			SachThamKhao sachThamKhao1 = new SachThamKhao("TK1", ngayNhap1, 31000.0, 5, "NXB B", 5.0);
			SachThamKhao sachThamKhao2 = new SachThamKhao("TK2", ngayNhap2, 32000.0, 5, "NXB A", 5.0);
			SachThamKhao sachThamKhao3 = new SachThamKhao("TK3", ngayNhap3, 33000.0, 5, "NXB B", 5.0);
			SachThamKhao sachThamKhao4 = new SachThamKhao("TK4", ngayNhap4, 34000.0, 5, "NXB B", 5.0);
			SachThamKhao sachThamKhao5 = new SachThamKhao("TK5", ngayNhap5, 35000.0, 5, "NXB B", 5.0);
			SachThamKhao sachThamKhao6 = new SachThamKhao("TK6", ngayNhap6, 36000.0, 5, "NXB B", 5.0);

			DS.themSach(sachThamKhao1);
			DS.themSach(sachThamKhao2);
			DS.themSach(sachThamKhao3);
			DS.themSach(sachThamKhao4);
			DS.themSach(sachThamKhao5);
			DS.themSach(sachThamKhao6);
		} catch (ParseException e) {
			System.out.println("Định dạng ngày tháng không hợp lệ: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void themMotSach(Scanner scanner, ThuVien DS) {
		System.out.println("Nhập loại sách (1. Sách giáo khoa, 2. Sách tham khảo): ");
		int loaiSach = scanner.nextInt();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Mã sách: ");
			String maSach = scanner.next();
			System.out.print("Ngày nhập (dd/MM/yyyy): ");
			Date ngayNhap = dateFormat.parse(scanner.next());
			System.out.print("Đơn giá: ");
			double donGia = scanner.nextDouble();
			System.out.print("Số lượng: ");
			int soLuong = scanner.nextInt();
			System.out.print("Nhà xuất bản: ");
			String nhaXuatBan = scanner.next();
			if (loaiSach == 1) {
				System.out.print("Có phải sách giáo khoa mới không (true/false): ");
				boolean sachGiaoKhoa = scanner.nextBoolean();
				SachGiaoKhoa sachGiaoKhoaMoi = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan,
						sachGiaoKhoa);
				DS.themSach(sachGiaoKhoaMoi);
				System.out.println("Đã thêm sách giáo khoa: " + sachGiaoKhoaMoi);
			} else if (loaiSach == 2) {
				System.out.print("Giá trị thuế: ");
				double giaTriThamKhao = scanner.nextDouble();
				SachThamKhao sachThamKhaoMoi = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan,
						giaTriThamKhao);
				DS.themSach(sachThamKhaoMoi);
				System.out.println("Đã thêm sách tham khảo: " + sachThamKhaoMoi);
			} else {
				System.out.println("Loại sách không hợp lệ.");
			}
		} catch (ParseException e) {
			System.out.println("Định dạng ngày tháng không hợp lệ: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra: " + e.getMessage());
		}
	}

	public static void timViTriSach() {
		System.out.print("Nhập mã sách: ");
		String maSachTim = scanner.next();
		int viTri = DS.timVitri(maSachTim);
		if (viTri != -1) {
			System.out.println("Vị trí sách: " + viTri);
		} else {
			System.out.println("Không tìm thấy sách với mã: " + maSachTim);
		}
	}

	public static void timSach() {
		System.out.print("Nhập mã sách: ");
		String maSach = scanner.next();
		Sach sachTim = DS.timSach(maSach);
		if (sachTim != null) {
			System.out.println("Sách tìm thấy: " + sachTim);
		} else {
			System.out.println("Không tìm thấy sách với mã: " + maSach);
		}
	}

	public static void xoaSach() {
		System.out.print("Nhập mã sách để xóa: ");
		String maSachXoa = scanner.next();
		Sach sachXoa = DS.timSach(maSachXoa);
		if (sachXoa != null) {
			DS.xoaSach(sachXoa);
			System.out.println("Đã xóa sách với mã: " + maSachXoa);
		} else {
			System.out.println("Không tìm thấy sách với mã: " + maSachXoa);
		}
	}

	public static void suaSach() {
		System.out.print("Nhập mã sách để sửa: ");
		String maSachSua = scanner.next();
		Sach sachSua = DS.timSach(maSachSua);
		if (sachSua != null) {
			System.out.print("Nhập tên sách mới: ");
			String tenSachMoi = scanner.next();
			sachSua.setMaSach(tenSachMoi);
			DS.suaSach(sachSua);
			System.out.println("Đã sửa thông tin sách với mã: " + maSachSua);
		} else {
			System.out.println("Không tìm thấy sách với mã: " + maSachSua);
		}
	}

	public static void tongThanhTienTungLoai() {
		double tongSachGiaoKhoa = DS.tinhTongThanhTienSachGiaoKhoa();
		double tongSachThamKhao = DS.tinhTongThanhTienSachThamKhao();
		System.out.println("Tổng thành tiền sách giáo khoa: " + tongSachGiaoKhoa);
		System.out.println("Tổng thành tiền sách tham khảo: " + tongSachThamKhao);
	}

	public static void TBSachThamKhao() {
		double trungBinhSachThamKhao = DS.tinhTrungBinhDonGiaSachThamKhao();
		System.out.println("Trung bình cộng đơn giá sách tham khảo: " + trungBinhSachThamKhao);
	}

	public static void timSachGiaoKhoaCuaNhaXuatBan() {
		scanner.nextLine();
		System.out.print("Nhập tên nhà xuất bản: ");
		String nhaXuatBan = scanner.nextLine().trim();

		if (nhaXuatBan.isEmpty()) {
			System.out.println("Tên nhà xuất bản không được để trống.");
		} else {
			boolean found = false;
			System.out.println("Sách giáo khoa của nhà xuất bản " + nhaXuatBan + ": ");
			for (SachGiaoKhoa sach : DS.getSachGiaoKhoas()) {
				if (sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
					System.out.println(sach);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Không tìm thấy sách giáo khoa nào của nhà xuất bản: " + nhaXuatBan);
			}
		}
	}

	public static void xuatDS() {
		System.out.println("---- Danh Sách Các Loại Sách ----");
		System.out.println("\n--- Sách Giáo Khoa ---");
		System.out.printf("%-10s %-15s %-10s %-10s %-20s %-10s %-10s\n", "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng",
				"Nhà Xuất Bản", "Tình Trạng", "Thành Tiền");
		System.out.println("--------------------------------------------------------------");
		for (Sach sach : DS.getSachGiaoKhoas()) {
			System.out.println(sach);
		}
		System.out.println("\n--- Sách Tham Khảo ---");
		System.out.printf("%-10s %-15s %-10s %-10s %-20s %-10s %-10s\n", "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng",
				"Nhà Xuất Bản", "Thuế", "Thành Tiền");
		System.out.println("--------------------------------------------------------------");
		for (Sach sach : DS.getThamKhaos()) {
			System.out.println(sach);
		}
		System.out.println("--------------------------------------------------------------");
	}

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("---- MENU ----");
			System.out.println("1. Nhập cứng sách");
			System.out.println("2. Nhập danh sách các loại sách");
			System.out.println("3. Tìm vị trí theo mã sách");
			System.out.println("4. Tìm sách theo mã");
			System.out.println("5. Xóa sách");
			System.out.println("6. Sửa sách");
			System.out.println("7. Tính tổng thành tiền cho từng loại sách");
			System.out.println("8. Tính trung bình cộng đơn giá của sách tham khảo");
			System.out.println("9. Xuất ra các sách giáo khoa của nhà xuất bản");
			System.out.println("10. Xuất danh sách các loại sách");
			System.out.println("0. Thoát");
			System.out.println("============================");
			System.out.print("Chọn một chức năng: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				nhapSachCung(DS);
				System.out.println("nhập cứng thành công");
				break;
			case 2:
				themMotSach(scanner, DS);
				break;
			case 3:
				timViTriSach();
				break;
			case 4:
				timSach();
				break;
			case 5:
				xoaSach();
				break;
			case 6:
				suaSach();
				break;
			case 7:
				tongThanhTienTungLoai();
				break;
			case 8:
				TBSachThamKhao();
				break;
			case 9:
				timSachGiaoKhoaCuaNhaXuatBan();
				break;
			case 10:
				xuatDS();
				break;
			case 0:
				System.out.println("Thoát chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
			}
		} while (choice != 0);
		scanner.close();
	}
}
