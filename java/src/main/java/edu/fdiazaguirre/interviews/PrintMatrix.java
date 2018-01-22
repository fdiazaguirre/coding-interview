package edu.fdiazaguirre.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author fdiazaguirre
 * Given a language without instructions to position the cursor on the screen or any other output device, 
 * please write a generic algorithm which will print a square matrix once N (the matrix’ dimension) is requested, 
 * as the example below shows:

	for N = 3
	
		1	6	7
		2	5	8
		3	4	9
	
	for N = 4
	
		1	8	9	16
		2	7	10	15
		3	6	11	14
		4	5	12	13
	
	for N = …

 *
 */
public class PrintMatrix {

	public void printSquareMatrix(int n) {
		int[][] m = new int[n][n];
		int[][] result = new int[n][n];
		int count = 1;
		List<Stack> stacks = new ArrayList<Stack>();
		

		// Initialize
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				m[j-1][i-1] = count++;
			}
		}
		
		// Create stacks as needed
		for (int i = 0; i < n / 2; i++) {
			Stack<Integer> s = new Stack<>();
			stacks.add(s);
		}
		
		// Sort vertically
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j % 2 == 0) {
					Stack<Integer> s = stacks.get((j/2)-1);
					s.push(m[i-1][j-1]);
				} else {
					result[i-1][j-1] = m[i-1][j-1]; 
				}				
			}
		}
		
		// Fill with reverse
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j % 2 == 0) {
					Stack<Integer> s = stacks.get((j/2)-1);
					result[i-1][j-1] = s.pop(); 
				}				
			}
		}
		
		
		// Print Result
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(result[i-1][j-1]);				
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PrintMatrix p = new PrintMatrix();
		p.printSquareMatrix(3);
	}

}
