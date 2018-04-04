package Prep;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeafPaths {

	public static void main(String gh[]) {
		/*TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		root.left.right.right = new TNode(6);
		root.left.right.left = new TNode(7);*/
		TNode root = new TNode(10);
		root.left = new TNode(8);
		root.right = new TNode(2);
		root.left.left = new TNode(3);
		root.left.right = new TNode(5);
		root.right.right = new TNode(4);
		root.right.left = new TNode(2);
		List<TNode> list = new ArrayList<TNode>();
		printPaths(root, list);
	}

	private static void printPaths(TNode node, List<TNode> list) {
		if (node == null)
			return;
		list.add(node);
		if (node.left == null && node.right == null) {
			printList(list);
			return;
		}
		printPaths(node.left, list);
		list.remove(node.left);
		printPaths(node.right, list);
		list.remove(node.right);
	}

	private static void printList(List<TNode> list) {
		for (TNode node : list) {
			System.out.print(node.data + " ");
		}
		System.out.println();
	}
}
