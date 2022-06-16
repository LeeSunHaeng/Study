import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		File file = new File("d:\\myfile\\newfile.txt");

		//파일 읽기
		//한글자씩 읽기
		try {
			/*
			FileReader fr = new FileReader(file);
			int ch = fr.read();
			while(ch!=-1) {
				System.out.println((char)ch);
			ch=fr.read();
			}
			fr.close();
			*/
			
			//문장으로 읽기
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String str;
			while((str = br.readLine()) !=null){
				System.out.println(str);
			}
			br.close();
			
			
		 }catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

}
