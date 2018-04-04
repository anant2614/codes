package DP;

public class SubsetSum {
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		boolean dp[][] = new boolean[sum + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= set[j - 1]) {
					dp[i][j] = dp[i][j] || dp[i - set[j - 1]][j - 1];
				}
			}
		}
		
		 for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
              System.out.print(dp[i][j]+"	");
           System.out.println();
         }
		return dp[sum][n];
	}

}
