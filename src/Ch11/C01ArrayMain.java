package Ch11;

import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Scanner;

//배열
//

public class C01ArrayMain {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int[] arr1 = new int[4];
		System.out.println("길이 : "+arr1.length);
		
		int plus=10;
		for(int i=0;i<arr1.length;i++)
		{
			arr1[i] = plus;
			plus+=10;
			System.out.println(arr1[i]);
		}
				
		System.out.println();
		for(int el:arr1)	//배열 요소들을 하나씩 꺼내준다.
		{
			System.out.println(el);
		}
		
		System.out.println();
		Arrays.stream(arr1).forEach(el->{
			System.out.println(el);
		});
		
		System.out.println();
		
		double arr2[];	//배열형 참조변수만 만들어놓았다.
		arr2 = new double[5];	//배열형 참조변수에 배열객체 연결
		
		
	}

}
