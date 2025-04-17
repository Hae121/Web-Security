package week06.w0601;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.crypto.SecretKey;


public class W0601_readKey {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.print("비밀키를 저장한 파일 이름: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		sc.close();

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			SecretKey secretKey = (SecretKey) in.readObject();
			in.close();
			System.out.println("암호화 알고리즘: " + secretKey.getAlgorithm());
			byte[] keyBytes = secretKey.getEncoded();
			System.out.println("키의 길이: " + keyBytes.length);
			printBytes(keyBytes);

		} catch (IOException | ClassNotFoundException e) {
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
