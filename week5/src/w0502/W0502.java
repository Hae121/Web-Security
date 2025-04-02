package w0502;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.io.FileOutputStream;
import java.io.IOException;

public class W0502 {

	private static final int SHA_BLOCK_SIZE = 64;
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String plainTxt = "The Road Not Taken by Robert Frost";
		
		for (int i = 0; i < 10; i ++) {
			plainTxt += plainTxt;
		}
		
		byte[] data = plainTxt.getBytes();
		System.out.println("plain text: " + data.length);
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		
		for (int i=0; i < data.length; i+= SHA_BLOCK_SIZE) {
			byte[] block = Arrays.copyOfRange(data, i, i+SHA_BLOCK_SIZE);
			messageDigest.update(block);
		
		}
		byte[] messageDigestSHA = messageDigest.digest();
		printBytes(messageDigestSHA);
		
		
	
	}
	  private static void printBytes(byte[] bytes) {//계산된 해시 값을 16진수 형태로 콘솔 출력
	        for (byte b : bytes) {
	            System.out.printf("%02x\t", b);
	        }
	        System.out.println();
	    }
	  byte[] calcHashVal(String fname) {//평문 파일의 해시 값을 계산하는 기능
		  
	  }
	  
	  void saveBytes(String fname, byte[] b) {//해시 값을 파일에 저장하는 기능
		  
	  }
	  
	  byte[] readHashVal(Strig fname) {//파일에 저장된 해시 값을 불러오는 기능
	  }
	  
	  boolean compareHashVal(byte[] h1, byte[] h2) {//2개의 해시 값이 동일한지 여부를 판단하는 기능
		  
	  }
}
