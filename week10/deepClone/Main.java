package week10.deepClone;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub

		Hello h3 = new Hello();
		Hello h4 = (Hello) h3.clone();
		
		h4.setData(2, 999);
		
		System.out.println("Original: " + h3);
		System.out.println("Clone   : " + h4);
		
	}

}
