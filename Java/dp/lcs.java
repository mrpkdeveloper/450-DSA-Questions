package dp;

public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcd";
		String str2 = "aebd";
		solvedp(str1, str2);
		System.out.println(solverecursive(str1, str2));
		solvedpopti(str1, str2);

	}

	// time -> O(2^n)
	public static int solverecursive(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		String res1 = s1.substring(1);
		String res2 = s2.substring(1);

		if (s1.charAt(0) == s2.charAt(0)) {
			return solverecursive(res1, res2) + 1;
		} else {
			return Math.max(solverecursive(res1, s2), solverecursive(s1, res2));
		}

	}

	// O(N^2)-> time and space
	public static void solvedp(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()]);

	}

	// space optimized -> O(N) space
	public static void solvedpopti(String s1, String s2) {
		int[][] dp = new int[2][s2.length() + 1];

		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
				} else {
					dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
				}
			}
		}

		System.out.println(dp[s1.length() % 2][s2.length()]);
	}

}
