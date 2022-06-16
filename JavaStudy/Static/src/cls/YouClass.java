package cls;

public class YouClass {
	int number;
		public void memberMethod() {
			System.out.println("YouClass memberMethod()");	
		}
		
		public static void staticMethod() {
			System.out.println("YouClass staticMethod()");	

				//멤버변수
			//number =1;
			//memberMethod();
			//this
			//super
		}
		
		public static void swap(int arr[],int i, int j) {
			
			int temp= arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		
}
