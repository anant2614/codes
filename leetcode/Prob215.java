package leetcode;

import java.util.PriorityQueue;

public class Prob215 {
	public static void main(String[] ar) {
		int[] a = { 3, 2, 1, 5, 6, 4 };
		System.out.println(kLargest(a, 2));
	}

	private static int kLargest(int[] a, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(a.length, (v, b) -> {
			return b - v;
		});
		for (Integer integer : a) {
			queue.add(integer);
		}
		int i = 0;
		while (i++ < k - 1)
			queue.remove();
		return queue.peek();
	}
}
