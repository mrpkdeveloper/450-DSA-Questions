package strings;

public class Longestrepeatingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRS("abacbc");

	}

	public static void LRS(String s1) {

		int[][] dp = new int[s1.length() + 1][s1.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s1.length() - 1; j >= 0; j--) {

				if (s1.charAt(i) == s1.charAt(j) && i != j) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}

			}
		}

		System.out.println(dp[0][0]);

	}

}
