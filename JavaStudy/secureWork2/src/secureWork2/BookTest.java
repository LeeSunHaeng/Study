package secureWork2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		List BookList = new ArrayList<List>();
		List MagazineList = new ArrayList<List>();
		
		Book book1 = new Book();
		book1.setIsbn("21424");
		book1.setTitle("Java Basic");
		book1.setAuthor("김하나");
		book1.setPublisher("Jean.kr");
		book1.setPrice(15000);
		book1.setDesc("Java 기본 문법");
		BookList.add(book1);
		
		Book book2 = new Book();
		book2.setIsbn("33455");
		book2.setTitle("JDBC Pro");
		book2.setAuthor("김철수");
		book2.setPublisher("Jean.kr");
		book2.setPrice(23000);
		BookList.add(book2);
		
		Book book3 = new Book();
		book3.setIsbn("55355");
		book3.setTitle("Selvlet/JSP");
		book3.setAuthor("박자바");
		book3.setPublisher("Jean.kr");
		book3.setPrice(41000);
		book3.setDesc("Mode12 기반");
		BookList.add(book3);
		
		Book book4 = new Book();
		book4.setIsbn("35332");
		book4.setTitle("Android App");
		book4.setAuthor("홍길동");
		book4.setPublisher("Jean.kr");
		book4.setPrice(25000);
		book4.setDesc("Lightweight Framework");
		BookList.add(book4);
		
		Book book5 = new Book();
		book5.setIsbn("35355");
		book5.setTitle("OOAD 분석,설계");
		book5.setAuthor("소나무");
		book5.setPublisher("Jean.kr");
		book5.setPrice(30000);
		BookList.add(book5);
		
		
		System.out.println("*********************** 도서 목록 **************************");
		for(int i = 0; i < BookList.size(); i++) {
			System.out.println(BookList.get(i));
		}
		
		Magazine magazine1 = new Magazine();
		magazine1.setIsbn("35535");
		magazine1.setTitle("Java World");
		magazine1.setAuthor("편집부");
		magazine1.setPublisher("Jean.kr");
		magazine1.setPrice(7000);
		magazine1.setYear(2013);
		magazine1.setMonth(2);
		MagazineList.add(magazine1);
		
		Magazine magazine2 = new Magazine();
		magazine2.setIsbn("33434");
		magazine2.setTitle("Mobile World");
		magazine2.setAuthor("편집부");
		magazine2.setPublisher("Jean.kr");
		magazine2.setPrice(8000);
		magazine2.setYear(2013);
		magazine2.setMonth(8);
		MagazineList.add(magazine2);
		
		Magazine magazine3 = new Magazine();
		magazine3.setIsbn("75342");
		magazine3.setTitle("Next Web");
		magazine3.setAuthor("편집부");
		magazine3.setPublisher("Jean.kr");
		magazine3.setPrice(10000);
		magazine3.setDesc("AJAX 소개");
		magazine3.setYear(2012);
		magazine3.setMonth(10);
		MagazineList.add(magazine3);
		
		Magazine magazine4 = new Magazine();
		magazine4.setIsbn("76543");
		magazine4.setTitle("Architecture");
		magazine4.setAuthor("편집부");
		magazine4.setPublisher("Jean.kr");
		magazine4.setPrice(5000);
		magazine4.setDesc("java 시스템");
		magazine4.setYear(2010);
		magazine4.setMonth(3);
		MagazineList.add(magazine4);
		
		Magazine magazine5 = new Magazine();
		magazine5.setIsbn("76534");
		magazine5.setTitle("Data Modeling");
		magazine5.setAuthor("편집부");
		magazine5.setPublisher("Jean.kr");
		magazine5.setPrice(14000);
		magazine5.setYear(2012);
		magazine5.setMonth(12);
		MagazineList.add(magazine5);
		
		System.out.println("*********************** 잡지 목록 **************************");
		for(int i = 0; i<MagazineList.size(); i++) {
			System.out.println(MagazineList.get(i));
		}
	}

}
