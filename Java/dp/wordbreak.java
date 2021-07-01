package dp;

import java.util.ArrayList;

public class wordbreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int wordBreak(String s, ArrayList<String> B) {
		int[] dp = new int[s.length()];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);
				if (B.contains(sub)) {
					if (j > 0) {
						dp[i] += dp[j - 1];
					} else {
						dp[i] = 1;
					}
				}
			}
		}
		if (dp[s.length() - 1] >= 1)
			return 1;
		return 0;
	}

}
