package Ch25;

public class C03Worker1 implements Runnable{

	C01GUI gui;
	
	C03Worker1(C01GUI gui){
		this.gui = gui;
	}

	@Override
	public void run() {
		while(true) {
			gui.area1.append("Thread1.......\n");
			try {Thread.sleep(500);}catch(Exception e1){e1.printStackTrace();}
		}
	}
	
	
}
