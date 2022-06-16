package main;

import cls.HeClass;
import cls.MyClass;
import cls.YouClass;
import singleton.Singleton;

public class MainClass {

	public static void main(String[] args) {
		MyClass mycls = new MyClass();
		YouClass youcls = new YouClass();
		HeClass hecls = new HeClass();
//		youcls.setTotal(mycls.getNumber());
//		youcls.setName(mycls.getName());
//		System.out.println(youcls.toString());
		
//		Singleton s = Singleton.getInstance();
//		System.out.println(s);
//		
//		s = Singleton.getInstance();
//		System.out.println(s);
		
		mycls.method();
		youcls.func();
		hecls.change();
		System.out.println(hecls.);
		
	}

}
