package backtracking;

public class equalsumsubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 1, 5, 11, 5 };
		int[] arr = { 2, 4, 11, 10, 5 };
//		System.out.println(equalPartition(arr.length, arr));
		targetsubsetsum(arr, 16);

	}

	static int equalPartition(int N, int arr[]) {
		int prefixsum = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixsum += arr[i];
		}
		if (prefixsum % 2 != 0 || arr.length < 2) {
			return 0;
		}

		boolean fans = partition(arr, 0, 0, new int[2]);
		return (fans == true ? 1 : 0);
	}

	public static boolean partition(int[] arr, int i, int psf, int[] sum) {
		if (i == arr.length) {
			if (psf == 2) {
				if (sum[0] == sum[1]) {
					return true;
				}
			}
			return false;
		}
		for (int j = 0; j < 2; j++) {
			if (sum[j] > 0) {
				sum[j] += arr[i];
				if (partition(arr, i + 1, psf, sum)) {
					return true;
				}
				sum[j] -= arr[i];
			} else {
				sum[j] += arr[i];
				if (partition(arr, i + 1, psf + 1, sum)) {
					return true;
				}
				sum[j] -= arr[i];
				break;
			}
		}
		return false;
	}

	// solving using dp
	public static void targetsubsetsum(int[] arr, int sum) {

		int[][] dp = new int[arr.length + 1][sum + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		dp[1][arr[0]] = 1;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (dp[i - 1][j] == 1) {
					dp[i][j] = 1;
				} else if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]] == 1) {
					dp[i][j] = 1;
				}
			}
		}

//		System.out.println(dp[arr.length][sum]);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
