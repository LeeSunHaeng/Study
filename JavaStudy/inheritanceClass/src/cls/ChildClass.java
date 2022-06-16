package cls;

public class ChildClass extends ParentClass {
	
	private double height;
	
	public ChildClass() {
		super(123,"hello");
		System.out.println("cls ChildClass()");
	}

	public ChildClass(double height) {
		super(234,"good");
		this.height = height;
	}
	
	public ChildClass(int number, String name, double height) {
		super(number,name);
		this.height =height;
	}
}
