import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	break == 탈출 escpae
		 			 loop를 멈춘다
		 			 
		 	switch, for, while, do while
		 	
		 	swicth(variable){
		 		case value :
		 			processing
		 			break;
		 	}
		 	
		 	for(int i = 0; i<100; i++){    //0...99
		 		if(조건){
		 			break;
		 			
		 		}
		 	}
		 	
		 	while(w<100){
		 		
		 		if(조건){
		 		break;
		 		}
		 		w++;
		 	}
		 */
	/*	
		for (int i = 0; i < 10; i++) {
			System.out.println("For loop"+ i);
			if(i==5) {
				break;
			}
		}

		int array[] = {1, 3, -7, 2, 8}
		for (int i = 0; i < array.length; i++) {
			System.out.println("array["+i+"] = " +array[i]	;
			if(array[i]<0)){
				break;
			}
		}
		/**/
		
		Scanner sc = new Scanner(System.in);
		
		int number;
		
		while(true) {
		System.out.print("숫자를 입력해 주세요(0<) :");
		number = sc.nextInt();
		
		if(number>0) {
			break;
		}
		System.out.println("양수를 입력해 주십시오");
		}
		
		for(int i = 0; i<10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j<8; j++) {
				System.out.println("\tj =" +j);
				
				if(i==5 && j==3) {
					break;
				}
			}
		}
		//boolean을 이용한 탈출
		boolean b =false;
		
		for(int i = 0; i<10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j<8; j++) {
				System.out.println("\tj =" +j);
				
				if(i==5 && j==3) {
					b=true;
				}
				if(b==true) {
					break;
				}
			}
			if(b==true) {
				break;
			}
		}
		
		
		
		//break를 셋팅
		
		out:for(int i = 0; i<10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j<8; j++) {
				System.out.println("\tj =" +j);
				
				if(i==4 && j==5) {
					break out;
				}
			}
		}
	}

}
