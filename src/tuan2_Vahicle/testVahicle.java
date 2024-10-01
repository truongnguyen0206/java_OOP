package tuan2_Vahicle;

import java.util.Scanner;

public class testVahicle {
	static Scanner sn;
	static VahicleArr vahicleList;
	public static String inputString(String s) {
		String str;
		System.out.print(s);
		sn = new Scanner(System.in);
		str = sn.nextLine();
		return str;
	}
	public static double inputDouble(String s) {
		double numDouble;
		System.out.print(s);
		sn = new Scanner(System.in);
		numDouble = sn.nextFloat();
		return numDouble;
	}
	public static int inputInt(String s) {
		int numInt;
		System.out.print(s);
		sn = new Scanner(System.in);
		numInt = sn.nextInt();
		return numInt;
	}
	public static void nhapCung() throws Exception{
		Vahicle[] vahicles = {
			new Vahicle("Nguyen Thu Loan", "Future Neo", 100, 35000000),
			new Vahicle("Le Minh Tinh", "Ford Ranger", 3000, 250000000),
			new Vahicle("Nguyen Minh Triet", "Landscape", 1500, 1000000000),
		};
		for (Vahicle vahicle: vahicles) {
			vahicleList.add(vahicle);
		}
	}
	public static Vahicle nhapMem() throws Exception{
		Vahicle acc;
		String tenChuXe,loaiXe;
		int dungTich;
		double triGia;
		tenChuXe = inputString("Nhap ten chu xe");
		loaiXe = inputString("Nhap loai xe");
		dungTich = inputInt("Nhap dung tich xe");
		triGia = inputDouble("Nhap gia tri xe");
		acc = new Vahicle(tenChuXe, loaiXe, dungTich, triGia);
		return acc;
	}
	public static void tieuDe() {
		String title = String.format("\t%-7s %-20s %-12s %-15s %-15s %-20s", "STT", "Tên chủ xe", "Loại xe", "dung tích","Trị giá","Thuế phải nộp");
		System.out.println(title);
	}
	public static void displayVahicle(Vahicle[] list) {
		tieuDe();
		for(int i = 0; i < vahicleList.size; i++) {
			System.out.printf("\t%-7d ", i+1);
			System.out.println(list[i]);
		}
	}
	public static void displayVahicleList() {
		Vahicle[] allVahicle = vahicleList.getVahicle();
		displayVahicle(allVahicle);
	}
	public static int menu() {
	    String[] options = {
	        "Xuất bản kê khai tiền thuế",
	        "Thêm thông tin",
	        "Thoát"
	    };
	    System.out.println("\n\t********************************");
	    System.out.println("\t** Chương Trình Quản lý **");
	    for (int i = 0; i < options.length; i++)
	    	System.out.printf("\t* %d. %s%n", i + 1, options[i]);
	    System.out.println("\t********************************");
	    int option = inputInt("Chọn: ");
	    return option;
	}
	public static void main(String[] args) throws Exception {
		vahicleList = new VahicleArr();
		int menu;
		Vahicle acc;
		do {
			menu = menu();
			switch (menu) {
			case 1: {
				nhapCung();
				displayVahicleList();
				break;
			}
			case 2: {
				acc = nhapMem();
				vahicleList.add(acc);
				break;
			}
			case 3: {
				break;
			}
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (menu != 3);
		System.out.println("Đã Kết Thúc Chương Trình!!!");
		sn.close();
	}
}
