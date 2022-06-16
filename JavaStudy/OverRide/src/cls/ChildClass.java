package cls;

public class ChildClass extends ParentClass {
	/*	OverRid 하는 이유
		1.상속받은 함수를 고쳐 작성하여 사용.
		
	 
	 */
	 
	@Override
	public void pMethod() {
		super.pMethod();
		
		System.out.println("ChildClass pMethod()");
	}
	
	public void func() {
		pMethod();
	}
}
