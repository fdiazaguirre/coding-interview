package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.math.IntMath;

public class ListDigitsTest {

	@Test
	public void testGetSubstract() {
		int n = 64;
		int expected = 60;
		int base = 10;
		int e = ListDigits.getInstance().getExponent(n, base);
		assertEquals(1, e);
		assertEquals(expected, ListDigits.getInstance().getSubstract(n, base, e));
		
		n = 128;
		expected = 100;
		e = ListDigits.getInstance().getExponent(n, base);
		assertEquals(2, e);
		assertEquals(expected, ListDigits.getInstance().getSubstract(n, base, e));
	}
	
	@Test
	public void testGetNumber() {
		int n = 60;
		Integer expected = 6;
		int base = 10;
		int e = (int) (Math.log(n) / Math.log(base));
		assertEquals(expected, ListDigits.getInstance().getDigit(n, base, e));
		
		n = 64;
		expected = 1;
		base = 2;
		e = (int) (Math.log(n) / Math.log(base));
		assertEquals(expected, ListDigits.getInstance().getDigit(n, base, e));
	}
	
	
	@Test
	public void testGetDigits() {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		int n =64;
		int base = 10;
		expected.add(6);
		expected.add(4);
		
		assertEquals(expected, ListDigits.getInstance().getDigits(n, base));

		expected.clear();
		result.clear();
		n=128;
		expected.add(1);
		expected.add(2);
		expected.add(8);
		assertEquals(expected, ListDigits.getInstance().getDigits(n, base));
	}
	
	@Test
	public void testExponent() {
		int number = 1000;
		int base = 10;
		int expected = IntMath.log10(number, RoundingMode.DOWN) / IntMath.log10(base, RoundingMode.DOWN);
		
		assertEquals(expected, ListDigits.getInstance().getExponent(number, base));
	}
}
