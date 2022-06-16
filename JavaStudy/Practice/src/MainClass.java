import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		/*  문제
		 편의점
		 지불금액 : 3210원
		 본인금액 : 10000월
		 
		 거스름돈 ->?
		 5000원 ->?장
		 1000원 ->?장
		  500원 ->?개
		  100원 ->?개
		   50원 ->?개
		   10원 ->?개
		 */
		
	/*	int price = 3210;
		int pay = 10000;
		int money;
		money=pay-price;
		int namogy;
		
		System.out.println("거스름돈은 : "+money+"원 입니다.");
		
		System.out.println("5000원권 -> "+money/5000+"장");
		namogy=money%5000;
		System.out.println("1000원권 -> "+namogy/1000+"장");
		namogy=namogy%1000;		
		System.out.println("500원권 -> "+namogy/500+"개");
		namogy=namogy%500;
		System.out.println("100원권 -> "+namogy/100+"개");
		namogy=namogy%100;
		System.out.println("50원권 -> "+namogy/50+"개");
		namogy=namogy%50;
		System.out.println("10원권 -> "+namogy/10+"개");
		*/
		Scanner scan = new Scanner(System.in);
		System.out.print("가격을 입력해주세요 : ");
		int price2 = scan.nextInt();
		System.out.print("지불 금액을 입력해 주세요 : ");
		int pay2 = scan.nextInt();
		int change =pay2-price2;

	/*	int a =change/5000;
		int b =(change-5000)/1000;
		int c =(change-5000*a-1000*b)/500;
		int d =(change-5000*a-1000*b-500*c)/100;
		int e =(change-5000*a-1000*b-500*c-100*d)/50;
		int f =(change-5000*a-1000*b-500*c-100*d-50*e)/10;
		int bill[] = {a, b, c, d, e, f};
		System.out.println("거스름돈은 "+change+"원 입니다.");
		System.out.println("5000원권 -> "+bill[0]+"개");
		System.out.println("1000원권 -> "+bill[1]+"개");
		System.out.println(" 500원권 -> "+bill[2]+"개");
		System.out.println(" 100원권 -> "+bill[3]+"개");
		System.out.println("  50원권 -> "+bill[4]+"개");
		System.out.println("  10원권 -> "+bill[5]+"개");
		*/
		
		int a =change/5000;
		int b =(change/1000)%5;
		int c =(change/500)%2;
		int d =(change/100)%5;
		int e =(change/50)%2;
		int f =(change/10)%5;
		int bill[] = {a, b, c, d, e, f};
		System.out.println("거스름돈은 "+change+"원 입니다.");
		System.out.println("5000원권 -> "+bill[0]+"개");
		System.out.println("1000원권 -> "+bill[1]+"개");
		System.out.println(" 500원권 -> "+bill[2]+"개");
		System.out.println(" 100원권 -> "+bill[3]+"개");
		System.out.println("  50원권 -> "+bill[4]+"개");
		System.out.println("  10원권 -> "+bill[5]+"개");
	}

}
