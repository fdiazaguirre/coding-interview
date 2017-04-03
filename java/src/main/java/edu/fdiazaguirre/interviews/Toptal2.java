package edu.fdiazaguirre.interviews;

public class Toptal2 {
	private static final int MIN = -100000000;
	private static final int MAX = 100000000;

	public static int solution(int A, int B) {
		int result = 0;
		// fail fast
		if (isNotInRange(A) || isNotInRange(B)) {
			return -1;
		}
		
		return result ;
	}

	private static boolean isNotInRange(int n) {
		// swap the booleans
		return (n < MIN || n > MAX) ? true : false;
	}
	
}
