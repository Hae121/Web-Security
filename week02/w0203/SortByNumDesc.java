package week02.w0203;

import java.util.Comparator;

public class SortByNumDesc implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		return s2.getSid() - s1.getSid();
	}

}
