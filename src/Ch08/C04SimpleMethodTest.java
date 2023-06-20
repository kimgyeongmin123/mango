package Ch08;

import java.util.Scanner;

class Sum
{
	//속성
	Scanner sc = new Scanner(System.in);
	
	//기능
	//인자도 있고 반환값도 있다.
	int sum1(int x, int y)
	{
		System.out.println("sum1(x,y) 호출!");
		return x=y;
	}
	
	//인자는 없고 반환값이 있다.
	int sum2()
	{
		System.out.println("int sum2(x,y) 호출!");
		System.out.println("x와 y를 입력하세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		return x+y;
	}
	
	//인자는 있고 반환값이 없다.
	void sum3(int x, int y)
	{
		System.out.println("void sum3(int x, int y) 호출!");
		System.out.println("result3 : "+(x+y));
	}
	
	//인자도 없고 반환값도 없다
	void sum4()
	{
		System.out.println("void sum4() 호출!");
		System.out.println("x와 y값을 입력하세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(x+" + "+y+" = "+(x+y));
	}
	
}

public class C04SimpleMethodTest {
	public static void main(String[] args) {
		
		Sum calc = new Sum();
		int result1 = calc.sum1(10, 20);
		System.out.println("result1 : "+result1);
		
		int result2 = calc.sum2();
		System.out.println("result2 : "+result2);
		
		calc.sum3(100, result2);
		calc.sum4();
	}
}
