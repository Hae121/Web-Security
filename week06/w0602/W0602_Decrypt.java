package week06.w0602;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;

public class W0602_Decrypt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//키 가져오기
		System.out.print("비밀키 파일: ");
		Scanner sc = new Scanner(System.in);
		String kFileName = sc.next();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(kFileName));
		SecretKey secretKey = (SecretKey) in.readObject();
		in.close();
		
		
		// 복호화를 위해 파일 열기
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		System.out.print("암호 파일: ");
		String eFileName = sc.next();
		FileInputStream encryptedInput = new FileInputStream(eFileName);
		CipherInputStream cis = new CipherInputStream(encryptedInput, cipher);
		// 복호화 수행
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer2 = new byte[16];
		int len;
		while ((len = cis.read(buffer2)) != -1) {
			baos.write(buffer2, 0, len);
		}
		String decryptedText = new String(baos.toByteArray());
		System.out.println("복호문: ");
		System.out.println(decryptedText);
		cis.close();
		sc.close();
	}

}
