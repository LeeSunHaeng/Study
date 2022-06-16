import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainClass {

	public static void main(String[] args) {

		//NullPointException : 동적 할당이 안된 경우
		String str = null;
		try {
			System.out.println(str.length());
		}catch(NullPointerException e) {
			e.printStackTrace();
			//System.out.println("str은 할당되지 않았습니다.");
		}
		
		
		//ArrayIndexOutOfException : 배열 범위가 초과한 경우
		int [] array = {1, 2, 3};
		
		try {
			array[3] = 'a';
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		//FileNotFoundException : 불러오려는 파일이 없는 경우
		File file = new File("d:\\xxx");
		FileInputStream is;
		
		try {
			is = new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//StringIndexOutOfException : 문자열의 길이가 넘어간 경우
		String str1 = "java";
		
		try {
			str1.charAt(4);
		}catch(StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		//NumberFormatException : 숫자가 아닌 경우
		boolean b =false;
	
				
		try {
		int number =Integer.parseInt("12a");
		}catch (NumberFormatException e) {
			e.printStackTrace();
			b=true;
		}

	}

}
