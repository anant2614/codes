package GeeksForGeeks;

public class IncreasingDecreasing {
	public static void main(String[] ar) {
		printSeq("DDIDDIID");
	}

	private static void printSeq(String s) {
		int max = 1;
		String out = "";
		int[] count = new int[s.length()];
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i + 1) == 'D') {
				count[i] = count[i + 1] + 1;
			}
		}
		int start = max + count[0] + 1;
		if (s.charAt(0) == 'I') {
			out += "1";
		} else {
			out += start;
		}
		
		max = Math.max(start, max);

		for (int i = 0; i < s.length(); i++) {
			int prev = Integer.valueOf(out.charAt(out.length() - 1)- '0');
			if (s.charAt(i) == 'D') {
				out += String.valueOf(prev-1);
			} else {
				out += String.valueOf(max + count[i] + 1);
				max = Math.max(max, max + count[i] + 1);
			}
		}
		System.out.println(out);
	}
}
