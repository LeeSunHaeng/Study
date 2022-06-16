package main;

import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		AccountDao dao = new AccountDao();
		
		while(true) {
			//메뉴
			System.out.println("1.데이터 추가");
			System.out.println("2.데이터 삭제");
			System.out.println("3.데이터 검색");
			System.out.println("4.데이터 수정");
			System.out.println("5.데이터 모두 출력");
			System.out.println("6.종료");
			System.out.println("7.데이터 임의 추가");
			
			System.out.print("메뉴 번호를 입력 >> ");
			int menuNum =sc.nextInt();
			
			switch(menuNum) {
				case 1 :			//추가
					dao.insert();
					break;
					
				case 2 :			//삭제
					dao.delete();
					break;
					
				case 3 :			//검색
					dao.select();
					break;
					
				case 4 :			//수정
					dao.update();
					break;
						
				case 5:				//모든데이터
					dao.alldata();
					break;
					
				case 6:
					System.exit(0); //프로그램 완전 종료
					
				case 7:				//데이터 임의 추가
					dao.input();	
					break;	
			}
		}

		
	}

}
