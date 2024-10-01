package tuan5_QuanLyKho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestHangHoa {
	static DSHangHoa danhSach = new DSHangHoa();
	static Scanner scanner = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void themHangThucPham() {
		try {
			System.out.print("Mã hàng: ");
			String maHangTP = scanner.nextLine();
			System.out.print("Tên hàng: ");
			String tenHangTP = scanner.nextLine();
			System.out.print("Số lượng tồn: ");
			int soLuongTonTP = scanner.nextInt();
			System.out.print("Đơn giá: ");
			double donGiaTP = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Ngày sản xuất (dd/MM/yyyy): ");
			Date ngaySanXuat = sdf.parse(scanner.nextLine());
			System.out.print("Ngày hết hạn (dd/MM/yyyy): ");
			Date ngayHetHan = sdf.parse(scanner.nextLine());
			System.out.print("Nhà cung cấp: ");
			String nhaCungCap = scanner.nextLine();
			HangThucPham hangThucPham = new HangThucPham(maHangTP, tenHangTP, soLuongTonTP, donGiaTP);
			hangThucPham.setNgaySanXuat(ngaySanXuat);
			hangThucPham.setNgayHethan(ngayHetHan);
			hangThucPham.setNhaCungCap(nhaCungCap);
			danhSach.them(hangThucPham);
			System.out.println("Thêm hàng thực phẩm thành công.");
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
		}
	}

	public static void themHangDienMay() {
		try {
			System.out.print("Mã hàng: ");
			String maHangDM = scanner.nextLine();
			System.out.print("Tên hàng: ");
			String tenHangDM = scanner.nextLine();
			System.out.print("Số lượng tồn: ");
			int soLuongTonDM = scanner.nextInt();
			System.out.print("Đơn giá: ");
			double donGiaDM = scanner.nextDouble();
			System.out.print("Thời gian bảo hành (tháng): ");
			int thoiGianBaoHanh = scanner.nextInt();
			System.out.print("Công suất (KW): ");
			int congSuat = scanner.nextInt();
			scanner.nextLine();
			HangDienMay hangDienMay = new HangDienMay(maHangDM, tenHangDM, soLuongTonDM, donGiaDM);
			hangDienMay.setThoiGianBaoHanh(thoiGianBaoHanh);
			hangDienMay.setCongXuat(congSuat);
			danhSach.them(hangDienMay);
			System.out.println("Thêm hàng điện máy thành công.");
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
		}
	}

	public static void themHangSanhSu() {
		try {
			System.out.print("Mã hàng: ");
			String maHangSS = scanner.nextLine();
			System.out.print("Tên hàng: ");
			String tenHangSS = scanner.nextLine();
			System.out.print("Số lượng tồn: ");
			int soLuongTonSS = scanner.nextInt();
			System.out.print("Đơn giá: ");
			double donGiaSS = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Nhà sản xuất: ");
			String nhaSanXuat = scanner.nextLine();
			System.out.print("Ngày nhập kho (dd/MM/yyyy): ");
			Date ngayNhapKho = sdf.parse(scanner.nextLine());
			HangSanhSu hangSanhSu = new HangSanhSu(maHangSS, tenHangSS, soLuongTonSS, donGiaSS);
			hangSanhSu.setNhaSanXuat(nhaSanXuat);
			hangSanhSu.setNgayNhapKho(ngayNhapKho);
			danhSach.them(hangSanhSu);
			System.out.println("Thêm hàng sành sứ thành công.");
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
		}
	}

	public static void xuat() {
		System.out.println("Danh sách hàng hóa thực phẩm:");
		System.out.printf("%-10s %-20s %-10s %-15s %-15s %-20s %-10s %-15s %-15s\n", "Mã hàng", "Tên hàng", "S.Lượng",
				"Đơn giá", "Ngày SX", "Ngày HH", "Nhà CC", "VAT", "Đánh giá");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------");
		for (HangHoa hangHoa : danhSach.DS) {
			if (hangHoa instanceof HangThucPham) {
				System.out.println(hangHoa);
			}
		}
		System.out.println();

		System.out.println("Danh sách hàng hóa điện máy:");
		System.out.printf("%-10s %-20s %-10s %-15s %-10s %-15s %-10s %-15s\n", "Mã hàng", "Tên hàng", "S.Lượng",
				"Đơn giá", "Th.BH", "Công suất", "VAT", "Đánh giá");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
		for (HangHoa hangHoa : danhSach.DS) {
			if (hangHoa instanceof HangDienMay) {
				System.out.println(hangHoa);
			}
		}
		System.out.println();

		System.out.println("Danh sách hàng hóa sành sứ:");
		System.out.printf("%-10s %-20s %-10s %-15s %-20s %-15s %-10s %-15s\n", "Mã hàng", "Tên hàng", "S.Lượng",
				"Đơn giá", "Nhà SX", "Ngày NK", "VAT", "Đánh giá");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");
		for (HangHoa hangHoa : danhSach.DS) {
			if (hangHoa instanceof HangSanhSu) {
				System.out.println(hangHoa);
			}
		}
	}

	public static void nhapCung() throws Exception {

		HangThucPham tp1 = new HangThucPham("TP001", "Gạo", 100, 20000);
		tp1.setNgaySanXuat(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		tp1.setNgayHethan(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2024"));
		tp1.setNhaCungCap("Nhà cung cấp 1");
		danhSach.them(tp1);

		HangThucPham tp2 = new HangThucPham("TP002", "Bánh mì", 0, 15000);
		tp2.setNgaySanXuat(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		tp2.setNgayHethan(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2024"));
		tp2.setNhaCungCap("Nhà cung cấp 2");
		danhSach.them(tp2);

		HangThucPham tp3 = new HangThucPham("TP003", "Sữa", 50, 30000);
		tp3.setNgaySanXuat(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		tp3.setNgayHethan(new SimpleDateFormat("dd/MM/yyyy").parse("22/10/2024"));
		tp3.setNhaCungCap("Nhà cung cấp 3");
		danhSach.them(tp3);

		HangThucPham tp4 = new HangThucPham("TP004", "Thịt", 80, 80000);
		tp4.setNgaySanXuat(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		tp4.setNgayHethan(new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2024"));
		tp4.setNhaCungCap("Nhà cung cấp 4");
		danhSach.them(tp4);

		HangThucPham tp5 = new HangThucPham("TP005", "Trứng", 120, 20000);
		tp5.setNgaySanXuat(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		tp5.setNgayHethan(new SimpleDateFormat("dd/MM/yyyy").parse("17/10/2024"));
		tp5.setNhaCungCap("Nhà cung cấp 5");
		danhSach.them(tp5);

		HangDienMay dm1 = new HangDienMay("DM001", "Máy giặt", 10, 5000000);
		dm1.setThoiGianBaoHanh(24);
		dm1.setCongXuat(2000);
		danhSach.them(dm1);

		HangDienMay dm2 = new HangDienMay("DM002", "Tủ lạnh", 2, 8000000);
		dm2.setThoiGianBaoHanh(36);
		dm2.setCongXuat(1500);
		danhSach.them(dm2);

		HangDienMay dm3 = new HangDienMay("DM003", "Lò vi sóng", 5, 2000000);
		dm3.setThoiGianBaoHanh(12);
		dm3.setCongXuat(800);
		danhSach.them(dm3);

		HangDienMay dm4 = new HangDienMay("DM004", "Máy lạnh", 4, 12000000);
		dm4.setThoiGianBaoHanh(24);
		dm4.setCongXuat(2500);
		danhSach.them(dm4);

		HangDienMay dm5 = new HangDienMay("DM005", "Bếp điện", 3, 1500000);
		dm5.setThoiGianBaoHanh(18);
		dm5.setCongXuat(1000);
		danhSach.them(dm5);

		HangSanhSu ss1 = new HangSanhSu("SS001", "Bát", 60, 30000);
		ss1.setNhaSanXuat("Nhà sản xuất 1");
		ss1.setNgayNhapKho(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		danhSach.them(ss1);

		HangSanhSu ss2 = new HangSanhSu("SS002", "Đĩa", 70, 40000);
		ss2.setNhaSanXuat("Nhà sản xuất 2");
		ss2.setNgayNhapKho(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		danhSach.them(ss2);

		HangSanhSu ss3 = new HangSanhSu("SS003", "Chén", 80, 25000);
		ss3.setNhaSanXuat("Nhà sản xuất 3");
		ss3.setNgayNhapKho(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		danhSach.them(ss3);

		HangSanhSu ss4 = new HangSanhSu("SS004", "Tô", 90, 35000);
		ss4.setNhaSanXuat("Nhà sản xuất 4");
		ss4.setNgayNhapKho(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		danhSach.them(ss4);

		HangSanhSu ss5 = new HangSanhSu("SS005", "Ly", 100, 20000);
		ss5.setNhaSanXuat("Nhà sản xuất 5");
		ss5.setNgayNhapKho(new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2024"));
		danhSach.them(ss5);
	}

	public static void main(String[] args) throws Exception {
		boolean exit = false;
		while (!exit) {
			System.out.println("========== MENU ==========");
			System.out.println("1. Thêm hàng thực phẩm");
			System.out.println("2. Thêm hàng điện máy");
			System.out.println("3. Thêm hàng sành sứ");
			System.out.println("4. In danh sách hàng hóa");
			System.out.println("5. Nhập cứng");
			System.out.println("6. Thoát");
			System.out.print("Chọn một tùy chọn: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				themHangThucPham();
				break;

			case 2:
				themHangDienMay();
				break;

			case 3:
				themHangSanhSu();
				break;

			case 4:
				xuat();
				break;
			case 5:
				nhapCung();
				break;
			case 6:
				exit = true;
				System.out.println("Đã thoát.");
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ.");
			}
		}
		scanner.close();
	}

}
