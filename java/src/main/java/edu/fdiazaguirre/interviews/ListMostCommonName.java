package edu.fdiazaguirre.interviews;

import java.util.HashMap;
import java.util.List;

public class ListMostCommonName {

	
	/**
	 * Return the name with most occurrences in the given list.
	 */
	public static String findName(List<String> names) {
		// Fail fast.
		if (names == null || names.isEmpty()) {
			throw new RuntimeException("List should contains names!");
		}
		
		String result = names.get(0);
		HashMap<String, Integer> map = new HashMap<>(); // Diamond
		Integer counter = new Integer(1);
		Integer max = new Integer(0);

		// Populate map with the given list.
		for (String s: names) {
			Integer v = map.get(s);
			if (v != null) {
				// When name is found increment the counter by 1.
				counter = new Integer(v + 1);
				map.put(s, counter);
			} else {
				// When it's the 1st occurrence initialize with 1. 
				map.put(s, new Integer(1));
			}
			// Compute the max while map is being populated.
			if (v != null && counter > max) {
				result = s;
				max = v; 
			}
		}
		return result;
	}
}
