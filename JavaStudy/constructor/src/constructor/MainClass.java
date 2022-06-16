package constructor;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	constructor : 생성자				initialize(초기화)
		 				  객체 생성시에 호출.
		 				  메소드의 하나
		 				  클래스명과 같다
		 				  return값이 없음
		 				  overload가 가능
		 				  생략이 가능하다
		 				  별도의 호출이 불가능
		 				  
		 				  
		 	destructor : 소멸자 <- 사라짐
		 */
		
		int array[] = {11, 22, 33};
		
	//	MyClass cls  = {11,"홍길동"};
	//	MyClass cls = new MyClass();
	//	MyClass cls = new MyClass(45);
		MyClass cls = new MyClass(2, "HELLO");
		System.out.println(cls);
		
		MyClass t = cls.getThis();
		System.out.println(t);
	}

}
