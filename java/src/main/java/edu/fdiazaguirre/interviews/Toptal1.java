package edu.fdiazaguirre.interviews;

public class Toptal1 {

	/**
	 * Search into the array finding differences and matches. When equilibrium
	 * is found is returned right away.
	 * 
	 * @param X
	 *            integer to find in the array
	 * @param A
	 *            array with integers
	 * @return the array's index where differences and matches are equal
	 */
	public static int solution(int X, int[] A) {
		// fail-fast
		if (A.length == 0) {
			return -1;
		}
		int totalMatches = 0;
		int totalDifferences = 0;

		// Count totals.
		for (int i = 0; i < A.length; i++) {
			if (A[i] == X) {
				totalMatches++;
			} else {
				totalDifferences++;
			}
		}

		// Search by position.
		for (int i = 0; i < A.length; i++) {
			if (A[i] == X) {
				totalMatches--;
			} else {
				totalDifferences--;
			}
			if (totalMatches == totalDifferences) {
				// Return ASAP.
				return i;
			}
		}

		return -1;
	}

}
