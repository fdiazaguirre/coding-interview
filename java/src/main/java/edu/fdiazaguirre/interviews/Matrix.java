package edu.fdiazaguirre.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Matrix {

	/**
	 * 
	 * @param itemAssociation 2D array
	 * @return largest group
	 */
	public static String[] largestItemAssociation(String[][] itemAssociation) {
		Set<String> max = new TreeSet<String>();
		String[] result = null;
		boolean associationFound = false;

		for (int i = 0; i < itemAssociation.length - 1; i++) {
			Set<String> current = new TreeSet<String>();
			Set<String> next = new TreeSet<String>();
			
			current.addAll(Arrays.asList(itemAssociation[i]));
			next.addAll(Arrays.asList(itemAssociation[i+1]));
			
			for (int j = 0; j < itemAssociation[i+1].length; j++) {
				String item = itemAssociation[i][j];
				// Check
				if (next.contains(item)) {
					current.addAll(next);
					i++;
					associationFound = true;
					break;
				}
			}
			
			
			if (current.size() > max.size()) {
				max = current;
			}
			
			if (i == itemAssociation.length - 1) {
				break;
			}
		}
		
		return associationFound ? max.toArray(new String[max.size()]) : result;

	}

}
