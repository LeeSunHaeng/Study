package cls;

import singleton.Singleton;

public class YouClass {
	private int total;
	private	String name;
	private String sweet;
	public void func() {
		Singleton s = Singleton.getInstance();
		
		total = s.number;
		name = s.name;
		s.sweet = sweet;
	}
	public void YouClass() {
		sweet = "스크류바";
	}
	

//	public void setTotal(int total) {
//		this.total = total;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return "YouClass [total=" + total + ", name=" + name + "]";
	}


	
	
}
