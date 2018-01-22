package edu.fdiazaguirre.bitmanipulation;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(log(N)); expected worst-case space
 * complexity is O(1).
 * 
 */
public class BitGap {

	public int solution(int n) {
		// write your code in Java SE 8
		int bitCount = Integer.bitCount(n);
		// fail fast
		if (bitCount == 0) {
			return 0;
		}
		String binRe = Integer.toBinaryString(n);
		char[] arr = binRe.toCharArray();
		int max = 0, partial = 0;

		int left = 0, right = 1;
		while (right < arr.length) {
			while (arr[right] == '0') {
				right++;
				if (right == arr.length - 1) {
					break;
				}
			}
			// Maybe found a 1 at right
			if (arr[right] == '1') {
			    partial = right - left - 1;
			    if (partial > max) {
					max = partial;
				}	
			}	
			left = right;
			right = left + 1;
			if (right == arr.length - 1) {
				break;
			}
		}

		return max;
	}
	
//	public int solution(int[] A) {
//        // write your code in Java SE 8
//        Arrays.sort(A);
//        int result = 0;
//        for (int i = 0; i < A.length; i++) {
//             //corner cases i == 0 && i == A.length -1
//            if ((i == 0) && (A[i] != A[i+1])) {
//                result = A[0];    
//            }
//            if ((i == A.length -1) && (A[i-1] != A[i])) {
//                result = A[A.length -1];
//            }
//            
//            if ((i > 0 && i < A.length -1) && (A[i] != A[i+1]) && (A[i-1] != A[i])) {
//                result = A[i];
//            } 
//           
//            
//        }
//        return result;
//    }
//	public int[] solution(int[] A, int K) {
//        int[] input = A;
//        int[] result = new int[A.length];
//        while (K > 0) {
//           // Rotate
//            for(int i = 0; i < input.length - 1; i++){
//                result[i+1] = input[i]; 
//            }
//            result[0] = input[input.length - 1];
//            input = result;
//            result = new int[input.length];
//            K--;
//        }
//        return input;
//    }
	
	
}
