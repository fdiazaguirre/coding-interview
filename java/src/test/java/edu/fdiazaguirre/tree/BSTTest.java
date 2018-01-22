package edu.fdiazaguirre.tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BSTTest {
	BST<Integer> selfBalancedTree = new BST<>();
	Node<Integer> root;
	
	@Before
	public void init() {
		Node<Integer> d = new Node<Integer>(5, null, null);	
		Node<Integer> e = new Node<Integer>(8, null, null);
		Node<Integer> f = new Node<Integer>(12, null, null);	
		Node<Integer> g = new Node<Integer>(13, null, null);
		
		Node<Integer> b = new Node<Integer>(7, d, e);
		Node<Integer> c = new Node<Integer>(11, f, g);
		
		root = new Node<Integer>(9, b, c);
		selfBalancedTree.insert(root);
	}
	
	@Test
	public void testdfs() {
		Set<Integer> expectedValues = new HashSet<Integer>();
		expectedValues.addAll(Arrays.asList(5,7,8,9,12,11,13));
		
		assertEquals(expectedValues, 
				selfBalancedTree.dfs(root).stream().collect(Collectors.toSet()));
	}

	
	@Test
	public void testbfs() {
		Set<Integer> expectedValues = new HashSet<Integer>();
		expectedValues.addAll(Arrays.asList(9,7,11,5,8,12,13));
		
		assertEquals(expectedValues, 
				selfBalancedTree.bfs(root).stream().collect(Collectors.toSet()));
	}
}
