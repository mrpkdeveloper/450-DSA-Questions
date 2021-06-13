package dp;

public class coinchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 10;
		int[] coins = { 2, 5, 3, 6 };
		solve(coins, sum, 0, "");
		System.out.println();
		System.out.println(solve2(coins, sum, 0));
		System.out.println(solve2dp(coins, sum));

	}

	// print
	public static void solve(int[] coins, int sum, int lcu, String ans) {

		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = lcu; i < coins.length; i++) {
			solve(coins, sum - coins[i], i, ans + coins[i]);
		}

	}

	// count
	public static int solve2(int[] coins, int sum, int lcu) {

		if (sum == 0) {
			return 1;
		}

		int myans = 0;
		for (int i = lcu; i < coins.length; i++) {
			if (sum - coins[i] >= 0) {
				myans += solve2(coins, sum - coins[i], i);
			}
		}

		return myans;

	}

	// count using dp
	// time-> O(n*sum)
	public static int solve2dp(int[] coins, int sum) {
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < dp.length; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		return dp[sum];
	}

}
