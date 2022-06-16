import java.util.Arrays;
import java.util.Scanner;

public class HomeWork2 {

	public static void main(String[] args) {

		/*	1번 문제
		 	사용자가 원하는 학생수로 점수를 입력받는다.
		 	총점, 평균 그리고 최고점수를 구한다.
		 	입력 받은 점수중에서 90점 이상인 학생의 수는 몇명인가?
		 	그리고 그 점수들만을 새로운 배열에 저장하도록 한다.
		 	
		 	2번문제
		 	숫자 입력 5개로 음수가 입력되면 다시 입력한다.
		 */
		
		//1번 문제 풀이
			Scanner scan = new Scanner(System.in);
	/*	// 점수 입력받기
			System.out.print("학생 수를 입력하세요 :");
			int num1 = scan.nextInt(); //학생 수 입력
			int num2; //학생 점수
			int sum=0; //학생 점수 총합,초기화
			int count = 0; //90점 이상인 학생 수 카운트

			 
			int score[] =new int[num1];//학생 점수들의 배열
			int temp=score[0]; // 최고점수 저장 변수
		// 점수 입력하기	
			for (int i = 0; i < score.length; i++) {
				System.out.print(i+1+"번 학생의 점수를 입력하세요 :");
				num2= scan.nextInt();
				score[i]=num2;
						
			}
			//System.out.println(Arrays.toString(score)); // <- 학생 점수 배열에 잘 들어갔는지 확인
			
		// 총점,평균,최고점수 구하기
			
			//총점,평균
			for (int i = 0; i < score.length; i++) {
				sum +=score[i];				
			}
			System.out.println("총점은 "+sum+"점 입니다.");
			System.out.println("평균은 "+sum/score.length+"점 입니다.");
			
			//최고점수
			for (int i = 1; i < score.length; i++) {
					if(temp<score[i]) {
						temp = score[i];
					}
			}
			System.out.println("최고 점수는 "+temp+"점 입니다.");
			
		// 90점 이상인 학생 수 구하기
			for (int i = 0; i < score.length; i++) {
				if(score[i]>=90) {
					count++;
				}
			}
			System.out.println("90점 이상인 학생은 "+count+"명 입니다.");
			
		// 90점 이상인 학생들을 새로운 배열에 저장	
			
			int count9=0; //90점 이상인 학생 수 배열순서
			int score9[] = new int[count]; // 90점 이상인 학생들의 배열
			
			for (int i = 0; i < score.length; i++) {
				if(score[i]>=90) {
					score9[count9] = score[i];
					count9++;
				}
			} 
			System.out.println("90점 이상인 학생들의 배열 : "+Arrays.toString(score9));
		*/
	
		//2번 문제
			/*
		 	2번문제
		 	숫자 입력 5개로 음수가 입력되면 다시 입력한다.
		 	*/
			
			int array[] = new int[5];
			int number;
			
			for (int i = 0; i < array.length; i++) {
				System.out.print(i+1+"번째 양수를 입력해 주세요 : ");
				number=scan.nextInt();
				if(number<0) {
					while(number<0) {
					System.out.print("양수로 입력하세요 : ");
					number = scan.nextInt();
					
					}
				}
				array[i]= number;
			}
			System.out.println(Arrays.toString(array));
			
			
		
		
		
		

	}

}
