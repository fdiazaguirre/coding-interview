package edu.fdiazaguirre.cracking;

public class BitManipulation {

	/**
	 * 5.1
	 */
	public static int updateBits(int n, int m, int i, int j) {
		int result = 0;
		int holder = m & getMask(i, j);
		int shifted = 0 << i;
		result = holder | shifted;
		return result;
	} 
	
	/**
	 * 5.1 
	 */
	public static int getMask(int i, int j) {
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right = ((1 << i) - 1);
		return left | right;
	}
	
	/**
	 * 5.2
	 */
	public static void printNumber(double d) {
		if (d > Integer.MAX_VALUE) {
			System.out.println("ERROR!");
		} else {
			//TODO: what I should do after?
			int digits = Integer.bitCount((int) d);
			System.out.println(digits);
		}
	}
}
