package cls;

import singleton.Singleton;

public class HeClass {
	private String sweet;
	
	public void change() {
		Singleton s = Singleton.getInstance();
		sweet =  s.sweet;
	}
}
