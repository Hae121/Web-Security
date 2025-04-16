package week02.w0202;

public class Student implements Comparable<Student>{
	
	private String major;
	private int sid;
	private String name;
	
	public Student() {}
	public Student(String major, int sid, String name) {
		this.major = major;
		this.sid = sid;
		this.name = name;
	}
	@Override
	public int compareTo(Student otherStudnet) {
		
		return this.sid - otherStudnet.sid;
	}
	
	@Override
	public String toString() {
		return major+"/"+sid+"/"+name;
	}

}
