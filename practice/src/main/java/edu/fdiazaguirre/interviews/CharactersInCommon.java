package edu.fdiazaguirre.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Write a function that takes two strings as arguments and returns a string
 * containing only the characters found in both strings
 * 
 * @author fdiazaguirre@gmail.com
 * 
 */
public class CharactersInCommon {

	/**
	 * This uses additional space: n * 4 - O(n) since has two additional arrays
	 * and two additional sets. Time complexity is O(n)
	 * 
	 * @param s1
	 * @param s2
	 * @return empty when either param is null or empty. Otherwise the common
	 *         characters in the s1 order.
	 */
	public static String generateV1(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		// Store s1 and s2 values in a Set
		Set<Character> set1 = new HashSet<Character>(), set2 = new HashSet<Character>();
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		for (int i = 0; i < a1.length; i++) {
			set1.add(new Character(a1[i]));
		}

		for (int i = 0; i < a2.length; i++) {
			set2.add(new Character(a2[i]));
		}
		// Then iterate over one set if the value is stored in the other set
		// add the character in the result.
		for (Character c : set1) {
			if (set2.contains(c)) {
				result.append(c);
			}
		}

		return result.toString();
	}

	/**
	 * This use also an additional space O(n): n * 2, but just two arrays this
	 * time. Time complexity is O (n log n) due to the sorting.
	 * 
	 * @param s1
	 * @param s2
	 * @return empty when either param is null or empty. Otherwise the common
	 *         characters in the s1 order.
	 */
	public static String generateV2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		// Sort O(n log n)
		Arrays.sort(a2);
		for (int i = 0; i < a1.length; i++) {
			// Search into the sorted array O(log n).
			if (Arrays.binarySearch(a2, a1[i]) > -1) {
				result.append(a1[i]);
			}
		}

		return result.toString();
	}
}
