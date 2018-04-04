package DP;

public class RodCutting {

	 public static void main(String args[])
	    {
	        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	        int size = arr.length;
	        System.out.println("Maximum Obtainable Value is " +
	                            cutRod(arr, size));
	    }

	private static int cutRod(int[] p, int size) {
		//C(i) = P(k)+C(i-k) 
		//for  1<=k<=i
		int dp[] = new int[size+1];
		dp[1]=p[0];
		for(int i=1;i<size;i++){
			int max=p[i];
			for(int k=1;k<i;k++){
				max = Math.max(max, p[k]+dp[i-k]);
			}
			dp[i+1]=max;
		}
		return dp[size];
	}
}
