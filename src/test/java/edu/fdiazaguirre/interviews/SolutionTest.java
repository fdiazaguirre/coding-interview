package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testContainsValueBetween() {
		int[] a = {0,1,2,3,3,7,7};
		
		assertTrue(Solution.containsValueBetween(a, 0, 3));
		assertFalse(Solution.containsValueBetween(a, 3, 6));
	}
	
	@Test
	public void testConvertToPrimitive() {
		int[] expected = {0,1,2,3,4,5};
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			input.add(i);
		}
		Arrays.equals(expected, Solution.convertToPrimitive(input));
	}

	@Test
	public void testSolution() {
		int[] input = {1,4,7,3,3,5};
		
		assertEquals(4, Solution.solution(input));
	}
	
	@Test
	public void testNonAdjacents() {
		int[] input = {0,1,2,3,4,5};
	
		assertEquals(-1, Solution.solution(input));
	}
}
