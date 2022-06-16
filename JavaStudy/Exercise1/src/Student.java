
public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	
	/*
	int getTotal(int a,int b ,int c){
		
		total = a+b+c;	
		
		return total;
	}
	double getAverage() {
		
		
		return (double)total / 3;
	}
	*/
	
	int getTotal(int kor, int eng, int math) {
		this.kor =kor;
		this.eng=eng;
		this.math=math;
		return kor+eng+math;
	}
	
	double getAverage() {
		return (double)(kor+eng+math)/3;
	}
	
	
	
	
	
	
	
	
	
	
	
}
