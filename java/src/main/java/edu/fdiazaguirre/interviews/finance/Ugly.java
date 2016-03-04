package edu.fdiazaguirre.interviews.finance;

/**
 * Utility class.
 * @author fdiazaguirre
 *
 */
public class Ugly {

	public static String uglifier(String prettyName) {
		StringBuffer sb = new StringBuffer();
		// Remove get: Assuming that starts with get
		char[] withoutPreffix = prettyName.substring(3).toCharArray();
		// Always start with a letter
		sb.append(withoutPreffix[0]);
		// Insert underscore between UPPERCASE
		char current = withoutPreffix[0], previous, next;
		for (int i = 1; i < withoutPreffix.length; i++) {
			previous = current;
			current = withoutPreffix[i];
			if (i < withoutPreffix.length - 1) {
				next = withoutPreffix[i + 1];
				// Check whether underscore is needed or not.
				if (Character.isLowerCase(previous) && Character.isUpperCase(current) || Character.isUpperCase(current) && Character.isLowerCase(next)) {
					sb.append("_");
				}
			}
			sb.append(current);
		}

		return sb.toString();
	}
}
