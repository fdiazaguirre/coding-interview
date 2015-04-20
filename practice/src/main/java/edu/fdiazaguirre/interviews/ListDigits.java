package edu.fdiazaguirre.interviews;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.google.common.math.IntMath;

/**
 * Write a recursive function which takes an integer, n, and a base, b, as
 * arguments and returns a list of the digits of n in base b.
 * 
 * Examples: n: 64, b:2 => (1,0,0,0,0,0,0) n: 64, b:10 => (6,4) n: 128, b:10 =>
 * (1,2,8) <----- n: 128, b:2 => (1,0,0,0,0,0,0,0)
 */
public class ListDigits {
	private static List<Integer> result = new ArrayList<Integer>();
	private static ListDigits instance = null;
	
	private ListDigits() {}
	
	public static ListDigits getInstance()  {
		if (instance == null) {
			instance = new ListDigits();
		}
		result.clear();
		return instance;
	}
	

	public List<Integer> getDigits(int number, int base) {
		// Exit condition
		if (number < base) {
			result.add(number);
			return result;
		}
		// Get the exponent needed
		int exponent = getExponent(number, base);
		
		int substract = getSubstract(number, base, exponent);
		int remainder = number - substract;
		result.add(getDigit(substract, base, exponent));
		// Find the non-zeros values for left positions
		if (remainder > 0) {
			return getDigits(remainder, base);
		}
		// Padding right positions with zeros
		if (exponent > 0){
			for (int i= 0; i < exponent; i++) {
				result.add(0);
			}
		}
		return result;
	}

	/**
	 * Returns the exponent corresponding for the given number.
	 */
	protected int getExponent(int number, int base) {
		return IntMath.log10(number, RoundingMode.DOWN) / IntMath.log10(base, RoundingMode.DOWN);
	}

	/**
	 * Returns the integer part of the number representation using the given base. 
	 */
	protected int getSubstract(int number, int base, int exponent) {
		return (int) ((int) (number / Math.pow(base, exponent)) * Math.pow(base, exponent));
	}

	protected Integer getDigit(int n, int base, int e) {
		return (int) (n / Math.pow(base, e));
	}
	
}
