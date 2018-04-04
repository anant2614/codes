package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Prob210 {
	public static void main(String[] ar) {
		int[][] mat = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		findOrder(mat);
	}

	private static void findOrder(int[][] mat) {
		Stack<Integer> st = new Stack<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (!set.contains(mat[i][j])) {
					printTopoSort(st, mat, set, mat[i][j]);
				}
			}
		}
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	private static void printTopoSort(Stack<Integer> st, int[][] mat, Set<Integer> set, int k) {
		set.add(k);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (mat[i][j] == k && !set.contains(mat[i][j])) {
					printTopoSort(st, mat, set, mat[i][j]);
				}
			}
		}
		st.push(k);
	}
}
