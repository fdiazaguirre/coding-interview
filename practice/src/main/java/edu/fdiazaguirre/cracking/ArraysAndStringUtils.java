package edu.fdiazaguirre.cracking;


public class ArraysAndStringUtils {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			int tmp = 1 << val;
			if ((checker & tmp) > 0) {
				return false;
			}
			checker |= tmp;
		}
		return true;
	}

	public static boolean isPermuted(String original, String modified) {
		if (original.length() != modified.length()
				|| original.compareTo(modified) == 0) {
			return false;
		}
		char[] aux = modified.toCharArray();
		boolean result = true;
		for (int i = 0; i < aux.length; i++) {
			result = result && original.contains(String.valueOf(aux[i]));
		}
		return result;
	}

	public static boolean isPermutedBookV1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

	private static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	public static boolean isPermutedBookV2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[256];
		char[] s_array = s.toCharArray();

		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < s_array.length; i++) {
			if (--letters[i] < 0) {
				return false;
			}
		}

		return true;
	}

	public static String replace(char[] input) {
		int spacesMoved = 0;
		boolean shouldMove = false;
		boolean shouldReplace = false;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] == ' ') {
				if (shouldReplace) {
					input[i + spacesMoved] = '0';
					input[i + spacesMoved - 1] = '2';
					input[i + spacesMoved - 2] = '%';
					spacesMoved = 0;
				} else {
					shouldMove = true;
				}
				spacesMoved++;
			} else if (shouldMove && spacesMoved > 0) {
				input[i+spacesMoved] = input[i];
				shouldReplace = true;
			}
		}
		return String.valueOf(input);
	}
	
	public static String replaceBookVersion(char[] input, int length) {
		int spacesCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (input[i] == ' ') {
				spacesCount++;
			}
		}
		newLength = length + spacesCount * 2;
//		input[newLength] = '\0';
		for (i = length-1; i >= 0; i--) {
			if (input[i] == ' ') {
				input[newLength - 1] = '0';
				input[newLength - 2] = '2';
				input[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				input[newLength - 1] = input[i];
				newLength = newLength - 1;
			}
		}
		
		
		return String.valueOf(input);
	}

	public static String compress(String str) {
		/* Check if compression would create a longer string */
		int size = countCompress(str);
		if (size >= str.length()) {
			return str;
		}
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				/* Update repeated char count*/
				index = setChar(str, array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		/* Update string with the last set of repeated characters. */
		index = setChar(str, array, last, index, count);
		return String.valueOf(array);
	}
	
	
	protected static int countCompress(String str) {
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last){
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	private static int setChar(String str, char[] array, char c, int index, int count){
		array[index] = c;
		index++;
		
		/* Convert the count to a String then to an array of chars. */
		char[] cnt = String.valueOf(count).toCharArray();
		
		/* Copy characters from the biggest digit to the smallest */
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
}
