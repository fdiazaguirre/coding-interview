package edu.fdiazaguirre.predicates;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

public class SimplePredicateTest {

	@Test
	public void testInlineImplementation() {
		Predicate<String> i  = s -> s.length() > 5;
		   
		assertTrue(i.test("Federico"));
	}

}
