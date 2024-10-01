package tuan3_HangThucPham;

import java.time.LocalDate;
import java.util.ArrayList;

public class DSHangThucPham {
	ArrayList<HangThucPham> dsHang;  
    public DSHangThucPham() {
        dsHang = new ArrayList<>();
    }   
    public void themHang(HangThucPham tp) {
        dsHang.add(tp);
    }
 // Hàm kiểm tra các sản phẩm đã hết hạn
    public ArrayList<HangThucPham> kiemTraHangHetHan() {
        ArrayList<HangThucPham> hangHetHan = new ArrayList<>();
        LocalDate today = LocalDate.now();          
        for (HangThucPham hang : dsHang) {            
            LocalDate ngayHetHan = hang.getNgayHH().toLocalDate();                      
            if (ngayHetHan.isBefore(today) || ngayHetHan.isEqual(today)) {
                hangHetHan.add(hang);
            }
        }        
        return hangHetHan;
    }
    
}
