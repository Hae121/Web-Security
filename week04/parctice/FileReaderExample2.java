package week04.parctice;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (FileReader fr = new FileReader("test.txt")) {
			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
