package Ch26;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendThread implements Runnable{

	Scanner sc = new Scanner(System.in);
	DataOutputStream dout;
	
	Socket client;
	
	ClientSendThread(Socket client)
	{
		this.client = client;
	}

	@Override
	public void run() {
		
		String send;
		try {
			dout = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			//송신
			System.out.print("[Client(q:종료)] ");
			send = sc.nextLine();
			try {
				dout.writeUTF(send);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dout.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//버퍼초기화
			if(send.equals("q")) break;
		}
		
	}
	
}
