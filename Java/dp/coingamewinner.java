package dp;

public class coingamewinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5, 4, 3));
		System.out.println(solve(2, 4, 3));

		solvedp(5, 4, 3);
		solvedp(2, 4, 3);

	}

	public static boolean solve(int n, int x, int y) {

		if (n == 0) {
			return false;
		}

		if (n == 1) {
			return true;
		}

		if (!solve(n - 1, x, y) || n >= x && !solve(n - x, x, y) || n >= y && !solve(n - y, x, y)) {
			// if any of the above says false .... that means my friend will win if that
			// much coins are there and now its my turn so here i have extra coins and i
			// will definitely win

			return true;
		}

		return false;

	}

	public static void solvedp(int n, int x, int y) {

		int[] dp = new int[n + 1];
		// -1 -> friend win
		// 1 -> i win
		dp[0] = -1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			if (dp[i - 1] == -1 || i >= x && dp[i - x] == -1 || i >= y && dp[i - y] == -1) {
				dp[i] = 1;
			} else {
				dp[i] = -1;
			}
		}

		if (dp[n] == 1) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

}
