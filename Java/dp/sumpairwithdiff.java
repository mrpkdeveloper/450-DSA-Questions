package dp;

import java.util.Arrays;

public class sumpairwithdiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {
		if (N == 1) {
			if (arr[0] < K)
				return arr[0];
			return 0;
		}

		Arrays.sort(arr);
		int ans = 0;
		for (int i = N - 1; i >= 0;) {
			if (i - 1 >= 0 && arr[i] - arr[i - 1] < K) {
				ans += arr[i] + arr[i - 1];
				i = i - 2;
			} else {
				i--;
			}
		}

		return ans;
	}
}
