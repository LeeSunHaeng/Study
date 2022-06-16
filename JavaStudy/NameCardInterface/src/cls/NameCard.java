package cls;

import inter.PrintInterface;

public class NameCard {

	String name;
	String phone;
	String email;
	
	PrintInterface printinterface;
	
	public NameCard(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public void setPrintCard(PrintInterface p) {
		printinterface = p;
	}
	public void print() {
		printinterface.print(this);
	}
	
}
