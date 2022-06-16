import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Menu >>> ");
		System.out.println("1. 10진수 -> 2진수로 변경");
		System.out.println("2. 10진수 -> 8진수로 변경");
		System.out.println("3. 10진수 -> 16진수로 변경");
		System.out.println("4. 2진수 -> 10진수로 변경");
		System.out.println("5. 8진수 -> 10진수로 변경");
		System.out.println("6. 16진수 -> 10진수로 변경");
		System.out.println("원하시는 처리 번호를 입력해 주십시오 : ");
		int work = sc.nextInt();
		
		System.out.print("변경하고 싶은 숫자를 입력해 주십시오 : ");
		String numStr = sc.next();
		
		switch(work) {
			case 1 :
				//int num10 = Integer.parseInt(numStr);
				//String num2 = Integer.toBinaryString(num10);
				
				System.out.println("10진수 : "+numStr + "의 2진수는" + decToBin(numStr)+"입니다.");	
				break;
				
			case 2 :
//				int num10_8 =Integer.parseInt(numStr);
//				String num3 = Integer.toOctalString(num10_8);
				System.out.println("10진수 : "+numStr + "의 8진수는" + decToOct(numStr)+"입니다.");
				break;
				
			case 3 :
//				int num10_16 = Integer.parseInt(numStr);
//				String num4 = Integer.toHexString(num10_16);
				System.out.println("10진수 : "+numStr + "의 16진수는" + decToHex(numStr)+"입니다.");
				break;
			case 4 :
//				int num2_10 = Integer.parseInt(numStr,2);
				System.out.println("2진수 : "+numStr + "의 10진수는" + BinToDex(numStr)+"입니다.");
				
				break;
			case 5 :
//				int num8_10 =Integer.parseInt(numStr,8);
				System.out.println("8진수 : "+numStr + "의 10진수는" + BinToOct(numStr)+"입니다.");
				break;
			case 6 :
//				int num16_10 =Integer.parseInt(numStr,16);
				System.out.println("16진수 : "+numStr + "의 10진수는" + BinToHex(numStr)+"입니다.");
				
				break;
		}

	}
	//10진수 -->2진수 변환 함수
	static String decToBin(String numStr) {
		int num10 = Integer.parseInt(numStr);
		String num = Integer.toBinaryString(num10);
		return num;
	}
	
	//10진수 -->8진수 변환 함수
		static String decToOct(String numStr) {
			int num10_8 =Integer.parseInt(numStr);
			String num = Integer.toOctalString(num10_8);
			return num;
		}
		
	//10진수 -->16진수 변환 함수
		static String decToHex(String numStr) {
			int num10_16 =Integer.parseInt(numStr);
			String num = Integer.toHexString(num10_16);
			return num;
		}
		
	//2진수 -->10진수 변환 함수
				static int BinToDex(String numStr) {
					int num2_10 =Integer.parseInt(numStr,2);

					return num2_10;
				}
	//2진수 -->8진수 변환 함수
				static int BinToOct(String numStr) {
					int num2_8 =Integer.parseInt(numStr,8);

					return num2_8;
				}	
	//2진수 -->16진수 변환 함수
				static int BinToHex(String numStr) {
					int num2_16 =Integer.parseInt(numStr,16);

					return num2_16;
				}		

}
