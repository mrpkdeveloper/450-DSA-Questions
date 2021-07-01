package dp;

public class mincostfillbag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 20, 10, 4, 50, 100 };
//		int arr[] = { -1, -1, 4, 3, -1 };
//		int arr[] = { 10, 10, 5, 17, -1, 13, 19, 9, 15 };
//		int arr[] = { 8, 17, 1, 9, -1, 9, 3, 20, 10 };
//		int w = 5;
//		int w = 12;
		int[] arr = { -1, 15, -1, 3, 14, 13, 10, 10 };
		int w = 810;

		solvedp(arr, w);
		solvedp2(arr, w);

	}

	// O(n^2) -> space
	public static void solvedp(int[] arr, int w) {

		int[][] dp = new int[arr.length + 1][w + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < i || arr[i - 1] == -1) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int a = dp[i - 1][j]; // i m not included
					int b = arr[i - 1];// i am included
					if (dp[i][j - i] != Integer.MAX_VALUE) {
						b += dp[i][j - i];
					} else {
						b = Integer.MAX_VALUE;
					}
					dp[i][j] = Math.min(a, b);
				}
			}
		}

		if (dp[arr.length][w] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(dp[arr.length][w]);

	}

	// O(n) -> space
	public static void solvedp2(int[] arr, int w) {

		int[] dp = new int[w + 1];

		for (int i = 1; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				if (j + 1 > i || arr[j] == -1) {
					continue;
				} else {
					int a = Integer.MAX_VALUE;
					if (dp[i - (j + 1)] != Integer.MAX_VALUE)
						a = arr[j] + dp[i - (j + 1)];
					min = Math.min(min, a);
				}
			}
			dp[i] = min;
		}

		if (dp[w] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(dp[w]);
	}

}
