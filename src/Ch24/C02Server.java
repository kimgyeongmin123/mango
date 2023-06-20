package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	public static void main(String[] args) throws Exception{
		
		//Server Socket 192.168.2.10
		ServerSocket server = new ServerSocket(5000);//연결//전화기만들기
		System.out.println("[INFO] Server Socket Listening..");
		
		//1:1 Socket Communication's Stream
		Socket client = server.accept();//정보받아서(한건의 요청에만 응답)//클라이언트에게 정보를 받을준비가 되었다.
		DataInputStream din = new DataInputStream(client.getInputStream());
		DataOutputStream dout = new DataOutputStream(client.getOutputStream());
		
		Scanner sc= new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true)
		{
			recv = din.readUTF();
			if(recv.equals("q")||recv==null) break;	//리시브가 q이거나 받은내용이 없으면 브레이크
			System.out.println("[Client] "+recv); 	//클라이언트에게 받은 내용 출력
			System.out.print("[Server(q:종료)] ");
			send = sc.nextLine();
			dout.writeUTF(send);
			dout.flush();//버퍼초기화
			if(send.equals("q")) break;
			
		}
		
	}

}
