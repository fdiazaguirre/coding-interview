package edu.fdiazaguirre.cracking;

import java.math.RoundingMode;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;

public class BitManipulation {

	/**
	 * 5.1
	 * Insert m into n such that m starts at bit j and ends at bit i.
	 */
	public static int insertBinary(int n, int m, int highIndex, int lowIndex) {
		Preconditions.checkArgument(Integer.toBinaryString(n).length() >= (highIndex - lowIndex + 1));
		// clear m from highIndex to 0
		int nCleared = n & clearBitsIthrough0(n, highIndex);
		// restore right digits
		// Using unsigned shift to restore the wrong cleared bits.
		// This approach is more readable and faster than avoid clear the lowIndex - 1 to 0 bits. 
		int trailingOnes = lowIndex - 1;
		int leadingZeros = 32 - trailingOnes ;
		int rightMask = -1 >>> leadingZeros;
		nCleared = nCleared | rightMask;
		// move n to start at highIndex
		int mShifted =  m << lowIndex;
		return nCleared | mShifted;
	} 
	
	public static int clearBitsIthrough0(int num, int highIndex) {
		int mask = ~(( 1 << (highIndex + 1)) - 1);
		return num & mask;
	}
	
	/**
	 * Creates a mask for the Integer.MAX_VALUE binary representation clearing
	 * the values between leftIndex and rightIndex.
	 * 
	 * @param leftMostIndex
	 *            the far left index to be allowed.
	 * @param rightMostIndex
	 *            the far right index to be allowed.
	 */
	public static int getMask(int leftMostIndex, int rightMostIndex) {
		int allOnes = Integer.parseInt(
				Integer.toBinaryString(Integer.MAX_VALUE), 2);
		// "<<" is a signed operation for this reason use "~" to revert the sign
		// effect in the left most digit
		int left = ~(allOnes << (rightMostIndex + 1));
		int right = ((1 << leftMostIndex) - 1);
		return left | right;
	}
	
	/**
	 * 5.2
	 */
	public static String printNumber(double d) {
		int partialResult = 0;
		if (d > Integer.MAX_VALUE) {
			throw new RuntimeException("ERROR");
		} else {
			// get msb and save it in number
			int exponent = IntMath.log2(Double.valueOf(d).intValue(), RoundingMode.HALF_EVEN);
			partialResult = 1 << exponent;
			// get remainder = number - pow(2, exponent)
			int remainder = Double.valueOf(d).intValue() - IntMath.pow(2, exponent);
			while (remainder > 0) {
				// get exponent
				exponent = IntMath.log2(Double.valueOf(remainder).intValue(), RoundingMode.HALF_EVEN);
				// update bits
				partialResult  = BitManipulation.setBit(partialResult, exponent);
				// compute new value for remainder
				remainder = Double.valueOf(remainder).intValue() - IntMath.pow(2, exponent);
			}
		}
		return Integer.toBinaryString(partialResult);
	}

	public static int setBit(int number, int index) {
		return number | (1 << index);
	}
	
	public static int setBits(int number, int highIndex, int lowIndex) {
		Preconditions.checkArgument(highIndex >= lowIndex);
		Preconditions.checkArgument(lowIndex >= 0);
		int result = 0;
		for (int i = lowIndex; i <= highIndex; i++) {
			result = result | (1 << i);
		}
		return number | result;
	}
}
