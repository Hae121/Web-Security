package week07.keyTest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Step03_DecryptMessage {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 개인키 로드
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("private.key"));
		PrivateKey privKey = (PrivateKey) in.readObject();
		in.close();
		
		// Cipher 설정
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		
		//암호문 읽고 복호화
		CipherInputStream cis = new CipherInputStream(new FileInputStream("encrypted_msg.bin"), cipher);
		Scanner sc = new Scanner(cis);
		
		try(PrintWriter pw = new PrintWriter("decrypted_msg.txt")){
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				pw.println(line);
			}
		}
		
		cis.close();
		sc.close();
		System.out.println("복호화 완료! decrypted_msg.txt 파일을 확인하세요");
	
	}

}
