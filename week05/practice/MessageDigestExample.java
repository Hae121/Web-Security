package week05.practice;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {

	public static void main(String[] args) throws NoSuchAlgorithmException{
		String plainTxt = "This is a message to be digested using MD5.";
		byte[] data = plainTxt.getBytes();
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(data);
		byte[] messageDigestMD5 = messageDigest.digest();
		
		System.out.println("plain text: " + plainTxt);
		System.out.println("length of digest (bytes): " + messageDigestMD5.length);
		System.out.print("digestedMDS (hex): ");
		for (byte bytes : messageDigestMD5) {
			System.out.print(String.format("%02x", bytes)+ "\t");
		}
		System.out.println();
	}

}
