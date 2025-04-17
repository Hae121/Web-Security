package week03.dayEnum4;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(Code c: Code.values()) {
			System.out.println("Code: " + c);
			
		}
		
		Code c = Code.ONE;
		c = Code.valueOf("TWO");
		
		if(c == Code.TWO) {
			System.out.println("enum can be compared usting ==");
		}
		
		System.out.println(c.name());
		System.out.println(c.ordinal());
		System.out.println(c.name()+ ": " + c.getCodeNum());

	}

}
