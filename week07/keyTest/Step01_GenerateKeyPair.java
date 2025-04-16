package week07.keyTest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Step01_GenerateKeyPair {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024); //1024비트 RSA 키생성
		KeyPair pair = keyGen.generateKeyPair();
		
		try (ObjectOutputStream outPub = new ObjectOutputStream(new FileOutputStream("public.key"))) {
		    outPub.writeObject(pair.getPublic());
		}

		try (ObjectOutputStream outPriv = new ObjectOutputStream(new FileOutputStream("private.key"))) {
		    outPriv.writeObject(pair.getPrivate());
		}
		System.out.println("공개키/개인키가 저장되었습니다.");

	}
}
