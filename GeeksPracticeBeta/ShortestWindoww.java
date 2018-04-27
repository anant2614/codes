package GeeksPracticeBeta;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShortestWindoww {
	public static void main(String[] ar) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		while (t > 0) {
			System.out.println(shortestWindow(in.nextLine()));
			t--;
		}
	}

	private static int shortestWindow(String s) {
		if (s == null)
			return 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		int num = set.size();
		int l = 0, r = 0;
		int a[] = new int[26];
		int count = 0;
		while (r < s.length()) {
			char c = s.charAt(r);
			if (a[c - 97] == 0) {
				count++;
			}
			a[c - 97]++;
			if (count == num)
				break;
			r++;
		}
		int min = r - l + 1;
		while (r < s.length() && r - l + 1 >= num) {
			while (l < s.length()) {
				a[s.charAt(l) - 97]--;
				if (a[s.charAt(l) - 97] == 0) {
					l++;
					count--;
					break;
				}
				l++;
			}
			min = Math.min(min, r - l + 2);
			r++;
			while (r < s.length()) {
				char c = s.charAt(r);
				if (a[c - 97] == 0) {
					count++;
				}
				a[c - 97]++;
				if (count == num)
					break;
				r++;
			}
			if (count == num)
				min = Math.min(min, r - l + 1);
		}
		return min;
	}
}
