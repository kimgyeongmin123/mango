package Ch15;

interface Tire
{
	void Run();
}

class 망고타이어 implements Tire
{
	@Override
	public void Run() 
	{
		System.out.println("망고타이어가 굴러갑니다..");
	}
}

class 창표타이어 implements Tire
{
	@Override
	public void Run() 
	{
		System.out.println("창표타이어가 굴러갑니다..");
	}
}

class Car
{
	Tire FL;
	Tire FR;
	Tire BL;
	Tire BR;
	Car()	//생성자
	{
		FL=new 망고타이어();	//UpCasting
		FR=new 망고타이어();
		BL=new 망고타이어();
		BR=new 망고타이어();
	}
	
	void Run()
	{
		FL.Run();
		FR.Run();
		BL.Run();
		BR.Run();
	}
}

public class C02InterfaceMain {
	public static void main(String[] args) {
		
		Car mangocar = new Car();
		mangocar.Run();
		
		mangocar.FR = new 창표타이어();	
		System.out.println();
		mangocar.Run();
	}
}
