package dp;

public class longestsequencewithadjdiif1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5 };
		solve(arr);

	}

	public static void solve(int[] arr) {

		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (Math.abs(arr[j] - arr[i]) == 1) {
					if (max < dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
		}

		int ans = 0;
		for (int i = 0; i < dp.length; i++) {
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}

}
