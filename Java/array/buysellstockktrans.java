package array;

public class buysellstockktrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void buysellstock(int[] arr, int k) {

		int[][] dp = new int[k + 1][arr.length];
		for (int t = 1; t < k + 1; t++) {
			for (int d = 1; d < arr.length; d++) {

				int max = dp[t][d - 1];

				for (int pd = 0; pd < d; pd++) {
					int profit = dp[t - 1][pd];
					int profit1 = arr[d] - arr[pd];
					if (profit + profit1 >= max) {
						max = profit + profit1;
					}
				}
				dp[t][d] = max;

			}
		}

		System.out.println(dp[k][arr.length - 1]);

	}

	public static void buysellstockoptimised(int[] arr, int k) {

		int[][] dp = new int[k + 1][arr.length];
		for (int t = 1; t < k + 1; t++) {
			int max = Integer.MIN_VALUE;
			for (int d = 1; d < arr.length; d++) {
				int prevmax = dp[t][d - 1];
				if (max < dp[t - 1][d - 1] - arr[d - 1]) {
					max = dp[t - 1][d - 1] - arr[d - 1];
				}
				int finalmax = Math.max(prevmax, max + arr[d]);
				dp[t][d] = finalmax;
			}

		}

		System.out.println(dp[k][arr.length - 1]);

	}

}
