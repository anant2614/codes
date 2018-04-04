package Standard;

import java.util.Arrays;

public class LISdp {
	public static void main(String args[]) {
		int arr[] = { 11, 22, 9, 33 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr) + "\n");
		System.out.println("Length of lis is " + LongestIncreasingSubsequenceLength(arr, arr.length) + "\n");
	}

	//O(n^2) solution
	private static int lis(int[] arr) {
		int dp[] = new int[arr.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					if (dp[i] > max)
						max = dp[i];
				}
			}
		}
		return max;
	}
	
	//O(nlogn) solution
	static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }
	
	static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
	
}
