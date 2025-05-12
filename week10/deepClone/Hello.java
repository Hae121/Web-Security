package week10.deepClone;

public class Hello implements Cloneable {
	private int[] data;
	
	public Hello() {
		data = new int[5];
		for (int i = 0; i < data.length; i++) {
			data[i] = i* 10;//그냥 0 10 20 30 40 저장
		}
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		Hello h = (Hello) super.clone();//얕은 클로닝~
		h.data = data.clone(); //깊은 클로닝~ 진짜 데이터까지 클론했다
		return h;
	}
	
	public void setData(int index, int value) {
		data[index] = value;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int num : data) {
			sb.append(num).append(" ");
		}
		
		sb.append("]");
		return sb.toString();
	}
}

