package GeeksForGeeks;

public class BIT {
	public static void main(String[] ar) {
		int[] a = { 5, 1, 6, 4, 2, 3, 3 };
		int[] bit = new int[a.length + 1];
		constructBit(a, bit);
		System.out.println(getSumTillIndex(bit, 5));
		System.out.println("Kth smallest::: >  "+ kthSmallest(bit, 3));
	}

	private static void constructBit(int[] a, int[] bit) {
		for (int i = 0; i < a.length; i++) {
			update(bit, i, a[i]);
		}
	}

	private static void update(int[] bit, int index, int x) {
		index = index + 1;
		while (index <= bit.length - 1) {
			bit[index] += x;
			index += index & (-index);
		}
	}

	private static int getSumTillIndex(int[] bit, int index) {
		index = index + 1;
		int sum = 0;
		while (index > 0) {
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}

	private static int kthSmallest(int[] bit, int k) {
		int l = 1;
		int h = bit.length;
		while (l < h) {
			int mid = (l + h) / 2;
			if (k <= sum(mid, bit))
				h = mid;
			else
				l = mid + 1;
		}

		return l;
	}

	static int sum(int i, int[] BIT) {
		int ans = 0;
		while (i > 0) {
			ans += BIT[i];
			i = i - (i & (-i));
		}

		return ans;
	}

}
