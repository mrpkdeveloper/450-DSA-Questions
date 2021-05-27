package searchingandsorting;

import java.util.Arrays;

public class counttripletwithsmallersum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long countTriplets(long arr[], int n, int sum) {
		Arrays.sort(arr);
		long c = 0;
		for (int i = 0; i < n; i++) {
			int j = i + 1, k = n - 1;
			int s = (int) (sum - arr[i]);
			while (j < k) {
				if (arr[j] + arr[k] < s) {
					c = c + k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return c;
	}

}
