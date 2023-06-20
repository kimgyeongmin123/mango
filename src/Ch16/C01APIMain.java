package Ch16;

import java.util.Scanner;

class A
{
	int x;
	int y;
	
	@Override	//오브젝트의 toString을 오버라이딩하여 재정의하여 쓴것이다.
	public String toString() {
		
		return "x = "+x+"  y = "+y;
	}
}

public class C01APIMain {
	
	public static void main(String[] args) {
		
		Object obj = new Object(); 
		System.out.println(obj);
		System.out.println(obj.toString());	//동일한 결과가 나온다.
		
		A obj2 = new A();
		System.out.println(obj2);
		System.out.println(obj2.toString());	//동일한 결과가 나온다.
		
		
	}
}
