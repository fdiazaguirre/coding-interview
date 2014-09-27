package edu.fdiazaguirre.interviews;

import java.util.Stack;

public class BasicCompiler {
	static final char[] opening = {'{','[','('};
	static final  char[] closing = {'}',']',')'};

	public static boolean compile(String input) {
		Stack toBeClosed = new Stack();
		char[] characters = input.toCharArray();
		if (characters.length > 0 && !isOpening(characters[0])) return false;
		for (int index = 0; index < characters.length; index++) {
			char underEvaluation = characters[index];
			if (isOpening(underEvaluation)) {
				toBeClosed.push(underEvaluation);
			} else {
				toBeClosed.pop();// should match with closing[index] use Guava
			}
		}
		return false;
	}

	private static boolean isOpening(char firstChar) {
		for (int i = 0; i < opening.length; i++) {
			if (opening[i] == firstChar) {
				return true;
			}
		}
		return false;
	}

}
