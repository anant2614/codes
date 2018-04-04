package GeeksForGeeks;

public class AllSubsetsOfSEt {

	public static void main(String gh[]) {
		int a[] = { 1, 2, 3 };
		printSubsets(a);
	}

	private static void printSubsets(int[] a) {
		for (int i = 0; i <=Math.pow(2, a.length)-1; i++) {
			String sub = "";
			for (int j = 1; j <= a.length; j++) {
				int shift = (1 << (j - 1));
				if ((i & shift) != 0) {
					sub += String.valueOf(a[j-1]);
				}
			}
			System.out.println(sub);
		}
	}
}
