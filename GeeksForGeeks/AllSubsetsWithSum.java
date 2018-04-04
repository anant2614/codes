package GeeksForGeeks;

public class AllSubsetsWithSum {

	public static void main(String gh[]) {
		int a[] = { 1, 5, -8 ,3 ,-4 ,8,16};
		printSubsets(a,6);
	}
	
	private static void printSubsets(int[] a,int sum) {
		for (int i = 0; i <=Math.pow(2, a.length)-1; i++) {
			int sub = 0;
			String subset = "";
			for (int j = 1; j <= a.length; j++) {
				int shift = (1 << (j - 1));
				if ((i & shift) != 0) {
					subset = subset + String.valueOf(a[j-1]) + " ";
					sub += (a[j-1]);
				}
			}
			if(sum==sub)
			System.out.println(subset);
		}
	}
}
