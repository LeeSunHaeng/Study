import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {

	public static void main(String[] args) {
		File file = new File("d:\\myfile\\writeData.txt");
		
		try {
			/*
			FileWriter fw = new FileWriter(file);
			fw.write("안녕하세요");
			fw.write("hi hello");
			fw.close();
			*/
			
			//추가쓰기
			/*
			FileWriter fw = new FileWriter(file,true);
			fw.write("반갑습니다");
			fw.write("근데 누구세요");
			fw.close();
			*/
			
			//문장쓰기
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println("안녕하세요");
			pw.println("nice to meet you");
			pw.println("건강하세요");
			
			pw.close();
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
