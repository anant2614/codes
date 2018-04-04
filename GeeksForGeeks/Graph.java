package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {
	List<Integer>[] adj;
	List<Edge> edges;

	public Graph(int V) {
		adj = new List[V];
		edges = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public void addDirectedEdge(int s, int d) {
		adj[s].add(d);
	}

	public void addUnDirectedEdge(int s, int d) {
		adj[s].add(d);
		adj[d].add(s);
		edges.add(new Edge(s, d));
	}

	public Graph getTranspose() {
		Graph g = new Graph(adj.length);
		for (int v = 0; v < adj.length; v++) {
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(v);
		}
		return g;
	}

	public static void main(String[] arg) {
		Graph graph = new Graph(4);
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(0, 2);
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(2, 3);
		graph = graph.getTranspose();
		System.out.println(graph);
	}
}
