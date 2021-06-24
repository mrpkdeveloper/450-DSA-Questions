package dp;

public class unboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int knapSack(int N, int w, int val[], int wt[]) {

		int[] dp = new int[w + 1];
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < wt.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if (wt[i] > j) {
					continue;
				} else {
					if (wt[i] == j) {
						dp[j] = Math.max(dp[j], val[i]);
					} else {
						if (dp[j - wt[i]] != 0) {
							dp[j] = Math.max(val[i] + dp[j - wt[i]], dp[j]);
						}
					}
				}

				ans = Math.max(ans, dp[j]);
			}
		}

		if (ans == Integer.MIN_VALUE) {
			return 0;
		}
		return ans;
	}
}
