package GeeksForGeeks;

import java.util.Stack;

public class LongestValidSubseq {
	public static void main(String[] ar) {
		System.out.println(longestBracketValid("())(())(())("));
	}

	private static int longestBracketValid(String s) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || s.charAt(i) == '(')
				stack.push(s.charAt(i));
			else {
				if (stack.peek() == '(') {
					count += 2;
					stack.pop();
				}
			}
		}
		return count;
	}
}
