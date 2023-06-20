package Ch17;

public class C02ArrayIdxExceptionMain {
	public static void main(String[] args) {

		int arr[] = { 10, 20, 30 };

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.print("arr배열의 공간을 초과하여 출력을 시도하였습니다.\n오류내용 : ");
			a.printStackTrace();
		}
		
		System.out.println("다음 실행할 코드");
	}

}
