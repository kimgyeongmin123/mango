package Ch19;

import java.util.HashMap;
import java.util.Map;

class AuthCollector
{
	private static Map<String,Integer> map = new HashMap();
	//CRUD
	public static void Insert(String id, Integer pw)
	{
		if(map.containsKey(id))
		{
			System.out.println("동일한 ID값이 존재합니다. Insert 할 수 없습니다.");
			return;
		}
		map.put(id, pw);
	}
	public static void ShowInfo()
	{
		for(String key :map.keySet())
		{
			System.out.println(key+" "+map.get(key));
		}
	}
	public static void ShowInfo(String key)	//오버라이딩
	{	
		
	}
	public static void Remove(String id)
	{
		map.remove(id);
	}
	public static void Update(String id, Integer pw)
	{
		//수정
		
		//삭제+삽입
		
		//Remove()
		
		//Insert()
		
		map.replace(id, pw);
	}
}

public class C04MapMain {
	public static void main(String[] args) {
		AuthCollector.Insert("aaa", 111);
		AuthCollector.Insert("bbb", 222);
		AuthCollector.Insert("bbb", 555);	//X
		AuthCollector.Insert("ccc", 333);

		AuthCollector.Insert("ccc", 1234);
		
		AuthCollector.ShowInfo();
		
	}

}
