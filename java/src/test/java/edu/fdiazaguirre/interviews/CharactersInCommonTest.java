package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharactersInCommonTest {

	@Test
	public void shouldReturnEmptyWhenNullOrEmptyArePassed(){
		String s1 = null, s2 = "something";
		assertTrue(CharactersInCommon.generateV1(s1, s2).isEmpty());
		
		s2 = null;
		s1 = "something";
		assertTrue(CharactersInCommon.generateV1(s1, s2).isEmpty());
		
		s2 = "";
		assertTrue(CharactersInCommon.generateV1(s1, s2).isEmpty());
		
		s2 = "some words";
		s1 = "";
		assertTrue(CharactersInCommon.generateV1(s1, s2).isEmpty());
	}
	
	
	@Test
	public void shouldReturnCommonsInFirstArgumentOrderWhenFoundMatches() {
		String s1 = "abcdefghixyz", s2 = "xyzabc";
		assertEquals("abcxyz", CharactersInCommon.generateV1(s1, s2));
		assertEquals("abcxyz", CharactersInCommon.generateV2(s1, s2));
	}

}
