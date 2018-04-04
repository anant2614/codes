package Prep;

public class MaxSumNoAdjacent {
	public static void main(String ghg[]) {
		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(1);
		root.right.right = new TNode(5);
		root.right.left = new TNode(4);
		
		System.out.println(maxSumNodes(root));
	}

	private static int maxSumNodes(TNode node) {
		if(node==null)
			return 0;
		return max(node.data,maxSumNodes(node.left)+maxSumNodes(node.right));
	}

	private static int max(int a, int b) {
		return a>b?a:b;
	}
}
