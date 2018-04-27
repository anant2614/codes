package GeeksForGeeks;

public class CeilIndex {
	public static void main(String[] ar) {
		int[] a = { 2, 5, 8, 11, 13, 15};
		System.out.println(ceilIndex(0, a.length - 1, a, 3));
	}

	private static int ceilIndex(int l, int r, int[] a, int k) {
		if (l == r)
			return l;
		int m = (l + r) / 2;
		if (k < a[m])
			return ceilIndex(l, m, a, k);
		return ceilIndex(m + 1, r, a, k);
	}
}
