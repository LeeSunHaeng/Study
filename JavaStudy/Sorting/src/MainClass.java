import java.util.Arrays;
import java.util.Scanner;

public class MainClass {



	public static void main(String[] args) {
		
		//정렬 프로그램
		
		//user 몇개의 숫자를 정렬 할건지?
		Scanner scan = new Scanner(System.in);
		
		int num;		
		System.out.print("몇개의 숫자를 정렬하십니까? : ");
		num = scan.nextInt();
		int sort[]= inputArr(num);
		/*
		//갯수를 결정
		int sort[] = new int[num];
		
		//숫자들을 입력받기
		int input;
		for (int i = 0; i < sort.length; i++) {
			System.out.print((i+1)+"번째 숫자를 입력해 주세요 :");
			input = scan.nextInt();
			sort[i] = input;
		}
		*/
		
		resultArr(sort);
		/*
		//오름차순인지 내림차순인지
		while(true) {
		int check;
		System.out.println("오름 차순 정렬은 1번, 내림 차순 정렬은 2번을 눌러주세요 : ");
		check = scan.nextInt();
		
		//정렬처리
		int temp;
		if(check == 1) {
			for (int i = 0; i < sort.length-1; i++) {
				
				for (int j = i+1; j < sort.length; j++) {
					if(sort[i]>sort[j]) {
						temp=sort[i];
						sort[i]=sort[j];
						sort[j]=temp;
					}
						
				}
				
			}
			
			break;
		}
		
		else if(check == 2) {
			for (int i = 0; i < sort.length-1; i++) {
				
				for (int j = i+1; j < sort.length; j++) {
					if(sort[i]<sort[j]) {
						temp=sort[i];
						sort[i]=sort[j];
						sort[j]=temp;
					}
						
				}
				
			}

			break;
		}
		else {
			System.out.println("1 또는 2를 입력해 주세요");
		}
		}
		*/
		System.out.println(Arrays.toString(sort));
		
		
}
	static int[] inputArr(int num) {
		
		Scanner scan = new Scanner(System.in);
		
		//갯수를 결정
		int sort[] = new int[num];
		
		//숫자들을 입력받기
		int input;
		for (int i = 0; i < sort.length; i++) {
			System.out.print((i+1)+"번째 숫자를 입력해 주세요 :");
			input = scan.nextInt();
			sort[i] = input;
		}
		return sort;
		
	
	}
	
	static void resultArr(int sort[]) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int check;
			System.out.println("오름 차순 정렬은 1번, 내림 차순 정렬은 2번을 눌러주세요 : ");
			check = scan.nextInt();
			
			//정렬처리
			int temp=0;
			if(check == 1) {
				for (int i = 0; i < sort.length-1; i++) {
					
					for (int j = i+1; j < sort.length; j++) {
						if(sort[i]>sort[j]) {
							rale(i,j,temp,sort);
							/*
							temp=sort[i];
							sort[i]=sort[j];
							sort[j]=temp;
							*/
						}
							
					}
					
				}
				
				break;
			}
			
			else if(check == 2) {
				for (int i = 0; i < sort.length-1; i++) {
					
					for (int j = i+1; j < sort.length; j++) {
						if(sort[i]<sort[j]) {
							rale(i,j,temp,sort);
							/*
							temp=sort[i];
							sort[i]=sort[j];
							sort[j]=temp;
							*/
						}
							
					}
					
				}

				break;
			}
			else {
				System.out.println("1 또는 2를 입력해 주세요");
			}
	}
}
	static void rale(int i, int j,int temp, int sort[]) {
		
			temp=sort[i];
			sort[i]=sort[j];
			sort[j]=temp;

	}
		
}
