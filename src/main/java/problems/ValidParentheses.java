package com.lucaslouca.other;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author lucas
 *
 */
public class ValidParentheses {

	private static boolean validate(String str) {
		boolean result = true;

		int openParentheses = 0;
		int openSquare = 0;
		int openCurly = 0;

		for (char c : str.toCharArray()) {
			switch (c) {
			case '(':
				openParentheses++;
				break;
			case ')':
				openParentheses--;
				break;
			case '{':
				openCurly++;
				break;
			case '}':
				openCurly--;
				break;
			case '[':
				openSquare++;
				break;
			case ']':
				openSquare--;
				break;
			default:
				break;
			}

			if (openParentheses < 0 || openCurly < 0 || openSquare < 0) {
				result = false;
				break;
			}
		}

		if (openParentheses > 0 || openCurly > 0 || openSquare > 0) {
			result = false;
		}

		return result;
	}

	public static void main(String[] args) {
		String valid = "(({[]}{}))";
		String valid2 = "(()()()()())";
		String invalid = "(({[]}{})";
		String invalid2 = "(){[]}{})";

		System.out.println(validate(valid));
		System.out.println(validate(valid2));
		System.out.println(validate(invalid));
		System.out.println(validate(invalid2));
	}

}
