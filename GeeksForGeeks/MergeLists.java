package GeeksForGeeks;

public class MergeLists {
	public static void main(String[] ar) {
		Node a = new Node(1);
		a.next = new Node(3);
		Node b = new Node(2);
		b.next = new Node(6);
		merge(a, b);
		System.out.println(a);
	}

	private static Node merge(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data <= b.data) {
			a.next = merge(a.next, b);
			return a;
		}
		b.next = merge(a, b.next);
		return b;
	}
}
