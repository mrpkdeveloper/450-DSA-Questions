package dp;

import java.util.HashMap;

public class countdistinctsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcbac";
		solvedp(s);

	}

	public static void solvedp(String s) {

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 1; i < dp.length; i++) {
			if (map.containsKey(s.charAt(i - 1))) {
				dp[i] = dp[i - 1] * 2 - dp[map.get(s.charAt(i - 1)) - 1];
			} else {
				map.put(s.charAt(i - 1), i);
				dp[i] = dp[i - 1] * 2;
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		System.out.println(dp[s.length()]);

	}

}
