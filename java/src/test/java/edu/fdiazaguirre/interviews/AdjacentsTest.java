package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AdjacentsTest {

	@Test
	public void testContainsValueBetween() {
		int[] a = {0,1,2,3,3,7,7};
		
		assertTrue(Adjacents.containsValueBetween(a, 0, 3));
		// fails due to repetition.
		assertFalse(Adjacents.containsValueBetween(a, 3, 6));
		// fails due to left > right.
		assertFalse(Adjacents.containsValueBetween(a, 3, 0));
		// fails due to array.length == 0
		assertFalse(Adjacents.containsValueBetween(new int[0], 0, 3));
	}
	
	@Test
	public void testConvertToPrimitive() {
		int[] expected = {0,1,2,3,4,5};
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			input.add(i);
		}
		Arrays.equals(expected, Adjacents.convertToPrimitive(input));
	}

	@Test
	public void testFindIndex() {
		// Not clear why this is passing. 
		int[] input = {1,4,7,3,3,5};
		assertEquals(4, Adjacents.findIndex(input));
		
		int[] a = {0,1,2,3,3,7,7};
		assertEquals(3, Adjacents.findIndex(a));
		
		// How should behave here?
		int[] c = {1,5,10,15,20,25};
		assertEquals(5, Adjacents.findIndex(c));
		
		int[] b = {0,0,1,1,3,4,5};
		assertEquals(-1, Adjacents.findIndex(b));
	}
	
	@Test
	public void testNonAdjacents() {
		int[] input = {0,1,2,3,4,5};
	
		assertEquals(-1, Adjacents.findIndex(input));
	}
}
