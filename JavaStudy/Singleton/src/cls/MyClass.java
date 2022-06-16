package cls;

import singleton.Singleton;

public class MyClass {
	private int number;
	private String name;
	
	public MyClass() {
		number =333;
		name = "홍길동";
	}

	public void method() {
		Singleton s = Singleton.getInstance();
		s.number = number;
		s.name = name;
	}
	
//	public String getName() {
//		return name;
//	}	
//	
//	
//	
//	public int getNumber() {
//		return number;
//	}
	
	
}
