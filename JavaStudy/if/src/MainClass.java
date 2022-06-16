
public class MainClass {

	public static void main(String[] args) {
	/*
	   if : 조건문
	   
	   형식 : if( 조건 ){  조건 -> true/false
	   			 처리
	   		};
	   		
	   	조건 : ==같다, >(크다), >(작다), >=(크거나 같다), <=(작거나 같다),!(같지 않다)
		
		다수의 조건 : 논리 연산자와 같이 사용
					&&(AND), ||(OR), !(NOT)
					
				if(조건1 && 조건2){
				
				}	
	 */
		/*
		int	number  = 5;
		if( number > 0 ) { // <-- true
			//처리
			System.out.println("number는 0 보다 큽니다.");
		};
		if(number==5) {
			System.out.println("number는 5 입니다.");
		}
		if(number >= 5) {
			System.out.println("number는 5보다 크거나 같습니다.");
			
		}
		boolean b =true;
		
		if( b == true) {
			System.out.println("b는 true 입니다.");
		}
		
		if(b) {
			System.out.println("if(b)는 true 입니다.");
		}
		
		b=false;
		if(b==false) {
			System.out.println("b는 false입니다.");
		}
		if(!b) {
			System.out.println("if(!b)는 false");
		}
		
		if(number > 0 && number <= 10 && b==false) {
			System.out.println("number는 0보다 크고 10 보다 작거나 같고 b는 false 입니다.");
		}
		
		if(number > 0 || number > 10) {
			System.out.println("number는 0 보다 크거나 10 보다 크다");
		}
		*/
		
		/*
		   if(조건){
		   	처리1
		   }
		   else{
		   	처리2
		   }
		   
		   삼항 연산자
		   값 = ( 조건 ) ? 값1 : 값2
		 */
		/*
		int number = 69;
		
		if(number >= 70) {
			System.out.println("통과입니다.");
		}
		else {
			System.out.println("재시험입니다.");
		}
		
		String result =(number >= 70) ? "통과입니다." : "재시험입니다.";
		System.out.println(result);
		
		int num = (number > 60) ? 10 : 5;
		System.out.println(num);
	}
	}
	
		
	
	 	조건분기
	 	if(조건1){
	 		처리1
	 	}
	 	else if(조건2){
	 			처리2
	 	}
	 	else if(조건3){
	 			처리3
	 	}
	 	else{
	 	처리4
	 	}
	 */
	/*
	int number = 90;
	
	if(number == 100) {
		System.out.println("A+입니다.");
	}
	else if(number >= 90) {
		System.out.println("A입니다.");
	}
	else if(number >= 80) {
		System.out.println("B입니다.");
	}
	else if(number >= 70) {
		System.out.println("C입니다.");
	}
	else {
		System.out.println("재시험 입니다.");
	}
	
	*/
	int number;
	number = 95;
	//95이상 A+
	//95미만 A
	if(number >= 90) {
		if(number >= 95) {
			System.out.print("A+");
		}
			else {
				System.out.print("A");
			}
				System.out.println("입니다.");
		
	}
		
	String str1="안녕하세요";
	String str2="안녕";
	
	str2 = str2+"하세요";
	
	if(str1 == str2) {
		System.out.println("같은 문자열 입니다");
	}
	else {
		System.out.println("다른 문자열 입니다");
	}
	//equals 비교
	if(str1.equals(str2)) {     // str1의 문자열과 str2의 완성된 문자열을 비교
		System.out.println("같은 문자열 입니다");
	}
	else {
		System.out.println("다른 문자열 입니다");
	}
			
	
	
	
	
	
		
	}
}

