package edu.fdiazaguirre.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxElementTest {

	@Test
	public void testWithIntegers() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(5);
		list.add(2);
		
		Integer max = (Integer) MaxElement.findMax(list, 0, 4);
		assertEquals(new Integer(5), max);
		
		max = (Integer) MaxElement.findMax(list, 0, 1);
		assertEquals(new Integer(3), max);
	}

	@Test
	public void testWithCharacters() {
		List<Character> list = new ArrayList<Character>();
		list.add(new Character('a'));
		list.add(new Character('d'));
		list.add(new Character('b'));
		list.add(new Character('z'));
		
		Character max = (Character) MaxElement.findMax(list, 0, 4);
		assertEquals(new Character('z'), max);
		
		max = (Character) MaxElement.findMax(list, 0, 3);
		assertEquals(new Character('d'), max);
	}
}
