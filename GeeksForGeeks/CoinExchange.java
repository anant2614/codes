package GeeksForGeeks;

public class CoinExchange {
	public static void main(String hj[]) {
		int a[] = {1,2,3};
		CoinExchange obj = new CoinExchange();
		int ways1 = obj.findCoins(a, a.length - 1, 3);
		System.out.println(ways1);
		int ways2 = obj.findUniqueCoins(a, a.length - 1, 3);
		System.out.println(ways2);
	}

	// when same amount coins can repeat
	private int findCoins(int[] a, int m, int N) {
		if (N == 0)
			return 1;
		if (N < 0 || (m < 0 && N >= 1))
			return 0;
		return findCoins(a, m, N - a[m]) + findCoins(a, m - 1, N);
	}

	// when same amount coins cannot repeat
	private int findUniqueCoins(int[] a, int m, int N) {
		if (N == 0)
			return 1;
		if (N < 0 || (m < 0 && N >= 1))
			return 0;
		return findUniqueCoins(a, m - 1, N - a[m]) + findUniqueCoins(a, m - 1, N);
	}
}
