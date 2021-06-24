package dp;

public class longestaltsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		solve(arr);
		solveopti(arr);

	}

	public static void solve(int[] arr) {

		int[][] dp = new int[2][arr.length];
		dp[0][0] = 1; // last element smaller
		dp[1][0] = 1; // last element grtr

		int ans = 0;
		for (int i = 1; i < dp[0].length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[1][i] < dp[0][j] + 1) {
					dp[1][i] = dp[0][j] + 1;
				}
				if (arr[j] > arr[i] && dp[0][i] < dp[1][j] + 1) {
					dp[0][i] = dp[1][j] + 1;
				}
			}

			if (ans < Math.max(dp[0][i], dp[1][i])) {
				ans = Math.max(dp[0][i], dp[1][i]);
			}

		}
		if (ans == 0) {
			System.out.println(1);
		}
		System.out.println(ans);

	}

	public static void solveopti(int[] arr) {

		int inc = 1, dec = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				inc = dec + 1;
			} else if (arr[i] < arr[i - 1]) {
				dec = inc + 1;
			}
		}

		System.out.println(Math.max(inc, dec));

	}

}
