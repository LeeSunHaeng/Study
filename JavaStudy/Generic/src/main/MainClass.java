package main;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Generic == tamplate(형태)
		 				:자료형 변수
		 				:같은 클래스에서 다양한 자료형을 사용하고 싶은 경우, 설정하는 요소
		 */
		Box<Integer> box = new Box<Integer>(123);
		box.setTemp(234);
		System.out.println(box.getTemp());
		
		Box<String> sbox = new Box<String>("Hello");
		sbox.setTemp("World");
		System.out.println(sbox.getTemp());
	}

}

class Box<T>{
	T temp;

	public Box(T temp) {
		super();
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
	
}

	class BoxMap <KEY, VALUE> {
		KEY =key;
		VALUE = value;
}
	
	









