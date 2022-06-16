package fileWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {

		// String data 3개 저장
		File newFile = new File("D:\\workfile\\creat.txt");
		
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String human[] = {"홍길동", "24", "서울시"};
		String data[] = {"apple","banana","tomato"};
		try {
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			int i=0;
			while(i<3) {
				pw.println(human[i]);
				i++;
			}
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(newFile));
			String str ;
			String student[] = new String[3];
			try {
				int i = 0;
				while((str=br.readLine()) != null) {
					student[i]=str;
					i++;
				}
				System.out.println(Arrays.toString(student));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		
		
		// String data 3개 불러오기 -> 배열에 저장
		
		
		

		//파일에 저장 -> println 을 한번사용해서 저장
		
		//파일에서 불러오기 -> 배열에 입력(임의의 배열) 배열[0] -> 이름, 배열[1] -> 나이, 배열[2] -> 주소
		
		//-----------------------------
		
		//함수화
	}

}
