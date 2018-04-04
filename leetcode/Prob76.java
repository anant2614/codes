package leetcode;

import java.util.Arrays;

public class Prob76 {
	public static void main(String[] ar) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}

	private static String minWindow(String s, String t) {
		int[] ch = new int[256];
		int count = t.length();
		int l = 0, r = 0, beg = 0, d = Integer.MAX_VALUE;
		for (int i = 0; i < t.length(); i++)
			ch[t.charAt(i)]++;
		for (int i = 0; i < t.length(); i++) {
			if (ch[t.charAt(i)] == 0)
				ch[t.charAt(i)] = 0 - s.length();
		}
		while (r < s.length()) {
			if (ch[s.charAt(r)]-- > 0) {
				count--;
			}
			while (count == 0) {
				d = Math.min(d, r - l + 1);
				if (ch[s.charAt(l)]++ == 0) {
					count++;
				}
				beg = l;
				l++;
			}
			r++;
		}
		return s.substring(beg, beg + d);
	}
}
