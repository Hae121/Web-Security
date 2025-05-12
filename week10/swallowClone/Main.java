package week10.swallowClone;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub

		Hello h1 = new Hello();
		Hello h2 = (Hello) h1.clone();
		
		h2.setData(2, 999);
		
		System.out.println("Original: " + h1);
		System.out.println("Clone   : " + h2);
		
	}

}
