package dp;

public class lcs3strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeks", s2 = "geeksfor", s3 = "geeksforgeeks";
		System.out.println(solverecursive(s1, s2, s3));
		solvedp(s1, s2, s3);

	}

	public static int solverecursive(String s1, String s2, String s3) {

		if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0) {
			return 0;
		}

		String res1 = s1.substring(1);
		String res2 = s2.substring(1);
		String res3 = s3.substring(1);

		if (s1.charAt(0) == s2.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
			return solverecursive(res1, res2, res3) + 1;
		} else {
			int a = solverecursive(res1, s2, s3);
			int b = solverecursive(s1, res2, s3);
			int c = solverecursive(s1, s2, res3);
			return Math.max(a, Math.max(b, c));
		}

	}

	public static void solvedp(String s1, String s2, String s3) {
		int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				for (int k = 1; k < dp[0][0].length; k++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()][s3.length()]);

	}

}
