package edu.fdiazaguirre.interviews;

public class AppleFarm {

	public int calculateApples(int apples, int fences){
		int applesAccum = apples;
		
		for (int i = 0; i < fences; i++) {
			// * 2 => to have enough to share half of the apples
			// + 1 => to satisfy only full apples request
			applesAccum = applesAccum * 2 + 1;
		}
		
		return applesAccum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppleFarm af = new AppleFarm();
		System.out.println(af.calculateApples(1, 3));
		System.out.println(af.calculateApples(1, 2));
		System.out.println(af.calculateApples(2, 2));
	}

}
