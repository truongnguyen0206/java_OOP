package tuan3_PhanSo;

public class PhanSo {
	private int tuSo;
	private int mauSo;
	public PhanSo(int tuSo, int mauSo) {
		if (mauSo == 0) {
			throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
		}
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}
	
	public int getTuSo() {
		return tuSo;
	}
	public void setTuSo(int tuSo) {
		this.tuSo = 0;
	}
	public int getMauSo() {
		return mauSo;
	}
	public void setMauSo(int mauSo) {
		this.mauSo = 1;
	}
	//tối giản
	private int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
	public void toiGian() {
		int gcd = gcd(tuSo, mauSo);
		tuSo /= gcd;
		mauSo /= gcd;
		if (mauSo < 0) {
			tuSo = -tuSo;
			mauSo = -mauSo;
		}
	}
	//nghịch đảo
	public PhanSo ngichDao() {
		if (tuSo == 0) {
            throw new IllegalArgumentException("Không thể lấy nghịch đảo của phân số có tử số bằng 0.");
        }
		return new PhanSo(mauSo, tuSo);
	}
	//so sánh 2 phân số
	public double toDouble() {
        return (double) tuSo / mauSo;
    }
	
	 public boolean equals(PhanSo other) {
		 double tolerance = 0.0001;
		 double difference = Math.abs(this.toDouble() - other.toDouble());
		 return difference < tolerance;
	 }
	// Kiểm tra xem phân số này có lớn hơn phân số khác không
	 public boolean isGreaterThan(PhanSo other) {
		 return this.toDouble() - other.toDouble() > 0.0001;
	}
	 // Kiểm tra xem phân số này có nhỏ hơn phân số khác không
	 public boolean isLessThan(PhanSo other) {
		 return other.toDouble() - this.toDouble() > 0.0001;
	 }
	 
	@Override
    public String toString() {
        if (mauSo == 1) {
            return String.valueOf(tuSo);
        }
        return tuSo + "/" + mauSo;
    }
	
}
