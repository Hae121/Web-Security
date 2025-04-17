package week06.example.objectStreamExample;

import java.io.Serializable;

public class Student implements Serializable{//직렬화 가능하게 만들기
	private static final long serialVersionUID = 1L;
	
	String name;
	int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String toString() {
		return name + "("+id+ ")";
	}

}
