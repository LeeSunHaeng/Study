
public class MainClass {

	public static void main(String[] args) {
	
		/*
		   Wrapper Class
		   일반 자료형(char, int, double)을 사용하기 편리하도록 구현해  놓은것
		   "문자열" '가' '나' '다' 'h' 'e' 'l' 'l' 'o'
		   String -> Wrapper Class
		   
		   일반 자료형				Wrapper Class(object)
		   boolean				Boolean
		   
		   byte					Byte
		   short				Short
		   int					Integer --------
		   long					Long
		   
		   float				Float
		   double				Double ---------
		   
		   char					Character
		   char[]				String ---------
		   
		   
		   
		 */
		
		
		// Integer == int
		
		int i =123;
		Integer iobj = 123;
		
		System.out.println("i = "+ i);
		System.out.println("iobj = "+ iobj);
		
		//class == 설계, 구성 + 변수 + 함수(메소드) - 
		//MyClass cls = new MyClass();
		//(코틀린) var cls = MyClass
		
		//정석대로라면 이렇게 동적할당 해줘야 하는데 인티저는 자동으로 동적할당 해줌
		Integer _iobj = new Integer(123);
		
		//String str = "hello";
		//String strObj = new String("hello");
		
		//Integer의 특성
		
		// 숫자 -> 문자열
		Integer objNumber = 123;
		String str =objNumber.toString()+1;
		System.out.println(str);
		
		// 숫자-> 문자열은 잘안씀 이유는 int형에 + ""; 해주면 toString 안해줘도 쉽게 바뀜
		int num = 123;
		String str1 = num + "";
		System.out.println(str1);
		
		double dnum  =123.234;
		String str2 = dnum+"";
		System.out.println(str2);
		
		//문자열 -> 숫자
		String str3 = "12345";
		int n = Integer.parseInt(str3);
		System.out.println(n+1);
		
		String str4 = "1234.4567";
		double d = Double.parseDouble(str4);
		System.out.println(str4);
		
		// 2진수, 8진수, 10진수, 16진수 변경
		// 10진수 -> 2진수
		int num10 = 16;
		String num2 = Integer.toBinaryString(num10);
		//Integer.toOctalString(i) 8진수로 변경
		//Integer.toHexString(i) 16진수로 변경
		System.out.println(num2);
		
		//2진수 -> 10진수
		/*
		   1010 1100
		   8421 8421
		 */
		//2진수는 문자열로 표현해야함
		String number2 = "10101100";
		int number10 = Integer.parseInt(number2, 2);
		System.out.println(number10);
		
		//10진수>>8진수
		
		int gum = 16;
		String rum2 = Integer.toOctalString(gum);
		System.out.println(rum2);
		int hum=Integer.parseInt(rum2,8);
		System.out.println(hum);
		
		int uum = 50;
		String eum = Integer.toHexString(uum);
		System.out.println(eum);
		int tum = Integer.parseInt(eum, 16);
		System.out.println(tum);
		
		
		

	}

}
