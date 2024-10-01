package tuan3_SinhVien;

import java.util.Scanner;

public class TestSinhVien {
	private static DSSinhVien DS = new DSSinhVien();
    private static Scanner scanner = new Scanner(System.in);
    public static void nhapCung() {    
            SinhVien sv1 = new SinhVien(101, "Nguyen Van A", "Dia Chi A", "1234567");
            SinhVien sv2 = new SinhVien(103, "Le Thi B", "Dia Chi B", "7654321");
            SinhVien sv3 = new SinhVien(102, "Tran Van C", "Dia Chi C", "2345678");
            DS.themSV(sv1);
            DS.themSV(sv2);
            DS.themSV(sv3);            
            System.out.println("Nhập cứng thành công!");       
    }
    public static void themSinhVien() {       
            System.out.print("Nhập mã sinh viên: ");
            int maSV = scanner.nextInt();
            scanner.nextLine();          
            System.out.print("Nhập họ tên: ");
            String hoTen = scanner.nextLine();            
            System.out.print("Nhập địa chỉ: ");
            String diaChi = scanner.nextLine();            
            System.out.print("Nhập số điện thoại (7 chữ số): ");
            String soDienThoai = scanner.nextLine();            
            SinhVien sv = new SinhVien(maSV, hoTen, diaChi, soDienThoai);
            DS.themSV(sv);
            System.out.println("Thêm sinh viên thành công!");        
    }
    public static void xuatDanhSach() {
        System.out.println("\nDanh sách sinh viên:");
        System.out.printf("%-15s %-20s %-15s %-15s\n","Mã sinh viên","Họ tên","Địa chỉ","Số điện thoại");
        for (SinhVien sv : DS.DS) {
            System.out.printf("%-15s %-20s %-15s %-15s\n",sv.getMaSV(),sv.getHoTen(),sv.getDiaChi(),sv.getSoDT());
        }
    }
    public static void xuatDanhSachSapXep() {
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo mã tăng dần:");
        DS.sapXepTheoMaTangDan();
        xuatDanhSach();
    }
    public static void main(String[] args) {
        int luaChon;
        do {            
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Nhập cứng danh sách sinh viên");
            System.out.println("2. Thêm 1 sinh viên");
            System.out.println("3. Xuất danh sách sinh viên");
            System.out.println("4. Xuất danh sách sinh viên đã sắp xếp theo mã tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");                        
            luaChon = scanner.nextInt();
            scanner.nextLine();            
            switch (luaChon) {
                case 1:
                    nhapCung();
                    break;
                case 2:
                    themSinhVien();
                    break;
                case 3:
                    xuatDanhSach();
                    break;
                case 4:
                    xuatDanhSachSapXep();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (luaChon != 0);
    }

}
