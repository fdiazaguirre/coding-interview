package edu.fdiazaguirre.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static List<Integer> getAnagramIndices(String haystack, String needle) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Character, Integer> orig = new HashMap<Character, Integer>();
		Map<Character, Integer> aux = new HashMap<Character, Integer>();
		Character key;
		int count;

		// Get needle chars
		for (char c : needle.toCharArray()) {
			key = Character.valueOf(c);
			if (orig.containsKey(key)) {
				count = orig.get(key) + 1;
				orig.put(key, count);
			} else {
				orig.put(key, 1);
			}
		}

		aux.putAll(orig);
		int index = -1;
		char[] array = haystack.toCharArray();

		for (int i = 0; i < array.length; i++) {
			key = Character.valueOf(array[i]);
			index = -1;
			aux.clear();
			aux.putAll(orig);
			while (aux.size() > 0 && aux.containsKey(key)) {
				// store index candidate
				if (aux.size() == orig.size()) {
					index = i;
				}
				// update map with new count
				if (aux.get(key) > 1) {
					count = aux.get(key) - 1;
					aux.put(Character.valueOf(key), count);
				} else {
					aux.remove(Character.valueOf(key));
				}
				// if index candidate is gt -1 save it in result
				if (index > -1 && aux.size() == 0) {
					result.add(Integer.valueOf(index));	
				}
				if (i == array.length - 1) {
					break;
				} else {
					i++;
					key = Character.valueOf(array[i]);
				}
				
			}		
		}
		
		
		return result;
	}
}
