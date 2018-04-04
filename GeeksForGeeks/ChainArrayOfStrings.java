package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class ChainArrayOfStrings {
	public static void main(String[] ar) {
		String[] st = { "ijk", "kji","abc","cba"};
		System.out.println(ifChained(st));
	}

	private static boolean ifChained(String[] st) {
		Map<Integer, Integer> in_map = new HashMap<>();
		Map<Integer, Integer> out_map = new HashMap<>();
		Graph graph = new Graph(26);
		int[] mark = new int[26];
		for (String s : st) {
			int f = 122 - s.charAt(0) ;
			int l = 122 - s.charAt(s.length() - 1) ;
			int count = in_map.containsKey(f) ? in_map.get(f) : 0;
			in_map.put(f, count + 1);
			int count2 = out_map.containsKey(l) ? out_map.get(l) : 0;
			out_map.put(l, count2 + 1);
			graph.addDirectedEdge(f, l);
			mark[f] = 1;
			mark[l] = 1;
		}

		if (in_map.size() != out_map.size())
			return false;

		for (Map.Entry<Integer, Integer> entry : in_map.entrySet()) {
			if (out_map.get(entry.getKey()) != entry.getValue())
				return false;
		}

		// do dfs
		return isConnected(graph, mark, 122 - st[0].charAt(0));
	}

	private static boolean isConnected(Graph graph, int[] mark, int source) {
		int[] visited = new int[26];
		doDfs(graph, visited, source);
		for (int i = 0; i < mark.length; i++) {
			if (visited[i] != mark[i])
				return false;
		}
		return true;
	}

	private static void doDfs(Graph graph, int[] visited, int source) {
		visited[source] = 1;
		for (int node : graph.adj[source]) {
			if (visited[node] != 1)
				doDfs(graph, visited, node);
		}
	}

}
