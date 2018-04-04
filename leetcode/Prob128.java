package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Prob128 {
	public static void main(String[] arg) {
		int[] a = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecSeq(a));
	}

	private static int longestConsecSeq(int[] a) {
		int max = 1;
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		for (int num : a) {
			if (!set.contains(num - 1)) {
				int st = num + 1;
				while (set.contains(st))
					st++;
				max = Math.max(max, st - num);
			}
		}
		return max;
	}
}
