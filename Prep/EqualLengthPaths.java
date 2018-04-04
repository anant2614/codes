package Prep;

import java.util.HashMap;
import java.util.Map;

public class EqualLengthPaths {

	public static void main(String gh[]) {
		TNode root = new TNode(10);
		root.left = new TNode(8);
		root.right = new TNode(2);
		root.left.left = new TNode(3);
		root.left.right = new TNode(5);
		root.right.right = new TNode(4);
		root.right.left = new TNode(2);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		equalLengthPaths(root, map, 0);
		System.out.println(map);
	}

	private static void equalLengthPaths(TNode node, Map<Integer, Integer> map, int length) {
		if (node == null)
			return;
		length++;
		if (node.left == null && node.right == null) {
			if (map.get(length) != null)
				map.put(length, map.get(length) + 1);
			else
				map.put(length, 1);
			return;
		}
		equalLengthPaths(node.left, map, length);
		equalLengthPaths(node.right, map, length);
		length--;
	}

}
