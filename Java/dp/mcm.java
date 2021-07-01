package dp;

public class mcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 30 };
		mcm(arr);

	}

	public static void mcm(int[] arr) {

		int[][] dp = new int[arr.length - 1][arr.length - 1];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						// i-k -> left half k+1-j+1 -> right half
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int mc = arr[i] * arr[k + 1] * arr[j + 1];
						int tc = lc + rc + mc;
						if (min > tc) {
							min = tc;
						}
						dp[i][j] = min;
					}
				}
			}

		}

		System.out.println(dp[0][dp.length - 1]);

	}

}
