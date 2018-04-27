package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BoxStacking {
	public static void main(String[] ar) {
		Box[] arr = new Box[2];
		arr[0] = new Box(1, 2, 4);
		arr[1] = new Box(3, 2, 5);

		System.out.println(maxHeight(arr));
	}

	private static int maxHeight(Box[] a) {
		int sum = 0;
		PriorityQueue<Box> queue = new PriorityQueue<>((b1, b2) -> {
			return (b2.l * b2.b) - (b1.l * b1.b);
		});
		for (Box box : a) {
			queue.add(box);
		}
		int max_length = Integer.MAX_VALUE;
		int max_width = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Box box = queue.poll();
			if (box.l < max_length && box.b < max_width) {
				sum += box.h;
				max_length = box.l;
				max_width = box.b;
			}
			if (box.flag) {
				box.setValues(box.b, box.h, box.l);
				queue.add(box);
			}
		}
		return sum;
	}

}

class Box {
	int l, b, h;
	boolean flag;

	public Box(int l, int b, int h) {
		List<Integer> li = new ArrayList<>();
		li.add(l);
		li.add(b);
		li.add(h);
		Collections.sort(li);
		this.l = li.get(2);
		this.b = li.get(1);
		this.h = li.get(0);
		this.flag = true;
	}

	public void setValues(int l, int b, int h) {
		this.l = l;
		this.b = b;
		this.h = h;
		this.flag = false;
	}
}
