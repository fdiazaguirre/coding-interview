package edu.fdiazaguirre.interviews;

public class Chess {

	public static boolean isWhite(int row, int column) {
		return (row % 2) != (column % 2);
	}
	
	
	public static void main(String[] args) {
		//false
		System.out.println(Chess.isWhite(1, 1));
		System.out.println(Chess.isWhite(1, 3));
		System.out.println(Chess.isWhite(999, 889));
		System.out.println(Chess.isWhite(1000, 888));
		System.out.println(Chess.isWhite(2, 2));
		
		//true
		System.out.println(Chess.isWhite(1, 2));
		System.out.println(Chess.isWhite(1, 8));
		System.out.println(Chess.isWhite(999, 888));
	}

}
