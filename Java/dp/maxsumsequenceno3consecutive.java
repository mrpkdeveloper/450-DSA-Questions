package dp;

public class maxsumsequenceno3consecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3000, 2000, 1000, 3, 10 };
		solve(arr);

	}

	public static void solve(int[] arr) {

		int[] dp = new int[arr.length];

		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(dp[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

		for (int i = 3; i < dp.length; i++) {
			// not include me
			int a = dp[i - 1];

			// include me
			int b = arr[i] + dp[i - 2];
			int c = arr[i] + arr[i - 1] + dp[i - 3];

			dp[i] = Math.max(a, Math.max(b, c));
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
