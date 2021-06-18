package dp;

public class editdistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ahellobye";
		String s2 = "amezooe";

		System.out.println(recursivesolve(s1, s2, 0, 0));
		solvedp(s1, s2);

	}

	// time -> O(3^n)
	public static int recursivesolve(String s1, String s2, int i, int j) {

		if (i >= s1.length() && j >= s2.length()) {
			return 0;
		}

		// only deletion can take place
		if (i < s1.length() && j >= s2.length()) {
			return s1.length() - i;
		}

		if (i >= s1.length() && j < s2.length()) {
			return s2.length() - j;
		}

		int myans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
			return recursivesolve(s1, s2, i + 1, j + 1);
		} else {
			int replace = recursivesolve(s1, s2, i + 1, j + 1);
			int delete = recursivesolve(s1, s2, i + 1, j);
			int insert = recursivesolve(s1, s2, i, j + 1);

			myans = Math.min(replace, Math.min(delete, insert)) + 1;
		}

		return myans;

	}

	// optimised by dp
	// time-> O(m*n)
	public static void solvedp(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int replace = dp[i - 1][j - 1];
					int delete = dp[i - 1][j];
					int insert = dp[i][j - 1];

					int min = Math.min(replace, Math.min(delete, insert)) + 1;
					dp[i][j] = min;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
