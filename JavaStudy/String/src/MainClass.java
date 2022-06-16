
public class MainClass {

	public static void main(String[] args) {
		
		/*
		 	String : Wrapper Class
		 			 char[] 
		 			 문자열 편집, 정보 취득 등등
		 */
		
		String str;
	// String : class 명칭
	// str 	  : class 변수 == object(객체)
		
		str = "안녕하세요";
		System.out.println(str);
		
		//정석대로
		String str1 = new String("안녕하세요");
		String str2 = "반갑습니다";
		
		// 문자열의 결합
		String str3 = str1+str2;
		System.out.println(str3);
		
		str3 = str3 + "건강하세요";
		System.out.println(str3);

		// equals :  문자열을 비교
		String str4 = "world";
		String str5 = "worl"; 
		str5 = str5 +"d";
		
		if(str4 == str5) { // ==는 주소를 비교함 equals 써야함
			System.out.println("같은 문자열 입니다.");
		}
		boolean b  = str4.equals(str5); //equals 문자열의 문자 하나하나 비교해서 정확함
		
		if(b==true) {
			System.out.println("같은 문자열입니다.");
			
		}
		else {
			System.out.println("다른 문자열입니다.");
		}
		
		
		
		if(str4.equals(str5)) {
			System.out.println("같은 문자열입니다.");
			
		}
		else {
			System.out.println("다른 문자열입니다.");
		}
		
		// indexOf : 문자의 위치를 돌려 준다      	hello world
		// lastIndexOf : 
		String str6 = "hello world";
		int index = str6.indexOf("h");
		System.out.println(index);
		
		int lastIndex = str6.lastIndexOf("o");
		System.out.println(lastIndex);
		
		//length : 문자열의 길이
		
		int len = str6.length();
		System.out.println(len);
		
		// replace : 수정
		String str7 = "A*B*C*D";
		String repStr = str7.replace("*", "");
		System.out.println(repStr);
		
		//split : 문자열을 자름			홍길동-24-2001/05/14-서울시 <<여기서 '-'는 : token
		
		String str8 = "홍길동-24-2001/05/14-서울시";
		String spStr[] = str8.split("-");
		/*
		System.out.println(spStr[0]);
		System.out.println(spStr[1]);
		System.out.println(spStr[2].replace("/","-"));
		System.out.println(spStr[3]);
		*/
		for (int i = 0; i < spStr.length; i++) {
			System.out.println(spStr[i]);
			
		}
		
		// substring : 문자열을 범위로 자른다
		String str9 = "안녕 반가워요 건강해요";
		
		String subStr = str9.substring(3,7);  //(시작위치, 이 위치 전까지)
		System.out.println(subStr);
		
		//toUpperCase() : 모두 대문자로 변환
		String str10="abc DEF";
		String upStr = str10.toUpperCase();
		System.out.println(upStr);
		
		//toLowerCase() : 모두 소문자로 변환
		String lowStr = str10.toLowerCase();
		System.out.println(lowStr);
		
		//trim : 문자열의 앞뒤에 공백을 제거
		String str11 = "    java  java   java           ";
		String trimStr = str11.trim();
		System.out.println(trimStr);
		
		//charAt : 문자열의 인덱스 값을 넣으면 그에 해당하는 문자가 출려됨
		String str12= "가나다라마";
		char c= str12.charAt(2);
		String str22 = str12.charAt(2)+str12.charAt(3)+"";
		System.out.println(c);
		
		//contains : 컨테이너
		String str13 = "서울시 마포구 서교동";
		boolean b1 = str13.contains("구 서");
		System.out.println(b1);
		
		
			
	}

}
