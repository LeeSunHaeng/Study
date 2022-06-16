package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;



public class AccountDao {
	
	//list <-불러오기
	List<AccountDto> acc = new ArrayList<AccountDto>();
	List<Integer> indexNum = new ArrayList<Integer>();	//검색할 데이터의 년도와 월이 일치하는 ArrayList 인덱스 번호
	
	//CRUD
	//임의의 데이터 입력
	public void input() {
		acc.add(new AccountDto("1997-12-24-11-10","과자","지출",2500,"스크류바 3개"));
		acc.add(new AccountDto("2021-12-20-12-55","볼펜","지출",1000,"모나미 3개"));
		acc.add(new AccountDto("1987-01-04-08-25","월급","수입",2000000,"1월 월급"));
		acc.add(new AccountDto("1492-06-04-18-36","외식","지출",50000,"소고기 2인분"));
		acc.add(new AccountDto("1845-03-15-00-10","노래방","지출",3000,"노래 9곡"));
	}
	
	//추가(insert)**********************************************************************
	public void insert() {
	 Scanner sc = new Scanner(System.in);
	 
	 String dateTime;	//yyyy-mm-dd(몇년 몇월 며칠)
	 System.out.print("(yyyy-mm-dd-00-00) -> :");
	 dateTime = sc.next();
	 
	 String use; 		//용도(쇼핑,교통대금,핸드폰요금 등등)
	 System.out.print("용도 : ");
	 use = sc.next();
	 
	 String classify = "";  	//수입/지출
	 int money=0;
	 int incExp;		//수입or지출 (1,2)
	 System.out.print("(1)수입 (2)지출 -> 1 OR 2 : ");
	 incExp = sc.nextInt();
	 			//금액
	 
	 if(incExp == 1) {
		 System.out.print("금액 : ");
		 money = sc.nextInt();
		 classify ="수입";
		 
	 }
	 else if(incExp == 2) {
		 System.out.print("지출 : ");
		 money = sc.nextInt();
		 classify = "지출";
	 }
	 
	 
	 
	 String memo;	 //내용(특이사항)
	 System.out.print("메모(특이사항) : ");
	 memo = sc.next();
	 
	 AccountDto creat = new AccountDto(dateTime, use, classify, money, memo);
	 
	 acc.add(creat);
	}

	//삭제(delete)**********************************************************************
	public void delete() {
		 Scanner sc = new Scanner(System.in);
		int searchMenu;
		int deleteIndex;
		
		
		System.out.print("(1)인덱스 번호 검색 후 삭제 , (2)인덱스 번호로 바로 삭제");
		searchMenu = sc.nextInt();
		
		if(searchMenu == 1) {
			//검색 함수
			search();
			
			System.out.print("삭제할 데이터의 인덱스 번호를 입력하세요 : ");
			deleteIndex = sc.nextInt();
			acc.remove(deleteIndex);
			System.out.println("index number "+deleteIndex+"번의 데이터가 삭제되었습니다.");
			
		}
		else if(searchMenu == 2) {
			System.out.print("삭제할 데이터의 인덱스 번호를 입력하세요 : ");
			deleteIndex = sc.nextInt();
			acc.remove(deleteIndex);
			System.out.println("index number "+deleteIndex+"번의 데이터가 삭제되었습니다.");
		}
		

		
	}
	
	
	
	
	//검색(select)**************************************************************
	public void select() {		
	
	//내용 검색을 검색어로 통해 산출된 데이터 출력		//입력한 달의 데이터 모두 출력 ->  수입과 지출 출력	
	search();	//검색 함수
	

	}
	//--------------------
	//파일저장/불러오기(불러오기 함수 따로 만들어서 list에 넣는방식)  <<<이거는 추가로 하고싶은 사람만
	
	
	//수정(update)**********************************************************************
	public void update() {
	 Scanner sc = new Scanner(System.in);
	int searchMenu;
	int updateIndex;
	int updateNum;
	
	
	System.out.print("(1)인덱스 번호 검색 후 수정 , (2)인덱스 번호로 바로 수정");
	searchMenu = sc.nextInt();
	
	if(searchMenu == 1) {
		//검색 함수
		search();

		System.out.print("수정할 데이터의 인덱스 번호를 입력하세요 : ");
		updateIndex = sc.nextInt();
		
		acc.get(updateIndex).toString();
		System.out.println("수정할 데이터를 입력해 주세요");
		System.out.print("(1)날짜 (2)용도 (3) 수입/지출 (4)금액 (5)내용 --> ");
		updateNum = sc.nextInt();
		
		
		switch(updateNum) {
		
		case 1 : 
			String updateDt;
			System.out.print(acc.get(updateIndex).getDateTime() + "--> (yyyy-mm-dd-00-00) ");
			updateDt = sc.next();
			acc.get(updateIndex).setDateTime(updateDt);
			System.out.println("날짜를 " + acc.get(updateIndex).getDateTime()+"로 수정했습니다.");
			break;
			
		case 2 : 
			String updateUse;
			System.out.print(acc.get(updateIndex).getUse() + "--> ");
			updateUse = sc.next();
			acc.get(updateIndex).setUse(updateUse);
			System.out.println("용도를 " + acc.get(updateIndex).getUse()+"(으)로 수정했습니다.");
			break;
			
		case 3 : 
			String updateClassify;
			System.out.print(acc.get(updateIndex).getClassify() + "-->  ");
			updateClassify = sc.next();
			acc.get(updateIndex).setClassify(updateClassify);
			System.out.println("(수입/지출)을 " + acc.get(updateIndex).getClassify()+"로 수정했습니다.");
			break;
			
		case 4 : 
			int money;
			System.out.print(acc.get(updateIndex).getMoney() + "원" + "-->  ");
			money = sc.nextInt();
			acc.get(updateIndex).setMoney(money);
			System.out.println("금액을 " + acc.get(updateIndex).getMoney()+"원 으로 수정했습니다.");
			break;
			
		case 5 : 
			String updateMemo;
			System.out.print(acc.get(updateIndex).getMemo() + "--> (yyyy-mm-dd-00-00) ");
			updateMemo = sc.next();
			acc.get(updateIndex).setMemo(updateMemo);
			System.out.println("내용(특이사항)을 " + acc.get(updateIndex).getMemo()+"(으)로 수정했습니다.");
			break;
		}			

		
	}
	else if(searchMenu == 2) {
		System.out.print("수정할 데이터의 인덱스 번호를 입력하세요 : ");
		updateIndex = sc.nextInt();
		
		acc.get(updateIndex).toString();
		System.out.println("수정할 데이터를 입력해 주세요");
		System.out.print("(1)날짜 (2)용도 (3) 수입/지출 (4)금액 (5)내용 --> ");
		updateNum = sc.nextInt();
		
		
		switch(updateNum) {
		
		case 1 : 
			String updateDt;
			System.out.print(acc.get(updateIndex).getDateTime() + "--> (yyyy-mm-dd-00-00) ");
			updateDt = sc.next();
			acc.get(updateIndex).setDateTime(updateDt);
			System.out.println("날짜를 " + acc.get(updateIndex).getDateTime()+"로 수정했습니다.");
			break;
			
		case 2 : 
			String updateUse;
			System.out.print(acc.get(updateIndex).getUse() + "--> ");
			updateUse = sc.next();
			acc.get(updateIndex).setUse(updateUse);
			System.out.println("용도를 " + acc.get(updateIndex).getUse()+"(으)로 수정했습니다.");
			break;
			
		case 3 : 
			String updateClassify;
			System.out.print(acc.get(updateIndex).getClassify() + "-->  ");
			updateClassify = sc.next();
			acc.get(updateIndex).setClassify(updateClassify);
			System.out.println("(수입/지출)을 " + acc.get(updateIndex).getClassify()+"로 수정했습니다.");
			break;
			
		case 4 : 
			int money;
			System.out.print(acc.get(updateIndex).getMoney() + "원" + "-->  ");
			money = sc.nextInt();
			acc.get(updateIndex).setMoney(money);
			System.out.println("금액을 " + acc.get(updateIndex).getMoney()+"원 으로 수정했습니다.");
			break;
			
		case 5 : 
			String updateMemo;
			System.out.print(acc.get(updateIndex).getMemo() + "--> (yyyy-mm-dd-00-00) ");
			updateMemo = sc.next();
			acc.get(updateIndex).setMemo(updateMemo);
			System.out.println("내용(특이사항)을 " + acc.get(updateIndex).getMemo()+"(으)로 수정했습니다.");
			break;
		}			

	}
	}
	
	
	
	
	
	//모든데이터(AllData)******************************************************************
	public void alldata() {
		
		for (int i = 0; i < acc.size(); i++) {
			System.out.println(i+"번 "+acc.get(i));
		}

	}
	
	
	//검색 함수
	public void search() {
		while(true) {
		 Scanner sc = new Scanner(System.in);
			//입력한 달의 데이터 모두 출력 ->  수입과 지출 출력
		 	int searchMenu;
		 	int count = -1;
		 	System.out.print("(1)키워드 검색 , (2)기간으로 검색, (3)인덱스 번호로 검색");
		 	searchMenu= sc.nextInt();
		 	
		 if(searchMenu == 2) {	//기간으로 검색
			String year;
			String month;
			
			
			 System.out.println("검색할 데이터의 연도 : ");
			 year = sc.next();
			 
			 System.out.println("검색할 데이터의 월 : ");
			 month = sc.next();
			 
			for (int i = 0; i < acc.size(); i++) {
				AccountDto put = acc.get(i);
				if(put.getDateTime().contains(year) && put.getDateTime().contains(month) ) {
					indexNum.add(i);
					count++;
				}
			}
			if(count== -1) {
				System.out.println(year+"년과 " + month+"월은 기록이 없습니다.");
			}
			else {
				//출력
				for (int i = 0; i < indexNum.size(); i++) {
						System.out.println("index number : "+indexNum.get(i)+"의 데이터 --> "+acc.get(indexNum.get(i)));
					}
				for (int i = 0; i < indexNum.size(); i++) {
					indexNum.remove(0);
				}
				count= -1;
				break;
			}
			
			
		 }	
		else if(searchMenu == 1) {	//키워드로 검색
				String word;
				System.out.print("검색할 키워드를 입력해 주세요 : "	);
				word = sc.next();
				
				for (int i = 0; i < acc.size(); i++) {
					AccountDto put = acc.get(i);
					if(put.getMemo().contains(word) ||put.getUse().contains(word)) {
						indexNum.add(i);
						count++;
					}
				}
				if(count== -1) {
					System.out.println(word+" 가 포함된 기록이 없습니다.");
				}
				else {
					//출력
					for (int i = 0; i < indexNum.size(); i++) {
							System.out.println("index number : "+indexNum.get(i)+"의 데이터 --> "+acc.get(indexNum.get(i)));
						}
					for (int i = 0; i < indexNum.size(); i++) {
						indexNum.remove(0);
					}
					count= -1;
					break;
				}
			
			}
		else if(searchMenu == 3) {
			int num;
			System.out.println("검색하실 index의 번호를 입력해 주세요 : ");
			num = sc.nextInt();
			System.out.println("index 번호 "+num+"번의 데이터 --> "+acc.get(num));
			break;
		}
		else {
			System.out.print("잘못 입력하셨습니다. 다시 입력해 주세요"	);
		}
		}
		}

	}
