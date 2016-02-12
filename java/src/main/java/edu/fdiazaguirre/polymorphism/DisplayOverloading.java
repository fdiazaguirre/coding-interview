package edu.fdiazaguirre.polymorphism;

/**
 * Method overloading is also known as Static Polymorphism.
 * 
 */
public class DisplayOverloading {

	/**
	 * Base method.
	 */
	public String disp(char c) {
		return "Base method" + c;
	}

	/**
	 * Example 1: Overloading – Different Number of parameters in argument list
	 */
	public String disp(char c, char n) {
		return "Example 1" + c + n;
	}

	/**
	 * Example 2: Overloading – Difference in data type of arguments.
	 * @return 
	 */
	public String disp(int c) {
		return "Example 2" + c;
	}

	/**
	 * Example3: Overloading – Sequence of data type of arguments.
	 * @return 
	 */
	public String disp2(char c, int n) {
		return "Example 3: I’m the first definition of method disp2-" + c + n;
	}

	public String disp2(int n, char c) {
		return "Example 3: I’m the second definition of method disp2-" + n + c;
	}

}
