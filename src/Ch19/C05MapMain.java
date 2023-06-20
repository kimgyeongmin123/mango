package Ch19;

import java.util.HashMap;
import java.util.Map;

class A {

	@Override
	public String toString() {
		return "A 객체";
	}

}

class B {

	@Override
	public String toString() {
		return "B 객체";
	}
}

class C {

	@Override
	public String toString() {
		return "C 객체";
	}
}

public class C05MapMain {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap();

		map.put("k1", new A());
		map.put("k2", new B());
		map.put("k3", new C());

		for (String key : map.keySet()) {
			if (map.get(key) instanceof A) {
				A down = (A) map.get(key);;
				System.out.println(down);
			}
		}
	}

}
