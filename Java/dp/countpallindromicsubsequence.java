package dp;

public class countpallindromicsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long countPS(String s) {
		long[][] dp = new long[s.length()][s.length()];
		int mod = 1000000007;
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
					} else {
						// mod arithmetics is different in case of subtraction
						dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
					}
				}
			}
		}

		return dp[0][s.length() - 1];
	}

}
