package HackeEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Codechef.FasterScanner;

public class MonkGraphs {
	static FasterScanner inp = new FasterScanner();

	public static void main(String args[]) throws Exception {
		String line = inp.nextLine();
		int N = Integer.valueOf(line.split(" ")[0]);
		int M = Integer.valueOf(line.split(" ")[1]);
		int k = Integer.valueOf(line.split(" ")[2]);

		List<List<Node>> lists = new ArrayList<List<Node>>(N);
		Node[] nodes=new Node[N];

		for (int i = 0; i < N; i++) {
			Node node = new Node(i + 1, inp.nextInt());
			nodes[i]=node;
			List<Node> list = new ArrayList<Node>();
			lists.add(list);
		}
		for (int i = 0; i < M; i++) {
			int id = inp.nextInt();
			int index = inp.nextInt();
			lists.get(id-1).add(nodes[index-1]);
			lists.get(index-1).add(nodes[id-1]);
		}
		for(int i=0;i<lists.size();i++){
			List<Node> list = lists.get(i);
			/*for (Node node : list) {
				System.out.println(i+1+" -->> "+node.id);
			}*/
			Collections.sort(list,new Comparator<Node>() {
				@Override
				public int compare(Node node1, Node node2) {
					return node2.val-node1.val;
				}
			});
			System.out.println(list.get(k-1).id);
		}
	}
}

class Node {
	public Node(int id, int val) {
		this.id = id;
		this.val = val;
	}

	int val;
	int id;
}