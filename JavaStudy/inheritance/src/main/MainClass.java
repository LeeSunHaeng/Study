package main;

import cls.ChildClass;
import cls.parentClass;

public class MainClass {

	public static void main(String[] args) {
		
		ChildClass cc = new ChildClass();
		cc.ParentMethod();
		cc.ChildMethod();
		
		parentClass pc = new parentClass();
		//pc.ChildMethod();		이건 안됨 부모>자식 호출 불가능
		
	}

}
