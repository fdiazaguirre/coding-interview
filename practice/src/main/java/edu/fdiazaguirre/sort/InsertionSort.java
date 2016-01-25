package edu.fdiazaguirre.sort;

public class InsertionSort {

	/**
	 * In place insertion sort implementation.
	 * 
	 * @param input
	 * @return the original array sorted
	 */
	public static Comparable[] sort(Comparable[] input) {
		if (!SortUtils.isSorted(input)) {
			for (int i = 1; i < input.length; i++) {
				Comparable tmp = input[i];
				int j;
				for (j = i - 1; j >= 0 && SortUtils.less(tmp, input[j]); j--) {
					input[j + 1] = input[j];
				}
				input[j + 1] = tmp;
			}
		}
		return input;
	}
}
