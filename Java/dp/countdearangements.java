package dp;

public class countdearangements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solverec(4));
		solvedp(4);

	}

	public static int solverec(int n) {

		if (n == 1) {
			return 0;
		}

		if (n == 2) {
			return 1;
		}

		// placing 0 at n-1 pos
		// then if 0 is placed at 1 pos -> pos left for 1 is (n-1)
		// if 0 is not placed at 1 pos -> pos left for 1 is (n-2) {1 cannot be placed at
		// 1pos and not at pos where 0 is placed}
		return (n - 1) * (solverec(n - 1) + solverec(n - 2));

	}

	public static void solvedp(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
		}

		System.out.println(dp[n]);
	}

}
