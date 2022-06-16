
public class MyClass {

	public static void main(String[] args) {
		/*
		 	switch : if문과 비슷하다.
		 			 값이 명확해야 한다.(
		 			 ->범위를 지정할 수 없다.)
		 			 실수를 사용할 수 없다. ex)0.152
		 			 
		 			//이런 형식 
		 			 if(number ==1){
		 			 }
		 			 else if(number == 2){
		 			 }
		 			 
		 	형식 :
		 		  switch( 대상이 되는 변수 == 값1 ){
		 		  
		 		  case 값1:
		 		  		   처리1
		 		  break;
		 		  
		 		  case 값2:
		 		  		   처리2
		 		  break;
		 		  
		 		  default :  
		 		  	모든 case에 해당 값이 없을 경우의 처리
		 		  	break;
		 		  }
		 		  
		 			 
		 */
		
		int number =2;
		switch(number) {
			case 1 :
				System.out.println("number는 1입니다");
				break;
				
			case 2 :
				System.out.println("number는 2입니다");
//				break;	
				
			case 3 :
				System.out.println("number는 3입니다");
				break;
				
//			case number > 0 :
//				break;
				
			case 4 :
				System.out.println("number는 4입니다");
				break;	
				
			default :
				System.out.println("맞는 숫자가 없습니다.");
				break;
		}
		
		double d = 1.2;
		
//		switch( d ) {
//		
//		}

	}

}
