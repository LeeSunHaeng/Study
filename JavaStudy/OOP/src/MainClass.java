
public class MainClass {

	public static void main(String[] args) {
		/*
	 	구조,관리
	 	Object Oriented Programming
	 	객체		지향		프로그래밍
	 	
	 	//객체지향의 특징
	 	1. 은닉성(캡슐화) //요즘 많이 사라짐
	 	2. 상속성
	 	3. 다형성
	 	
	 	형식:
	 		class 클래스명{
	 			변수(variable)
	 			
	 			메소드(method)
	 		}
	 	
	 	흐름 -> 절차지향
	 */
		
		// Class, array -> allocation(동적할당) -> Heap영역에 저장됨
		MyClass cls = new MyClass();
	//   자료형	클래스의 변수 == 객체
	//			instance(주체)
		
		cls.number = 1;
		cls.name = "홍길동";
		cls.method();
		
		MyClass cls1 = new MyClass();
		cls1.number = 2;
		cls1.name = "성춘향";
		cls1.method();
		
		//절차지향
		boolean isPoweron;
		int channel;
		int volume;
		
		isPoweron=true;
		channel =23;
		volume =10;
				
		System.out.println("TV는"+isPoweron+"이고 채널 : "+channel+"번을 보고 있으며 볼륨:"+volume+"입니다.");
		
		
		/*
		TV tv1 = new TV();
		tv1.isPoweron =true;
		tv1.channel = 23;
		tv1.volume = 10;
		tv1.method();
		
		TV tv2 = new TV();
		tv2.isPoweron =false;
		tv2.channel = 50;
		tv2.volume = 0;
		tv2.method();
		*/
		
		TV tvArray[] =new TV[2];	//객체 생성이 아님!! 배열 생성임!! == TV tv1, tv2, tv3
		
		for (int i = 0; i < tvArray.length; i++) {
			tvArray[i] = new TV(); //객체 생성
			
		}
		tvArray[0].isPoweron = true;
		tvArray[0].channel = 23;
		tvArray[0].volume = 12;
		tvArray[0].maker = "삼성";
		
		tvArray[1].isPoweron = false;
		tvArray[1].channel = 25;
		tvArray[1].volume = 17;
		tvArray[1].maker = "LG";
		
		for (int i = 0; i < tvArray.length; i++) {
			tvArray[i].method();
		}
	}

}

class TV{
	boolean isPoweron;
	int channel;
	int volume;
	String maker;
	
	void method() {
		System.out.println("TV 회사는"+maker+"이고 전원은 "+isPoweron+"이고 채널 : "+channel+"번을 보고 있으며 볼륨:"+volume+"입니다.");

	}
}




class MyClass{
	// 멤버 변수
	int number;
	String name;
	
	//멤버 메소드
	void method() {
		System.out.println("MyClass method()");
	
	}
}


