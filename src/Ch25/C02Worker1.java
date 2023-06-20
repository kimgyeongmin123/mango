package Ch25;

public class C02Worker1 implements Runnable{

	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("TASK1..");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
