package edu.fdiazaguirre.interviews;

import java.util.List;

/**
 * Remember PECS: "Producer Extends, Consumer Super".
 * 
 * "Producer Extends" - If you need a List to produce T values (you want to read
 * Ts from the list), you need to declare it with ? extends T, e.g. List<?
 * extends Integer>. But you cannot add to this list.
 * 
 * "Consumer Super" - If you need a List to consume T values (you want to write
 * Ts into the list), you need to declare it with ? super T, e.g. List<? super
 * Integer>. But there are no guarantees what type of object you may read from
 * this list.
 * 
 * If you need to both read from and write to a list, you need to declare it
 * exactly with no wildcards, e.g. List<Integer>.
 * 
 * e.g.:
 * public class Collections { 
 * 		public static <T> void copy(List<? super T> dest, List<? extends T> src) 
 *  	{
 *     		for (int i=0; i<src.size(); i++) 
 *       		dest.set(i,src.get(i)); 
 *  	} 
 * }
 * 
 * @author fdiazaguirre@gmail.com
 * 
 */
public class MaxElement {

	/**
	 * Write a generic method to find the maximal element in the range [begin,
	 * end]​ of a list.
	 * 
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> T findMax(List<T> list,
			int begin, int end) {
		List<T> subList = list.subList(begin, end);
		// Consumer super
		T max = null;
		// Producer extends
		for (T e : subList) {
			if (max == null || e.compareTo(max) > 0) {
				max = e;
			}
		}
		return max;
	}

}
