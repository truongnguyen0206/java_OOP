package tuan2_Vahicle;

public class VahicleArr {
	private Vahicle[] vahicle;
	public int size = 0;
	public VahicleArr() {
		super();
		this.vahicle = new Vahicle[1];
	}
	public VahicleArr(int initCapacity) {
		this.vahicle = new Vahicle[initCapacity];
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Vahicle[] getVahicle() {
		return vahicle;
	}
	public Vahicle[] copyArray(Vahicle[] arr, int length) {
		Vahicle[] newArr = new Vahicle[length]; 
	    for (int i = 0; i < size; i++)
	        newArr[i] = arr[i];
	    return newArr;
	}
	public void add(Vahicle acc) throws Exception{
		if(size == vahicle.length)
			vahicle = copyArray(vahicle, size*2);
		vahicle[size++] = acc;
	}
}
