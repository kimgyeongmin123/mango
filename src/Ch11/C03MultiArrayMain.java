package Ch11;

public class C03MultiArrayMain {
	public static void main(String[] args) {
		
		int [][] arr1 = new int[2][3]; //각각 행 열
		arr1[0][0] = 10;
		arr1[0][1] = 20;
		arr1[0][2] = 30;
		
		arr1[1][0] = 11;
		arr1[1][1] = 22;
		arr1[1][2] = 33;
		System.out.println("-------arr1 배열---------");
		System.out.println("행 개수 : "+arr1.length);
		System.out.println("0번째 행의 열 개수 : "+arr1[0].length);
		System.out.println("1번째 행의 열 개수 : "+arr1[1].length);
		
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr1[i].length;j++)
			{
				System.out.print(arr1[i][j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("\n-------arr2 배열------");
		int [][] arr2 = {
				{10,20,30},
				{40,50,60,70},
				{80,90,100,110,120}
		};
		System.out.println("행 개수 : "+arr2.length);
		System.out.println("0번째 행의 열 개수 : "+arr2[0].length);
		System.out.println("1번째 행의 열 개수 : "+arr2[1].length);
		System.out.println("2번째 행의 열 개수 : "+arr2[2].length);
		
		for(int i=0;i<arr2.length;i++)
		{
			for(int j=0;j<arr2[i].length;j++)
			{
				System.out.print(arr2[i][j]+"  ");
			}
			System.out.println();
		}
		
	}

}
