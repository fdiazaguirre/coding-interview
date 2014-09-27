package edu.fdiazaguirre.cracking;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackImplTest {

	@Test
	public void testIsEmpty() {
		Stack underTest = new StackImpl();
		
		assertTrue(underTest.isEmpty());
		
		underTest.push(new Object());
		assertFalse(underTest.isEmpty());
	}

}
