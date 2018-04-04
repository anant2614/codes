package GeeksForGeeks;

public class TrajanArticulationPoint {
	static int time = 0;

	public static void main(String[] arg) {
		Graph graph = new Graph(5);
		graph.addUnDirectedEdge(1, 2);
		graph.addUnDirectedEdge(0, 2);
		graph.addUnDirectedEdge(0, 1);
		graph.addUnDirectedEdge(0, 3);
		graph.addUnDirectedEdge(3, 4);

		int[] visited = new int[graph.adj.length];
		int[] low = new int[graph.adj.length];
		int[] disc = new int[graph.adj.length];
		int[] parent = new int[graph.adj.length];
		int[] articulation = new int[graph.adj.length];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		// do DFS
		doDfs(1, graph, visited, disc, low, parent, articulation);
		for (int i = 0; i < articulation.length; i++) {
			if (articulation[i] == 1) {
				System.out.println(i);
			}
		}
	}

	private static void doDfs(int u, Graph graph, int[] visited, int[] disc, int[] low, int[] parent,
			int[] articulation) {
		low[u] = disc[u] = ++time;
		visited[u] = 1;
		int children = 0;
		for (int v : graph.adj[u]) {
			if (visited[v] == 0) {
				children++;
				parent[v] = u;
				doDfs(v, graph, visited, disc, low, parent, articulation);
				low[u] = Math.min(low[u], low[v]);
				if (parent[u] == -1 && children > 1) {
					articulation[u] = 1;
				} else if (parent[u] != -1 && low[v] >= disc[u]) {
					articulation[u] = 1;
				}
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}

	}
}
