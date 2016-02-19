package edu.fdiazaguirre.interviews;

import java.util.HashMap;
import java.util.Map;

public class Equilibrium {

	class Node {
		Long leftWithoutCurrent;
		Long rightWithoutCurrent;

		Node(Long l, Long r) {
			this.leftWithoutCurrent = l;
			this.rightWithoutCurrent = r;
		}

		void setLeft(Long l) {
			this.leftWithoutCurrent = l;
		}

		void setRight(Long r) {
			this.rightWithoutCurrent = r;
		}
	}

	public int mySolution(int[] A) {
		// Empty array.
		if (A.length == 0) {
			return -1;
		}
		// Just one element.
		if (A.length == 1) {
			return 0;
		}
		// 3 elements array
		if (A.length == 3 && A[0] == A[2]) {
			return 1;
		}

		long leftSum = 0;
		int result = -1;
		// Additional Space O(n).
		Map<Integer, Node> m = new HashMap<>();
		// 1st Pos always has left with 0.
		m.put(0, new Node(0L, null));
		// Last pos always has right with 0.
		m.put(A.length - 1, new Node(null, 0L));

		Node current = null;
		// Loop to compute left sum.
		for (int i = 1; i < A.length; i++) {
			leftSum = leftSum + A[i - 1];
			if (i == A.length - 1) {
				current = m.get(i);
				current.setLeft(leftSum);
				m.put(i, current);
			} else {
				m.put(i, new Node(leftSum, null));
			}

		}

		// Loop again to compute right sum
		long rightSum = 0;
		current = null;
		Node nextRight = null;
		for (int i = A.length - 2; i > -1; i--) {
			current = m.get(i);
			nextRight = m.get(i + 1);
			// Retrieve right sum
			if (nextRight.rightWithoutCurrent != null) {
				rightSum = nextRight.rightWithoutCurrent + A[i + 1];
				// Update current node
				current.setRight(rightSum);
				m.put(i, current);
				// Break as soon as an equilibrium is found.
				if (current.leftWithoutCurrent == current.rightWithoutCurrent) {
					return i;
				}
			}
		}

		return result;
	}

	public int solution(int[] A) {
		int n = A.length;
		if (n == 0)
			return -1;
		long sum = 0;
		int i;
		for (i = 0; i < n; i++) {
			sum += (long) A[i];
		}

		long sum_left = 0;
		for (i = 0; i < n; i++) {
			long sum_right = sum - sum_left - (long) A[i];
			if (sum_left == sum_right)
				return i;
			sum_left += (long) A[i];
		}
		return -1;
	}
}
