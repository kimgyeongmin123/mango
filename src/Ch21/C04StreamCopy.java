package Ch21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C04StreamCopy {
	public static void main(String[] args) throws IOException {
		
		try {
			InputStream in = new FileInputStream("c:\\iotest\\코딩춘식.jpg");
			OutputStream out = new FileOutputStream("c:\\iotest\\코딩춘식카피.jpg");
			byte [] buffer = new byte[4096];
			while(true)
			{
				int cnt = in.read(buffer);
				if(cnt==-1) break;
				
				out.write(buffer,0,cnt);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
