import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 	계산기
		 */
		//1. 입력
		// 1번째 숫자
		// 연산자 +-*/
		// 2번째 숫자
		
		//2. 연산
		
		//3. 결과 출력
		
		Scanner scan = new Scanner(System.in);
		String oper = " ";
		String numStr1 = " ";
		String numStr2 = " ";
		int input1 = 0;
		int input2 = 0;
		
		
		input1 = frNum(numStr1,"첫번째");		//첫번째 수 입력
		String operator = oper(oper);		//연산자 입력
		input2 = frNum(numStr2,"두번째");		//두번째 수 입력
		result(operator,input1,input2);		//결과값 출력
		/*
		while(true) {
		// 첫번째 숫자 입력
		System.out.print("첫번째 숫자: \t\t");
		numStr1 = scan.next();
			
		boolean nbOk = true;
		for (int i = 0; i < numStr1.length(); i++) {
			int n = (int)numStr1.charAt(i); // 입력받은 문자열에서 한 글자씩 ascii 번호로 산출
			if(n<48 || n>57) {
				nbOk =false;    	// 1234a
				break;
			}
			
		}
		
		if(nbOk == true) {
				break;
			}	
		System.out.println("숫자를 정확히 입력해 주세요.");
		
		}
		*/
		
		//연산자 입력
		
		/*
		while(true) {
		System.out.print("+, -, *, / 중 연산자를 골라주세요 : ");
		 operator= scan.next();
		if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
			break;
		}
		System.out.println("연산자를 정확히 입력해 주십시오.");
		}
		/**/
		
		/*
		System.out.print("두번째 숫자: \t\t");
		 numStr2 = scan.next();
		boolean nbOk = true;
		for (int i = 0; i < numStr2.length(); i++) {
			int n = (int)numStr2.charAt(i); // 입력받은 문자열에서 한 글자씩 ascii 번호로 산출
			if(n<48 || n>57) {
				nbOk =false;			// 1234a
				break;
				
			}
			if(nbOk == false) {
				continue;
			}
			break;
		}
		*/
		
		//연산

		/*
		if(operator.equals("+")) {
			System.out.println(input1+"+"+input2+"="+(input1+input2));
		}
		else if(operator.equals("-")) {
			System.out.println(input1+"-"+input2+"="+(input1-input2));
		}
		else if(operator.equals("*")) {
			System.out.println(input1+"*"+input2+"="+(input1*input2));
		}
		else if(operator.equals("/")) {
			System.out.println(input1+"/"+input2+"="+(input1/input2));
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
		}
		/**/
	}
	// 숫자 입력 받는 함수
	static int frNum(String a, String b) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			// 숫자 입력
			System.out.print(b + " 숫자: \t\t");
			a = scan.next();
				
			boolean nbOk = true;
			for (int i = 0; i < a.length(); i++) {
				int n = (int)a.charAt(i); // 입력받은 문자열에서 한 글자씩 ascii 번호로 산출
				if(n<48 || n>57) {
					nbOk =false;    	// 1234a
					break;
				}
				
			}
			
			if(nbOk == true) {
					break;
				}	
			System.out.println("숫자를 정확히 입력해 주세요.");
			
			}
		int input = Integer.parseInt(a);
		return input;
	}

	static String oper(String oper) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("+, -, *, / 중 연산자를 골라주세요 : ");
			oper= scan.next();
			if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			}
			System.out.println("연산자를 정확히 입력해 주십시오.");
			}
		return oper;
	}
	static void result(String operator, int input1, int input2) {
		
		if(operator.equals("+")) {
			System.out.println(input1+"+"+input2+"="+(input1+input2));
		}
		else if(operator.equals("-")) {
			System.out.println(input1+"-"+input2+"="+(input1-input2));
		}
		else if(operator.equals("*")) {
			System.out.println(input1+"*"+input2+"="+(input1*input2));
		}
		else if(operator.equals("/")) {
			System.out.println(input1+"/"+input2+"="+(input1/input2));
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
