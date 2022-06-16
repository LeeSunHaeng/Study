import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {

		/*
		 int num1, num2, num3, num4, num5;
		 
		 Array : 배열. 같은 자료형 변수들 묶음. <-변수들
		 		 목적 -> 변수관리	
		 형식   : 
		 			자료형 배열변수명[] = new 자료형[배열의 총 갯수];
		 			배열변수명[index number]
		 			
		 			int arrName[] = new int[5];
		 						   동적(dynamic)할당  정적(static)
		 			arrName[0] = 11;
		 			arrName[1] = 22;
		 			arrName[2] = 33;
		 			arrName[3] = 44;
		 			arrName[4] = 55;
		 			   
		 */
		//int array[] = new int[5];
		//int []array = new int[5];
		int[] array = new int[5];  // 자동적으로 각 인덱스에 0 입력됨.
		
		System.out.println(array); // 36aa7bc2 <-- heap 영역의 주소
		System.out.println(array.length);
		int num1;
		num1 = 4;
		
		System.out.println(num1);
		System.out.println(array[0]);
		
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;
		array[3] = 44;
		array[4] = 55;
		System.out.println(array[2]);  // 배열의 2번 인덱스 값을 출력
		System.out.println(Arrays.toString(array)); // 배열의 모든 요소를 보고싶을때
		
		//선언 & 초기화
		int number = 0; //선언과 동시에 초기화
		number = 1; //값의 갱신
		
		// 배열 선언&초기화
		int Array[] = {111, 222, 333, 444, 555};
					// 0    1	 2    3    4   
		System.out.println(Array[1]); // Array 배열의 2번 인덱스 값을 출력
		
		
		char chArr[] = {'h','e','l','l','o'};
		System.out.println(chArr.length);
		System.out.println(Arrays.toString(chArr));
		
		System.out.println(chArr); // 문자열로 인식해서 주소값이 안나옴
		
		char c = 'A';
		System.out.println(c);
		System.out.println((int)c);// <<65가 나오는데 ASCII코드임
		
		String strArr[] = {"홍길동", "이선행", "권민영", "일지매"};
		System.out.println(strArr[2]);
		
	}

}
