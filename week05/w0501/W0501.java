package week05.w0501;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class W0501 {


	public static void main(String[] args) throws NoSuchAlgorithmException{
		String plainTxt = "The Road Not Taken by Robert Frost";
		
		for (int i = 0; i < 10; i ++) {
			plainTxt += plainTxt;
		}
		
		
		byte[] data = plainTxt.getBytes();
		System.out.println("plain text: " + data.length);
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
//		
//		for (int i=0; i < data.length; i+= SHA_BLOCK_SIZE) {
//			byte[] block = Arrays.copyOfRange(data, i, i+SHA_BLOCK_SIZE);
//			messageDigest.update(block);
//		
//		}
		
		messageDigest.update(data);

		byte[] messageDigestSHA = messageDigest.digest();
		printBytes(messageDigestSHA);
		
		
	
	}
	
	  private static void printBytes(byte[] bytes) {
	        for (byte b : bytes) {
	            System.out.printf("%02x\t", b);
	        }
	        System.out.println();
	    }

}
