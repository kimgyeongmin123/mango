package Ch16;

import java.util.Calendar;
import java.util.Date;

public class C06DataMain {
	public static void main(String[] args) {
		
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getYear());
		System.out.println(d1.getMonth()+1);
		System.out.println(d1.getDay());	//요일 0부터 6까지(일~토)
		System.out.println(d1.getDate());
		System.out.println(d1.getHours());
		System.out.println(d1.getMinutes());
		System.out.println(d1.getSeconds());
		
		//=======================================================
		//Calendar
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));	//이건 1부터 시작한다.
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.TUESDAY);
		System.out.println(Calendar.WEDNESDAY);
		System.out.println(Calendar.THURSDAY);
		System.out.println(Calendar.FRIDAY);
		System.out.println(Calendar.SATURDAY);
	}
}
