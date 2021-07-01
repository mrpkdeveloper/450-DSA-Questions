package dp;

public class longestpallindromicsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println(solverec(s, 0, s.length() - 1));
		solvedp(s);

	}

	public static int solverec(String s, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}

		if (s.charAt(i) == s.charAt(j)) {
			return 2 + solverec(s, i + 1, j - 1);
		} else {
			return Math.max(solverec(s, i + 1, j), solverec(s, i, j - 1));
		}

	}

	public static void solvedp(String s) {

		int[][] dp = new int[s.length()][s.length()];
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}
		}

		System.out.println(dp[0][s.length() - 1]);

	}

}
