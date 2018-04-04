package unionfind;

public class UnionFind {
	int num;
	int[] p;
	int[] rank;

	public UnionFind(int num) {
		this.num = num;
		this.p = new int[num];
		this.rank = new int[num];

		for (int i = 0; i < num; i++) {
			p[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		if (p[x] == x)
			return x;
		p[x] = find(p[x]);
		return p[x];
	}

	public void union(int x, int y) {
		int xroot = find(x);
		int yroot = find(y);
		if (xroot == yroot)
			return;
		if (rank[xroot] > rank[yroot]) {
			p[y] = xroot;
			rank[xroot] += 1;
		} else if (rank[xroot] < rank[yroot]) {
			p[x] = yroot;
			rank[yroot] += 1;
		} else {
			p[y] = x;
			rank[x] += 1;
		}
	}
}
