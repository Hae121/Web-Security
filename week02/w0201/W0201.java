package week02.w0201;

public class W0201 {

	public static void calcSum(int... nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		System.out.println(sum);

	}

	public static void main(String[] args) {
		calcSum(10, 20);
		calcSum(10, 20, 30);
		calcSum(10, 20, 30, 40, 50);

	}

}
