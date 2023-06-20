package Ch24;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {
	public static void main(String[] args) throws Exception{
		
		//192.168.2.10
		ServerSocket server = new ServerSocket(5000);//연결//전화기만들기
		System.out.println("Server Socket Listening..");
		Socket client = server.accept();//정보받아서(한건의 요청에만 응답)//클라이언트에게 정보를 받을준비가 되었다.
		System.out.println("[INFO] "+client.getInetAddress()+"접속되었다.");
		
		OutputStream out = client.getOutputStream();//클라이언트에게 전송할 내용
		DataOutputStream dout = new DataOutputStream(out);
		
		dout.writeUTF(client.getInetAddress()+"님 접속하였소 by server");
		dout.flush();//버퍼초기화
		dout.close();//종료
		
		System.out.println("종료종료");
		
		
	}

}
