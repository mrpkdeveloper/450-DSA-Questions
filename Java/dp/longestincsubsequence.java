package dp;

public class longestincsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
		solvedp(arr);

	}

	public static void solvedp(int[] arr) {

		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					if (max < dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);

	}

}
