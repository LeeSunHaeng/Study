package study22;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		int array [] = {9,6,5,4,7,8,1,2,3};
		int [][] commands = {
				{1,4,2},
				{2,8,3},
				{3,9,4},
				{1,9,3}
		};


	
	
	

	        int[] answer = new int[commands.length];
	        int count =0;
	        for(int i = 0; i<commands.length; i++){
	           int proto[]= new int[commands[i][1]-commands[i][0]+1];
	            for(int j = 0; j<array.length; j++){
	                if(commands[i][0] <= j+1 &&  j+1 <= commands[i][1]){
	                    proto[count] =array[j];
	                    count++;
	                }
	            }
	            count =0;
	            int temp=0;
	            for(int k =0; k<proto.length-1; k++){
	                for(int n = k+1; n<proto.length; n++){
	                    if(proto[k]>proto[n]){
	                        temp=proto[k];
	                        proto[k]=proto[n];
	                        proto[n]=temp;
	                            
	                    }
	                }
	            }
	            
	            answer[i] = proto[commands[i][2]-1];
	            
	        }
	        
	        System.out.println(Arrays.toString(answer));

	    
	
	}
}
	
	


