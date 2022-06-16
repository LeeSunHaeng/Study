import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
	
	int number[];	//두개의 메소드에서 필요로 할떄는 멤버 변수로 선언
	int upDown;
	
	void input() {
	Scanner scan = new Scanner(System.in);
	System.out.println("몇개 정렬 = ");
	int count = scan.nextInt();
	
	number = new int [count];
	
	for (int i = 0; i < number.length; i++) {
		System.out.println((i+1)+"번째 수 : ");
		number[i] = scan.nextInt();
	}
	System.out.println("오름(1)/내림(2)");
	upDown = scan.nextInt();
	}
	
	void sorting() {
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(upDown ==1) {
					if(number[i]>number[j]) {
						swap(i,j);	
					}
				}
				else {
					if(number[i]<number[j]) {
						swap(i,j);	
					
				}
			}
			
		}
	}
	}
	
	void swap(int i, int j) {
		int temp = number[i];
		number[i]=number[j];
		number[j]=temp;
	}
	
	void result() {
		System.out.println(Arrays.toString(number));
	}
}
