package GeeksForGeeks;

public class SearchInSortedRotated {
	public static void main(String[] aer) {
		int[] a = { 2,3,4,1 };
		System.out.println(min(a, 0, a.length - 1));
	}

	private static int min(int[] a, int l, int r) {
		if (a[l] < a[r])
			return a[l];
		int m = (l + r) / 2;
		if (a[m] < a[m - 1] && a[m] < a[m + 1])
			return a[m];
		if (a[l] < a[m])
			return min(a, m + 1, r);
		return min(a, l, m - 1);
	}
}
