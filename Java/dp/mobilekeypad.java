package dp;

public class mobilekeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mobilekeypad(3);

	}

	public static void mobilekeypad(int n) {

		int[][] data = { { 0, 8 }, { 1, 2, 4 }, { 2, 1, 3, 5 }, { 3, 2, 6 }, { 4, 1, 5, 7 }, { 5, 2, 8, 4, 6 },
				{ 6, 3, 9, 5 }, { 7, 4, 8 }, { 8, 5, 0, 7, 9 }, { 9, 8, 6 }, };

		int[][] dp = new int[n + 1][10];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 1) {
					dp[i][j] = 1;
				} else {
					int[] keythatcanpress = data[j];
					for (int k = 0; k < keythatcanpress.length; k++) {
						dp[i][j] += dp[i - 1][keythatcanpress[k]];
					}
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		int ans = 0;
		for (int j = 0; j < dp[0].length; j++) {
			ans += dp[n][j];
		}
		System.out.println(ans);

	}

}
