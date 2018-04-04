package leetcode;

public class Prob45 {
	public static void main(String[] arg) {
		int[] a = { 2, 3, 1, 1, 4 };
		System.out.println(minJumps(a));
	}

	private static int minJumps(int[] a) {
		int step = 1, count = a[0];
		int maxR = a[0];
		for (int i = 1; i < a.length; i++) {
			count--;
			if (count == 0) {
				step++;
			}
			if (a[i] + i >= a.length-1)
				return step++;
			count--;
			// maxR = Math.max(maxR, i + a[i]);
		}
		return step;
	}
}
