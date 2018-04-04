package leetcode;

import java.util.Stack;

public class Prob85 {
	public static void main(String[] arg) {
		int[][] mat = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		System.out.println(maximalArea(mat));
	}

	private static int maximalArea(int[][] mat) {
		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]!=0)
				mat[i][j] += mat[i - 1][j];
			}
		}
		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			max = Math.max(max, findMax(mat[i]));
		}
		return max;
	}

	private static int findMax(int[] a) {
		int max = 0;
		Stack<Integer> s = new Stack<>();
		int i = 0;
		for (; i < a.length;) {
			if (s.isEmpty() || a[s.peek()] <= a[i]){
				s.push(i);
				i++;
			}
			else {
				int top = s.pop();
				max = Math.max(max, a[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
		}
		while(!s.isEmpty()){
			int top = s.pop();
			max = Math.max(max, a[top] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return max;
	}

}
