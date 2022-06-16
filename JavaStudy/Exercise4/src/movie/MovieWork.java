package movie;

public class MovieWork extends Movie{

	private int qualitiy;	//작품성
	private int popular;	//대중성
	private int script;		//대본
 

	
	
	public MovieWork(String title, int director, int acter,int qualitiy,int popular, int script) {
		super(title, director, acter);

		this.qualitiy = qualitiy;
		this.popular = popular;
		this.script = script;
	}


	@Override 
	public void display() { //여기를 구현하세요. 
		int total =director+qualitiy+popular+script+acter;
		System.out.println("영화제목 : " + this.title);
		System.out.println("감독:" + this.director+", "+"배우:" + this.acter+", "+"작품성:" + this.qualitiy+", "+"대중성:" + this.popular+", "+"대본:" + this.script+", ");
		System.out.println("영화총점 : " + total);
		System.out.println("영화평점 : " + "☆☆☆☆☆");
	}
}
