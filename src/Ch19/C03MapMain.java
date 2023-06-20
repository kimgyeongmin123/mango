package Ch19;

import java.util.HashMap;
import java.util.Map;

public class C03MapMain {
	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap();
		map.put("aaa", 1234);
		map.put("bbb", 2222);
		map.put("ccc", 3333);
		map.put("ddd", 4444);
		map.put("ddd", 1234);	//id중복인 경우(나중 요청된 K:V 저장)
		map.put("fff", 1234);	//pw중복인 경우(문제없이 저장)
		//삭제
		map.remove("ccc");
		
		//개수
		System.out.println("저장 수 : "+map.size());
		
		for(String key:map.keySet())
		{
			System.out.println(key+" "+map.get(key));
		}
	}

}
