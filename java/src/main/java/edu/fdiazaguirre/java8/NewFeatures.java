package edu.fdiazaguirre.java8;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import edu.fdiazaguirre.tree.Node;
import edu.princeton.cs.algs4.AVLTreeST;

public class NewFeatures {

	/**
	 * The following is a generic method that encapsulates the preceding idiom,
	 * returning a Set of the same generic type as the one passed.
	 */
	public static <E> Set<E> removeDups(Collection<E> c) {
	    return new LinkedHashSet<E>(c);
	}
	
	public boolean isBalanced(AVLTreeST t) {
		if (t == null){
			return true;
		} else {			
			return isBalanced(null) && isBalanced(null);
		}
	}
}
