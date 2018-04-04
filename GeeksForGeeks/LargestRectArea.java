package GeeksForGeeks;

import java.util.Stack;

public class LargestRectArea {
	public static void main(String[] arg) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(findMax(hist));
	}

	private static int findMax(int[] a) {
		int max = 0;
		Stack<Integer> s = new Stack<>();
		int i = 0;
		for (; i < a.length;) {
			if (s.isEmpty() || a[s.peek()] <= a[i]) {
				s.push(i);
				i++;
			} else {
				int top = s.pop();
				max = Math.max(max, a[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			max = Math.max(max, a[top] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return max;
	}

}
