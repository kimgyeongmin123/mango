package Ch25;

public class C01ThreadMain {
	public static void main(String[] args) throws Exception{
		
		//Main Thread에서의 실행흐름
		for(int i=0;i<5;i++)
		{
			System.out.println("TASK1..");
			Thread.sleep(500); 	//0.5초 일시정지	
		}
		
		for(int i=0;i<5;i++)
		{
			System.out.println("TASK2..");
			Thread.sleep(500);
		}
	}

}
