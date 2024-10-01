package tuan3_SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSSinhVien {
	ArrayList<SinhVien> DS;
	public DSSinhVien() {
		DS = new ArrayList<>();
	}
	public void themSV(SinhVien sv) {
		DS.add(sv);
	}
	 public void sapXepTheoMaTangDan() {
		 Collections.sort(DS, new Comparator<SinhVien>() {
			 @Override
			 public int compare(SinhVien sv1, SinhVien sv2) {
				 return Integer.compare(sv1.getMaSV(), sv2.getMaSV());
	         }
	    });
	 }
}
