package edu.fdiazaguirre.interviews;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.corba.se.spi.orbutil.fsm.Input;

@Ignore
public class Toptal3Test {

	@Test
	public void test() {
		int[] a 	  = {1,0,0,1,1}; // 9 represented in base -2
		int[] aResult = {1,1,0,1}; // -9
		int[] b 	  =	{1,0,0,1,1,1}; // -23
		int[] nResult = {1,1,0,1,0,1,1};// 23
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		String input = sb.toString();
		
		assertEquals("10011",input);
		System.out.println(Integer.valueOf("1001", 2));
		
		assertEquals(-2, ~1);
	}

	@Ignore
	@Test
	public void testBitGap() {
		assertEquals(1,Integer.bitCount(4));
		assertEquals(2,Integer.bitCount(5));
	
		assertEquals(4, Integer.highestOneBit(5));
		assertEquals(1, Integer.lowestOneBit(5));
		
		
		// Strategy: 1) get how many ones are in the number
		// 			 2) get the distance between the adjacent bits
		int bitCount = Integer.bitCount(529);
		int leftMostBit = Integer.highestOneBit(529);
		int rightMostBit = Integer.lowestOneBit(529);
		int numberOfComparissons = bitCount - 1;
		int zerosCount = 0;
		
//		System.out.println(Integer.toBinaryString(529));
//		System.out.println(Integer.toBinaryString(leftMostBit));
//		System.out.println(Integer.toBinaryString(rightMostBit));
//		int middleBit = 529- leftMostBit - rightMostBit;
//		System.out.println(Integer.toBinaryString(leftMostBit).substring(1, Integer.toBinaryString(middleBit).length()).length());
//		int end = Integer.toBinaryString(middleBit).length() - 1;
//		System.out.println(Integer.toBinaryString(middleBit).substring(rightMostBit, end).length());

		System.out.println(Integer.toBinaryString(17));
		System.out.println(Integer.numberOfTrailingZeros(17));
		System.out.println(Math.getExponent(4));
//		while (numberOfComparissons > 0) {
//			
//			
//			bitCount--;
//		}
	}
}
