package singleton;

public class Singleton {

	private static Singleton single = null;
	
	public int number;
	public String name;
	public String sweet;
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		return single;	//single ton -> 1개의 instance만 사용한다
	}
}
