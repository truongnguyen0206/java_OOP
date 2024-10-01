package tuan4_Sach;

import java.util.ArrayList;

public class ThuVien {
	ArrayList<Sach> DS;

	public ThuVien() {
		DS = new ArrayList<>();
	}

	public void themSach(Sach sach) throws Exception {
		if (sach != null && !DS.contains(sach)) {
			DS.add(sach);
		} else {
			throw new Exception("đã tồn tại mã sách");
		}
	}

	public void xoaSach(Sach sach) {
		DS.remove(sach);
	}

	public void suaSach(Sach sach) {
		DS.set(timVitri(sach.maSach), sach);
	}

	public int timVitri(String maSach) {
		for (Sach sach : DS) {
			if (sach.maSach.equalsIgnoreCase(maSach)) {
				return DS.indexOf(sach)+1;
			}
		}
		return -1;
	}

	public Sach timSach(String maSach) {
		int viTri = timVitri(maSach)-1;
		if (viTri != -1)
			return DS.get(viTri);
		return null;
	}

	ArrayList<SachGiaoKhoa> getSachGiaoKhoas() {
		ArrayList<SachGiaoKhoa> dSSachGiaoKhoas = new ArrayList<SachGiaoKhoa>();
		for (Sach sach : DS) {
			if (sach instanceof SachGiaoKhoa) {
				dSSachGiaoKhoas.add((SachGiaoKhoa) sach);
			}
		}
		return dSSachGiaoKhoas;
	}

	ArrayList<SachThamKhao> getThamKhaos() {
		ArrayList<SachThamKhao> dsSachThamKhaos = new ArrayList<SachThamKhao>();
		for (Sach sach : DS) {
			if (sach instanceof SachThamKhao) {
				dsSachThamKhaos.add((SachThamKhao) sach);
			}
		}
		return dsSachThamKhaos;
	}

	public ArrayList<Sach> getDS() {
		return DS;
	}

	public double tinhTongThanhTienSachGiaoKhoa() {
		double tong = 0;
		for (Sach sach : DS) {
			if (sach instanceof SachGiaoKhoa) {
				tong += sach.thanhTien();
			}
		}
		return tong;
	}

	public double tinhTongThanhTienSachThamKhao() {
		double tong = 0;
		for (Sach sach : DS) {
			if (sach instanceof SachThamKhao) {
				tong += sach.thanhTien();
			}
		}
		return tong;
	}

	public int tinhSoLuongSachThamKhao() {
		int count = 0;
		for (Sach sach : DS) {
			if (sach instanceof SachThamKhao) {
				count++;
			}
		}
		return count;
	}

	public double tinhTrungBinhDonGiaSachThamKhao() {
		double tongDonGia = 0;
		int soLuongSachThamKhao = tinhSoLuongSachThamKhao();

		for (Sach sach : DS) {
			if (sach instanceof SachThamKhao) {
				tongDonGia += sach.getDonGia();
			}
		}
		if (soLuongSachThamKhao > 0) {
			return tongDonGia / soLuongSachThamKhao;
		} else {
			return 0;
		}
	}
}
