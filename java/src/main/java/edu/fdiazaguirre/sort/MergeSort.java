package edu.fdiazaguirre.sort;

public class MergeSort {
	
	public static Comparable[] execute(Comparable[] a) {
		return sort(a, new Comparable[a.length], 0, a.length - 1);
	}

	private static void merge(Comparable[] a, Comparable[] aux,int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		
		int left = leftStart;
		int right = rightStart;
		int idx = leftStart;
		
		int size = rightEnd - leftStart + 1;
		
		// a) either half would have remaining elements and force to exit
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left].compareTo(a[right]) < 1) {
				aux[idx] = a[left];
				left++;
			} else {
				aux[idx] = a[right];
				right++;
			}
			idx++;
		}
		// Only one of these two lines would be executed due to a)
		System.arraycopy(a, left, aux, idx, leftEnd - left + 1);
		System.arraycopy(a, right, aux, idx, rightEnd - right + 1);
		
		System.arraycopy(aux, leftStart, a, leftStart, size);
	}
	
	private static Comparable[] sort(Comparable[] a, Comparable[] aux, int leftStart, int rightEnd) {
        if (rightEnd <= leftStart) return a;
        int mid = (leftStart + rightEnd) / 2;
        sort(a, aux, leftStart, mid);
        sort(a, aux, mid+1, rightEnd);
        merge(a, aux, leftStart, rightEnd);
        return a;
    }

}
