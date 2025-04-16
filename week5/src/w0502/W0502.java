package w0502;

import java.security.MessageDigest;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException; //??
import java.util.Scanner;

public class W0502 {

	private static final int SHA_BLOCK_SIZE = 64;

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		byte[] messageDigestSHA = messageDigest.digest();
		
		System.out.println("실행 예시 (해시값 저장)");
		System.out.print("입력 파일 이름: ");
		String file1 = sc.next();
		byte[] hash1 = calcHashVal(file1);
		
		System.out.print("계산된 해시값\n");
		printBytes(readHashVal(file1));
		
		System.out.print("해시값을 저장할 파일이름: ");
		String file1Save = sc.next();
		saveBytes(file1Save, hash1);
		
		
		System.out.println("실행 예시 (해시값 비교-01)");
		
		System.out.print("입력 파일 이름: ");
		file1 = sc.next();
		hash1 = calcHashVal(file1);

		System.out.print("계산된 해시값\n");
		printBytes(readHashVal(file1));
		String file2Save = sc.next();
		byte[] hash2 = readHashVal(file2Save);
		
		System.out.print("저장된 해시값 파일 이름: ");
		System.out.println("비교결과: "+compareHashVal(hash1, hash2));
		
		saveBytes("Hashed-Woolf-modified.txt", hash2);

	}

	static void printBytes(byte[] bytes) {// 계산된 해시 값을 16진수 형태로 콘솔 출력
		for (byte b : bytes) {
			System.out.printf("%02x\t", b);
		}
		System.out.println();
	}

	static byte[] calcHashVal(String fname) {// 평문 파일의 해시 값을 계산하는 기능

		try {
			FileInputStream inputTXT = new FileInputStream(fname);
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

			byte[] buffer = new byte[64];
			int bytesRead;

			while ((bytesRead = inputTXT.read(buffer)) != -1) {
				messageDigest.update(buffer, 0, bytesRead);

			}
			inputTXT.close();
			return messageDigest.digest();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	static void saveBytes(String fname, byte[] b) {// 해시 값을 파일에 저장하는 기능
		FileOutputStream out;
		try {
			out = new FileOutputStream(fname);
			out.write(b);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	static byte[] readHashVal(String fname) {// 파일에 저장된 해시 값을 불러오는 기능
		
		FileInputStream in;
		try {
			in = new FileInputStream(fname);
			byte[] data = new byte[in.available()];
			in.read(data);
			in.close();
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	static boolean compareHashVal(byte[] h1, byte[] h2) {// 2개의 해시 값이 동일한지 여부를 판단하는 기능
		
		for (int i = 0; i < h1.length; i++) {
			if (h1[i] != h2[i]) {
				return false;
			}
		}
		return true;
	}
}
