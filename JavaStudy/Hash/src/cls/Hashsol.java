package cls;

import java.util.HashMap;
import java.util.Map;

public class Hashsol {
	String [] participant = {"mislav", "stanko", "mislav", "ana"};
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<Integer,String> com = new HashMap<Integer,String>();
        Map<Integer,String> list = new HashMap<Integer,String>();
        for(int i = 0; i<participant.length; i++){
            com.put(i,participant[i]);           
        }
        for(int j = 0; j<completion.length; j++){
            list.put(j,participant[j]);           
        }
        int i =0;
        int j =0;
        while(com.size()==1) {
        	while(j<completion.length) {
        	if(com.get(i).equals(completion[j])){
        		com.remove(i);
        		list.remove(j);
        		
        		break;
        	}
        }
        }
        int num=0;
        for (int j2 = 0; j2 < participant.length; j2++) {
			if(!com.get(i).equals(null)) {
				num=i;
			}
		}
        answer = com.get(num);
        return answer;
    }
}
