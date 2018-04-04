package leetcode;

import java.util.Stack;

public class Prob32 {
	public static void main(String[] ar) {
		System.out.println(longestValidParen(")()())()()("));
	}

	private static int longestValidParen(String s) {
		int max = -1;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty() || s.charAt(i) == '(')
				st.push(i);
			else if (s.charAt(st.peek()) == '(') {
				st.pop();
				if (st.isEmpty())
					max = Math.max(max, i + 1);
				else {
					max = Math.max(max, i - st.peek());
				}
			}
			else
				st.push(i);
			System.out.println(max);
		}
		return max;
	}
}
