package GeeksForGeeks;

public class CheckPartitioningEqualHalves {

	public static void main(String gh[]) {
		int arr[] = { 3, 1, 2, 11, 15 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(checkForHalves(arr, arr.length - 1, sum / 2));
	}

	private static boolean checkForHalves(int[] arr, int n, int sum) {
		if (n <= 0)
			return false;
		if (arr[n - 1] == sum) 
			return true;
		return checkForHalves(arr, n - 1, sum) || checkForHalves(arr, n - 1, sum - arr[n - 1]);
	}
}
