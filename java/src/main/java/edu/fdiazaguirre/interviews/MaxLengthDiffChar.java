package edu.fdiazaguirre.interviews;


import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author fdiazaguirre@gmail.com
 *
 */
public class MaxLengthDiffChar {

	public static int findMaxLength(String text, int diffCharsAllowed) {
		// Corner cases.
		if (text.isEmpty()) {return 0;}
		if (diffCharsAllowed < 1 && !text.isEmpty()) { return 1;}
		// General cases.
		char a[] = text.toCharArray();
		int max = 0, begin = 0,
			end = begin + 1,
			currentLength,
			currentDiff = diffCharsAllowed;
		Character currentCharacter = new Character(a[begin]);
		Character nextCharacter = new Character(a[end]);
		Set<Character> used = new HashSet<Character>();
		// Initialize the set with the 1st character.
		used.add(currentCharacter);
		// Array loop.
		while (begin < a.length) {
			// Substring loop.
			while (currentDiff > 0 || used.contains(nextCharacter)) {
				currentCharacter = nextCharacter;
				// Decrement when a different char is found.
				if (used.isEmpty()) {
					used.add(currentCharacter);
				} else if (!used.isEmpty() && !used.contains(currentCharacter)) {
					currentDiff--;
					used.add(currentCharacter);
				}
				// Move the right pointer and
				// get the next char when end does not overflow .
				if (end < a.length - 1) {
					end++;
					nextCharacter = new Character(a[end]);
				} else {
					break;
				}
			}
			// Compute the length of the substring.
			// Decrement end when currentDiff reaches zero and !used.contains(nextCharacter)
			end--;
			currentLength = end - begin + 1; 
			if (currentLength > max) {
				max = currentLength;
			}
			// Reset substring values.
			currentDiff = diffCharsAllowed;
			currentLength = 0;
			begin = begin + 1;
			end = begin + 1;
			used.clear();
		}
		
		return max;
	}
}
