package edu.fdiazaguirre.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortUtilsTest {

	@Test
	public void moveOnePosToRight() {
		int[] input = {1,2,3,4};
		int[] expected = {4,1,2,3};
		int[] actual = SortUtils.moveToRightOnePos(input);
		assertArrayEquals(expected, actual);
	}

}
