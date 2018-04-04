package leetcode;

public class Prob72 {
	public static void main(String[] arf) {
		String s1 = "a";
		String s2 = "ab";
		//System.out.println(minEditDis(s1, s2, 0, 0));
		System.out.println(minEditDP(s1, s2));
	}

	private static int minEditDis(String s1, String s2, int s1_i, int s2_i) {
		if (s1_i == s1.length())
			return s2.length() - s2_i;
		if (s2_i == s2.length())
			return s1.length() - s1_i;
		if (s1.charAt(s1_i) == s2.charAt(s2_i))
			return minEditDis(s1, s2, s1_i + 1, s2_i + 1);
		return 1 + Math.min(minEditDis(s1, s2, s1_i, s2_i + 1),
				Math.min(minEditDis(s1, s2, s1_i + 1, s2_i + 1), minEditDis(s1, s2, s1_i + 1, s2_i)));
	}

	private static int minEditDP(String s1, String s2) {
		int[][] dp = new int[s2.length() + 1][s1.length() + 1];
		for (int i = s2.length(); i >= 0; i--)
			dp[i][s1.length()] = s2.length() - i;
		for (int i = s1.length(); i >= 0; i--)
			dp[s2.length()][i] = s1.length() - i;
		for (int i = s2.length() - 1; i >= 0; i--) {
			for (int j = s1.length() - 1; j >= 0; j--) {
				if (s2.charAt(i) == s1.charAt(j))
					dp[i][j] = dp[i + 1][j + 1];
				else
					dp[i][j] = 1+Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
			}
		}
		return dp[0][0];
	}
}
