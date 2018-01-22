package edu.fdiazaguirre.tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * 
 * @author fdiazaguirre
 *
 * Using TreeMap under the hood RedBlack Tree
 *
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
	private Map<Integer, Node<T>> t = new TreeMap<>();
	
	public Node<T> find(Node<T> root, T key) {
		// Fail fast and avoid NPE FOR compareTo(null)
		if (root == null) {
			return null;
		}
		
		switch(key.compareTo(root.getValue())) {
			case -1:
				return find(root.getLeft(), key);
			case 0:
				return root;
			case 1:
				return find(root.getRight(), key);
			// This is to suppress compiler, would never be executed!	
			default:
				return null;
		}
	}
	
	public boolean insert(Node<T> newNode){
		return t.put(Integer.valueOf(newNode.hashCode()), newNode) != null ? true : false;
	}
	
	public boolean delete(Node<T> newNode){
		return t.remove(Integer.valueOf(newNode.hashCode())) != null ? true : false;
	}
	
	public Set<T> bfs(Node<T> root) {
		Set<T> result = new TreeSet<T>();
		Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node<T> x = queue.poll();
			x.setVisited(true);
			System.out.print(x.getValue() + " ");
			result.add(x.getValue());
			if (x.getLeft() != null && !x.getLeft().isVisited()) queue.add(x.getLeft());
			if (x.getRight() != null && !x.getRight().isVisited()) queue.add(x.getRight());
		}
		
		return result;
	}
	
	
	public Set<T> dfs(Node<T> root) {
		Set<T> result = new TreeSet<T>();
		Stack<Node<T>> s = new Stack<>();
		s.push(root);
		
		while (!s.isEmpty()) {
			Node<T> x = s.pop();
			if (x.getRight() != null && !x.getRight().isVisited()) s.push(x.getRight());
			if (x.getLeft() != null && !x.getLeft().isVisited()) s.push(x.getLeft());
			printInorder(x, result);
		}
		
		return result;
	}
	
	/* Given a binary tree, print its nodes in inorder*/
    private void printInorder(Node<T> node, Set<T> result) {
        if (node == null || node.isVisited())  return;
 
        /* first recur on left child */
        printInorder(node.getLeft(), result);
 
        /* then print the data of node */
        node.setVisited(true);
        result.add(node.getValue());
        System.out.print(node.getValue() + " ");
 
        /* now recur on right child */
        printInorder(node.getRight(), result);
    }
}
