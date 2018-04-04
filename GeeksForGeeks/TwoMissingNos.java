package GeeksForGeeks;

public class TwoMissingNos {
	public static void main(String gh[]) {
		int a[] = {1, 3, 5, 6};
		twoMissing(a,6);
	}

	private static void twoMissing(int[] a,int n) {
		int xor1 = a[0];
		int xor2 = 1;
		for(int i=1;i<a.length;i++){
			xor1 = xor1 ^ a[i];
		}
		for(int i=2;i<=n;i++){
			xor2 = xor2 ^ i;
		}
		int xor3 = xor1 ^ xor2;
		
		for(int i=1;i<=a.length;i++){
			if((xor3 ^ i)>=1&&(xor3 ^ i)<=n)
				System.out.println(i);
		}
	}
}
