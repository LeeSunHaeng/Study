package health;

public class HealthRate extends Health {
		double SW;
		double B;
	
	public HealthRate(String name, double height, double weight) {
		super(name,height,weight);
	}
	public double swCheck() {
		SW=(height-100)*0.9;
		return SW;
	}
	
	public String bCheck() {
		B=(weight-swCheck())/swCheck()*100;
		String a = " ";
		if(B<10) {
			a="정상입니다";
		}
		else if(B>=10 && B<20) {
			a="과체중입니다.";
		}
		else if(B>=20) {
			a="비만입니다.";
			}
		return a;
	}
	public void prn() {
		super.prn();
		System.out.println(bCheck());
				
		
	}
}
