package Ch13;

//상속
//상위(부모,슈퍼)클래스의 속성과 기능을 하위(자식,서브)클래스에서 그대로 받아 사용할 수 있도록 허용한 문법
//받은 하위클래스는 상위클래스의 속성과 기능 이외의 멤버를 추가할 수 있다.
//extends예약어를 사용한다.

//상속 사용이유
//1 확장성
//2 유지보수
//3 가독성

class Point2D
{
	int x;
	int y;
	
	Point2D()
	{
		System.out.println("Point2D 생성자 호출!");
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
}

class Point3D extends Point2D
{
	int z;
	
	Point3D()
	{
		System.out.println("Point3D 생성자 호출!");
	}

	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}

public class C01InheritanceMain {
	public static void main(String[] args) {
		
		Point3D ob = new Point3D();
		ob.x = 100;	//상속받은 멤버변수
		ob.y = 200;	//상속받은 멤버변수
		ob.z = 300;	//확장된 멤버변수
		
		System.out.println(ob.toString());
		
	}

}
