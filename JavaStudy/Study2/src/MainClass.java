import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		

		System.out.print("자연수 n = ");
		int n = scan.nextInt();

		for(int i = 1; i < n; i++) {
			if(n%i == 1) {			
				System.out.print("가장 작은 수는 : "+i);
				break;
			}
		
		}

	}

}
