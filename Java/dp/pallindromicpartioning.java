package dp;

public class pallindromicpartioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solverec("ababbbabbababa"));
//		System.out.println(solverec("aaabba"));

		solvedp("ababbbabbababa");

	}

	public static int solverec(String s) {
		if (s.length() == 1 || checkpallindrome(s)) {
			return 0;
		}

		int myfans = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			String mys = s.substring(0, i + 1);
			String ros = s.substring(i + 1);
			if (checkpallindrome(mys)) {
				int myans = solverec(ros);
				if (myfans > myans + 1) {
					myfans = myans + 1;
				}
			}
		}

		return myfans;

	}

	public static boolean checkpallindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// Optimized solution for time using dp
	public static void solvedp(String s) {
		int[][] dp = new int[s.length()][s.length()];

		int[][] check = new int[s.length()][s.length()];
		for (int g = 0; g < check.length; g++) {
			for (int i = 0, j = g; j < check[0].length && i < check.length; j++, i++) {
				if (g == 0) {
					check[i][j] = 1;
				} else if (g == 1) {
					check[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
				} else {
					if (s.charAt(i) == s.charAt(j) && check[i + 1][j - 1] == 1) {
						check[i][j] = 1;
					} else {
						check[i][j] = 0;
					}
				}
			}
		}

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = check[i][j] == 1 ? 0 : 1;
				} else {
					if (check[i][j] == 1) {
						dp[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						for (int k = i; k < j; k++) {
							int lefthalf = dp[i][k];
							int righthalf = dp[k + 1][j];
							if (min > lefthalf + righthalf + 1) {
								min = lefthalf + righthalf + 1;
							}
						}
						dp[i][j] = min;
					}
				}
			}
		}

		System.out.println(dp[0][s.length() - 1]);

	}

}
