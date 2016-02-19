package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquilibriumTest {

	@Test
	public void testReturnSolution() {
		Equilibrium e = new Equilibrium();

		int test[] = {-1, 3, -4, 5, 1, -6, 2, 1 };
		assertEquals(1, e.solution(test));
	}

	@Test
	public void extreme_large_numbers() {
		Equilibrium e = new Equilibrium();

		int test[] = { 1082132608, 0, 1082132608 };
		assertEquals(1, e.solution(test));
	}

	@Test
	public void extreme_negative_numbers() {
		Equilibrium e = new Equilibrium();

		int test[] = { -2147483648, -2147483648, -2147483648 };
		assertEquals(1, e.solution(test));
	}

	@Test
	public void overflow_tests2() {
		Equilibrium e = new Equilibrium();

		int test[] = {0, 2147483647, 2147483647, 2147483647};
		assertEquals(2, e.solution(test));
	}
	
	@Test
	public void testReturnZeroForArraysWithOnlyOneElement() {
		Equilibrium e = new Equilibrium();
		int A[] = new int[1];
		A[0] = -12;

		assertEquals(0, e.solution(A));
	}

	@Test
	public void testNotFound() {
		Equilibrium e = new Equilibrium();
		int B[] = new int[4];
		B[0] = 6;
		B[1] = -12;
		B[2] = 1;
		B[3] = 0;

		assertEquals(-1, e.solution(new int[0]));
		assertEquals(-1, e.solution(B));
	}

}
