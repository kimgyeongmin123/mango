package Ch17;

public class C01NullPointExceptionMain {
	public static void main(String[] args) {
		
		try
		{
			String str = null;
			System.out.println(str.toString());	//NullPointerException 예외객체가 생성되는 시점
		} catch (NullPointerException e)
		{
			System.out.println("NullPointerException 예외발생!! 오류! 오류!");
			System.out.println(e.getCause());	//예외원인
			System.out.println(e.toString());	//예외객체 메시지
			System.out.println(e.getStackTrace());	//예외객체 정보
			System.out.println();
			System.out.println();
			
			e.printStackTrace();	//stack : 쌓다, Trace : 추종
		}
		
		System.out.println("코드1");
		System.out.println("코드2");
	}

}
