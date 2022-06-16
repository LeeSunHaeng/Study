import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
	/*
	 Array : 같은 자료형의 묶은 변수들.
	 		 접근 및 관리는 index로 된다. 0 ~ Arrat.length-1
	 		 int Arr[] = new int[5]; //0 ~ 4
	 		 동적으로 할당한 후에 정적으로 사용
	 		 	 		 
	 		 1차원 0-0-0-0-0
	 		 int Array[] = {1, 2, 3, 4, 5};
	 		 

	 		 2차원 0-0-0-0-0
	 		      0-0-0-0-0
	 		      0-0-0-0-0
	 		      0-0-0-0-0
	 		 int Array2[][] = new int[3][4]; 
	 		 int []Array2[] = new int[3][4]; 
	 		 int [][]Array2 = new int[3][4]; 
	 		 
	 		       0-0-0-0
	 		       0-0-0-0
	 		       0-0-0-0
	 		 //초기화
	 		 int Array2[][] = {
	 		 {1, 2, 3, 4},
	 		 {5, 6, 7, 8},
	 		 {9, 10, 11, 12}
	 		 };      
	 		      
	 */	 	
	
		int Array2[][] = new int [3][4];
		Array2[0][0] = 1;
		Array2[0][1] = 2;
		Array2[0][2] = 3;
		Array2[0][3] = 4;
		
		Array2[1][0] = 5;
		Array2[1][1] = 6;
		Array2[1][2] = 7;
		Array2[1][3] = 8;
		
		Array2[2][0] = 9;
		Array2[2][1] = 10;
		Array2[2][2] = 11;
		Array2[2][3] = 12;
		
		System.out.println(Arrays.toString(Array2[0]));
		
		//2차원 배열의 초기화
		
		int Array23[][] = {
				{1, 2},
				{3, 4},
				{5, 6},
		};
		
		System.out.println(Array23[1][1]);
		System.out.println(Array23[2][1]);
		
		System.out.println(Array23.length);
		System.out.println(Array23[0].length);
		
	}

}
