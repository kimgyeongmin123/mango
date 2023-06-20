package Ch15;

interface remocon
{
	void On();
	void ChangeChannel(int channel);
	void Off();	//추상메서드
}

class TV implements remocon
{
	int channel;
	@Override
	public void On() {	System.out.println("TV가 켜져따.");}
	
	@Override
	public void Off() {System.out.println("TV가 꺼져따.");}

	@Override
	public void ChangeChannel(int channel) {
		this.channel = channel;
		System.out.println("TV채널이 "+channel+"로 변경되었다.");
	}
}

interface Browser
{
	void Searchable(String url);
}

class SmartTV extends TV implements Browser
{
	@Override
	public void Searchable(String url) {
		System.out.println("브라우저에서 URL["+url+"]접속을 요청 합니다.");	
	}
}

class Radio implements remocon
{
	int channel;
	@Override
	public void On() {System.out.println("Radio소리가 난다.");}
	
	@Override
	public void Off() {System.out.println("Radio소리가 안난다.");}

	@Override
	public void ChangeChannel(int channel) {
		System.out.println("Radio채널이 "+channel+"로 변경되었다.");
		
	}
}

public class C01InterfaceMain {
	
	public static void TurnOn(remocon controller)
	{
		controller.On();
	}
	
	public static void TurnOff(remocon controller)
	{
		controller.Off();
	}
	
	public static void Changechannel(remocon controller, int channel)
	{
		controller.ChangeChannel(channel);
	}
	
	public static void SearchBrowser(Browser browser, String url)
	{
		browser.Searchable(url);
	}
	
	public static void main(String[] args) {
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		
//		TurnOn(tv1);
//		TurnOff(tv1);
//		
//		TurnOn(radio1);
//		TurnOff(radio1);
//		
//		Changechannel(tv1, 50);
		
		SmartTV tv2 = new SmartTV();
		TurnOn(tv2);
		Changechannel(tv2,100);
		SearchBrowser(tv2,"망고블로그");
		
	}
	

}
