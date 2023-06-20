package ch2;

public class C01진수 {

	public static void main(String[] args) {

		// 2진수 > 10진수
		// 10101100 : 172
		// 10011010 : 154
		// 01101001 : 105
		// 10010010 : 146

		// 10진수 > 2진수
		// 192 : 11000000
		// 224 : 11100000
		// 252 : 11111100
		// 12 : 00001100
		// 15 : 00001111

		System.out.printf("10진수 : %d\n", 0b00001111); //2진수로 바꿀땐 0b 를 앞에 붙이자
		System.out.printf("10진수 : %d\n", 173);
		System.out.printf("10진수 : %d\n", 0255);
		System.out.printf("10진수 : %d\n", 0xAD);

		System.out.printf("8진수 : %o\n", 173);
		System.out.printf("8진수 : %o\n", 0255);
		System.out.printf("8진수 : %o\n", 0xAD);

		System.out.printf("16진수 : %x\n", 173);
		System.out.printf("16진수 : %x\n", 0255);
		System.out.printf("16진수 : %x\n", 0xAD);
	
		
	
	
	
	
	}
}
