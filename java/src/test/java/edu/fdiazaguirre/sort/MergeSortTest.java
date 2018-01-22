package edu.fdiazaguirre.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void test() {
		Integer[] input = {7,4,2,8,1,6,5,3};
		Integer[] expected = new Integer[input.length];
		for (int i = 0; i < 8; i++) {
			expected[i] = i + 1;
		}
		
		Comparable[] actual = MergeSort.execute(input);
		assertArrayEquals(expected, actual);
	}

}
