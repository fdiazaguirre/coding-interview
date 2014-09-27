package edu.fdiazaguirre.bitmanipulation;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.fdiazaguirre.cracking.BitManipulation;

public class BitManipulationTest {

	@Test
	public void test() {
		int a = 60; /* 60 = 0011 1100 */
		int b = 13; /* 13 = 0000 1101 */
		int c = 0;

		c = a & b; /* 12 = 0000 1100 */
		assertEquals(12, c);

		c = a | b; /* 61 = 0011 1101 */
		assertEquals(61, c);

		c = a ^ b; /* 49 = 0011 0001 */
		assertEquals(49, c);

		c = ~a; /*-61 = 1100 0011 */
		assertEquals(-61, c);
		int d = -1111;
		assertEquals(1110, ~d);

		c = a << 2; /* 240 = 1111 0000 */
		assertEquals(240, c);

		c = a >> 2; /* 15 = 1111 */
		assertEquals(15, c);

		//The unsigned right shift operator ">>>" shifts a zero into the leftmost position,
		// while the leftmost position after ">>" depends on sign extension.
		c = a >>> 2; /* 15 = 0000 1111 */
		assertEquals(15, c);
		c = b >>> 1;
		assertEquals(6, c); /* 1101 >>> 1 = 0110 */
		
		int bitmask = 0x000F;
		int val = 0x2222;
		assertEquals(2, val & bitmask);
	}

	@Test
	public void testMask() {
		// -15 = 110001
		assertEquals(-15, BitManipulation.getMask(1, 3));
	}
	
	@Ignore
	@Test
	public void testUpdateBits() {
		// 17 = 010011
		assertEquals(17, BitManipulation.updateBits(2, 15, 1, 2));
	}
	
	@Ignore
	@Test
	public void testPrintNumber() {
		double d = 25;
		assertEquals(4, Integer.highestOneBit((int) d));
	}
}
