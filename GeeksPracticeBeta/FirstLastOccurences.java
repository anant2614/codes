package GeeksPracticeBeta;

import java.util.Scanner;

public class FirstLastOccurences {
	public static void main(String[] ae) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		while (t-- > 0) {
			String st[] = in.nextLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int x = Integer.parseInt(st[1]);
			int a[] = new int[n];
			String st2[] = in.nextLine().split(" ");
			int i = 0;
			for (String string : st2) {
				a[i++] = Integer.parseInt(string);
			}
			calculate(a, x);
		}
	}

	private static void calculate(int[] a, int x) {
		System.out.println(ceilIndex(a, 0, a.length - 1, x));
		System.out.println(floorIndex(a, 0, a.length - 1, x));
	}

	private static int floorIndex(int[] a, int l, int r, int x) {
		if (l == r)
			return l;
		int m = l + (r - l) / 2;
		if (m < a.length && a[m] == x && a[m + 1] != x)
			return m + 1;
		if (a[m] <= x)
			return floorIndex(a, m, r, x);
		return floorIndex(a, l, m, x);
	}

	private static int ceilIndex(int[] a, int l, int r, int x) {
		if (l == r)
			return l;
		int m = l + (r - l) / 2;
		if (m > 0 && a[m] == x && a[m - 1] != x)
			return m - 1;
		if (a[m] < x)
			return ceilIndex(a, m, r, x);
		return ceilIndex(a, l, m, x);
	}
}
