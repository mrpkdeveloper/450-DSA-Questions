package strings;

public class wildcardcharactersstringmatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wildcard("baaabab", "ba*a?");

	}

	// ?-> 1 char
	// *-> many char
	public static void wildcard(String s1, String pat) {
		int[][] dp = new int[pat.length() + 1][s1.length() + 1];
		dp[pat.length()][s1.length()] = 1;
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = s1.length(); j >= 0; j--) {
				if (j == s1.length()) {
					if (pat.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					}
				} else if (pat.charAt(i) == s1.charAt(j) || pat.charAt(i) == '?') {
					dp[i][j] = dp[i + 1][j + 1];
				} else if (pat.charAt(i) == '*') {
					if (dp[i][j + 1] == 1 || dp[i + 1][j] == 1) {
						dp[i][j] = 1;
					}
				}

			}

		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(dp[0][0]);

	}

}
