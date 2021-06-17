package dp;

public class catalanno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(catalan(7));

	}

	// FORMULA
	// C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0;

	public static int catalan(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];

	}

}
