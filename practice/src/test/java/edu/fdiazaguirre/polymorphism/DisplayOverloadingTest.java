package edu.fdiazaguirre.polymorphism;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisplayOverloadingTest {

	@Test
	public void testStaticPolymorphism() {
		DisplayOverloading d = new DisplayOverloading();
		char ch, n;
		int c, num;
		ch = 'f';
		assertEquals("Base method" + ch, d.disp(ch));
		n = '1';
		assertEquals("Example 1" + ch + n, d.disp(ch,n));
		c = 2;
		assertEquals("Example 2" + c, d.disp(c));
		num = 3;
		assertEquals("Example 3: I’m the first definition of method disp2-" + ch + num, d.disp2(ch, num));
		assertEquals("Example 3: I’m the second definition of method disp2-" + num + ch, d.disp2(num, ch));
	}

}
