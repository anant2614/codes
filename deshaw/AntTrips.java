package deshaw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class AntTrips implements Runnable{
	public static void main(String[] ar) {
		new Thread(null, new AntTrips(), "Main", 1<<26).start();
		
	}

	private static LinkedList<Integer>[] initList(int V) {
		LinkedList<Integer> adj[] = new LinkedList[V + 1];
		adj[1] = new LinkedList<>();
		adj[1].add(2);
		adj[1].add(5);

		adj[2] = new LinkedList<>();
		adj[2].add(1);
		adj[2].add(3);

		adj[3] = new LinkedList<>();
		adj[3].add(2);
		adj[3].add(4);

		adj[4] = new LinkedList<>();
		adj[4].add(3);
		adj[4].add(5);

		adj[5] = new LinkedList<>();
		adj[5].add(4);
		adj[5].add(1);
		return adj;
	}

	private static long visit(LinkedList<Integer>[] adj, int node, int trips, long target, Map<String, Long> map) {
		if (trips > target)
			return 0;
		if (node == 1 && trips == target)
			return 1;
		if (map.get(String.valueOf(node) + String.valueOf(trips)) != null)
			return map.get(String.valueOf(node) + String.valueOf(trips));
		LinkedList<Integer> li = adj[node];
		long total = 0;
		for (Integer v : li) {
			total += visit(adj, v, trips + 1, target, map)%(Math.pow(10, 9) + 7);
		}
		map.put(String.valueOf(node) + String.valueOf(trips), total);
		return (long) (total % (Math.pow(10, 9) + 7));
	}

	@Override
	public void run() {
		LinkedList<Integer>[] adj = initList(5);
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			long n = in.nextLong();
			Map<String, Long> map = new HashMap<>();
			// Arrays.fill(dp, -1);
			System.out.println(visit(adj, 1, 0, n, map));
		}
	}
}
