package week06.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryption01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//비밀키 생성 (AES, 128비트)
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		
		//암호호할 원본 문자열
		String plainText = "this is a test!";
		
		//암호화 수행
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encrypted = cipher.doFinal(plainText.getBytes());
		
		System.out.println("암호문 (hex): ");
		printBytes(encrypted);
		
		
		//복호화 수행
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decrypted = cipher.doFinal(encrypted);
		
		String decryptedText = new String(decrypted);
		System.out.println("복호문: ");
		System.out.println(decryptedText);
	}
	private static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.printf("%02x ", b);
        }
        System.out.println();
    }
}
