
public class MainClass {

	public static void main(String[] args) {
		
		
		/*
		 	Operator :연산자
		 	+ - * / %
		 	++    increment
		 	--    decrement
		 	
		 */
		
		int number1, number2;
		int result;
		
		number1 = 25;
		number2 = 7;
		
		result = number1 + number2;
		System.out.println(result);
		
		result = number1 - number2;
		System.out.println(result);
		
		result = number1 * number2;
		System.out.println(result);
		
		result = number1 / number2;       //몫
		System.out.println(result);
		
		result = number1 % number2;		//나머지  /,% 둘다 분모에 0이 들어오면 안됌
		System.out.println(result);
		
		//Arithmetic == 산수, 연산
		
		//++--
		number1 =0;
		number1 = number1 + 1;
		System.out.println(number1);
		number1 += 1;
		System.out.println(number1);
		
		//increment == ++ == +1
		//decrement == -- == -1
		
		number1 ++;
		System.out.println(number1);
		number1 --;
		System.out.println(number1);
		++number1;
		System.out.println(number1);
		--number1;
		System.out.println(number1);
		
		int num1, num2;
		
		num1 = 0;
		num2 = 0; 
		
		num2 = num1++;
		System.out.println("num1 : "+ num1);
		System.out.println("num2 : "+ num2);
		
		
		

	}

}
