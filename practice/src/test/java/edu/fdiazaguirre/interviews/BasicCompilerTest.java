package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasicCompilerTest {

	@Test
	public void shouldReturnFalseWhenFirstCharacterIsClosing() {
		String input = "}";
		assertFalse(BasicCompiler.compile(input));
	}

	@Test
	public void shouldReturnTrueWhenMatching() {
		String input = "{}";
		assertTrue(BasicCompiler.compile(input));
	}
}
