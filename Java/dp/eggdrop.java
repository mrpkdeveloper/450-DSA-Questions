package dp;

public class eggdrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noe = 2, tf = 3; 
		System.out.println(solve(noe, tf));
		solvedp(noe, tf);

	}

	public static int solve(int noe, int tf) {

		if (tf == 0 || tf == 1) {
			return tf;
		}

		if (noe == 1) {
			return tf;
		}

		int myans = Integer.MAX_VALUE;

		for (int i = 1; i <= tf; i++) {
			// if egg breaks
			int a = solve(noe - 1, i - 1);
			// egg not break
			int b = solve(noe, tf - i);

			if (myans > Math.max(a, b)) {
				myans = Math.max(a, b);
			}
		}

		return myans + 1;

	}

	public static void solvedp(int noe, int tf) {

		int[][] dp = new int[noe + 1][tf + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j == 1) {
					dp[i][j] = 1;
				} else if (i == 1) {
					dp[i][j] = j;
				} else {
					int min = Integer.MAX_VALUE;
					for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
						int v1 = dp[i][mj];// egg survives
						int v2 = dp[i - 1][pj]; // egg breaks
						int val = Math.max(v1, v2);
						min = Math.min(val, min);
					}
					dp[i][j] = min + 1;
				}
			}
		}

		System.out.println(dp[noe][tf]);

	}

}
