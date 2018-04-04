package GeeksForGeeks;

import java.util.LinkedList;
import java.util.List;

public class CycleInGraph {
	
	private static int V=4;
	private static LinkedList<Integer> adj[] = new LinkedList[V];
	private static Boolean visited[] = new Boolean[V];
	
	public CycleInGraph() {
		for (int i=0; i<V; ++i){
            adj[i] = new LinkedList<Integer>();
            visited[i]=false;
		}
	}
	
	public static void main(String arg[]) {
		CycleInGraph obj = new CycleInGraph();
		obj.addEdge(0, 1, adj);
		obj.addEdge(0, 2, adj);
		obj.addEdge(1, 2, adj);
		obj.addEdge(2, 0, adj);
		obj.addEdge(2, 3, adj);
		obj.addEdge(3, 3, adj);
		obj.printList(adj);
		Boolean isCycle = obj.detectCycle(adj,0);
		System.out.println(isCycle);
	}

	private Boolean detectCycle(LinkedList<Integer>[] adj,int v) {
		if(visited[v])
			return true;
		visited[v]=true;
		List<Integer> neighbors = adj[v];
		for (Integer vertex : neighbors) {
			return detectCycle(adj, vertex);
		}
		return false;
	}

	private void printList(LinkedList<Integer>[] adj) {
		for(int i=0;i<adj.length;i++){
			LinkedList<Integer> linkedList = adj[i];
			for (Integer val : linkedList) {
				System.out.println(i+" -->> "+val);
			}
			System.out.println();
		}
	}

	private void addEdge(int u, int v, LinkedList<Integer> adj[]) {
		adj[u].add(v);
	}
}
