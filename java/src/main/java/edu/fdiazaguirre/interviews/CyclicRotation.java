package edu.fdiazaguirre.interviews;

public class CyclicRotation {

	
	public static int[] solution(int[] A, int K) {
        K = K % A.length;
        if (K == 0) {
			return A;
		}
		int i = 0;
		while (i < A.length) {
			int v = A[0], pos = i+K -1;
			if (pos >= A.length) {
			    pos = pos - A.length;
			}
			System.out.println(pos);
			A[0] = A[pos]; 
			A[pos] = v;
			i++;
		}
		if ( i == A.length - 1) {
		 A[0] = A[i];
		}
		
		return A;
    }
}
