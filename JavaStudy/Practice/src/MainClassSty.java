import java.util.Scanner;

public class MainClassSty {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//자연수 입력
		System.out.print("자연수 n = ");
		int n = scan.nextInt();

	
		//자연수를 나눴을때 나머지가 1 되는 수의 개수를 찾아서 배열만들고 비교하기
		//나머지가 1 되는 수의 갯수
		int count=0;
		for(int j = 1; j <n; j++) {
			if(n%j==1) {
				count++;
			}
		}
		System.out.println(count);
		//나머지가 1되는 수의 배열 만들기
		int arr[] = new int[count];
		int count2=0;
		for (int k = 1; k < n; k++) {
			if(n%k==1) {
				
				arr[count2]=k;
				count2++;
			}
			
		}
		//나머지가 1되는 수의 배열에서 가장 작은 수 찾기
		int temp=arr[0];
		for(int h =1; h<arr.length; h++) {
			if(temp>arr[h]) {
				temp=arr[h];
			}
		}
		
		System.out.println("가장 작은 수  : " + temp);
		
	}

}
