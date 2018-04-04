package GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubsets1ToNForSum {
	public static void main(String gh[]) {
		List<Integer> list = new ArrayList<Integer>();
		sum(4, list);
	}

	private static void sum(int n, List<Integer> list) {
		if (n == 0) {
			for (Integer integer : list)
				System.out.print(integer);
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			list.add(i);
			sum(n - i, list);
			if (list.size() > 0)
				list.remove(list.size() - 1);
		}
	}
}
