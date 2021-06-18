package dp;

public class friendspairing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345";
		recursivesolveprint(s, "");
		System.out.println(recursivesolvecount(5));
		System.out.println(countFriendsPairings(5));

	}

	public static void recursivesolveprint(String s, String ans) {

		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}

		// i m single
		String ros = s.substring(1);
		recursivesolveprint(ros, ans + "{" + s.charAt(0) + "}");

		// i will pair up
		for (int i = 1; i < s.length(); i++) {
			String pair = "{" + s.charAt(0) + s.charAt(i) + "}";
			String res = s.substring(1, i) + s.substring(i + 1);
			recursivesolveprint(res, ans + pair);
		}

	}

	public static int recursivesolvecount(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		int myans = 0;
		// i m single
		myans += recursivesolvecount(n - 1);

		// i will pair up
		myans += recursivesolvecount(n - 2) * (n - 1);

		return myans;

	}

	public static long countFriendsPairings(int n) {
		int mod = 1000000007;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % mod;
		}
		return dp[n];
	}

}
