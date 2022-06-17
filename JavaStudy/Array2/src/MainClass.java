import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
	/*
	 Array : 媛숈� �옄猷뚰삎�쓽 臾띠� 蹂��닔�뱾.
	 		 �젒洹� 諛� 愿�由щ뒗 index濡� �맂�떎. 0 ~ Arrat.length-1
	 		 int Arr[] = new int[5]; //0 ~ 4
	 		 �룞�쟻�쑝濡� �븷�떦�븳 �썑�뿉 �젙�쟻�쑝濡� �궗�슜
	 		 	 		 
	 		 1李⑥썝 0-0-0-0-0
	 		 int Array[] = {1, 2, 3, 4, 5};
	 		 

	 		 2李⑥썝 0-0-0-0-0
	 		      0-0-0-0-0
	 		      0-0-0-0-0
	 		      0-0-0-0-0
	 		 int Array2[][] = new int[3][4]; 
	 		 int []Array2[] = new int[3][4]; 
	 		 int [][]Array2 = new int[3][4]; 
	 		 
	 		       0-0-0-0
	 		       0-0-0-0
	 		       0-0-0-0
	 		 //珥덇린�솕
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
		
		//2李⑥썝 諛곗뿴�쓽 珥덇린�솕
		
		int Array23[][] = {
				{1, 2},
				{3, 4},
				{5, 6},
		};
		
		System.out.println(Array23[1][1]);
		System.out.println(Array23[2][1]);
		
		System.out.println(Array23.length);
		System.out.println(Array23[0].length);
		System.out.println(Array23[2].length);
		System.out.println(Array23[3].length);
		
	}

}
