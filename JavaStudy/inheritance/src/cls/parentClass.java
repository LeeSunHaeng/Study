package cls;

public class parentClass {
	private int number;
	protected String name;
	
	public void ParentMethod(){
		System.out.println("ParentClass parentMethod()");
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
