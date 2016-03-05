package edu.fdiazaguirre.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adjacents {

	/**
	 * Returns the max index of non-equals numbers in a sequence.
	 * @param A array with the sequence.
	 * @return -1 when all elements are equals and for arrays with less than 3 elements.
	 */
	public static int findIndex(int[] A) {
		int nonAdjacents = -1;
		List<Integer> partialResults = new ArrayList<Integer>();
		partialResults.add(nonAdjacents);
		// consider array smaller than 3
		if (A.length < 3) {return -1;}
		
		int q = 1;
		
		while (q < A.length -1) {
			if (A[q-1] < A[q] && A[q] < A[q+1]) {
				partialResults.add(q);
			}
			++q;
		}
		
		int[] result = convertToPrimitive(partialResults);
		Arrays.sort(result); 
		int biggestIndex = result.length - 1;
		return result[biggestIndex];
	}

	/**
	 * Checks if there is at least one value between the pointers,
	 * that is bigger than the value in the left pointer but smaller than the right pointer. 
	 */
	static boolean containsValueBetween(int[] a, int p, int q) {
		// fail fast.
		if (a.length == 0 || p >= q) {return false;}
		
		for (int index = p; index < q; index++) {
			if ((a[p] < a[index]) && (a[index] < a[q])) {
				return true;
			}
		}
		return false;
	}
	
	static int[] convertToPrimitive (List<Integer> b) {
		int[] arr = new int[b.size()];
		int index = 0;
		for( Integer i : b ) {
		  arr[index++] = i; //note the autounboxing here
		}
		return arr;
	}
}
