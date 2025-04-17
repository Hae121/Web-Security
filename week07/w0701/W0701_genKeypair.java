package week07.w0701;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Scanner;

public class W0701_genKeypair {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String encryptAlgo = "RSA";
		System.out.print("암호화 알고리즘: "+ encryptAlgo);
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance(encryptAlgo);
		keyGen.initialize(1024);
		
		KeyPair pair = keyGen.generateKeyPair();
		byte[] pubByte = pair.getPublic().getEncoded();
		System.out.println("생성된 공개키정보: ");
		printBytes(pubByte);
		System.out.printf("키의 길이 (bytes): %d\n", pubByte.length);
		
		byte[] privByte = pair.getPrivate().getEncoded();
		System.out.println("생성된 개인키정보: ");
		printBytes(privByte);
		System.out.printf("키의 길이 (bytes): %d\n", privByte.length);
		

		
		System.out.print("공개키를 저장할 파일 이름: ");
		String publicName = sc.next();
		try (ObjectOutputStream outPub = new ObjectOutputStream(new FileOutputStream(publicName))) {
		    outPub.writeObject(pair.getPublic());
		}

		System.out.print("개인키를 저장할 파일 이름: ");
		String privateName = sc.next();
		try (ObjectOutputStream outPriv = new ObjectOutputStream(new FileOutputStream(privateName))) {
		    outPriv.writeObject(pair.getPrivate());
		}
		System.out.println("저장완료!");
		sc.close();
	}
	static void printBytes(byte[] bytes) {
		for (byte b : bytes) {
			System.out.printf("%02x\t", b);
		}
		System.out.println();
	}


}
