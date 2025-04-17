package week04.parctice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner scan = new Scanner (new FileReader("input.txt"));
			//아예 파일을 스캔하게 설정함
			while(scan.hasNext()) {
				String s = scan.next();
				System.out.println(s);
			}
			
			if (scan != null)
				scan.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
