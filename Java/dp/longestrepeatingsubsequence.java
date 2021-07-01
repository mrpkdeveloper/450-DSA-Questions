package dp;

public class longestrepeatingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solvedp("abcbc", "abcbc");

	}

	public static void solvedp(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i - 1 != j - 1) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()]);

	}

}
