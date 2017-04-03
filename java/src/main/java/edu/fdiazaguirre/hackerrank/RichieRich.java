package edu.fdiazaguirre.hackerrank;

import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String number = in.next();
		char[] arr = number.toCharArray();
		int i = 0; int j = arr.length - 1; int diff = 0;
		while (i < j) {
			if (arr[i] != arr[j]) {
				diff++;
			}
			if (diff > k) {
                // Fail fast.
				System.out.println(-1);
				return;
			}
			++i;
			--j;
		}
        
        // Changing cycle.
        i = 0; j = arr.length - 1;
        while (k >= diff && i < j) {
            // Check if it's worth it to change both.
            if ((k >= 2) && (k / 2 > 0) && arr[i] != '9' && arr[j] != '9') {
                arr[i] = '9';
                arr[j] = '9';
                k = k - 2;
                diff = diff -2;
            }
            // Base case, just copy the greater value in the other position.
            if (Integer.parseInt(String.valueOf(arr[i])) > Integer.parseInt(String.valueOf(arr[j]))) {
                arr[j] = arr[i];
                --k;
                --diff;
            } else if (Integer.parseInt(String.valueOf(arr[i])) < Integer.parseInt(String.valueOf(arr[j]))) {
               arr[i] = arr[j];
               --k;
               --diff;
            }
            ++i;
			--j;
        }
            
        
        // Change center for odd arrays.
        if (arr.length % 2 != 0 && k == 1 && i == j) {
            arr[i] = '9';
        }
		
		System.out.println(arr);
    }
	   
}
