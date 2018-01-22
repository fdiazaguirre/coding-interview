package edu.fdiazaguirre.tree;


public class Node<T extends Comparable<T>> {
	private T value;
	private Node<T> left;
	private Node<T> right;
	private boolean visited = false;
	
	public Node(T value, Node<T> left, Node<T> right) {
		this.setValue(value);
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
