package dp;

public class knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 5;
		int val[] = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		solve(wt, val, 0, W, 0, 0);
		System.out.println(maxval);
		solve2(wt, val, W);

	}

	// brute force time-> O(2^n)
	public static int maxval = Integer.MIN_VALUE;

	public static void solve(int[] wt, int[] val, int i, int twt, int sumwt, int sumval) {
		if (sumwt > twt) {
			return;
		}
		if (maxval < sumval) {
			maxval = sumval;
		}
		if (i >= wt.length) {
			return;
		}

		// add in wt
		solve(wt, val, i + 1, twt, sumwt + wt[i], sumval + val[i]);

		// not add
		solve(wt, val, i + 1, twt, sumwt, sumval);

	}

	// optimised
	public static void solve2(int[] wt, int[] val, int twt) {

		int[][] dp = new int[wt.length + 1][twt + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int a = 0;
				// if added
				if (twt >= wt[i - 1] && j - wt[i - 1] >= 0)
					a = val[i - 1] + dp[i - 1][j - wt[i - 1]];
				dp[i][j] = Math.max(dp[i - 1][j], a);
			}
		}

		System.out.println(dp[wt.length][twt]);

	}

}
