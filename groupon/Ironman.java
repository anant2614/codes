package groupon;

public class Ironman {
	public static void main(String[] ar) {
		int[] a = { -5, 4, -3, 2, 1 };
		System.out.println(calc(a));
	}

	private static int calc(int[] a) {
		int sum = 0;
		int min = 0;
		for (int i : a) {
			sum += i;
			min = Math.min(sum, min);
		}
		return Math.abs(min) + 1;
	}
}
