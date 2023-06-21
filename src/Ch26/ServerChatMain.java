package Ch26;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatMain {
	
	public static void main(String[] args) throws Exception{
		
		//1 서버 소켓 생성
		ServerSocket server = new ServerSocket(9999);
		System.out.println("서비스실행!");
		
		//2 클라이언트 연결 받기
		Socket client = server.accept();
		System.out.println(client.getInetAddress()+"접속해따구리");
		
		//3 송수신 스레드 생성
		ServerSendThread snd = new ServerSendThread(client);
		ServerRecvThread rev = new ServerRecvThread(client);
		Thread th1 = new Thread(snd);
		Thread th2 = new Thread(rev);
		
		//4 송수신 스레드 실행
		th1.start();
		th2.start();
		
	}

}
