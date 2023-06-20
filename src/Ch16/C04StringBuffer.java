package Ch16;

import java.net.MulticastSocket;

public class C04StringBuffer {
	public static void main(String[] args) {
		
		String str1 = "Mango";
		System.out.println("STR1 : " + System.identityHashCode(str1));
		String str2 = "World";
		str1 = str1.concat(str2);	//문자열 덧붙이기 함수
		System.out.println(str1);
		System.out.println("STR1 : " + System.identityHashCode(str1));	//덧붙이면 값이 달라진다(메모리의 위치가 바뀐다/공간이 새롭게 생긴다)
		
		long startTime = System.currentTimeMillis();	//시작시간 변수에 현재 시간을 넣는다.
		//이 사이에 코드를 입력하면 이 코드 실행을 위해 걸리는 시간을 기록
		
		//기본덧붙이기
		String str="";
		for(int i=0;i<=500000;i++)
		{
			str+="H";
		}
		
		//StringBuffer로 문자열 붙이기
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<=500000;i++)	//시간이 덜걸린다.
		{
			buffer.append("H");
		}
		
		long endTime = System.currentTimeMillis();		//끝나는시간 변수에 현재 시간을 넣는다.
		
		System.out.println("소요시간 : "+(endTime-startTime)+"ms");
	}
	
}
