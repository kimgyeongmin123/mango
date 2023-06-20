package Ch22;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//보조스트림
//기본스트림에 용도에 따른 부가적인 기능을 추가하는 스트림

//InputStreamReader		: 바이트스트림 -> 문자스트림(Reader)
//OutputStreamWriter	: 바이트스트림 -> 문자스트림(Writer)

public class C01CharacterConvertStream {
	
	public static void main(String[] args) throws Exception{
		
//		String str = "문자 변환 스트림 사용";;;;;;;;;;;;;;;;;;;;;;;;;;
//		FileOutputStream out = new FileOutputStream("c:\\iotest\\test.txt");
//		BufferedOutputStream bout = new BufferedOutputStream(out);
//		OutputStreamWriter wout = new OutputStreamWriter(out);	//보조스트림을 붙여서 out을 write가능하게 해준다.
//		
//		wout.write(str);
//		wout.flush();
//		wout.close();
		
		FileInputStream in = new FileInputStream("c:\\iotest\\test.txt");
		BufferedInputStream bin = new BufferedInputStream(in); 
		InputStreamReader rin = new InputStreamReader(bin);

		char[] buffer = new char[100];
		while(true)
		{
			int cnt = rin.read(buffer);
			if(cnt==-1) break;
			System.out.println(buffer);
		}
	}

}
