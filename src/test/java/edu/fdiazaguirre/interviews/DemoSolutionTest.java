package edu.fdiazaguirre.interviews;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DemoSolutionTest {

	@Test
	public void testFindZeros() {
		Set<Integer> zerosArray = new HashSet<Integer>();
		for (int i = 0; i < 7; i++) {
			zerosArray.add(i);
		}
		
		int[] expected = {0,6};
		
//		int[] actual = DemoSolution.findZeros(zerosArray);
		Arrays.equals(expected, null);
	}

}
