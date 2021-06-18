package dp;

public class subsetsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// whether an subset exist that sums equal to give sum
		int[] arr = { 1, 5, 11, 5 };
		subsetsum(arr, 11);

	}

	public static void subsetsum(int[] arr, int sum) {
		int[][] dp = new int[arr.length + 1][sum + 1];
		dp[1][arr[0]] = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (dp[i - 1][j] == 1) {
					dp[i][j] = dp[i - 1][j];
				} else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
