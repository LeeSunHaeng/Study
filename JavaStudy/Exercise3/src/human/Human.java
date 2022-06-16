package human;

public class Human {
	String name;
	int age;
	int height;
	int weight;

	public Human() {
	}

	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String toString() {
		String data = name + "\t" + age + "\t" + height + "\t" + weight;
		return data;
	}

}
