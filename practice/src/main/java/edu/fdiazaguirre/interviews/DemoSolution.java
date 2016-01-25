package edu.fdiazaguirre.interviews;

import java.util.HashSet;
import java.util.Set;


public class DemoSolution {

	public int solution(int[] A) {
        // write your code in Java SE 6
        int length = A.length;
		return length;
    }

	public static int[] findZeros(int[] zerosArray) {
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0; i < zerosArray.length; i++) {
			if (zerosArray[i] == 0 ){
				result.add(zerosArray[i]);
			}
		}
		return convertToPrimitive((Integer[]) result.toArray());
	}
	
	private static int[] convertToPrimitive (Integer[] b) {
		int[] a = null;
		for (int i = 0; i < b.length; i++) {
		    a[i] = b[i];
		}
		return a;
	}
}
