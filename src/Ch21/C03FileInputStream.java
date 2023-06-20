package Ch21;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class C03FileInputStream {
	
	public static void main(String[] args) throws Exception{
		
		//1byte 단위로 받기
		InputStream in = new FileInputStream("c:\\iotest\\test.exe");
		
//		while(true)
//		{
//			int data = in.read();
//			if(data==-1) break;
//			
//			System.out.println((char)data);
//		}
		
		//문자열(UTF8)받기
		byte[] buffer = new byte[4096];	//버퍼공간 생성
		while(true)
		{
			int bytedata = in.read(buffer);	//buffer배열의 크기만큼 input으로 받아오는 byte값들을 저장
											//읽어들인 byte의 개수를 빈횐 -> bytedata변수가 저장
			System.out.println("BYTEDATA : "+bytedata);
			System.out.println("BYTEDATA : "+Arrays.toString(buffer));
		}
		
		
	}

}
