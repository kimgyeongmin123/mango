package ch2;

public class C04자료형 {

	public static void main(String[] args) {

		//-----------------------
		//정수 int-4byte 정수 부호 O
		//-----------------------
		int n1 = 0b10101101; //2진수값
		int n2 = 173; //10진정수값
		int n3 = 0255; //8진수
		int n4 = 0xad; //16진수
		System.out.printf("%d %d %d %d\n", n1, n2, n3, n4);
		
		//-----------------------
		//정수 byte-1byte 정수 부호 O
		//-----------------------
		System.out.println("-------------------------");
		byte n5 = -128;
		byte n6 = -30;
		byte n7 = 30;
		byte n8 = 127;
		byte n9 = (byte)129;  //문제발생.. 왜?
		System.out.printf("%d\n", n5);
		
		//-----------------------
		//정수 short-2byte 정수 부호 O | char-2byte 정수 부호X (양수만)
		//-----------------------
		System.out.println("-------------------------");
		char n10 = 65535;
		short n11 = 32767;
		
		char n12 = 60000;
//		short n13 = n12;  //문제발생.. 왜?
		
		System.out.printf("%c\n", n12);
		
		//-----------------------
		//정수 long-8byte 정수 부호 O
		//-----------------------
		System.out.println("-------------------------");
		long n14 = 10;
		long n15 = 20L;  //L,l(리터럴접미사) : long 자료형 사용하여 값 저장
		
		long n16 = 10000000000L; //문제발생.. 왜?
		long n17 = 10000000000L;
		
		
		//-----------------------
		//실수
		//-----------------------
		//유리수와 무리수의 통칭
		//소숫점이하값을 가지는 수 123.456
		//float : 4byte 실수(6~9자리)
		//double : 8byte 실수(15~18자리), 기본자료형
		
		//정밀도 확인
		float n18 = 0.123456789123456789F; // f,F : float형 접미사
		double n19 = 0.123456789123456789; 
		
		System.out.println(n18);
		System.out.println(n19);
		
		//-----------------------
		//단일문자 char 2byte 정수
		//-----------------------
		char ch1 = 'a';
		System.out.println(ch1);
		System.out.println((int)ch1); //011000001
		
		char ch2 = 98;
		System.out.println(ch2);
		System.out.println((int)ch1); //011000010
		
		char ch3 = 'c'+2;
		System.out.println(ch3);
		System.out.println((int)ch3); //011000011
		
		char ch4 = 'c'+2;
		System.out.println((char)ch4);
		System.out.println(ch4); //011000011
		
		char ch5 = '가';
		char ch6 = 0xac00+1;
		System.out.printf("%c %c\n",ch5, ch6);
		
		// \\u : 유니코드값 이스케이프문자
		System.out.printf("%c\n", '\uAC80');
		
		System.out.printf("TEST : %c\n", '\ud7fb');
		
		//-----------------------
		//문자열 : String (클래스자료형)
		//-----------------------
		
		//기본자료형(원시타입)
		//byte n1;
		//short n2;
		//double n3;
		//long n4;
		
		//클래스자료형
		//클래스자료형으로 만든변수는 '참조변수'라고 하고
		//참조변수는 데이터가 저장된 위치정보(메모리주소값)이 저장된다.
		int n20 = 10;
		String name = "경미니";
		String job = "미래의 프로그래머";
		System.out.println(name);
		System.out.println(job);
		
		
		//-----------------------
		//boolean : 논리형(true/false 저장)
		//-----------------------
		boolean flag = (10>5); //참(긍정)
		if(flag)
		{
			System.out.println("참인경우 실행");
		}
		else
		{
			System.out.println("거짓인경우 실행");
		}
		
	}

}
