package edu.fdiazaguirre.interviews;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.fdiazaguirre.interviews.ListMostCommonName;

public class ListMostCommonNameTest {

	@Test
	public void testFindMostCommonName() {
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("John");
		names.add("Peter");
		
		assertEquals("John", ListMostCommonName.findName(names));
	}

	@Test(expected=RuntimeException.class)
	public void shouldThrowExceptionWhenEmptyListIsPassed(){
		ListMostCommonName.findName(new ArrayList<String>());
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowExceptionWhenNullIsPassed(){
		ListMostCommonName.findName(null);
	}
}
