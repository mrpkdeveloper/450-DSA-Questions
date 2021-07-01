package dp;

public class interleavedstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "cd";
		String s3 = "acbd";

		if (s1.length() + s2.length() == s3.length()) {
			System.out.println(solve(s1, s2, s3, 0, 0));
		} else {
			System.out.println(false);
		}

		if (s1.length() + s2.length() == s3.length()) {
			System.out.println(solvedp(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]));
		} else {
			System.out.println(false);
		}

	}

	public static boolean solve(String s1, String s2, String s3, int i, int j) {

		if (i == s1.length() && j == s2.length()) {
			return true;
		}

		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
			if (solve(s1, s2, s3, i + 1, j)) {
				return true;
			}
		}

		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
			if (solve(s1, s2, s3, i, j + 1)) {
				return true;
			}
		}

		return false;

	}

	// memoisation
	public static boolean solvedp(String s1, String s2, String s3, int i, int j, Boolean dp[][]) {
		if (dp[i][j] != null) {
			return dp[i][j];
		}
		if (i == s1.length() && j == s2.length()) {
			return true;
		}

		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
			if (solvedp(s1, s2, s3, i + 1, j, dp)) {
				dp[i][j] = true;
				return true;
			} else {
				dp[i][j] = false;
			}
		}

		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
			if (solvedp(s1, s2, s3, i, j + 1, dp)) {
				dp[i][j] = true;
				return true;
			} else {
				dp[i][j] = false;
			}
		}

		dp[i][j] = false;
		return false;

	}

}
