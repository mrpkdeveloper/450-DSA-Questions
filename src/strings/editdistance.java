package strings;

public class editdistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		editdistance("abc", "bcd");
		editdistance("abc", "abd");

	}

	public static void editdistance(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		// filling first row
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
		// filling first column
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int replace = dp[i - 1][j - 1];
					int insert = dp[i][j - 1];
					int remove = dp[i - 1][j];
					dp[i][j] = Math.min(replace, Math.min(remove, insert)) + 1;
				}

			}
		}

//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + "    ");
//			}
//			System.out.println();
//		}

		System.out.println(dp[m][n]);

	}

}
