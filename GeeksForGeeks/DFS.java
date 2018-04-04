package GeeksForGeeks;

import java.util.LinkedList;
import java.util.List;

public class DFS {

	private static int V = 4;
	private static LinkedList<Integer> adj[] = new LinkedList[V];
	private static Boolean visited[] = new Boolean[V];

	public DFS() {
		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList<Integer>();
			visited[i] = false;
		}
	}

	public static void main(String arg[]) {
		DFS obj = new DFS();
		obj.addEdge(0, 1, adj);
		obj.addEdge(0, 2, adj);
		obj.addEdge(1, 2, adj);
		obj.addEdge(2, 0, adj);
		obj.addEdge(2, 3, adj);
		obj.addEdge(3, 3, adj);
		//obj.dfs(2);
		obj.dfs();
	}

	private void dfs() {
		for (int i = 0; i < V; ++i) {
			if(!visited[i])
			dfs(i);
		}
	}

	private void dfs(int v) {
		visited[v] = true;
		System.out.println(v);
		List<Integer> neighbors = adj[v];
		for (Integer vertex : neighbors) {
			if(!visited[vertex])
			dfs(vertex);
		}
	}

	private void addEdge(int u, int v, LinkedList<Integer> adj[]) {
		adj[u].add(v);
	}

}
