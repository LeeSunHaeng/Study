
public class MainClass {

	public static void main(String[] args) {
		/*
		 	loop
		 	
		 	for(초기화; 조건식; 연산식;){
		 		처리
		 	}
		 	
		 	초기화
		 	while(조건식){      if(조건식) // > < >=
		 		  처리
		 		  연산식
		 	}
		 	
		 	초기화
		 	do{
		 		처리
		 		연산식
		 	}while(조건식);
		 	
		 	
		 */
		
		int w;
		w =0;  //초기화는 밖에 있어야함.
		while(w<0) {
			System.out.println("while loop");
			
			w++;
		}
		/*
		int count = 0;
		while( true ) {
			count++;
			System.out.println(count);
		}
		*/
		
		/*
		 	Program
		 	
		 	초기화 - initialize
		 	
		 	메인 - loop(무한루프)
		 	
		 	해방(메모리) - release
		 */
		
	/*	int dw;
		
		dw = 0;
		
		do {
			System.out.println("do While loop" + dw);
			dw++;
		}while(dw < 10);
		*/
		
		//2중 while 구구단
		
		int i = 1;
		int j = 1;
		while(i<10) {
			while(j<10) {
				System.out.print(i+"x"+j+"="+i*j+" ");
				j++;
			}
			j=1;
			System.out.println();
			i++;
		}
		
	}

}
