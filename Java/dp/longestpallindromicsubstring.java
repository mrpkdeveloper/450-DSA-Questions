package dp;

public class longestpallindromicsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		String s = "aacabdkacaa";
//		String s = "cbbd";
		solvedp(s);

	}

	public static void solvedp(String s) {

		int[][] dp = new int[s.length()][s.length()];

		int maxi = 0, maxj = 0, maxlength = 0;

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = 0;
					}
				}
				if (maxlength < dp[i][j]) {
					maxlength = dp[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}

		System.out.println(s.substring(maxi, maxj + 1));
		System.out.println(maxlength);

	}

}
