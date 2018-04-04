package DP;

public class EggDropping {

	public static void main(String agf[]) {
		System.out.println(bomber("qpaaaaadaaaaadprq"));
	}

	private static String bomber(String s) {
		String st="";
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int j=i+1;
			boolean flag=true;
			while(j<s.length()&&(c==s.charAt(j))){
				flag=false;
				j++;
				i++;
			}
			if(flag)
			st=st.concat(String.valueOf(s.charAt(i)));
		}
		if(st.length()!=s.length()){
			System.out.println(st);
			return bomber(st);
		}
		return st;
	}
}
