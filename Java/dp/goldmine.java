package dp;

public class goldmine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		solve(mat);

	}

	// brute -> visit all path and check for max

	// optimised dp
	public static void solve(int[][] arr) {

		int dp[][] = new int[arr.length][arr[0].length];
		// copying last column values as it is
		for (int i = 0; i < dp.length; i++) {
			dp[i][arr[0].length - 1] = arr[i][arr[0].length - 1];
		}

		int max = Integer.MIN_VALUE;

		for (int j = arr[0].length - 2; j >= 0; j--) {
			for (int i = 0; i < dp.length; i++) {
				int right = 0, upright = 0, downright = 0;
				right = dp[i][j + 1];
				if (i - 1 >= 0)
					upright = dp[i - 1][j + 1];
				if (i + 1 < dp.length)
					downright = dp[i + 1][j + 1];

				dp[i][j] = Math.max(right, Math.max(upright, downright)) + arr[i][j];

				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(max);

	}

}
