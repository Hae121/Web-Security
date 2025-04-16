package week02.w0203;

import java.util.Comparator;

public class SortByMajorNum implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		if (s1.getMajor().compareTo(s2.getMajor()) != 0) {
			return s1.getMajor().compareTo(s2.getMajor());
		} else {
			return s2.getSid()-s1.getSid();
		}
	}

}
