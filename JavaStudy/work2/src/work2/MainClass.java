package work2;

import java.util.Arrays;

public class MainClass {
	
	//정수인지 실수인지 판별 함수
	static boolean isDouble(String snumber) {
		
		//boolean b = snumber.contains(".");
		//return b;
		
		boolean b = false;
		for (int i = 0; i < snumber.length(); i++) {
			char c = snumber.charAt(i);
			if(c=='.') {
				b = true;
				break;
			}
		}
		return b;
	}
	
	
	//2차원 배열 1차원 배열로 변경 함수
	static int[] array2ToArray1(int array[][]) {		//함수의 프로토타입
		int count = 0;
				
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				count++;				
			}
		}
		
		int array1[] = new int[count];
		int count2 = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array1[count2] = array[i][j];
				count2++;
	}		
	}
		/*			// 2차원 배열의 행과 열이 같을때 
		int array1[] = new int[count];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array1[array[i].length*i+j] = array[i][j];    // 이렇게 하면 번호를 넣을 수 있음
				*/

	}		
	}
		
		return array1;
	}
	
	//두 점 사이의 거리
	static double distance(double x1, double y1, double x2, double y2) {
		double a = Math.pow(x2-x1,2);
		double b = Math.pow(y2-y1,2);
		double c = Math.sqrt(a+b);
		return c;
		
	}
	//아스키 코드 변환 함수
	static char ascToChar(int asc) {
		char acii = (char)asc;
		return acii;
	}
	//두 수의 몫과 나머지를 구하는 함수
	static int[] share(int a, int b) {
		int c = a/b;
		int d = a%b;
		int arr[] = {c,d};
		return arr;
	}
	public static void main(String[] args) {
		int asc=95;
		ascToChar(asc);
		char b = ascToChar(asc);
		// 아스키 코드 값을 입력하면 문자를 확인할 수 있는 함수를 작성하라.
		System.out.println("아스키코드 값은 :"+b + "입니다");
			
				
		
		// 두수의 나눗셈을 하는 함수를 작성하라. 하나의 함수에서 몫과 나머지를 구한다.
		int num1=40;
		int num2 =20;

		int arrf[] =share(num1,num2);
		System.out.println("몫은 : "+arrf[0]+"입니다.");
		System.out.println("나머지는 : "+arrf[1]+"입니다.");
		
		// 두점 사이의 거리를 구하는 함수를 작성하라. 
		// static double distance(double x1, double y1, double x2, double y2)
		// 	root (y2 - y1)2승 + (x2 - x1)2승
		//두 점 사이의 거리 구하는 공식
		double a1 =11.0;
		double b1 =13.5;
		double c1 =19;
		double d1 =13.6;
		double line = distance(a1, b1, c1, d1);
		System.out.println("두 점 사이의 거리는"+line+"입니다.");

		// 입력된 숫자가 정수인지 실수인지 확인할 수 있는 함수를 작성하라.
		// static boolean isDouble(String snumber)
		
		String snumber = "123.456";
		boolean b = isDouble(snumber);
		System.out.println(b);
				
		
		//2차원 배열을 1차원 배열로 변경해서 리턴하는 함수를 작성하라.
		int arrays[][] = {
				{2,1,5,47,3},
				{5,2,3,48,3},
				{8,6,5,2,4,3}	
				};
		int arrayss [] =array2ToArray1(arrays);
		
		System.out.println(Arrays.toString(arrayss));
		
		
		
		
		
		


	}

}
