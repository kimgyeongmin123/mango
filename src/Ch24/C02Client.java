package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {
	public static void main(String[] args) throws Exception{
		
		//전화걸기
		Socket client = new Socket("192.168.2.11",6000);
		System.out.println("Server와 연결이 완료되어따.");
		
		DataInputStream din = new DataInputStream(client.getInputStream());
		DataOutputStream dout = new DataOutputStream(client.getOutputStream());
		
		Scanner sc= new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true)
		{
			//송신
			System.out.println("[Client(q:종료)] ");
			send = sc.nextLine();
			dout.writeUTF(send);
			dout.flush();//버퍼초기화
			if(send.equals("q")) break;
			
			recv = din.readUTF();
			if(recv.equals("q")||recv==null) break;	//리시브가 q이거나 받은내용이 없으면 브레이크
			System.out.println("[Server] "+recv); 	//클라이언트에게 받은 내용 출력
		}
		
		
	}
}
