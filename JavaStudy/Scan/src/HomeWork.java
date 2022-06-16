import java.util.Scanner;

public class HomeWork {

	public static void main(String[] args) {
		//1번문제
	/*	String a = "이름";
		String b = "나이";
		String c = "전화번호";
		String d = "주소";
		System.out.println("이름\t" +"나이\t"+"전화번호\t\t"+"주소\t");
		System.out.println();
		System.out.println("홍길동\t" +"20\t"+"010-111-2222\t"+"경기도\t");
		System.out.println("일지매\t" +"18\t"+"02-123-4567\t"+"서울\t");
		/**/
	
		//2번 문제
	/*	System.out.println("name\t"+"age\t"+"phone\t\t"+"address\t");
		System.out.println();
		System.out.println("홍길동\t"+"20\t"+"010-111-2222\t"+"경기도\t");
		System.out.println("일지매\t"+"18\t"+"02-123-4567\t"+"서울\t");
		/**/
		
		//3번 문제
		
	/*	String name;
		name = "홍길동";
		int age;
		age = 20;
		boolean man;
		man = true;
		String phone;
		phone = "010-111-2222";
		double height;
		height = 175.12;
		String address;
		address = "경기도";
		System.out.println("name\t" + "age\t" + "man\t" + "phone\t\t" + "height\t"
				+ "address");
		System.out.println(name+"\t"+age+"\t"+man+"\t"+phone+"\t"+height+"\t"+address);
		name="일지매";
		age=20;
		man=true;
		phone="02-123-4567";
		height=180.01;
		address="경기도";
		System.out.println(name+"\t"+age+"\t"+man+"\t"+phone+"\t"+height+"\t"+address);
		name="장옥정";
		age=14;
		man=false;
		phone="02-345-7890";
		height=155.78;
		address="부산";
		System.out.println(name+"\t"+age+"\t"+man+"\t"+phone+"\t"+height+"\t"+address);
	/**/
		
		//4번 문제
	/*	Scanner scan= new Scanner(System.in);
		
		String name;
		int age;
		boolean man;
		String phone;
		double height;
		String address;
		
		//이름 입력받기
		System.out.print("이름을 입력하세요 : ");
		name = scan.next();
		
		//나이 입력받기
		System.out.print("나이를 입력하세요 : ");
		age = scan.nextInt();
		
		//성별 입력받기
		System.out.print("성별을 입력하세요 : ");
		man = scan.nextBoolean();
		
		//번호 입력받기
		System.out.print("번호를 입력하세요 : ");
		phone = scan.next();
		
		//키 입력받기
		System.out.print("키를 입력하세요 : ");
		height = scan.nextDouble();
		
		//주소 입력받기
		System.out.print("주소를 입력하세요 : ");
		address = scan.next();
		
		//이름 출력하기
		System.out.println("이름은 " +name+" 입니다.");
		//나이 출력하기
		System.out.println("나이는 " +age+" 입니다.");
		//성별 출력하기
		System.out.println("성별은 " +man+" 입니다.");
		//번호 출력하기
		System.out.println("번호는 " +phone+" 입니다.");
		//키 출력하기
		System.out.println("키는 " +height+" 입니다.");
		//주소 출력하기
		System.out.println("주소는 " +address+" 입니다.");
		/**/
		
		//5번 문제
		
		Scanner scan = new Scanner(System.in);
		int tmp;
		int x;
		int y;
		
		System.out.print("x값을 입력하세요 : ");
		x=scan.nextInt();

		
		System.out.print("y값을 입력하세요 : ");
		y=scan.nextInt();
		tmp=x;
		x=y;
		y=tmp;
		
		
		
		System.out.println("x값은"+x+"입니다");
		
		System.out.println("y값은"+y+"입니다");
		
		
		

				
				
		
	}

}
