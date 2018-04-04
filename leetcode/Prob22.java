package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Prob22 {
	public static void main(String[] ar) {
		List<String> li = new ArrayList<>();
		print("", 0, 0, 4, li);
		System.out.println(li);
	}

	private static void print(String s, int l, int r, int n, List<String> li) {
		if (s.length() == n)
			if (l == r)
				li.add(s);
		if (s.length() > n || r > l)
			return;
		print(s + "(", l + 1, r, n, li);
		print(s + ")", l, r + 1, n, li);
	}
}
