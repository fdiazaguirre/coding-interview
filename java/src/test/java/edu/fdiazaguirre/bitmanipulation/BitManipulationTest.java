package edu.fdiazaguirre.bitmanipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.fdiazaguirre.cracking.BitManipulation;
import edu.fdiazaguirre.interviews.ListDigits;

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

		// The unsigned right shift operator ">>>" shifts a zero into the
		// leftmost position,
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
	public void testClearBitsIthrough0() {
		int expected = Integer.parseInt("11111110000", 2);
		int n = Integer.parseInt("11111111111", 2);

		assertEquals(expected, BitManipulation.clearBitsIthrough0(n, 3));
	}

	@Test
	public void testShift() {
		assertEquals("1",
				Integer.toBinaryString(Integer.parseInt("1111", 2) >> 3));
	}

	@Test
	public void testSetBit() {
		int expected = Integer.parseInt("1101", 2);
		int original = Integer.parseInt("0101", 2);

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(BitManipulation.setBit(original, 3)));
	}

	@Test
	public void testSetBits() {
		int expected = Integer.parseInt("101111", 2);
		int original = Integer.parseInt("100000", 2);

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(BitManipulation.setBits(original, 3, 0)));

		expected = Integer.parseInt("101110", 2);
		original = Integer.parseInt("100000", 2);

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(BitManipulation.setBits(original, 3, 1)));
	}

	@Test
	public void testMask() {
		assertEquals(Integer.parseInt("1111", 2), BitManipulation.getMask(1, 3));
	}

	@Test
	public void testinsertBinary() {
		int expected = Integer.parseInt("10001001101", 2);
		int m = Integer.parseInt("10011", 2);
		int n = Integer.parseInt("10000000001", 2);
		int highIndex = 6;
		int lowIndex = 2;

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(BitManipulation.insertBinary(n, m,
						highIndex, lowIndex)));
	}

	@Test
	public void testRightShift() {
		int expected = Integer.parseInt("00000000111111111111111111111111", 2);

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(-1 >>> 8));
		int trailingOnes = 2;
		int leadingZeros = 32 - trailingOnes;
		expected = Integer.parseInt("00000000000000000000000000000011", 2);

		assertEquals(Integer.toBinaryString(expected),
				Integer.toBinaryString(-1 >>> leadingZeros));
	}

	@Test(expected = RuntimeException.class)
	public void testPrintNumberThrowsException() {
		double d = Double.MAX_VALUE;
		BitManipulation.printNumber(d);
	}

	@Test
	public void testPrintNumber() {
		Double d = new Double(8.0d);

		assertEquals(Integer.toBinaryString(Integer.parseInt("1000", 2)),
				BitManipulation.printNumber(d));

		d = new Double(10.0d);

		assertEquals(Integer.toBinaryString(Integer.parseInt("1010", 2)),
				BitManipulation.printNumber(d));
		
		d = new Double(72.0d);

		assertEquals(Integer.toBinaryString(Double.valueOf(d).intValue()),
				BitManipulation.printNumber(d));
	}
	
	@Test
	public void testSwapValuesUsingXOR() {
		int a = 2, b = 6;
		System.out.println("Before");
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println("---Get the delta---");
		a = a ^ b;
		System.out.println(Integer.toBinaryString(a));
		System.out.println("--------");
		b = b ^ a; // same as a ^ b since -> ^ is exclusive!
		a = b ^ a; // same as a ^ b
		System.out.println("Swapped");
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
	}
}
