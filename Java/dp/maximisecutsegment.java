package dp;

public class maximisecutsegment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9999, x = 94, y = 20, z = 244;
		System.out.println(maximizeCuts(n, x, y, z));
//		System.out.println(solverecursive(n, x, y, z));

	}

	public static int solverecursive(int n, int x, int y, int z) {

		if (n == 0) {
			return 0;
		}

		int xcut = Integer.MIN_VALUE, ycut = Integer.MIN_VALUE, zcut = Integer.MIN_VALUE;

		if (n - x >= 0)
			xcut = solverecursive(n - x, x, y, z);
		if (n - y >= 0)
			ycut = solverecursive(n - y, x, y, z);
		if (n - z >= 0)
			zcut = solverecursive(n - z, x, y, z);

		return Math.max(xcut, Math.max(ycut, zcut)) + 1;

	}

	public static int maximizeCuts(int n, int x, int y, int z) {

		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		int a = solvedp(n, x, y, z, dp);
		if (a < 0)
			return 0;
		return a;

	}

	// O(n) -> space and time
	public static int solvedp(int n, int x, int y, int z, int[] dp) {

		if (n == 0) {
			return 0;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int xcut = Integer.MIN_VALUE, ycut = Integer.MIN_VALUE, zcut = Integer.MIN_VALUE;

		if (n - x >= 0)
			xcut = solvedp(n - x, x, y, z, dp);
		if (n - y >= 0)
			ycut = solvedp(n - y, x, y, z, dp);
		if (n - z >= 0)
			zcut = solvedp(n - z, x, y, z, dp);

		dp[n] = Math.max(xcut, Math.max(ycut, zcut)) + 1;
		return dp[n];

	}

}
