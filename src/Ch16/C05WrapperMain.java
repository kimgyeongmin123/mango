package Ch16;

public class C05WrapperMain {
	public static void main(String[] args) {
		
		//Boxing(기본자료형 -> wrapper Class)
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1+ob2+ob3);
		
		//UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		
		System.out.println(n1+n2+n3);
		
		//자동 Boxing
		Integer n4 = 100;
		int n5 = n4 + 200;
		
		
	}
}
