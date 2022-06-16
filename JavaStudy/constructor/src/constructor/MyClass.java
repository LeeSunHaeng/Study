package constructor;

public class MyClass {
	//멤버변수
	int number;
	String name;
	
	MyClass(){
		System.out.println("MyClass 기본 생성자");
	}
	
	MyClass(int number){	//두번째 생성자
		System.out.println("MyClass(int num) 기본 생성자");
	}
	
	MyClass(int number, String name){
		this.number = number;	//this.number == 멤버 변수, number== 
		this.name = name;
		System.out.println("MyClass(int num,String na) 기본 생성자");
		
		//this : 자기참조 -> 현재 객체읮 ㅜ소
		
	}
	MyClass getThis() {
		return this;
	}
}
