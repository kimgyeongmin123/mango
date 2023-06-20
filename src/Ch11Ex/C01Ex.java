package Ch11Ex;

import java.util.Scanner;

public class C01Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//스캐너 생성
		
		int arr[] = new int[5];	
		
		//5개의 정수값을 입력받아 int형 배열에 저장하고
		//최대값, 최소값, 전체합을 출력해요세요.
		
		int sum = 0;
		
		System.out.println("배열에 넣을 숫자를 입력하세요(5개)");
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextInt();	//값 5개를 입력받음
			sum+=arr[i];
			System.out.print("arr["+i+"] : ");
			System.out.println(arr[i]);
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>=max) max=arr[i];
			if(arr[i]<=min) min=arr[i];
		}
		
		System.out.println("최대값 : "+max+"\n최소값 : "+min+"\n전체 합 : "+sum
				);
	}

}
