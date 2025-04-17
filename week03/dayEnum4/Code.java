package week03.dayEnum4;

public enum Code {
	ONE(100), TWO(200), THREE(300);
	
	private int codeNum;
	
	Code(int num){
		codeNum = num;
	}
	
	public int getCodeNum() {
		return codeNum;
	}

}
