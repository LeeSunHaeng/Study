import java.util.Iterator;
import java.util.Scanner;

public class MainClassString {

	public static void main(String[] args) {

		//입력된 문자가 숫자로만 되어있는지 아니면 다른 문자인지를 판별 하는 코드 작성
		char a = 'A';
		//System.out.println((int)a);
		
		int asccode = (int)a;
		boolean numberOk = true;
		if(asccode < 48 || asccode > 57) {
			numberOk =false;
		}
		if(numberOk) {
			System.out.println("숫자입니다.");
		}
		else {
			System.out.println("숫자가 아닙니다.");
		}
		
		
		//숫자입니다
		
		//숫자가 아닙니다.
		
		//입력된 문자열이 모두 숫자로 되어있는 아니면 모두 숫자로 되어있지 않은지 판별 코드
		//123 123a
		Scanner scan = new Scanner(System.in);
		
		System.out.println("number : ");
		String strNum = scan.next();
		numberOk = true;
		for (int i = 0; i < strNum.length(); i++) {
			char ch = strNum.charAt(i);
			int n = (int)ch;
			if(n<48 || n>57) {
				numberOk = false;
				break;
			}
			
		}
		if(numberOk) {
			System.out.println("모두 숫자입니다.");
			int Number = Integer.parseInt(strNum);
		}
		else {
			System.out.println("숫자가 아닌 문자가 포합되어 있습니다.");
		}
		
		//영단어를 입력 -> toUpperCase 나 toLowerCase를 사용하지 않고 모두 대문자로
		

		String word = scan.next();
		String result = "";

		for (int i = 0; i < word.length(); i++) {
			char chasc = word.charAt(i);
			int n = (int)chasc;
			
			if(n>=97) {   //97(a)  -65(A) = 32
				n = n-32;
				
			}
			result = result + (char)n;
			
		}
		System.out.println(result);
		
	}

}
