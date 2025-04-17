package week05.practice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MessageDigestExample2 {
	private static final int MD_BLOCK_SIZE = 64;
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String plainTxt = "This is a message to be digested using MD5.";
		
		for (int i = 0; i < 10; i ++) {
			plainTxt += plainTxt;
		}
		
		byte[] data = plainTxt.getBytes();
		System.out.println("plain text: " + data.length);
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		
		for (int i=0; i < data.length; i+= MD_BLOCK_SIZE) {
			byte[] block = Arrays.copyOfRange(data, i, i+MD_BLOCK_SIZE);
			messageDigest.update(block);
		
		}
		byte[] messageDigestMD5 = messageDigest.digest();
		printBytes(messageDigestMD5);
		
		
	
	}
	
	  private static void printBytes(byte[] bytes) {
	        for (byte b : bytes) {
	            System.out.printf("%02x\t", b);
	        }
	        System.out.println();
	    }
}
