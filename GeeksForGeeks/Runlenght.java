package GeeksForGeeks;

public class Runlenght {
	public static void main(String[] ar) {
		runLength("aaabbc");
	}

	private static void runLength(String s) {
		String out = "";
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			out += String.valueOf(s.charAt(i));
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i + 1) == c) {
				i++;
				count++;
			}
			i++;
			out += String.valueOf(count);
		}
		System.out.println(out);
	}
}
