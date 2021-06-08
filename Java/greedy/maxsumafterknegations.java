package greedy;

import java.util.Arrays;

public class maxsumafterknegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(nlogn) -> time
	public static long maximizeSum(long arr[], int n, int k) {
		Arrays.sort(arr);
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (c == k) {
				break;
			}
			if (arr[i] < 0) {
				c++;
				arr[i] = arr[i] * -1;
			}
		}

		if (c != k) {
			Arrays.sort(arr);
			int left = k - c;
			if (left % 2 != 0) {
				arr[0] *= -1;
			}
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
