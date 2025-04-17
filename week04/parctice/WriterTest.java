package week04.parctice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));

			pw.print("9.5" + "\t");
			pw.println(567.000);

			if (pw != null)
				pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
