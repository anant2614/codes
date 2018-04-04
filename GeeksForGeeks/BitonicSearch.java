package GeeksForGeeks;

public class BitonicSearch {

	public static void main(String gh[]) {
		int arr[] = {120, 100, 80, 20, 0};
		System.out.println(search(arr, 0, arr.length-1, arr.length));
	}

	private static int search(int[] a, int l, int r, int max) {
		if (l == r)
			return a[l];
		if (l + 1 == r && a[l] >= a[r])
			return a[l];
		if (l + 1 == r && a[r] > a[l])
			return a[r];
		int mid = (l + r) / 2;
		if (a[mid] > a[mid + 1] && a[mid] >= a[mid - 1])
			return a[mid];
		if (a[mid] < a[mid + 1] && a[mid] >= a[mid - 1])
			return search(a, mid + 1, r, max);
		return search(a, l, mid, max);
	}
}
