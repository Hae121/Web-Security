package week03.dayEnum1;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("월요일: " + Day.MONDAY);
		System.out.println("화요일: " + Day.TUESDAY);
		System.out.println("수요일: " + Day.WEDNESDAY);
		System.out.println("목요일: " + Day.THURSDAY);
		System.out.println("금요일: " + Day.FRIDAY);
		System.out.println("토요일: " + Day.SATURDAY);
		System.out.println("일요일: " + Day.SUNDAY);

		
		@SuppressWarnings("unused")
		int lecture = Day.WEDNESDAY;
		lecture = -10;
	}

}
