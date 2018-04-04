package GeeksForGeeks;

public class AllCombinationsSizeR {

	public static void main(String gh[]) {
		f(5, 3, "");
	}

	static void f(int n, int k, String s) {
		if (s.length() == k) {
			System.out.println(s);
			return;
		}

		int m;
		if (s.isEmpty()) {
			m = 0;
		} else {
			m = s.charAt(s.length() - 1) - '0';
		}
		for (int i = m + 1; i <= n; i++) {
			f(n, k, s + String.valueOf(i));

		}
	}

}
