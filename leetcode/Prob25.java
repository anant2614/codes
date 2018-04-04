package leetcode;

public class Prob25 {
	public static void main(String[] arg) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(8);
		// Node r = null;
		// Node q = node;
		// Node p = node;
		// while (q != null) {
		// q = p.next;
		// p.next = r;
		// r = p;
		// p = q;
		// }
		// System.out.println(r);
		System.out.println(length(node));
		Node head = reverseInK(node, node, 1, 3, 6);
		System.out.println(head);
	}

	private static int length(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	private static Node reverseInK(Node p, Node q, int k, int K, int len) {
		if (len - k < K - 1)
			return p;
		int i = 1;
		Node head = p;
		Node r = null;
		while (i++ <= K) {
			q = p.next;
			p.next = r;
			r = p;
			p = q;
		}
		head.next = reverseInK(p, q, k + K, K, len);
		return r;
	}
}
