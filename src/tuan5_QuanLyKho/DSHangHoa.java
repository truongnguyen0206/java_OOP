package tuan5_QuanLyKho;

import java.util.ArrayList;

public class DSHangHoa {
	ArrayList<HangHoa> DS;
	public DSHangHoa() {
		DS = new ArrayList<>();
	}
	public void them(HangHoa hh) throws Exception {
		if (hh.maHang != null && !DS.contains(hh)) {
			DS.add(hh);
		} else {
			throw new Exception("đã tồn tại mã hàng hóa");
		}
	}
}
