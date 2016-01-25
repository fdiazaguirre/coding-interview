package edu.fdiazaguirre.sort;

public class LinkedListUtils {

	/**
	 * Sort the given linked list around the value moving the nodes with greater
	 * value to the end. If head node is greater than the value is put in the
	 * tail of the list.
	 * 
	 * @param head
	 * @param thresholdValue
	 */
	public static void sort(Node head, int thresholdValue) {
		Node tail = findTail(head);
		Node current = head;
		while (current.getNext() != null) {
			if (current.getNext().getValue() > thresholdValue) {
				// link to the previous tail
				tail.setNext(current.getNext());
				// update reference to the new tail
				tail = current.getNext();
				// update current reference to the next Node
				current.setNext(current.getNext().getNext());
				// tail doesn't have next
				tail.setNext(null);
				// move to the next Node
				current = current.getNext();
			}
		}
		if (head.getValue() > thresholdValue) {
			tail.setNext(head);
			head = head.getNext();
			tail = head;
			tail.setNext(null);
		}
	}

	/**
	 * Returns null when there isn't a tail (head is null).
	 * 
	 * @param head
	 *            to the linked list
	 * @return the tail Node
	 */
	public static Node findTail(Node head) {
		Node current = head;
		if (head != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}
		}
		return current;
	}

	/**
	 * Sums the given linked list taking in count that the lists to sum are given in the reverse order.
	 * @param firstNumberHead
	 * @param secondNumberHead
	 * @return a new linked list with the result.
	 */
	public static Node sumNodesReverseOrder(Node firstNumberHead,
			Node secondNumberHead) {
		Node result = new Node(-1, null);
		Node head = null;
		int firstValue = 0, secondValue = 0, overflow = 0;
		Integer value = new Integer(0);
		while (firstNumberHead != null || secondNumberHead != null) {
			if (firstNumberHead != null) {
				firstValue = firstNumberHead.getValue();
				firstNumberHead = firstNumberHead.getNext();
			}
			if (secondNumberHead != null) {
				secondValue = secondNumberHead.getValue();
				secondNumberHead = secondNumberHead.getNext();
			}
			value = firstValue + secondValue + overflow;
			if (value.toString().length() > 1) {
				overflow = 1;
			} else {
				overflow = 0;
			}
			// Has 1 digit value?
			if (overflow != 0) {
				// First value?
				if (result.getValue() == -1) {
					result.setValue(Integer.valueOf(String.valueOf(value.toString().charAt(1))));
					head = result;
				} else {
					result.setNext(new Node(Integer.valueOf(String.valueOf(value.toString().charAt(1))), null));
					head = result;
					result = result.getNext();
				}
			} else {
				// First value?
				if (result.getValue() == -1) {
					result.setValue(value);
					head = result;
				} else {
					result.setNext(new Node(value, null));
					head = result;
					result = result.getNext();
				}
			}
			firstValue = 0;
			secondValue = 0;
		}
		result = head;
		return result;
	}

}
