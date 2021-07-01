package dp;

public class optimalbst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 12 }, freq[] = { 34, 50 };
		solvedp(arr, freq);

	}

	public static void solvedp(int[] arr, int[] freq) {

		int[][] dp = new int[arr.length][arr.length];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length && i < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = freq[i];
				} else if (g == 1) {
					dp[i][j] = Math.min(freq[i] + 2 * freq[j], 2 * freq[i] + freq[j]);
				} else {
					int freqsum = 0;
					for (int k = i; k <= j; k++) {
						freqsum += freq[k];
					}
					int min = Integer.MAX_VALUE;

					for (int k = i; k <= j && k < dp.length; k++) {
						int left = k == i ? 0 : dp[i][k - 1];
						int right = k == j ? 0 : dp[k + 1][j];

						if (min > left + right + freqsum) {
							min = left + right + freqsum;
						}
					}
					dp[i][j] = min;
				}

			}
		}

		System.out.println(dp[0][arr.length - 1]);
	}

}
