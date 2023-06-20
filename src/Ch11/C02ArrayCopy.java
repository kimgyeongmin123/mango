package Ch11;

import java.util.Arrays;

public class C02ArrayCopy {
	public static void main(String[] args) {
		
		int arr1[] = {10,20,30};
		int arr2[];
		
		arr2 = arr1;	//주소값 복사해서 동일한 배열을 가르키는 두개의 참조변수가 생긴다.(얕은복사)
		
		arr1[0]=123;
		System.out.println("----arr2[0]");
		System.out.println(arr2[0]);	//arr2도 같이 변한다.
		
		System.out.println("----arr3");
		//깊은 복사
		int arr3[] = new int[3];
		for(int i=0;i<arr1.length;i++)
		{
			arr3[i]=arr1[i];	//아예 값을 복사
			System.out.println(arr3[i]);
		}
		
		//깊은 복사
		int arr4[] = Arrays.copyOf(arr1,arr1.length);
		System.out.println("----arr4[0]");
		System.out.println(arr4[0]);
	}

}
