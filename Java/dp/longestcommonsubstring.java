package dp;

public class longestcommonsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int longestCommonSubstr(String s1, String s2, int n, int m) {

		// comparing all prefix suffix with each other -> the longest common suffix of
		// prefix is ans

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}

				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

}
