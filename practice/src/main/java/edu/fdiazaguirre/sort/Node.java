package edu.fdiazaguirre.sort;

public class Node {
	private int value;
	private Node next;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(Integer newValue) {
		this.value = newValue;
	}

}
