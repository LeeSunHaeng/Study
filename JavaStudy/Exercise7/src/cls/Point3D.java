package cls;

public class Point3D {
	int x,y,z;
	Point3D(int x, int y, int z) {
	this.x=x;
	this.y=y;
	this.z=z;
	}
	Point3D() {
	this(0,0,0);
	}
	public boolean equals(Object obj) {
	/*
	(1) 인스턴스변수 x, y, z를 비교하도록 오버라이딩하시오.
	*/
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
