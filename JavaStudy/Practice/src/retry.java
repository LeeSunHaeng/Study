import java.util.Scanner;

public class retry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//자연수 입력
		
		System.out.print("자연수 n = ");
		int n = scan.nextInt();

		//자연수를 나눴을때 1되는 수를 에 넣고 비교하면서 제일 작은 수 찾기
		for(int i = 1; i<n; i++) {
			if(n%i == 1) {			
				System.out.print("가장 작은 수는 : "+i);
				break;
			}
		
		}

		
	}

}
