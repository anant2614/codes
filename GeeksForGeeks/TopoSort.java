package GeeksForGeeks;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopoSort {

	private static int V = 6;
	private static LinkedList<Integer> adj[] = new LinkedList[V];
	private static Boolean visited[] = new Boolean[V];

	public TopoSort() {
		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList<Integer>();
			visited[i] = false;
		}
	}

	public static void main(String arg[]) {
		TopoSort g = new TopoSort();
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
		g.topoSort();
	}

	private void topoSort(){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<V;i++){
			if(!visited[i])
			dfs(i,stack);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
	
	private void dfs(int v, Stack<Integer> stack) {
		visited[v] = true;
		List<Integer> neighbors = adj[v];
		for (Integer vertex : neighbors) {
			if(!visited[vertex])
			dfs(vertex, stack);
		}
		stack.push(v);
	}

	private void addEdge(int u, int v) {
		adj[u].add(v);
	}
}
