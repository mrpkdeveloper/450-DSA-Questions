package array;

import java.util.Arrays;

public class choclatedistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		dist(arr, 3);

	}

	public static void dist(int[] arr, int m) {
		Arrays.sort(arr);

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i + m - 1 < arr.length; i++) {
			int diff = arr[i + m - 1] - arr[i];
			if (diff < ans) {
				ans = diff;
			}
		}
		System.out.println(ans);
	}

}
