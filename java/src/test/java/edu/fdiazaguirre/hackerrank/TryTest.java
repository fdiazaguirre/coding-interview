package edu.fdiazaguirre.hackerrank;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TryTest {

	@Test
	public void test() {
		TryNode t = new TryNode('a');
		t.addChild('b');
		t.addChild('c');
		t.addChild('d');
		t.addChild('e');
		t.addLastChild('f');
		
		assertTrue(t.hasCharacter('a'));
		assertTrue(t.hasCharacter('b'));
		assertTrue(t.hasCharacter('c'));
		assertTrue(t.hasCharacter('d'));
		assertTrue(t.hasCharacter('e'));
		assertTrue(t.hasCharacter('f'));
	}

}
