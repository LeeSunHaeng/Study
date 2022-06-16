package secureWork1;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	@Override
	public String toString() {
		String a="21424 | Java Pro\t| 김하나 | Jaen.kr\t\t | 15000";
		String b="35355 | OOAD 분석,설계\t| 소나무 | Jaen.kr\t\t | 30000";
		
		return  a+"\n"+b;
	
}
}