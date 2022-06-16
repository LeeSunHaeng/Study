package main;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	final = 마지막
		 	final int NUMBER = 20;    // NUMBER는 상수임 변하지 않음
		 */
	}

}
/*final*/ class Parent{		// final이 추가 되면 상속 금지
	public /*final*/ void method() { //final 붙어 있으면 오버라이드 금지 메소드!
		
	}
}
class Child extends Parent{
	public void method() {	//over ride
		
	}
}