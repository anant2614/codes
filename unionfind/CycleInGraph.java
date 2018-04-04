package unionfind;

import GeeksForGeeks.Edge;
import GeeksForGeeks.Graph;

public class CycleInGraph {
	public static void main(String[] ar) {
		int V = 3;
		Graph graph = new Graph(V);
		graph.addUnDirectedEdge(0, 1);
		graph.addUnDirectedEdge(1, 2);
		graph.addUnDirectedEdge(2, 0);

		System.out.println(doesCycleExist(graph, V));
	}

	private static boolean doesCycleExist(Graph graph, int V) {
		UnionFind unionFind = new UnionFind(V);
		for (Edge edge : graph.getEdges()) {
			if (unionFind.find(edge.getSource()) == unionFind.find(edge.getDest()))
				return true;
			unionFind.union(edge.getSource(), edge.getDest());
		}
		return false;
	}
}
