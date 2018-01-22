package edu.fdiazaguirre.hackerrank;

public class Solution {
	static final char[] VOCABULARY = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static final int OFFSET = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < VOCABULARY.length; i++) {
			System.out.println(Character.getNumericValue(VOCABULARY[i]) - OFFSET);
		}
	}

}
