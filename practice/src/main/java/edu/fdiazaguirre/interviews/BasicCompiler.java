package edu.fdiazaguirre.interviews;

import java.util.Stack;

public class BasicCompiler {
	static final char[] opening = {'{','[','('};
	static final  char[] closing = {'}',']',')'};

	public static boolean compile(String input) {
		Stack<Character> toBeClosed = new Stack<Character>();
		char[] characters = input.toCharArray();
		if (characters.length > 0 && !isOpening(characters[0])) return false;
		for (int index = 0; index < characters.length; index++) {
			char underEvaluation = characters[index];
			if (isOpening(underEvaluation)) {
				toBeClosed.push(underEvaluation);
			}
			if(isClosing(underEvaluation)) {
				toBeClosed.pop();
			}
		}
		return true;
	}

	private static boolean isOpening(char c) {
		return contains(opening, c);
	}

	private static boolean isClosing(char c) {
		return contains(closing, c);
	}
	
	private static boolean contains(char[] collection, char c) {
		for (int i = 0; i < collection.length; i++) {
			if (collection[i] == c) {
				return true;
			}
		}
		return false;
	}
}
