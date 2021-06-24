package dp;

public class maxpathmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 348, 391 }, { 618, 193 } };
		solve(arr);

	}

	public static void solve(int[][] arr) {

		int[][] dp = new int[arr.length][arr[0].length];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1) {
					dp[i][j] = arr[i][j];
				} else {
					int a = 0, b = 0, c = 0;
					a = dp[i + 1][j];
					if (j - 1 >= 0)
						b = dp[i + 1][j - 1];
					if (j + 1 < dp[0].length)
						c = dp[i + 1][j + 1];
					dp[i][j] = Math.max(a, Math.max(b, c)) + arr[i][j];
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < dp[0].length; i++) {
			ans = Math.max(ans, dp[0][i]);
		}
		System.out.println(ans);
	}

}
