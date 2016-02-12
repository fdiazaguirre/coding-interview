package edu.fdiazaguirre.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static int solution(int[] A) {
		int nonAdjacents = -1;
		List<Integer> partialResults = new ArrayList<Integer>();
		partialResults.add(nonAdjacents);
		// consider array smaller than 3
		int p , q;
		for (int i = 0; i < A.length; i++) {
			p = i;
			q = p + 2;
			if (p == A.length -1 || q == A.length -1) { break;}
			while (A[p] != A[q] && !containsValueBetween(A, p, q)) {
				if (q == A.length -1) { break;}
				q++;
				partialResults.add(Math.abs(p - q));
			}
		}
		int[] result = convertToPrimitive(partialResults);
		Arrays.sort(result); 
		int biggestIndex = result.length - 1;
		return result[biggestIndex];
	}

	static boolean containsValueBetween(int[] a, int p, int q) {
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
