package week07.keyTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class Step02_EncryptMessage {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		//공개키로드
		 ObjectInputStream in = new ObjectInputStream(new FileInputStream("public.key"));
		 PublicKey pubKey = (PublicKey) in.readObject();
		 in.close();
		 
		 //Cipher 설정
		 Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		 cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		 
		 //평문 읽고 암호화 파일 쓰기
		 FileInputStream fis = new FileInputStream("msg.txt");
		 CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("encrypted_msg.bin"), cipher);
	
		 byte[] buffer = new byte[64]; 
		 int len;
		 while ((len = fis.read(buffer)) != -1) {
	            cos.write(buffer, 0, len);
	        }
		 
		 fis.close();
		 cos.close();
		 System.out.println("암호화 완료!");
	
	
	}

}
