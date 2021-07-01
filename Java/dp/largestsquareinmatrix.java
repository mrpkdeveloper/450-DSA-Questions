package dp;

public class largestsquareinmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int maxSquare(int n, int m, int arr[][]) {

		int[][] dp = new int[n][m];
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (arr[i][j] == 0) {
					dp[i][j] = 0;
				} else if (i == n - 1 || j == m - 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}

		return ans;
	}

}
