package cls;

import inter.PrintInterface;

public class PrintNameCard implements PrintInterface{

	@Override
	public void print(NameCard nc) {
		System.out.println("이름 : "+nc.name);
		
	}

}
