package Ch18;

class 재료 {
	
}

class 팥 extends 재료{
	String meterial;

	팥(String m) // 생성자
	{
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class 야채 extends 재료 {
	String meterial;

	야채(String m) // 생성자
	{
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class 피자 extends 재료 {
	String meterial;

	피자(String m) // 생성자
	{
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class 민트초코 {
	String meterial;

	민트초코(String m) // 생성자
	{
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class 호빵은_맛없어<T extends 재료> {		//T extends 재료 //재료와 상속관계인 하위클래스만 받겠다. 
	private T meterial; // 피자,야채,팥객체 연결

	호빵은_맛없어(T meterial) {
		this.meterial = meterial;
	}

	void ShowInfo() {
		System.out.println(meterial.toString() + "(으)로 만든 호빵은 맛없어!");
	}
}

public class C01GenericMain {
	public static void main(String[] args) {

		호빵은_맛없어<팥> ob1 = new 호빵은_맛없어<팥>(new 팥("단팥"));
		ob1.ShowInfo();
		호빵은_맛없어<피자> ob2 = new 호빵은_맛없어<피자>(new 피자("치즈 피자"));
		ob2.ShowInfo();
		호빵은_맛없어<야채> ob3 = new 호빵은_맛없어<야채>(new 야채("야채향 듬뿍"));
		ob3.ShowInfo();
//		호빵은_맛없어<민트초코> ob4 = new 호빵은_맛없어<민트초코>(new 민트초코("민트향 3배인 민트초코"));
		ob4.ShowInfo();
	}

}
