package edu.fdiazaguirre.interviews;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() {
		// Given
		String[][] items = {
		{"Item1", "Item2", "Item3"},
		{"Item3", "Item4", "Item5"},
		{"Item6", "Item7", "Item8"}};
		
		String[] expected = {"Item1", "Item2", "Item3","Item4", "Item5"};
		
		Assert.assertArrayEquals(expected, Matrix.largestItemAssociation(items));
	}

}
