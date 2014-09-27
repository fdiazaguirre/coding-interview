package edu.fdiazaguirre.interviews;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BasicCompilerTest {

	@Test
	public void shouldReturnFalseWhenFirstCharacterIsClosing() {
		String input = "}";
		assertFalse(BasicCompiler.compile(input));
	}

	@Ignore
	@Test
	public void shouldReturnTrueWhenMatching() {
		String input = "{}";
		assertTrue(BasicCompiler.compile(input));
	}
}
