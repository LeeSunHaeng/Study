package work3copy;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean a = true;
		while(true) {
		//학생들의 수 입력받기
		int stuNum; 				//학생들의 수 변수 선언
		stuNum = studentNum();		//학생들의 수 입력받는 함수
		
		//학생들의 정보 배열에 입력하기
		String[][] studentIm = new String[stuNum][5];
		studentArr(studentIm);
		while(a=true) {
		//메뉴 만들기 1~5 리턴
		int menuNum;
		menuNum=menu();
		System.out.println(menuNum);
		
		//메뉴 1 학생들 개개인의 국,영,수 총점
		int score[] = new int[stuNum];
		
		if(menuNum == 1) {

		plusScore(score,studentIm);		//score배열에 학생들 점수 총점 입력
		resultPlus(score);				//학생의 총점 출력
		menuReturn(a);
		}
		
	

		//메뉴 2 학생들의 국,영,수 총점 ex(국어 총 점수 : 90+95+80)
		else if(menuNum == 2){
		subSum(studentIm); 				//국,영,수 총점 출력 함수
		System.out.println("");
		menuReturn(a);
		}
		//메뉴 3 과목별 최고점수 출력
		else if(menuNum == 3) {
			scoreHigh(studentIm);
			System.out.println("");
			menuReturn(a);
		}
		//메뉴 4 과목별 최저점수 출력
		else if(menuNum == 4) {
			scoreLow(studentIm);
			System.out.println("");
			menuReturn(a);
		}
		//메뉴 5 학급에서 국+영+수 점수 1등 이름 출력

		else if(menuNum ==5){
			bestScore(stuNum,score,studentIm);
			System.out.println("");
			menuReturn(a);
		}
		else {
			System.out.println("");
			break;
		}
	}
		}
	}

	//학생들의 정보 2차원 배열에 입력받기
	static int studentNum() {
	Scanner scan = new Scanner(System.in);
	System.out.println("학생 수를 입력해 주세요 : ");
	int studentNum = scan.nextInt();
	return studentNum;
	}
	
	//학생들의 정보 배열에 입력하기
	static void studentArr(String [][] studentIm) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < studentIm.length; i++) {
			
			System.out.println((i+1)+"번 학생의 정보를 입력해 주십시오.");
			for (int j = 0; j < 5; j++) {
				stuInput(i,j,studentIm);
			}
		}
	}
	//학생들 정보 입력받기 if문
	static void stuInput(int i,int j,String [][] studentIm) {
		Scanner scan = new Scanner(System.in);
		if(j==0) {
			System.out.print("이름 : ");
			String stuName = scan.next();
			studentIm[i][j] = stuName;
		}
		else if(j==1) {
			System.out.print("생년원일 : ");
			String stuBir = scan.next();
			studentIm[i][j] = stuBir;
		}
		else if(j==2) {
			System.out.print("국어 점수 : ");
			String stuKo = scan.next();
			studentIm[i][j] = stuKo;
		}
		else if(j==3) {
			System.out.print("영어 점수 : ");
			String stuEn = scan.next();
			studentIm[i][j] = stuEn;
		}
		else{
			System.out.print("수학 점수 : ");
			String stuMath = scan.next();
			studentIm[i][j] = stuMath;
		}

	}
	// 메뉴 입력받아서 출력해주는 함수
	static int menu() {
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.println("메뉴");
		System.out.println("1. 학생들 개개인의 국,영,수 총점");
		System.out.println("2. 학생들의 국,영,수 총점");
		System.out.println("3. 과목별 최고점수 출력");
		System.out.println("4. 과목별 최저점수 출력");
		System.out.println("5. 학급에서 국+영+수 점수 1등 학생 출력");
		System.out.println("6. 학생 정보 다시 입력하기");
		System.out.println("메뉴를 입력해 주세요(1~6) : ");
		num = scan.nextInt();
		return num;
	}	
	//메뉴 1 학생들 개개인의 국,영,수 총점 저장
	static void plusScore(int score[], String[][] studentIm) {
		
			int sum =0;
					
				for (int j = 0; j < studentIm.length; j++) {
					
					for (int j2 = 2; j2 < 5; j2++) {
						int a = Integer.parseInt(studentIm[j][j2]);
						sum+=a;
					}
					score[j] = sum;
					sum=0;
				}
			
	}
	//메뉴 1 학생들 개개인의 국,영,수 총점 출력
	static void resultPlus(int score[]) {
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("총점을 볼 학생의 번호를 입력해 주세요 : ");
		num = scan.nextInt();
				System.out.println((num)+"번 학생의 총 점수는"+score[num-1]+"입니다");
			

	}
	//과목별 총점 출력 함수
	static void subSum(String studentIm[][]) {
		int koSum = 0;
		int enSum = 0;
		int mathSum = 0;
		int a;
		int b;
		int c;
		for (int i = 0; i < studentIm.length; i++) {
			 a = Integer.parseInt(studentIm[i][2]);
			 b = Integer.parseInt(studentIm[i][3]);
			 c = Integer.parseInt(studentIm[i][4]);
			koSum += a;	
			enSum += b;	
			mathSum += c;			
		}
		System.out.println("국어 총점은 "+koSum+"점 입니다.");
		System.out.println("영어 총점은 "+enSum+"점 입니다.");
		System.out.println("수학 총점은 "+mathSum+"점 입니다.");
	}
	//과목별 최고점수 출력 함수
	static void scoreHigh(String studentIm[][]) {
		int koBest = Integer.parseInt(studentIm[0][2]);
		int enBest = Integer.parseInt(studentIm[0][3]);
		int mathBest = Integer.parseInt(studentIm[0][4]);
		for (int i = 1; i < studentIm.length; i++) {
			int a = Integer.parseInt(studentIm[i][2]);
			if(koBest<=a) {
				koBest = a;
			}
			int b = Integer.parseInt(studentIm[i][3]);
			if(enBest<=b) {
				enBest = b;
			}
			int c = Integer.parseInt(studentIm[i][4]);
			if(mathBest<=c) {
				mathBest = c;
			}
		
		}
		System.out.println("국어 최고 점수는 "+koBest+"점 입니다.");
		System.out.println("영어 최고 점수는 "+enBest+"점 입니다.");
		System.out.println("수학 최고 점수는 "+mathBest+"점 입니다.");
	}
	//과목별 최저점수 출력 함수
		static void scoreLow(String studentIm[][]) {
			int koLow = Integer.parseInt(studentIm[0][2]);
			int enLow = Integer.parseInt(studentIm[0][3]);
			int mathLow = Integer.parseInt(studentIm[0][4]);
			for (int i = 1; i < studentIm.length; i++) {
				int a = Integer.parseInt(studentIm[i][2]);
				if(koLow>=a) {
					koLow = a;
				}
				int b = Integer.parseInt(studentIm[i][3]);
				if(enLow>=b) {
					enLow = b;
				}
				int c = Integer.parseInt(studentIm[i][4]);
				if(mathLow>=c) {
					mathLow = c;
				}
			
			}
			System.out.println("국어 최저 점수는 "+koLow+"점 입니다.");
			System.out.println("영어 최저 점수는 "+enLow+"점 입니다.");
			System.out.println("수학 최저 점수는 "+mathLow+"점 입니다.");
		}
		//메뉴 5 학급에서 국+영+수 점수 1등 이름 출력
		static void bestScore(int stuNum,int score[],String studentIm[][]) {
			plusScore(score,studentIm);	//score[]에 총점 값 입력 함수
			int best = score[0];
			int stuNm=0;
			String bestSc;
			for (int i = 1; i < stuNum; i++) {
				
				if(best < score[i]) {
					best=score[i];
					stuNm=i;
				}
			}
			bestSc=studentIm[stuNm][0];
			System.out.println("국+영+수 총점 1등 학생은 "+bestSc+" 입니다.");
		}
		static boolean menuReturn(boolean a) {
			Scanner scan = new Scanner(System.in);
			String mRe;
			System.out.print("메뉴로 돌아가시겠습니까?(y/n)");		
			mRe=scan.next();
			if(mRe.equals("n")) {
				a=false;
		}
			return a;
}
}
