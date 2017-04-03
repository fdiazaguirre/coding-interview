package edu.fdiazaguirre.interviews;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CyclicrotationTest {

	@Test
	public void test() {
		Integer[] expecteds = {9, 7, 6, 3, 8};
		Integer[] arg = {3, 8, 9, 7, 6};
		Assert.assertArrayEquals(expecteds, CyclicRotation.solution(arg, 3));
	}

}
