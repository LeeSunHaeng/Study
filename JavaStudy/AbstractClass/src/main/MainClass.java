package main;

import abstractCls.AbstractClass;
import cls.MyClass;
import cls.YouClass;

public class MainClass {

	public static void main(String[] args) {
		
	//	AbstractClass ac= new AbstractClass(); //생성 안됨
		MyClass mycls = new MyClass();
		mycls.method();
		mycls.abstractMethod();
		
		AbstractClass ac= new MyClass();
		ac.method();
		ac.abstractMethod();
		
		((MyClass)ac).func();
		
		YouClass you = new YouClass();
		you.abstractMethod();
		

	}

}
