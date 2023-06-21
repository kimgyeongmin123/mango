package Ch26;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRecvThread implements Runnable{
	
	Socket client;
	DataInputStream din;

	ClientRecvThread(Socket client) {
		this.client = client;
	}

	public void run() {

		try {
			din = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String recv = null;

		while (true) {

			// 수신
			try {
				recv = din.readUTF();	//무한반복을 하여 클라이언트로부터 데이터가 들어온다면 계속 반응을 할 수 있다.
				if (recv.equals("q") || recv == null)
					System.exit(-1); // 종료

				System.out.println("[Client] " + recv);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
