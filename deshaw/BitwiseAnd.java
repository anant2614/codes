package deshaw;

public class BitwiseAnd {
	public static void main(String[] ar) {
		int[] a = {1,2,3};
		System.out.println(xorSum(a, 3));
	}

	static int xorSum(int arr[], int n) {

		int bits = 0;

		// Finding bitwise OR of all elements
		for (int i = 0; i < n; ++i)
			bits &= arr[i];

		int ans = bits * (int) Math.pow(2, n - 1);

		return ans;
	}

}
