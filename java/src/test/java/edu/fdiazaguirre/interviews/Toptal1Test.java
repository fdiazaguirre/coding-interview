package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Toptal1Test {

	@Test
	public void test() {
		int[] test =   {5, 5, 1, 7, 2, 3, 5};
		
		assertTrue(Toptal1.solution(5, test) == 4);
	}

}
