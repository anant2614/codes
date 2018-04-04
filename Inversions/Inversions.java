package Inversions;

public class Inversions {
	public static void main(String agf[]) {
		int arr[] = {1, 20, 6, 4, 5};  
        printArray(arr);
        Inversions obj = new Inversions();
        int inv  = obj.sort(arr, 0, arr.length-1);
        printArray(arr);
        System.out.println("Inversions "+inv);
	}

	int merge(int arr[], int l, int m, int r) {
		int count=0;
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
				//count+=n2-j;
			} else {
				arr[k] = R[j];
				j++;
				count+=n1-i;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return count;
	}

	int sort(int arr[], int l, int r) {
		int count=0;
		if (l < r) {
			int m = (l + r) / 2;
			count+=sort(arr, l, m);
			count+=sort(arr, m + 1, r);
			count+=merge(arr, l, m, r);
		}
		return count;
	}
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
