package Ch21;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C03OutputStream {
	
	public static void main(String[] args) throws Exception{
		
		try {
			OutputStream out = new FileOutputStream("c:\\iotest\\test.exe");
			out.write("가".getBytes(StandardCharsets.UTF_8));	//문자열을 byte배열로 변환전달
			out.write('b');
			out.write('c');
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
