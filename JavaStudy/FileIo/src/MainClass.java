import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	File : 저장 매체.
		 			Database(file)
		 */
		File file = new File("c:\\");
		
		//파일 조사
		/*
		String filelist[] = file.list();
		
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		//파일?폴더? 조사하는 코드
		/*
		File filelist[] = file.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			}
			
		}
		*/
		
		//파일 생성
		File newFile = new File("d:\\myfile\\newfile.txt");
		
	try {
		if(newFile.createNewFile()){
			System.out.println("파일을 생성 성공입니다.");		
		}else {
			System.out.println("파일을 생성 실패입니다.");
		}
	}catch (IOException e) {
			System.out.println("파일을 생성하지 못했습니다.");
	}
		
		File newDir = new File("d:\\myfile\\myimage");
		if(newDir.mkdir()) {
			System.out.println("폴더 생성 성공!");
		}else {
			System.out.println("폴더 생성 실패!");
		}
		
		//file 존재 여부
		if(newFile.exists()) {
			System.out.println("newfile.txt가 존재합니다.");
		}else {
			System.out.println("newfile.txt가 존재하지 않습니다.");
		}
		
		//읽기전용으로 만들기
	//	newFile.setReadOnly();
		
		//쓰기 가능 여부
		if(newFile.canWrite()) {
			System.out.println("쓰기 가능합니다.");
		}else {
			System.out.println("쓰기 불가능 합니다.");
		}
		
		//파일 삭제
		//newFile.delete();
	}

}
