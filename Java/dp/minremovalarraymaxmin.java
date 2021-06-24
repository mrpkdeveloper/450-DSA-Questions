package dp;

import java.util.Arrays;

public class minremovalarraymaxmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
		int k = 4;
		Arrays.parallelSort(arr);
		// 1 2 5 6 8
		int[][] dp = new int[arr.length][arr.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(solve(arr, 0, arr.length - 1, k, dp));
		solveopti(arr, k);

	}

	public static int solve(int[] arr, int start, int end, int k, int[][] dp) {

		if (start >= end) {
			return 0;
		}

		if (arr[end] - arr[start] <= k) {
			return 0;
		}

		if (dp[start][end] != -1) {
			return dp[start][end];
		}

		int myans = 1 + Math.min(solve(arr, start + 1, end, k, dp), solve(arr, start, end - 1, k, dp));

		dp[start][end] = myans;
		return myans;

	}

	// optimised O(nlogn) -> time
	public static void solveopti(int[] arr, int k) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int max = k + arr[i]; // this is max value find value smaller or equal to this)
			int idxofmaxvalue = upperbound(i, arr, max);
			ans = Math.min(arr.length - (idxofmaxvalue - i), ans);
		}
		System.out.println(ans);

	}

	private static int lowerbound(int lo, int[] arr, int max) {
		int hi = arr.length - 1;
		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (max <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;

	}

	public static int upperbound(int low, int[] array, int value) {
		int high = array.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

}
