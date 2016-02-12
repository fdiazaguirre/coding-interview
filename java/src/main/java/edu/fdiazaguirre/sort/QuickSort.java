package edu.fdiazaguirre.sort;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Random;

public class QuickSort {

	private static final int SIZE_THRESHOLD = 5;
	private static char method;
	private static boolean swapMark;
	private static Random rnd = new Random();

	public static void sort(Comparable[] a) {
		if (SortUtils.isSorted(a)) {
			return;
		}
		if (a.length <= SIZE_THRESHOLD) {
			InsertionSort.sort(a);
			setUsedsortMethod('i');
		} else {
			StdRandom.shuffle(a);
			recQuickSort(a, 0, a.length - 1);
			setUsedsortMethod('q');
		}
	}

	private static void recQuickSort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo, i = lo + 1, gt = hi;
		// Random pivots for each call is good enough, to avoid O(n^2) and achieve O(n log n).
		int pivot = lo + rnd.nextInt(hi - lo);
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {
				SortUtils.swap(a, lt++, i++);
				setSwapMark(true);
			} else if (cmp > 0) {
				SortUtils.swap(a, i, gt--);
				setSwapMark(true);
			} else
				i++;
		}
		// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
		recQuickSort(a, lo, lt - 1);
		recQuickSort(a, gt + 1, hi);
	}


	static char getUsedsortMethod() {
		return method;
	}

	static void setUsedsortMethod(char newValue) {
		method = newValue;
	}

	static void setSwapMark(boolean newValue) {
		swapMark = newValue;
	}

	static boolean hasSwapMark() {
		return swapMark;
	}
}
