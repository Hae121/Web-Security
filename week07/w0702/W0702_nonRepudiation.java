package week07.w0702;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class W0702_nonRepudiation {
	public static void main(String[] args) throws Exception {
		// 개인키로 암호화, 공개키로 복호화 해 부인방지
		// 공개키로드
		Scanner sc = new Scanner(System.in);
		System.out.print("암호화 키 파일: ");
		String privKeyFileName = sc.next();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(privKeyFileName));
		PrivateKey privKey = (PrivateKey) in.readObject();
		in.close();

		// Cipher 설정
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privKey);

		// 평문 읽고 암호화 파일 쓰기
		System.out.print("데이터 파일 이름: ");
		String dataFileName = sc.next();
		FileInputStream fis = new FileInputStream(dataFileName);
		System.out.print("암호데이터 출력 파일: ");
		String encryptedFileName = sc.next();
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(encryptedFileName), cipher);

		byte[] buffer = new byte[64];
		int len;
		while ((len = fis.read(buffer)) != -1) {
			cos.write(buffer, 0, len);
		}

		fis.close();
		cos.close();
//		System.out.println("개인키로 암호화 완료!\n");

		// 이제 개인키로 복호화 해야함

		// 개인키 로드
		System.out.print("복호화 키 파일: ");
		String pubKeyFileName = sc.next();
		in = new ObjectInputStream(new FileInputStream(pubKeyFileName));
		PublicKey pubKey = (PublicKey) in.readObject();
		in.close();

		// Cipher 설정
		cipher.init(Cipher.DECRYPT_MODE, pubKey);

		// 암호문 읽고 복호화
		System.out.print("암호데이터 파일: ");
		String decryptFileName = sc.next();

		sc.close(); // 두개열면 좀그래서 닫음
		CipherInputStream cis = new CipherInputStream(new FileInputStream(decryptFileName), cipher);
		sc = new Scanner(cis); // 복호화된 데이터를 읽기위해 다시 열음

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}

		cis.close();
		sc.close();
//		System.out.println("공개키로 복호화 완료!");

	}
}
