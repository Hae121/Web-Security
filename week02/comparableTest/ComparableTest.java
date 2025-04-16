package week02.comparableTest;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(new Person("철수", 22));
		list.add(new Person("영희", 19));
		list.add(new Person("민수", 25));
		
		System.out.println("정렬 전: "+list);
		
		Collections.sort(list);
		
		System.out.println("정렬 후: "+list);

	}

}
