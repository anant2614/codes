package GeeksForGeeks;

import java.util.Arrays;

public class DistinctSubseq {
	public static void main(String[] ar) {
		System.out.println(count("gfg"));
	}

	private static int count(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		int[] last = new int[26];
		Arrays.fill(last, -1);
		for (int i = 1; i <=s.length(); i++) {
			int subseq = 2 * dp[i - 1];
			if (last[s.charAt(i - 1)-97] != -1)
				subseq -= dp[last[s.charAt(i - 1)-97]];
			dp[i] = subseq;
			last[s.charAt(i - 1)-97] = i - 1;
		}
		return dp[s.length()];
	}
}
