package week02.arrayTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPractice {

	public static void main(String[] args) {
		//배열 생성 및 복사
		String[] fruits = {"Apple", "Banana", "Cherry"};
		
		//전체복사
		String[] copy1 = Arrays.copyOf(fruits, fruits.length);
		//일부복사
		String[] copy2 = Arrays.copyOfRange(fruits, 1, 3);
		
		System.out.println("원본 배열: " + Arrays.toString(fruits));
		System.out.println("전체 복사: "+Arrays.toString(copy1));
		System.out.println("일부 복사: "+Arrays.toString(copy2));

		
		
		//배열을 ArrayList(동적배열)로 변환하기!
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList(fruits));
		System.out.println("리스트로 변환: "+ list1);
		
		//ArrayList 복사하기 ~ 생성자 이용
		ArrayList<String> list2 = new ArrayList<>(list1);
		
		//ArrayList 복사하기 ~ addAll 사용
		ArrayList<String> list3 = new ArrayList<>();
		list3.addAll(list1);
		
		System.out.println("복사된 리스트 (생성자): " + list2);
        System.out.println("복사된 리스트 (addAll): " + list3);
        
        //확인용 수정
        list1.set(0, "Mango");
        System.out.println("list1: "+list1);
        System.out.println("list1: "+list2);
        System.out.println("list1: "+list3);
	}
}
