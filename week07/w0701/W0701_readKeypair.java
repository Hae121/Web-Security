package week07.w0701;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class W0701_readKeypair {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		

		System.out.print("공개키를 저장한 파일 이름: ");
		String publicName = sc.next();
		try (ObjectInputStream inPub = new ObjectInputStream(new FileInputStream(publicName))) {
			PublicKey pubKey = (PublicKey) inPub.readObject();
		    byte[] pubBytes = pubKey.getEncoded();
		    //갖고왔으니까 이제 정보출력
		    System.out.println("암호화 알고리즘: "+ pubKey.getAlgorithm());
		    System.out.println("복귀된 공개키 정보: ");
		    System.out.println("키의 길이 (bytes): "+ pubBytes.length);
			printBytes(pubBytes);
		}

		System.out.print("개인키를 저장한 파일 이름: ");
		String privateName = sc.next();
		try (ObjectInputStream inPriv = new ObjectInputStream(new FileInputStream(privateName))) {
			PrivateKey privKey = (PrivateKey) inPriv.readObject();
		    byte[] privBytes = privKey.getEncoded();
		    //갖고왔으니까 이제 정보출력
		    System.out.println("암호화 알고리즘: "+ privKey.getAlgorithm());
		    System.out.println("복귀된 공개키 정보: ");
		    System.out.println("키의 길이 (bytes): "+ privBytes.length);
			printBytes(privBytes);
		}
		
		System.out.println("성공!");
		sc.close();
	}
	static void printBytes(byte[] bytes) {// 공개키를 프린트해주는 함수? 16진수로
		for (byte b : bytes) {
			System.out.printf("%02x\t", b);
		}
		System.out.println();
	}
}
