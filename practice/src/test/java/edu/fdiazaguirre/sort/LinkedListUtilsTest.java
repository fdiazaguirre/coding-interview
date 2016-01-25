package edu.fdiazaguirre.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListUtilsTest {

	@Test
	public void testSortLinkedList() {
		Node expectedTail = new Node(5, null);
		Node head = new Node(1, new Node(5, new Node(3, new Node(7, new Node(9, null)))));
		
		LinkedListUtils.sort(head, 3);
		
		Node actualTail = head.getNext().getNext().getNext().getNext();
		assertEquals(1, head.getValue());
		assertEquals(expectedTail.getValue(), actualTail.getValue());
		assertNull(actualTail.getNext());
	}

	@Test
	public void testFindTail() {
		Node expectedTail = new Node(2, null);
		Node head = new Node(1, new Node(5, new Node(3, new Node(7, expectedTail))));
		
		assertEquals(expectedTail, LinkedListUtils.findTail(head));
	}
	
	@Test
	public void testSumNodesReverseOrder() {
		Node firstNumberHead = new Node(1, new Node(2, null));
		Node secondNumberHead = new Node(9, null);
		
		Node expectedResult = new Node(0, new Node(3, null));
		
		Node actualResult = LinkedListUtils.sumNodesReverseOrder(firstNumberHead, secondNumberHead);
		
		while(expectedResult != null) {
			assertNotNull("Actual result has an smaller lenght than expected", actualResult);
			assertEquals(expectedResult.getValue(), actualResult.getValue());
			expectedResult = expectedResult.getNext();
			actualResult = actualResult.getNext();
		}
	}
}
