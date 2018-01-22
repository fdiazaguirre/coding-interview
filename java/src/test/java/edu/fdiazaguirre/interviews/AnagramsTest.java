package edu.fdiazaguirre.interviews;

import org.junit.Assert;
import org.junit.Test;

public class AnagramsTest {

	@Test
	public void test() {
		String h = "abcdbfagabcd";
		String n = "abcd";
		
		Integer[] expecteds = {0, 8};
		
		Assert.assertArrayEquals(expecteds, Anagrams.getAnagramIndices(h, n).toArray());
		
		n = "xyz";
		
		Assert.assertTrue(Anagrams.getAnagramIndices(h, n).isEmpty());
	}

}
