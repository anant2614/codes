package GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class PArtitionOfNumber {

	public static void main(String hj[]) {
		List<Integer> list = new ArrayList<Integer>();
		int parts = 4;
		sum(5, list, 1, parts);
	}

	private static void sum(int n, List<Integer> list, int index, int parts) {
		if (n == 0 && list.size() == parts) {
			for (Integer integer : list)
				System.out.print(integer);
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			list.add(i);
			sum(n - i, list, index + 1, parts);
			if (list.size() > 0)
				list.remove(list.size() - 1);
		}
	}
}
