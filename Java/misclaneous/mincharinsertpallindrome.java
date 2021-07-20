package misclaneous;

public class mincharinsertpallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babb";
//		int[] pi = pitable(s);
//		for (int i = 0; i < pi.length; i++) {
//			System.out.println(pi[i]);
//		}
		System.out.println(solve(s));

	}

	public static int solve(String s) {
		int ans = 0;
		String rev = new StringBuilder(s).reverse().toString();
		String fs = s + "#" + rev;
		int[] pi = pitable(fs);
		int commlen = pi[pi.length - 1];
		ans = rev.length() - commlen;
		return ans;

	}

	public static int[] pitable(String s) {
		int[] pi = new int[s.length()];
		pi[0] = 0;
		for (int i = 1; i < pi.length; i++) {
			int j = pi[i - 1];
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j - 1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}
			pi[i] = j;
		}
		return pi;

	}

}
