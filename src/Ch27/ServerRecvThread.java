package Ch27;

import java.io.DataInputStream;
import java.net.Socket;

public class ServerRecvThread implements Runnable{

	Socket client;
	DataInputStream Din;
	Sgui gui;
	
	public ServerRecvThread(Socket client,Sgui gui){
		this.client=client;
		this.gui = gui;
	}
	@Override
	public void run(){
		try {
			Din = new DataInputStream(client.getInputStream());
			String recv;
			while(true)
			{
				recv=Din.readUTF(); //클라이언트의 전달 메시지를 수신
				if(recv==null || recv.equals("q")) {
					gui.area.append("클라언트와 연결을 종료합니다\n");
					System.exit(-1);
				}
				gui.area.append("[Client] : " + recv+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}