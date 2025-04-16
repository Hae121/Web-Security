package week06.example.objectStreamExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student s1 = new Student("지존김신해", 20250415);
		
		//객체 저장 (직렬화)
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Student.obj"));
			out.writeObject(s1);
			out.close();
			System.out.println("객체 저장 완료");
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		//역직렬화 
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.obj"));
			Student s2 = (Student) in.readObject();
			in.close();
			
			System.out.println("원본 객체: "+s1);
			System.out.println("읽은 객체: "+s2);
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}

	}

}
