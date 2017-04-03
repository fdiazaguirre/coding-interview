package edu.fdiazaguirre.interviews;

public class BinaryGap {

	public static int solution (int N) {
		if (N < 5) {
			return 0;
		}
		int exp = (int) (Math.log(N) / Math.log(2));
		double remainder = N - Math.pow(2, exp);
		byte binaryRepresentation[] = new byte[exp];
		
		//Initialize binaryRepresentation.
		binaryRepresentation[exp -1] = 1;
		// Actually there is no need to do this but,
		// since the memory space is already being used does not harm. 
		for (int i = 0; i < exp; i++) {
			binaryRepresentation[i] = 0;
		}
		
		// Compute remaining values.
		int nexp, dist, maxDist = 0;
		while (remainder > 0) {
			nexp = (int) (Math.log(remainder) / Math.log(2));
			binaryRepresentation[nexp] = 1;
			dist = exp - nexp - 1; // -1 is needed to exclude boundary
			exp = nexp;
			remainder = remainder - Math.pow(2, exp);
			
			// check for distance.
			if ( dist > maxDist) {
				maxDist = dist;
			}
		}
		
		return maxDist;
	};
}
