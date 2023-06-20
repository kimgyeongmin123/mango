package Ch24;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class C01Client {
	public static void main(String[] args) throws Exception{
		
		//전화걸기
		Socket client = new Socket("192.168.2.254",6000);
		System.out.println("Server와 연결이 완료되어따.");
		
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		String message = din.readUTF();
		System.out.println("{INFO} "+message);
		
		din.close();
		client.close();
		
		
	}
}
