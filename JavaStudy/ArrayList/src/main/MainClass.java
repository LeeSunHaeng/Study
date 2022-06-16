package main;

import java.util.ArrayList;
import java.util.List;

import dto.MyClass;
import dto.YouClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Collection : 수집 
		 	
		 	List : 목록
		 			ArrayList
		 				배열처럼 사용할 수 있는 목록
		 				선형 구조				O-O-O-O-O-O-O-O
		 				검색속도가 우수하다.
		 				index로 접근한다.
		 				
		 			
		 			LinkedList
		 				추가/삭제의 속도가 우수하다.
		 */
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		//List<Integer> arrList = new ArrayList<Integer>();

		
		// 추가
		arrList.add(111);					//[0]
		
		Integer in = new Integer(222);		//[1]
		arrList.add(in);
		
		arrList.add(new Integer(333));		//[2]
		
		int len = arrList.size();	//길이 size
		System.out.println("lsit의 크기 : " + len);
		
		System.out.println(arrList.get(0));
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		for (Integer n : arrList) {
			System.out.println(n);
		}
		//원하는 위치에 추가
		arrList.add(1, 200);
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		// 삭제
		Integer num = arrList.remove(2);
		System.out.println(num);
		
		
		// 검색
		int index = arrList.indexOf(333);
		System.out.println(index);
		
		index = -1;
		for (int i = 0; i < arrList.size(); i++) {
			Integer val = arrList.get(i);
			if(val ==200) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		
		// 수정
		Integer newValue = new Integer(100);
		arrList.set(0, newValue);
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
		
		ArrayList<String> slist = new ArrayList<String>();
		
		//추가
		slist.add("이선행");
		slist.add("김윤희");
		slist.add("이민영");
		slist.add("권민영");
		//삭제
		slist.remove(2);
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i));
		}
		//검색
		System.out.println(slist.indexOf("김윤희"));
		//수정
		slist.set(2, "권민영");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i));
		}
		
		List<MyClass> list = new ArrayList<MyClass>();
		 MyClass list1 = new  MyClass(1,"이선행",185.0);
		//추가
		list.add(new MyClass(1,"이선행",185.0));
		list.add(new MyClass(2,"권민영",171.0));
		list.add(new MyClass(3,"김인호",176.0));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		//중간에 추가 
		list.add(1, new MyClass(2,"이현범",175.0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//삭제
		list.remove(1);
		//검색
		String name = "권민영";
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			MyClass my = list.get(i);
			if(my.getName().equals(name)) {
				findIndex =i;
				break;
			}
		}
		list.get(findIndex).toString();
		
		//수정
		
		MyClass obj = list.get(0);
		obj.setHeight(182.3);
		
		MyClass mcls = new MyClass(5,"정수동",169.5);
		list.set(2, mcls);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		List<Object> allobjlist = new ArrayList<Object>();
		allobjlist.add(new YouClass());
		allobjlist.add(new MyClass());
		
		
		
	}

}
