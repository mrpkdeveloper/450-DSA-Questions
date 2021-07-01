package dp;

import java.util.Arrays;

public class maxsumrectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		int[][] arr = { { -1, -2 }, { -3, -4 } };

		solvedp(arr);
	}

	// O(n^3) time O(n) -> space
	public static void solvedp(int[][] arr) {

		int[] dp = new int[arr[0].length];

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int max = 0;
				int sum = 0;
				for (int k = 0; k < arr[0].length; k++) {
					dp[k] += arr[j][k];
					// kadane's algo
					if (k == 0) {
						sum = dp[k];
						max = dp[k];
					} else {
						if (sum + dp[k] > dp[k]) {
							sum += dp[k];
						} else {
							sum = dp[k];
						}
						max = Math.max(sum, max);
					}
				}
				ans = Math.max(max, ans);
			}
			Arrays.fill(dp, 0);
		}
		System.out.println(ans);
	}

}
