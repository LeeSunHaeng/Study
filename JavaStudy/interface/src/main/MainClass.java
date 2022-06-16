package main;

import cls.MyClass;
import cls.YouClass;
import inter.MyInterface;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyClass myi = new MyInterface();
		
		MyClass mycls = new MyClass();
		mycls.method();
		
		MyInterface myie = new MyClass();
		myi.method();
		
		MyInterface mtinter = new MyInterface() {

			@Override
			public void method() {
				
			}
			};
		
		YouClass ycls = new YouClass();
		ycls.func();
		ycls.method();
		
		
}
}		
				
			
		
		



//class ParentOne{
//	
//}
//class ParentTwo{
//	
//}
//
//class Child extends ParentOne, ParentTwo{
//	
//}
	
	