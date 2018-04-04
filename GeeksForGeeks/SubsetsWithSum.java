package GeeksForGeeks;

public class SubsetsWithSum {

	public static void main(String arg[]) {
		int a[] = { 1, 3, 2, 5, 4, 9 };
		printSubsets(a, 9, a.length);
	}

	private static boolean printSubsets(int[] a, int k, int n) {
		if (n <= 0)
			return false;
		if (k == 0)
			return true;
		boolean l = printSubsets(a, k - a[n - 1], n - 1);
		if(l)
			System.out.print(a[n-1]+ " ");
		boolean r = printSubsets(a, k, n - 1);
		if(r)
			System.out.print(a[n-1]+" ");
		return l || r;
	}
}
