package dp;

public class minjumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
//		int[] arr = { 1, 4, 3, 2, 6, 7 };
//		int[] arr = { 1, 1, 2, 2, 6, 7 };
		solvedp(arr);
		System.out.println(solveopti(arr));

	}

	// O(n^2) -> time
	public static void solvedp(int[] arr) {

		int[] dp = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] + i >= arr.length - 1) {
				dp[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j <= i + arr[i]; j++) {
					if (min > dp[j]) {
						min = dp[j];
					}
				}
				dp[i] = min + 1;
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		if (dp[0] < 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[0]);
		}

	}

	// O(n) -> time
	public static int solveopti(int[] arr) {

		int steps = arr[0], minjumps = 1, maxreachidx = arr[0];
		if (arr[0] == 0) {
			return -1;
		}
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return minjumps;
			}
			maxreachidx = Math.max(maxreachidx, arr[i] + i);
			steps--;
			if (steps == 0) {
				if (i >= maxreachidx)
					return -1;
				minjumps++;
				steps = maxreachidx - i;
			}
		}

		return -1;

	}

}
