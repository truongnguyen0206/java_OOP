package tuan3_HangThucPham;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class KiemTraHangThucPham {
	public static void nhapCung(DSHangThucPham dsHang) {
        dsHang.themHang(new HangThucPham("TP001", "Bánh mì", 5000, Date.valueOf("2023-09-01"), Date.valueOf("2023-09-10")));
        dsHang.themHang(new HangThucPham("TP002", "Sữa tươi", 12000, Date.valueOf("2023-08-01"), Date.valueOf("2025-01-01")));
        dsHang.themHang(new HangThucPham("TP003", "Thịt gà", 60000, Date.valueOf("2023-09-20"), Date.valueOf("2023-10-05")));
        System.out.println("Nhập cứng thành công!");
    }
	public static void themThucPham(DSHangThucPham dsHang, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();
        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        System.out.print("Nhập ngày sản xuất (yyyy-mm-dd): ");
        String ngaySX = scanner.next();
        System.out.print("Nhập ngày hết hạn (yyyy-mm-dd): ");
        String ngayHH = scanner.next();        
        HangThucPham thucPham = new HangThucPham(maHang, tenHang, donGia, Date.valueOf(ngaySX), Date.valueOf(ngayHH));
        dsHang.themHang(thucPham);
        System.out.println("Thêm thực phẩm thành công!");
    }
	public static void xuatDanhSachThucPham(DSHangThucPham dsHang) {
        ArrayList<HangThucPham> danhSach = dsHang.kiemTraHangHetHan();
        System.out.printf("%-10s %-20s %-10s %-15s %-15s %-10s\n", "Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn", "Hết hạn");
        
        for (HangThucPham hang : dsHang.dsHang) {
            boolean hetHan = danhSach.contains(hang);
            String ketQuaHetHan = hetHan ? "Có" : "Không";
            System.out.printf("%-10s %-20s %-10.2f %-15s %-15s %-10s\n", 
                    hang.getMaHang(), 
                    hang.getTenHang(), 
                    hang.getDonGia(), 
                    hang.getNgaySX(), 
                    hang.getNgayHH(), 
                    ketQuaHetHan);
        }
    }
	public static void main(String[] args) {
		DSHangThucPham dsHang = new DSHangThucPham();
        Scanner scanner = new Scanner(System.in);
        int choice;        
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Nhập cứng danh sách thực phẩm");
            System.out.println("2. Thêm 1 thực phẩm");
            System.out.println("3. Xuất danh sách thực phẩm");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");
            choice = scanner.nextInt();            
            switch (choice) {
                case 1:
                    nhapCung(dsHang);
                    break;
                case 2:
                    themThucPham(dsHang, scanner);
                    break;
                case 3:
                    xuatDanhSachThucPham(dsHang);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 0);        
        scanner.close();
	}
}
