package GeeksForGeeks;

public class SmallestMissingPositive {

	public static void main(String gh[]) {
		int a[] = { 1, 1, 0, -1, -2 };
		System.out.println(findSmallest(a, a.length));
	}

	private static int findSmallest(int[] a, int length) {
		int smallest = 0;
		for (int i = 0; i < length; i++) {
			if (a[i] != i + 1) {
				smallest = i;
				break;
			}
		}
		for (int j = smallest + 1; j < length; j++) {
			if (a[j] == smallest + 1) {
				int tmp = a[smallest];
				a[smallest] = a[j];
				a[j] = tmp;
				j--;
				smallest++;
			}
		}
		return smallest + 1;
	}
}
