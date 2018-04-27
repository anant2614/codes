package GeeksForGeeks;

public class MinimumMergeOperationsToMakePallindrome {
	public static void main(String[] ar) {
		int[] a = {11, 14, 15, 99 };
		System.out.println(minOps(a, 0, a.length - 1));
	}

	private static int minOps(int[] a, int l, int r) {
		if (l == r)
			return 0;
		if (a[l] > a[r]) {
			a[l + 1] += a[l];
			return 1 + minOps(a, l + 1, r);
		}
		if (a[r] > a[l]) {
			a[r - 1] += a[r];
			return 1 + minOps(a, l, r - 1);
		}
		return minOps(a, l + 1, r - 1);
	}
}
