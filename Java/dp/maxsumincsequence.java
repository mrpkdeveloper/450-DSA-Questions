package dp;

public class maxsumincsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 101, 2, 3, 100 };
		solve(arr);

	}

	// O(N^2) -> time
	public static void solve(int[] arr) {

		int[] dp = new int[arr.length];
		dp[0] = arr[0];

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (max < dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + arr[i];
			if (dp[i] > ans) {
				ans = dp[i];
			}
		}

		if (ans < dp[0]) {
			ans = dp[0];
		}
		System.out.println(ans);
	}

}
