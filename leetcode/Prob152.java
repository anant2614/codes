package leetcode;

public class Prob152 {
	public static void main(String[] ar) {
		int[] a = { -1, -3, -10, 0, 60 };
		System.out.println(maxProd(a));
	}

	private static int maxProd(int[] a) {
		int maxNeg = 1, maxPos = 1, max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				max = Math.max(max, a[i] * maxNeg);
				int prev = maxNeg;
				maxNeg = Math.min(maxNeg, Math.min(a[i], maxPos * a[i]));
				maxPos = Math.max(1, prev * a[i]);
			} else if (a[i] > 0) {
				max = Math.max(max, a[i] * maxPos);
				maxNeg = Math.min(maxNeg, maxNeg * a[i]);
				maxPos = Math.max(maxPos, maxPos * a[i]);
			} else {
				maxNeg = 1;
				maxPos = 1;
			}
		}
		return max;
	}
}
