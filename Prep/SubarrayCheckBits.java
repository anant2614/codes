package Prep;

public class SubarrayCheckBits {

	public static void main(String ghg[]) {
		int a[] = {4,1,5};
		int q = 7;
		System.out.println(querySubsetSum(a,q));
	}

	private static int querySubsetSum(int[] a, int q) {
		int sum=1;
		for(int i=0;i<a.length;i++){
			sum=sum|(sum<<a[i]);
		}
		int val=(1<<q);
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(sum));

		return sum&val;
	}
}
