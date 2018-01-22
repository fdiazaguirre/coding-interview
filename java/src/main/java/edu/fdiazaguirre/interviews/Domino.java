package edu.fdiazaguirre.interviews;

import java.util.Scanner;

import org.junit.Assert;

/**
 * @author fdiazaguirre
 * Create an algorithm to generate domino chip pairs with the following format and order: 

(6,6), (6,5), (6,4), (6,3), (6,2), (6,1), (6,0), (5,5), (5,4), (5,3), … (2,2). (2,1). (1,0), (0,0)

In a domino game, there are 28 chips, the greater being (6,6) so N=6. 
The algorithm to develop must generate any group of chips for which N could be between 0 and 32000. 
Please include the validation logic for the possible N values. In case of errors, 
please ask for the capture to be re-tried. Number of re-tries cannot be greater than ten (10) times. 
Please consider a mechanism to request the end of the program’s execution. 

 *
 */
public class Domino {

	public static void generate(int n) {
		int partialSum = n * (n + 1) / 2;
		int k = 0, l = k;
		for (int i = 0; i < partialSum; i++) {
			while (k <= n) {
				System.out.println(k+ ", " + l);
				l++;
				if (l == n+1 ) {
					k++;
					l = k;
				}
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean isValid = 0 <= n && n <= 32000;
        int maxRetries = 10;
        while (!isValid && maxRetries > 0){
        	System.out.println("N could be between 0 and 32000");
        	n = in.nextInt();
            isValid = 0 <= n && n <= 32000;
            maxRetries--;
        }
        if (isValid) {
        	Domino.generate(n);
        }
	}

}
