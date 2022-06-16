package abstractCls;

/*
 	Abstract class : 추상 클래스
 					 추상 메소드를 하나 이상 포함하고 있는 클래스
 					 일반 메소드를 포함하고 있다.
 					 멤버 변수도 선언할 수 있다.
 					 
 	Abstract method : 내용(처리)은 없고 prototype(매개변수,리턴값)만 선언되어 있는 메소드
 	
 				public void method(char c , int i){					//일반 메소드
 					process
 					}
 					
 				public abstract void method(char c , int i);		//추상 메소드
 					
 */

public abstract class AbstractClass {
	
	private String name;
	
	public AbstractClass() {
		
	}
	
	public void method() {
		
		System.out.println("AbstractClass method()");
	}
	
	public abstract void abstractMethod();
	
}
