package Ch16;

class C03Simple
{
	private int id;	//동등객체여부 판단하는 기준
	int n;
	
	C03Simple(int id, int n)
	{
		this.id = id;
		this.n = n;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		return new HashCodeBuilder(true,PRIME);
	}
	
	//toString() 재정의
	//equals() 재정의
	//hashcode() 재정의
}

public class C03HashCodeMain {
	public static void main(String[] args) {
		
		C03Simple ob1 = new C03Simple(1,5);
		C03Simple ob2 = new C03Simple(1,6);
		
		System.out.println(ob1.getClass().getName()+"@"+Integer.toHexString(ob1.hashCode()));	// = ob1
		System.out.println(ob1.toString());
		System.out.printf("%x\n",ob1.hashCode());	//16진수로 변환하여 동일한값인걸 확인한다.
		
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());
		System.out.println(System.identityHashCode(ob1));
		System.out.println(System.identityHashCode(ob2));
		
	}

}
