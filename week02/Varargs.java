package week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Varargs {
	
	public static void displayStrings(String...strs) {
		System.out.println("넘겨받은 인자의 개수: "+strs.length);
		for(String str : strs) {
			System.out.println(">>"+str);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문장을 입력하세요: ");
		String line = sc.nextLine();
		
		String[] tokens = line.split(" ");
		
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list, tokens);
		
		displayStrings(tokens);
		
		sc.close();

	}

}
