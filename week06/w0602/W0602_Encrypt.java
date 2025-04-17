package week06.w0602;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class W0602_Encrypt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 비밀키 생성 (AES, 128비트)
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		
		//키를 파일에 저장하기
		System.out.println("비밀키 파일: ");
		Scanner sc = new Scanner(System.in);
		String kFileName = sc.next();
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(kFileName));
		out.writeObject(secretKey);
		out.close();
		
		// 암호화 준비
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		// 암호호할 원본 문자열을 File 에서 가져오기
		System.out.print("데이터 파일 이름: ");

		String inFileName = sc.next();
		FileInputStream fis = new FileInputStream(inFileName);
		
		//암호화하기
		System.out.print("암호화 출력 파일: ");
		String outFileName = sc.next();
		FileOutputStream fos = new FileOutputStream(outFileName);
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);


		//암호화 해서 적기
		byte[] buffer = new byte[16];
		int bytesRead;
		while ((bytesRead = fis.read(buffer)) != -1) {
			cos.write(buffer , 0, bytesRead);
		}
		cos.close();
		fis.close();
		sc.close();

		
	}

}
