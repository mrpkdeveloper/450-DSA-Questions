package strings;

public class printsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsequence("abc", "");

	}

	public static void subsequence(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);
		String res = str.substring(1);
		subsequence(res, ans + ch);
		subsequence(res, ans);
	}

}
