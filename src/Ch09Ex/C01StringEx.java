package Ch09Ex;

class Profile
{
	private static Object args;
	private static Object[] arr;
	private String name;
	private String addr;
	private String job;
	private String major;
	
	//셍성자
	// 1) 디폴트생성자 삽입
	public Profile(){}
	
	// 2) 모든 인자를 받는 생성자
	public Profile(String name, String addr, String job, String major)
	{
		super();
		this.name = name;
		this.addr = addr;
		this.job = job;
		this.major = major;
	}
	
	// 3) 문자열로 인자를 한번에 받아서 ,를 기준으로 잘라내어 각 속성에 저장
	//"홍창표,대구,프로그래머,컴퓨터공학" -> [홍창표,대구,프로그래머,컴퓨터공학]
	public Profile(String args)	//모든 인자
	{
		args=args.trim();//앞뒤공백제거
		String arr[] = args.split(",");	//,를 기준으로 잘른다.
		this.name=arr[0];
		this.addr=arr[1];
		this.job=arr[2];
		this.major=arr[3];
	}
	
	//toString()재정의
	@Override
	public String toString()
	{
		return "Profile [name="+name+", addr="+addr+", job="+job+", major="+major+"]";
	}
	
	boolean isContain(String findstr)
	{
		//findstr의 문자열이 각멤버인 name,addr,job,major 중 하나라도 포함되어 있으면 true 리턴
		//아니면 false 리턴
		
		findstr = findstr.trim();
		
		boolean is = this.name.contains(findstr) || 
				this.addr.contains(findstr) ||
				this.job.contains(findstr) || 
				this.major.contains(findstr);
		return is;
				
	}
	
	boolean isEquals(String str)
	{
		//인자로 받은 str문자열을 "," 단위로 잘라내어서 각각 나눠진 문자열이
		//name,adrr,job,major와 일치하면 true, 하나라도 다른게 있으면 false를 리턴
		
		str=str.trim();//앞뒤공백제거
		String strarr[] = str.split(",");	//,를 기준으로 잘른다.
		this.name=strarr[0];
		this.addr=strarr[1];
		this.job=strarr[2];
		this.major=strarr[3];	//이까지 str을 ,을 기준으로 잘랐다.
		
		for(int i=0;i<=3;i++)
		{
			
		}
		
	}
}

public class C01StringEx {
	public static void main(String[] args) {
		
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
		System.out.println(hong.toString());
		
		System.out.println("길동 포함여부 : "+hong.isContain("길동"));
		System.out.println("컴퓨터 포함여부 : "+hong.isContain("컴퓨터"));
		System.out.println("프로필 일치여부 : "+hong.equals("홍길동,대구,프로그래머,컴퓨터공학"));
		System.out.println("프로필 일치여부 : "+hong.equals("홍길동,울산,프로그래머,컴퓨터공학"));
		
	}
}
