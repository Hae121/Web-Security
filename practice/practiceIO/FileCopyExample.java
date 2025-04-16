package practice.practiceIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String inputFile = "input.txt";
//		String outputFile = "copy.txt";

		try {
			FileInputStream in = new FileInputStream("src/practice/practiceIO/input.txt");
			byte[] data = new byte[in.available()];
			in.read(data);
			in.close();
			
			FileOutputStream out = new FileOutputStream("src/practice/practiceIO/copy.txt");
			out.write(data);
			out.close();
			
			
			String text = new String(data);
			System.out.println("복사된 내용: \n"+text);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
