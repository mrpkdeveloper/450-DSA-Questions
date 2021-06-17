package dp;

public class binomialcoffecient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ncr -> n!/(r!(n-r)!)

	// brute force
	static int ncr(int n, int r) {

		if (n < r) {
			return 0;
		}
		if (r == 0 || r == n) {
			return 1;
		}

		return ncr(n - 1, r - 1) + ncr(n - 1, r);

	}

	// concept of pascal triangle used (Optimised)
	// O(n*r) -> time O(r)-> space
	static int nCropti(int n, int r) {
		if (n < r) {
			return 0;
		}

		int mod = 1000000007;
		int[] dp = new int[r + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = r; j > 0; j--) {
				dp[j] = (dp[j] + dp[j - 1]) % mod;
			}
		}
		return dp[r];
	}

}
