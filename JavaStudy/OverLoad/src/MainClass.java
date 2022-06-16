
public class MainClass {

	public static void main(String[] args) {
		/*
		 	OverLoad : 함수 명은 같고 매개변수(parameter)의 자료형이나 갯수가 다른 것을 의미한다.
		 	
		 	paint() : image drawing 
		 	paint(int x, int y)
		 	paint(int z)
		 	paint(cahr c)
		 	paint(char , int i)
		 	void paint(int i, char c)
		 	
		 	paint(int n, char ch) x
		 	int paint(int i, char c) x
		 	
		 */
		method();
		method('A');
		method(10);
		method('A', 10);
		method(10, 'A');
		int sum = sumProc(90,95,100,75,80);
		System.out.println(sum);
		sum= sumProc(10,20,30);
		System.out.println(sum);
		sumProc("성춘향",10,20,30);
		
	}
	static void method() {
		System.out.println("method()");
	}
	static void method(char c) {
		System.out.println("method(char c)");
	}
	static void method(int i) {
		System.out.println("method(int i)");
}
	static void method( char c, int i) {
		System.out.println("method(char c, int i)");
}
	static void method( int i, char c ) {
		System.out.println("method(int i, char c)");
}
	/*
		static void method( int n, char ch ) {
				System.out.println("method(int i, char c)");	 
}
	 */
	/*
	static int method( int i, char c ) {
		System.out.println("method(int i, char c)");
		return 1;
}
	*/
	
	//가변인수
	static int sumProc(int...num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum = sum+num[i];
		}
		return sum;
	}
	static void sumProc(String name, int...num){			//가변인수 쓸때는 매개변수의 맨 끝에 써야함
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum = sum+num[i];
		}
		System.out.println(name+"님의 합계는 "+sum+"입니다.");
	}
}
