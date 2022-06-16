package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dto.StudentDto;
// 데이터의 접근, 관리
public class StudentDao {

	Scanner sc = new Scanner(System.in);

		
		private List<StudentDto> student = new ArrayList<StudentDto>();

		
		
		// CRUD
		public void insert() {	//추가
			System.out.print("번호 : ");
			int number = sc.nextInt();
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("신장 : ");
			Double height = sc.nextDouble();
			
			System.out.print("영어 점수 : ");
			int eng = sc.nextInt();
			
			System.out.print("수학 점수 : ");
			int math = sc.nextInt();
			
			student.add(new StudentDto(number,name, height, eng, math)); 
		}
		
		public void delete() {	//삭제
			int num;
			System.out.print("몇번 학생의 데이터를 삭제 하시겠습니까 : ");
			num = sc.nextInt();
			student.remove(num);
			System.out.print(num+" 학생의 정보를 삭제했습니다.");
		}
		
		public void select() {	//검색
			System.out.print("검색할 학생명 : ");
			String name = sc.next();
			int index = -1;
			for (int i = 0; i < student.size(); i++) {
				if(student.get(i).getName().equals(name)) {
					index = i;
				}
			}
			student.get(index).toString();
			}
		
		
		public void update() {	//수정
		int num;
		int changeNum;
		int number;
		String name;
		Double height;
		int eng;
		int math;
		
		System.out.println("몇번 학생의 정보를 수정하시겠습니까? : ");
		num=sc.nextInt();
		
		System.out.println("무슨 정보를 수정하시겠습니까?(1.번호 2.이름 3.키 4.영어점수 5.수학점수) : ");
		changeNum = sc.nextInt();
		
		StudentDto cha = student.get(num-1);
		switch(changeNum) {
		
		case 1 : 
			int num2;
			System.out.println("번호를 입력해 주세요 : ");
			num2 = sc.nextInt();
			cha.setNumber(num2);
			break;
			
		case 2 : 
			String chName;
			System.out.println("이름을 입력해 주세요 : ");
			chName = sc.next();
			cha.setName(chName);
			break;
			
		case 3 : 
			double height2;
			System.out.println("키를 입력해 주세요 : ");
			height2 = sc.nextDouble();
			cha.setHeight(height2);
			break;
			
		case 4 : 
			int chEng;
			System.out.println("영어점수를 입력해 주세요 : ");
			chEng = sc.nextInt();
			cha.setEng(chEng);
			break;
			
		case 5 : 
			int chMath;
			System.out.println("수학점수를 입력해 주세요 : ");
			chMath = sc.nextInt();
			cha.setMath(chMath);	
			break;
			
		}
		
//		System.out.print("번호 : ");
//		int number = sc.nextInt();
//		
//		System.out.print("이름 : ");
//		String name= sc.next();
//		
//		System.out.print("신장 : ");
//		Double height = sc.nextDouble();
//		
//		System.out.print("영어 점수 : ");
//		int eng = sc.nextInt();
//		
//		System.out.print("수학 점수 : ");
//		int math = sc.nextInt();
		
		student.get(num).toString();
		
	}
		
		
		public void alldate() {	//모든 정보 확인용
			for (int i = 0; i < student.size(); i++) {
				System.out.println((i+1)+"."+student.get(i));
				
			}
		}
	}


