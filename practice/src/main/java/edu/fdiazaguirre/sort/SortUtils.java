package edu.fdiazaguirre.sort;

public class SortUtils {

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	public static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void swap(Comparable[] a, int oldIndex, int newIndex) {
		Comparable t = a[oldIndex];
		a[oldIndex] = a[newIndex];
		a[newIndex] = t;
	}
	
	public static int[] moveToRightOnePos(int[] input) {
		int lastValue = input[input.length-1];
		for (int i = input.length-2; i >= 0 ; i--) {
			input[i+1] = input[i];
		}
		input[0] = lastValue;
		return input;
	}
}
