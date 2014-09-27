package edu.fdiazaguirre.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void shouldUseQuicksortExclusivelyForLargeArrays() {
		QuickSort.setUsedsortMethod('n');
		Integer[] input = {7,4,2,8,1,6,5,3,10,11,0,-1,-2,9};
		Integer[] expected = new Integer[input.length];
		for (int i = 0; i < input.length; i++) {
			expected[i] = i - 2;
		}
		QuickSort.sort(input);
		assertArrayEquals(expected, input);
		assertEquals('q',QuickSort.getUsedsortMethod());
		assertTrue(QuickSort.hasSwapMark());
	}

	@Test
	public void shouldUseInsertionsortExclusivelyForTinyArrays() {
		QuickSort.setUsedsortMethod('n');
		Integer[] input = {2,1,0,-1,-2};
		Integer[] expected = new Integer[input.length];
		for (int i = 0; i < input.length; i++) {
			expected[i] = i - 2;
		}
		QuickSort.sort(input);
		assertArrayEquals(expected, input);
		assertEquals('i',QuickSort.getUsedsortMethod());
	}
	
	@Test
	public void shouldNotSwapEqualsElements() {
		QuickSort.setSwapMark(false);
		Integer[] input = new Integer[100];
		for (int i = 0; i < 100; i++) {
			input[i] = 7;
		}
		assertFalse(QuickSort.hasSwapMark());
	}
}
