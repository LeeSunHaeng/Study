package main;

import cls.ChildClass;
import cls.ChildClass2;
import cls.ParentClass;

public class MainClass {

	public static void main(String[] args) {
		
		// 자식 클래스의 객체 총 10개의 객체 생성
		ChildClass arrOne[] = new ChildClass[10];
		ChildClass2 arrTwo[] = new ChildClass2[10];
		
		
		/*
		String name = "";
		if((name).equals("one")) {
			
		}
		else {
			
		}
		
		arrOne[0] = new ChildClass();
		*/
		
		// 자식 클래스의 객체 총 10개의 객체 생성
//		ParentClass pc1 = new ChildClass();
//		ParentClass pc2 = new ChildClass2();
		
		ParentClass arrParent[] = new ParentClass[10];  
		
		arrParent[0] = new ChildClass();
		arrParent[1] = new ChildClass2();
		arrParent[2] = new ChildClass();
		arrParent[3] = new ChildClass2();
		arrParent[4] = new ChildClass2();
		arrParent[5] = new ChildClass();
		arrParent[6] = new ChildClass();
		arrParent[7] = new ChildClass2();
		arrParent[8] = new ChildClass();
		arrParent[9] = new ChildClass();
		
		
		for (int i = 0; i < arrParent.length; i++) {
			arrParent[i].Method();
			
			if(arrParent[i] instanceof ChildClass) {
				ChildClass one =(ChildClass)arrParent[i];
				one.func();
			}
			else if(arrParent[i] instanceof ChildClass2) {
				ChildClass2 two =(ChildClass2)arrParent[i];
				two.proc();
			}
		}
		/*
		ChildClass o =(ChildClass)arrParent[0];
		o.func();
		
		//instanceof : 생성된 class를 찾아준다.
		
		if(arrParent[0] instanceof ChildClass) {
			ChildClass one =(ChildClass)arrParent[0];
			one.func();
		}
		*/
		
	}

}







