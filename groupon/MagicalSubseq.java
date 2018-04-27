package groupon;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicalSubseq {

	public static void main(String[] ar) {
		System.out.println(longestSubsequence("aeiiouu"));
	}

	private static int longestSubsequence(String s) {
		int[] a = new int[s.length()];
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				a[i] = 1;
				flag1 = true;
			} else if (s.charAt(i) == 'e') {
				a[i] = 2;
				flag2 = true;
			} else if (s.charAt(i) == 'i') {
				a[i] = 3;
				flag3 = true;
			} else if (s.charAt(i) == 'o') {
				a[i] = 4;
				flag4 = true;
			} else if (s.charAt(i) == 'u') {
				a[i] = 5;
				flag5 = true;
			}
		}
		if (!flag1 || !flag2 || !flag3 || !flag4 || !flag5)
			return 0;
		return findSubsequence(a);
	}

	static int printLiS(int[] arr) {
		int lis[] = new int[arr.length];
		storeLis(arr, lis);
		int maxIndex = findMaxLisIndex(lis);
		Stack<Integer> stack = new Stack<Integer>();
		int lastMaxIndex = maxIndex;
		stack.push(arr[lastMaxIndex]);
		for (int j = maxIndex - 1; j >= 0; j--) {
			if (lis[lastMaxIndex] == lis[j] + 1 && arr[lastMaxIndex] >= arr[j]) {
				stack.push(arr[j]);
				lastMaxIndex = j;
			}
		}
		findSubsequence(arr);
		if (stack.size() < 5 || !stack.contains(1) || !stack.contains(2) || !stack.contains(3) || !stack.contains(4)
				|| !stack.contains(5))
			return 0;
		return stack.size();
	}

	 static int findMaxLisIndex(int[] lis) {
		// TODO Auto-generated method stub
		int maxIndex = 0;
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > lis[maxIndex])
				maxIndex = i;
		}
		return maxIndex;

	}

	private static void storeLis(int[] arr, int[] lis) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++)
			lis[i] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] <=arr[i] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
	}
	
	public static int findSubsequence(int[] arrA) {
		int[] LIS = new int[arrA.length];
		for (int i = 0; i < arrA.length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				// check if previous elements > current element
				if (arrA[i] >= arrA[j]) {
					// update the max from the previous entries
					if (max == -1 || max < LIS[j] + 1) {
						max = 1 + LIS[j];
					}
				}
			}
			if (max == -1) {
				// means none of the previous element has smaller than arrA[i]
				max = 1;
			}
			LIS[i] = max;
		}
		// find the max in the LIS[]
		int result = -1;
		int index = -1;
		for (int i = 0; i < LIS.length; i++) {
			if (result < LIS[i]) {
				result = LIS[i];
				index = i;
			}
		}
		// Print the result
		// Start moving backwards from the end and
		String path =  arrA[index] + " ";
		int res = result-1;
		for (int i = index-1; i >= 0; i--) {
			if(LIS[i]==res){
				path =  arrA[i] + " " + path;
				res--;
			}			
		}
		if(!path.contains("1") || !path.contains("2") || !path.contains("3") || !path.contains("4") || !path.contains("5")  )
			return 0;
		return result;
	}

}
