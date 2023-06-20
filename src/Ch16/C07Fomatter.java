package Ch16;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C07Fomatter {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		//포매터 객체 생성(입력받을때의 포매팅)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);
		System.out.println(date);
		
		//포매터 객체 생성(출력할때의 포매팅)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(fmtout.format(date));
	}

}
