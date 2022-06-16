package main;

public class practice {

	public static void main(String[] args) {
		String answer = "";
		String hand = "left";
		int [] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		 int [] leftPoint = {3,0};
	        int [] rightPoint = {3,2};
	        String [][] num = {
	            {"1","2","3"},
	            {"4","5","6"},
	            {"7","8","9"},
	            {"*","0","#"}
	        };

	        int i =0;
	        int x; int y; double ld; double rd;
	        while(i<numbers.length) {
	        	
	        	switch(numbers[i]) {
	        	
	        	case 1 : leftPoint[0] = 0;
						 leftPoint[1] = 0;
						 answer = answer+"L";
						 break;
						 
	        	case 4 : leftPoint[0] = 1;
						 leftPoint[1] = 0;
						 answer = answer+"L";
						 break;
						 
	        	case 7 : leftPoint[0] = 2;
						 leftPoint[1] = 0;
						 answer = answer+"L";
						 break;
						 
	        	case 3 : rightPoint[0] = 0;
	        			 rightPoint[1] = 2;
						 answer = answer+"R";
						 break;
						 
	        	case 6 : rightPoint[0] = 1;
	        			 rightPoint[1] = 2;
	        			 answer = answer+"R";
	        			 break;
				 
	        	case 9 : rightPoint[0] = 2;
	        			 rightPoint[1] = 2;
	        			 answer = answer+"R";
	        			 break;
	        	
	        	case 2 : 
	        			 x = (int)Math.pow((1-leftPoint[1]), 2);
	        			 y = (int)Math.pow((0-leftPoint[0]), 2);
						 ld = Math.sqrt(x+y);
						 
	        			 x = (int)Math.pow((1-rightPoint[1]), 2);
	        			 y = (int)Math.pow((0-rightPoint[0]), 2);
						 rd = Math.sqrt(x+y);
						 
						 
						 
						 if(ld>rd) {
							rightPoint[0] = 0;
							rightPoint[1] = 1;
							answer = answer+"R";
							break;
						 }
						 else if(ld<rd) {
							leftPoint[0] = 0;
							leftPoint[1] = 1;
						    answer = answer+"L";
						    break;
						 }
						 else if(ld == rd) {
							 if(hand.equals("left")) {
								 leftPoint[0] = 0;
								 leftPoint[1] = 1;
							     answer = answer+"L";
							     break;
							 }
							 else if(hand.equals("right")) {
								 rightPoint[0] = 0;
								 rightPoint[1] = 1;
								 answer = answer+"R";
								 break;
							 }
						 }
						 
	        	case 5 :
			   			 x = (int)Math.pow((1-leftPoint[1]), 2);
			   			 y = (int)Math.pow((1-leftPoint[0]), 2);
							 ld = Math.sqrt(x+y);
							 
			   			 x = (int)Math.pow((1-rightPoint[1]), 2);
			   			 y = (int)Math.pow((1-rightPoint[0]), 2);
							 rd = Math.sqrt(x+y);
							 
							 if(ld>rd) {
								rightPoint[0] = 1;
								rightPoint[1] = 1;
								answer = answer+"R";
								break;
							 }
							 else if(ld<rd) {
								leftPoint[0] = 1;
								leftPoint[1] = 1;
							    answer = answer+"L";
							    break;
							 }
							 else if(ld == rd) {
								 if(hand.equals("left")) {
									 leftPoint[0] = 1;
									 leftPoint[1] = 1;
								     answer = answer+"L";
								     break;
								 }
								 else if(hand.equals("right")) {
									 rightPoint[0] = 1;
									 rightPoint[1] = 1;
									 answer = answer+"R";
									 break;
								 }
							 }
							 
	        	case 8 :
			   			 x = (int)Math.pow((1-leftPoint[1]), 2);
			   			 y = (int)Math.pow((2-leftPoint[0]), 2);
							 ld = Math.sqrt(x+y);
							 
			   			 x = (int)Math.pow((1-rightPoint[1]), 2);
			   			 y = (int)Math.pow((2-rightPoint[0]), 2);
							 rd = Math.sqrt(x+y);
							 
							 if(ld>rd) {
								rightPoint[0] = 2;
								rightPoint[1] = 1;
								answer = answer+"R";
								break;
							 }
							 else if(ld<rd) {
								leftPoint[0] = 2;
								leftPoint[1] = 1;
							    answer = answer+"L";
							    break;
							 }
							 else if(ld == rd) {
								 if(hand.equals("left")) {
									 leftPoint[0] = 2;
									 leftPoint[1] = 1;
								     answer = answer+"L";
								     break;
								 }
								 else if(hand.equals("right")) {
									 rightPoint[0] = 2;
									 rightPoint[1] = 1;
									 answer = answer+"R";
									 break;
								 }
							 }
							 
	        	case 0 :
			   			 x = (int)Math.pow((1-leftPoint[1]), 2);
			   			 y = (int)Math.pow((3-leftPoint[0]), 2);
							 ld = Math.sqrt(x+y);
							 
			   			 x = (int)Math.pow((1-rightPoint[1]), 2);
			   			 y = (int)Math.pow((3-rightPoint[0]), 2);
							 rd = Math.sqrt(x+y);
							 
							 if(ld>rd) {
								rightPoint[0] = 3;
								rightPoint[1] = 1;
								answer = answer+"R";
								break;
							 }
							 else if(ld<rd) {
								leftPoint[0] = 3;
								leftPoint[1] = 1;
							    answer = answer+"L";
							    break;
							 }
							 else if(ld == rd) {
								 if(hand.equals("left")) {
									 leftPoint[0] = 3;
									 leftPoint[1] = 1;
								     answer = answer+"L";
								     break;
								 }
								 else if(hand.equals("right")) {
									 rightPoint[0] = 3;
									 rightPoint[1] = 1;
									 answer = answer+"R";
									 break;
								 }
							 }
						 
						 
	        		
	        	}
	        	
	        	i++;
	        }
	        
	        System.out.println(answer);

	}

}
