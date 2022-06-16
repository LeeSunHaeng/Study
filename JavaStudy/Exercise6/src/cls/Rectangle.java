package cls;

public class Rectangle extends Shape {
	double width;	//폭
	double height;	//높이
	
	public Rectangle(double width, double height) {

		this.width = width;
		this.height = height;
	}
	
	public boolean isSquare() {
		if(width==height) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	double calcArea() {
		
		return width*height;
	}
}
