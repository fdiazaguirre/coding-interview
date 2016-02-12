package edu.fdiazaguirre.interviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxLengthDiffCharTest {

	@Test
	public void shouldReturnZeroWhenTextIsEmpty() {
		assertEquals(0, MaxLengthDiffChar.findMaxLength("", 100));
	}

	@Test
	public void shouldReturnOneWhenDiffParameterIsZero() {
		assertEquals(1, MaxLengthDiffChar.findMaxLength("aaabcc", 0));
	}
	
	@Test
	public void shouldReturnLeftLengthWhenMaxIsAtBegining() {
		assertEquals(4, MaxLengthDiffChar.findMaxLength("aaabcc",1));
	}
	
	@Test
	public void shouldReturnRightLengthWhenMaxIsAtEnd() {
		assertEquals(7, MaxLengthDiffChar.findMaxLength("aabcccccc", 1));
	}
	
	@Test
	public void shouldReturnTotalLengthWhenDiffParameterIsEqualOrGreaterThanDifferentChars(){
		assertEquals(7, MaxLengthDiffChar.findMaxLength("aaabbccc",2));
		assertEquals(8, MaxLengthDiffChar.findMaxLength("aaabbbbbb",2));
	}
}
