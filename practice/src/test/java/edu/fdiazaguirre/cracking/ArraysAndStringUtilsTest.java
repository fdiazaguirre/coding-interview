package edu.fdiazaguirre.cracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class ArraysAndStringUtilsTest {

	@Test
	public void shouldReturnTrueWhenThereAreUniqueChars() {
		assertTrue(ArraysAndStringUtils.isUniqueChars("fnderico"));
	}
	
	@Test
	public void shouldReturnFalseWhenThereAreNotUniqueChars() {
		assertFalse(ArraysAndStringUtils.isUniqueChars("federico"));
	}
	
	@Test
	public void shouldReturnFalseWhenLenghtIsDifferent(){
		assertFalse(ArraysAndStringUtils.isPermuted("locas","cola"));
	}
	
	@Test
	public void shouldReturnFalseWhenIsNotPermuted(){
		assertFalse(ArraysAndStringUtils.isPermuted("pepe","pepe"));
	}
	
	@Test 
	public void shouldReturnFalseWhenHasDifferentChars() {
		assertFalse(ArraysAndStringUtils.isPermuted("coca","cola"));
	}
	
	@Test
	public void shouldReturnTrueWhenIsPermuted() {
		assertTrue(ArraysAndStringUtils.isPermuted("loca", "cola"));
	}
	
	@Test
	@Ignore("The v1 is not checking if the two strings are the same.")
	public void shouldReturnFalseWhenIsNotPermutedBookV1(){
		assertFalse(ArraysAndStringUtils.isPermutedBookV1("pepe","pepe"));
	}
	
	@Test
	public void shouldReturnFalseWhenIsNotPermutedBookV2(){
		assertFalse(ArraysAndStringUtils.isPermutedBookV2("pepe","pepe"));
	}
	
	@Ignore
	@Test
	public void shouldReplaceBlankSpacesWithEncodeValue() {
		String expected = "Mr%20John%20Smith";
		assertEquals(expected, ArraysAndStringUtils.replace("Mr John Smith    ".toCharArray()));
	}
	
	@Test
	public void shouldReplaceBlankSpacesWithEncodeValueBookVersion() {
		String expected = "Mr%20John%20Smith";
		int length = 13;
		assertEquals(expected, ArraysAndStringUtils.replaceBookVersion("Mr John Smith    ".toCharArray(), length));
		
		expected = "A2%20BB%20CCC%20DDDD";
		length = 14;
		assertEquals(expected, ArraysAndStringUtils.replaceBookVersion("A2 BB CCC DDDD      ".toCharArray(), length));
	}
	
	@Test
	public void shouldCompressOnlyWhenResulIsSmallerThanOriginalLenght() {
		int expectedCount = 4;
		String input = "aaaab";
		assertEquals(expectedCount, ArraysAndStringUtils.countCompress(input));
		
		String expected = "a2b1c5a3";
		assertEquals(expected, ArraysAndStringUtils.compress("aabcccccaaa"));
		
		expected = "a2b1c5a3d1";
		assertEquals(expected, ArraysAndStringUtils.compress("aabcccccaaad"));
	}
}
