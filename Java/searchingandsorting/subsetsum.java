package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class subsetsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 1, 2 };
		solve(arr, -1, 2, arr.length);
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		long a = scn.nextLong();
//		long b = scn.nextLong();
//		long[] arr = new long[n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scn.nextLong();
//		}
//		scn.close();
//		solve(arr, a, b, n);

	}

	public static void solve(long[] arr, long a, long b, int n) {

		long[] sum1 = subsets(arr, 0, (n / 2) - 1);
		long[] sum2 = subsets(arr, n / 2, n - 1);
		Arrays.parallelSort(sum2);

		for (int i = 0; i < sum1.length; i++) {
			System.out.println(sum1[i]);
		}
		System.out.println();
		for (int i = 0; i < sum2.length; i++) {
			System.out.println(sum2[i]);
		}
		System.out.println();

		long c = 0;
		for (int i = 0; i < sum1.length; i++) {
			long lower = a - sum1[i];
			long upper = b - sum1[i];

			int lb = lower_bound(sum2, lower);
			int ub = upper_bound(sum2, upper);

			System.out.println(ub + " - " + lb);

			c += ub - lb + 1;
		}
		System.out.println();
		System.out.println(c);

	}

	public static int upper_bound(long[] arr, long k) {
		int s = 0;
		int e = arr.length - 1;
		while (s != e) {
			int mid = s + e >> 1;
			if (arr[mid] <= k) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		if (s == arr.length) {
			return -1;
		}
		return s;
	}

	public static int lower_bound(long[] arr, long k) {
		int s = 0;
		int e = arr.length - 1;
		while (s != e) {
			int mid = s + e >> 1;
			if (arr[mid] < k) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		if (s == arr.length) {
			return -1;
		}
		return s;
	}

	private static long[] subsets(long[] arr, int start, int end) {

		int limit = 1 << (end - start + 1);
		long[] ans = new long[limit];

		for (int i = 0; i < limit; i++) {
			int sum = 0;
			int temp = i;
			for (int j = end; j >= start; j--) {
				if ((temp & 1) == 1) {
					sum += arr[j];
				}
				temp = temp >> 1;
			}
			ans[i] = sum;
		}

		return ans;

	}
}
