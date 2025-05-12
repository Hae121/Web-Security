package week10.w1001;

public class Date implements Cloneable{
	private int year;
	private int month;
	private int date;
	
	public Date(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public void setDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString() {
		String rslt = year+"년 "+month+"월 "+date+"일";
		return rslt;
	}

}
