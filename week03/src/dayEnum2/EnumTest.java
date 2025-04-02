package dayEnum2;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println("월요일: " + Day.MONDAY);
		System.out.println("화요일: " + Day.TUESDAY);
		System.out.println("수요일: " + Day.WEDNESDAY);
		System.out.println("목요일: " + Day.THURSDAY);
		System.out.println("금요일: " + Day.FRIDAY);
		System.out.println("토요일: " + Day.SATURDAY);
		System.out.println("일요일: " + Day.SUNDAY);

//		int lecture = Day.WEDNESDAY;
		
		@SuppressWarnings("unused")
		Day lecture = Day.WEDNESDAY;
		
//		lecture = 2; //컴파일 에러. day 를 int 로  만들 수는없음
		
	}

}
