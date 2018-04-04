package leetcode;

public class Prob115 {
	public static void main(String ar[]){
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(countDistinctSubSeq(s,t,0,0));
	}

	private static int countDistinctSubSeq(String s, String t, int s_i, int t_i) {
		if(t_i == t.length())
			return 1;
		if (s_i == s.length())
			return 0;
		if(s.charAt(s_i)==t.charAt(t_i))
			return countDistinctSubSeq(s, t, s_i+1, t_i+1) + countDistinctSubSeq(s, t, s_i+1, t_i);
		return countDistinctSubSeq(s, t, s_i + 1, t_i);
	}
}
