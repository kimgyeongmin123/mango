package Ch26;

import java.net.Socket;

public class ClientChatMain {
	
	public static void main(String[] args) throws Exception{
		
		//1 서버로 연결요청
		Socket client = new Socket("ServerIP",9999);
		

		// 3 송수신 스레드 생성
		ClientSendThread snd = new ClientSendThread(client);
		ClientRecvThread rev = new ClientRecvThread(client);
		Thread th1 = new Thread(snd);
		Thread th2 = new Thread(rev);

		// 4 송수신 스레드 실행
		th1.start();
		th2.start();

	}
}
