package week04.w0401;

import java.io.FileInputStream;

public class Student {
	private int sid;
	private String name;
	private String major;

	public Student() {
	}

	public Student(int sid, String name, String major) {
		this.sid = sid;
		this.name = name;
		this.major = major;
	}
	
	static Student readFromFile(String fname) {
		FileInputStream in = FileInputStream;
	}
}
