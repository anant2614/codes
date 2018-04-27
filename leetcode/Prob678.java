package leetcode;

public class Prob678 {
	public static void main(String[] ar) {
		System.out.println(isValid(
				"(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))"));
	}

	private static boolean isValid(String s) {
		int low = 0, high = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				low += 1;
				high += 1;
			} else if (s.charAt(i) == ')') {
				low = Math.max(0, low - 1);
				high -= 1;
			} else {
				low = Math.max(0, low - 1);
				high += 1;
			}
			if (high < 0)
				return false;
		}
		return low == 0;
	}
}
