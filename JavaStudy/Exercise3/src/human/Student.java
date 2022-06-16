package human;

public class Student extends Human {
	private String number;
	

	public Student(String name, int age, int height, int weight, String number) {
		super(name, age, height, weight);
		this.number=number;
	}

	public String toString() {
		return super.toString() + "\t" + this.number;

}
}
