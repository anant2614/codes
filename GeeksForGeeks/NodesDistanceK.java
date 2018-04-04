package GeeksForGeeks;

public class NodesDistanceK {

	TreeNode root;
	
	public static void main(String arg[]){
		NodesDistanceK tree = new NodesDistanceK();
		 tree.root = new TreeNode(20);
	        tree.root.left = new TreeNode(8);
	        tree.root.right = new TreeNode(22);
	        tree.root.left.left = new TreeNode(4);
	        tree.root.left.right = new TreeNode(12);
	        tree.root.left.right.left = new TreeNode(10);
	        tree.root.left.right.right = new TreeNode(14);
	        TreeNode target = tree.root.left;
	        printfromTarget(target,2);
	}

	private static void printfromTarget(TreeNode node,int k) {
		if(node==null)
			return;
		printDown(node,k,0);
	}

	private static void printDown(TreeNode node, int k, int dis) {
		if(node==null)
			return;
		if(dis==k)
			System.out.println(node.key);
		printDown(node.left, k, dis+1);
		printDown(node.right, k, dis+1);
	}
}
