package strings;

import java.util.HashSet;

public class wordbreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
//				"mango" };
		String[] dict = { "i", "love", "ilove", "mango", "man", "go", "ice", "cream", "icecream" };
		HashSet<String> dictset = new HashSet<String>();
		for (int i = 0; i < dict.length; i++) {
			dictset.add(dict[i]);
		}
//		System.out.println(wordbreak("idontlovemangoicecream", dictset));
		wordbreakbacktracking("ilovemangoicecream", dictset, "");

	}

	public static boolean wordbreak(String s, HashSet<String> dict) {

		int[] dp = new int[s.length()];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				String wordcheck = s.substring(j, i + 1);
				if (dict.contains(wordcheck)) {
					if (j > 0)
						dp[i] += dp[j - 1];
					else
						dp[i] = 1;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}

		return dp[s.length() - 1] > 0;

	}

	public static void wordbreakbacktracking(String s, HashSet<String> dict, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			if (dict.contains(left)) {
				String right = s.substring(i + 1);
				wordbreakbacktracking(right, dict, ans + left + " ");
			}
		}

	}

}
