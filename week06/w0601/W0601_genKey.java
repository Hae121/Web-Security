package week06.w0601;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class W0601_genKey {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		System.out.println("암호화 알고리즘: " + keyGen.getAlgorithm());

		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		byte[] keyBytes = secretKey.getEncoded();
		System.out.println("키의 길이: " + keyBytes.length);

		System.out.print("비밀키를 저장할 파일 이름: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		sc.close();
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(secretKey);
			out.close();
//			System.out.println("객체 저장 완료");
			printBytes(keyBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void printBytes(byte[] bytes) {
		for (byte b : bytes) {
			System.out.printf("%02x\t", b);
		}
		System.out.println();

	}

}
