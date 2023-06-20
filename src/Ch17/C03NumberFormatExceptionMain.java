package Ch17;

public class C03NumberFormatExceptionMain {
	public static void main(String[] args) {

		String data1 = "100";
		String data2 = "a100";
		int value1=0;
		int value2=0;
		try {
			value1 = Integer.parseInt(data1);
			value2 = Integer.parseInt(data2);
		} catch (NumberFormatException e) {
			System.out.print("NumberFormatException 예외 발생\n예외 발생 내용 : ");
			e.printStackTrace();
		} finally {
			System.out.println("예외발생과는 상관없이 무조건 실행코드");
		}
		
		int result = value1 + value2;
		System.out.println(data1 + "+" + data2 + "=" + result);
		
	}

}
