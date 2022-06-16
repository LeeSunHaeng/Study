
public class MainClass {

	public static void main(String[] args) {
	
		/* 
		   loop문, 순환문, 반복문
		   
		   for : 지정 회수에 따라서 반복하는 제어문
		   
		   형식 : 
		   			변수 선언
		   			
		   			for(변수의 (선언)초기화; 조건식; 연산식){
		   					
		   				처리
		   			}
		   			
		   			for(	;		;		;){
		   			
		 */
	/*
		String name[] = {"홍길동", "일지매", "성춘향", "홍두께"};
		//성춘향을 찾아라
		int number =0;
		for(int i =0; i<name.length;i++) {
			number++;
			if(name[i].equals("성춘향")) {
				System.out.println("찾았습니다.");
				System.out.println("번호는"+number+"입니다.");
			}
		}
	
		
		int arr[] = {90,75,85,95,80};
		int top =arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(top<arr[i]) {
				top=arr[i];
			}
		}
		System.out.println(top);
		
		// for each
		for (String nam : name) {
			System.out.print(nam + " ");
			
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i = "+i);
			
			for(int j = 0; j<5; j++) {
				System.out.println("\tj = "+j);
			}
			
		}
		*/
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print( i + "x" + j + "=" + i*j + " ");
			}
			System.out.println();
		}
		
		int array2[][] = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34}
		};
		
		for (int i = 0; i < array2.length; i++) {
			
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j] + " ");
				
			}
			System.out.println();
			
		}

	}

}
