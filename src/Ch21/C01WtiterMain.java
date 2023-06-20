package Ch21;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WtiterMain {
	
	public static void main(String[] args) {
		try {
//			Writer out = new FileWriter("c:\\iotest\\test1.txt");	//덮어쓰기 //못쓰는 경우를 고려해서 예외처리 해줘야함
			Writer out = new FileWriter("c:\\iotest\\test1.txt",true);	//추가하기(밑에다가 내용을 추가)
			out.write("만고야..공부해라\n");
			out.write("만고야..\n");
			out.write("만고야......\n");
			out.flush(); 	//버퍼 초기화
			out.close(); 	//스트림 종료
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
