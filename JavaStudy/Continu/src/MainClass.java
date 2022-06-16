
public class MainClass {

	public static void main(String[] args) {
		/*
		 	continu : skip(생략)
		 	
		 	loop문과 같이 사용한다.
		 	
		 	while( 조건문 ) {
		 		
		 		처리1
		 		
		 		처리2
		 		
		 		if(조건){
		 			continue;
		 		}
		 		
		 		처리3    <-조건이 true면 이 처리는 되지 않는다.
		 */
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i = "+i);
			
			System.out.println("for start");
			
			if(i>3) {
				continue;
			}
			System.out.println("for end");
			
		}
	}

}
