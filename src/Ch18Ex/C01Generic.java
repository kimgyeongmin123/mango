package Ch18Ex;

class 재료 {

}

class 민트초코 extends 재료 {
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

class 갈릭 extends 재료 {
	String meterial;

	갈릭(String m) {
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class 오리지날 {
	String meterial;

	오리지날(String m) {
		this.meterial = m;
	}

	@Override
	public String toString() {
		return meterial;
	}

}

class popCorn<T extends 재료> {
	private T meterial;

	popCorn(T meterial) {
		this.meterial = meterial;
	}

	void ShowInfo() {
		System.out.println(meterial.toString() + "맛 팝콘!");
	}
}

public class C01Generic {

	public static void main(String[] args) {
		popCorn<민트초코> ob1 = new popCorn<민트초코>(new 민트초코("민트향 3배인 민트초코"));
		ob1.ShowInfo(); // 민트초코맛 팝콘이 출력

		popCorn<갈릭> ob2 = new popCorn<갈릭>(new 갈릭("갈릭향이 고소한 갈릭"));
		ob2.ShowInfo(); // 갈릭맛 팝콘이 출력

		// 오리지날 팝콘은 제너릭으로 선택되지 않도록 합니다.
//		popCorn<오리지날> ob3 = new popCorn<오리지날>(new 오리지날("오리지날"));
		
	}

}
