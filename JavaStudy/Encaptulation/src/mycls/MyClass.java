package mycls;

public class MyClass {


		/*
		 	Encapsulation == 은닉성, 캡슐화
		 	멤버에 대해서 외부 접근 제어(차단, 읽기전용, 허용여부)
		 	
		 	 접근 지정자 
		 	 private : 개인적인
		 	 public : 대중적인
		 	 protected : 상속에 따른 보호		//요즘 잘 안쓰는 표현 
		 	 		
		 */
		
		 private int number;
		 public String name;
		 protected double height;
		
		 public void setNumber(int number) { //setter
			 this.number =number;
		 }
		 public int getNumber(int number) {	 //getter
			 return this.number;
		 }
}
