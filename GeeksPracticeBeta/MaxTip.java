package GeeksPracticeBeta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxTip {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; i++) {
			String[] inp = in.nextLine().split(" ");
			int n = Integer.parseInt(inp[0]);
            int x = Integer.parseInt(inp[1]);
            int y = Integer.parseInt(inp[2]);
			Obj[] a = new Obj[n];
			Obj[] b = new Obj[n];
			String[] as = in.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				Obj ob = new Obj(Integer.parseInt(as[j]), j);
				a[j] = ob;
			}
			String[] bs = in.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				Obj ob = new Obj(Integer.parseInt(bs[j]), j);
				b[j] = ob;
			}
			System.out.println(maxSum(a, b, x, y));
		}
	}

	private static int maxSum(Obj[] a, Obj[] b, int x, int y) {
		int sum = 0;
		int x_count = 0, y_coutn = 0;
		Arrays.sort(a, (ob1, ob2) -> {
			return ob2.val - ob1.val;
		});
		Arrays.sort(b, (ob1, ob2) -> {
			return ob2.val - ob1.val;
		});
		int l = 0, r = 0;
		Set<Integer> set = new HashSet<>();
		int orders = 0;
		while ((x_count <= x || y_coutn <= y)) {
			if (l < a.length && x_count <= x && !set.contains(a[l].index)) {
				sum += a[l].val;
				set.add(a[l].index);
				x_count++;
				orders++;
			}
			if (r < a.length && y_coutn <= y && !set.contains(b[r].index)) {
				sum += b[r].val;
				set.add(b[r].index);
				y_coutn++;
				orders++;
			}
			l++;
			r++;
			if (orders == a.length)
				break;
		}
		return sum;
	}
}

class Obj {
	int val;
	int index;

	public Obj(int val, int index) {
		this.val = val;
		this.index = index;
	}
}
