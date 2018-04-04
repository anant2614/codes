package Inversions;

public class Inersion_1 {
	public static void main(String agf[]) {
		int arr[] = {5, 0, 10, 2, 4, 1, 6}; 
        int count = calculateGreater(arr);
        Inversions.printArray(arr);
        System.out.println("Inversions "+count);
	}

	private static int calculateGreater(int[] arr) {
		 Inversions obj = new Inversions();
		 for(int i=0;i<arr.length;i++)
			 arr[i]=i*arr[i];
		 return obj.sort(arr, 0, arr.length-1);
	}
}
