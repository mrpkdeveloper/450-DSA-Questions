package dp;

public class buysellstockKtrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 5, 75, 65, 80 };
		int k = 2;
		System.out.println(maxProfit(k, arr.length, arr));
		System.out.println(maxProfitopti(k, arr.length, arr));

	}

	public static int maxProfit(int k, int n, int arr[]) {
		// code here
		int[][] dp = new int[k + 1][n];

		for (int t = 1; t < k + 1; t++) {
			for (int d = 1; d < n; d++) {
				int alltransactiondoneonprevday = dp[t][d - 1];
				int max = alltransactiondoneonprevday;
				for (int prevday = 0; prevday < d; prevday++) {
					int prevdayprofitwithk_1trans = dp[t - 1][prevday];
					int kthtrans = arr[d] - arr[prevday];
					int totalprofit = prevdayprofitwithk_1trans + kthtrans;
					max = Math.max(max, totalprofit);
				}
				dp[t][d] = max;
			}
		}
		return dp[k][n - 1];
	}

	public static int maxProfitopti(int k, int n, int arr[]) {
		// code here
		int[][] dp = new int[k + 1][n];
		for (int t = 1; t < k + 1; t++) {
			int maxofkth_1trans = Integer.MIN_VALUE;
			for (int d = 1; d < n; d++) {
				int alltransactiondoneonprevday = dp[t][d - 1];
				if (maxofkth_1trans < dp[t - 1][d - 1] - arr[d - 1]) {
					maxofkth_1trans = dp[t - 1][d - 1] - arr[d - 1];
				}
				dp[t][d] = Math.max(maxofkth_1trans + arr[d], alltransactiondoneonprevday);
			}
		}
		return dp[k][n - 1];
	}
}
