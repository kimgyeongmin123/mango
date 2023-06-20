package Ch18;

import javax.annotation.processing.SupportedSourceVersion;

class Tiger
{
	String name;
	
	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
	Tiger(String name)	//생성자
	{
		super();
		this.name =name;
	}
	
}

class Panda
{
	String name;
	
	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
	
	Panda(String name)	//생성자
	{
		super();
		this.name =name;
	}
}

public class C03GenericMain {
	
	public static <T> void PrintInfo(T[] array)
	{
		for(T el : array)
		{
			System.out.println(el.toString());
		}
	}
	
	public static void PrintInfo2(Object[] array)
	{
		for(Object el : array)
		{
			if(el instanceof Tiger)
			{
				Tiger down = (Tiger)el;
				System.out.println(down);
			}
			else if(el instanceof Panda)
			{
				Panda down = (Panda)el;
				System.out.println(down);
			}
		}
	}
	
	public static void main(String[] args) {
		Tiger[] arr1= {new Tiger("호주머니"),new Tiger("호랑나비"),new Tiger("호식이")};
		PrintInfo(arr1);
		System.out.println("----------------------------------");
		Panda[] arr2 = {new Panda("판도라"), new Panda("판사"), new Panda("판자")};
		PrintInfo(arr2);
		System.out.println("----------------------------------");
		Object[] arr3 = {new Tiger("어흥흥"), new Panda("판판판")};
		PrintInfo2(arr3);
	}

}
