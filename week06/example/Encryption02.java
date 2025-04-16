package week06.example;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryption02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 비밀키 생성 (AES, 128비트)
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		
		// 암호화 준비
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		// 암호호할 원본 문자열을 File 에서 가져오기
		FileInputStream fis = new FileInputStream("plain.txt");
		FileOutputStream fos = new FileOutputStream("encrypted.bin");
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);


		//암호화 해서 적기
		byte[] buffer = new byte[16];
		int bytesRead;
		while ((bytesRead = fis.read(buffer)) != -1) {
			cos.write(buffer , 0, bytesRead);
		}
		cos.close();
		fis.close();
		
		//복호화를 위해 파일 열기
		FileInputStream encryptedInput = new FileInputStream("encrypted.bin");
		CipherInputStream cis = new CipherInputStream(encryptedInput, cipher);
		// 복호화 수행
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer2 = new byte[16];
		int len;
		while ((len = cis.read(buffer2)) != -1){
			baos.write(buffer2, 0, len);
		}
		String decryptedText = new String(baos.toByteArray());
		System.out.println("복호문: ");
		System.out.println(decryptedText);
		cis.close();
	}
}
