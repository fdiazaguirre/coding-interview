package edu.fdiazaguirre.amazon;

import java.util.Set;

public class SecondRound {

	/**
	 * Print spiral
	 * 
	 * */
	public static void printMatrixSpiral(int[][] matrix, int rowSize, int columnSize) {
		int i,  startingRow = 0, startingColumn = 0;
	    rowSize--;  columnSize--;      

	    while(startingRow <= rowSize && startingColumn <= columnSize){
	        for(i = startingColumn; i <= columnSize; ++i) {
	            System.out.print(matrix[startingRow][i]+ " ");
	        }           
	        startingRow++;

	        for(i = startingRow; i <= rowSize; ++i) {
	            System.out.print(matrix[i][columnSize] + " ");
	        }
	        columnSize--;

	        for(i = columnSize; i >= startingColumn; --i) {
	                System.out.print(matrix[rowSize][i] + " ");
	        }
	        rowSize--;


	        for(i = rowSize; i >= startingRow; --i) {
	            System.out.print(matrix[i][startingColumn] + " ");
	        }
	        startingColumn++;
	    }
	}
	
	/**
	 * @param {Date Timestamp, Long customerId, String pagerURI} log
	 * @param {Date} window
	 * 
	 * @return {Set<Long>} user that visited 5 different pages or more for the given window
	 * */
	public Set<Long> getCustomers() {
		return null;
	}
}
