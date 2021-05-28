package searchingandsorting;

import java.util.Scanner;

public class subsetsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long[] arr = { 1, -2, 3 };
//		solve(arr, -1, 2);
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long a = scn.nextLong();
		long b = scn.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}
		solve(arr, a, b);

	}

	public static void solve(long[] arr, long a, long b) {

		long count = 0;
		if (a <= 0 && 0 <= b) {
			count++;
		}
		for (int i = 0; i < arr.length; i++) {
			long sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (a <= sum && sum <= b) {
					count++;
				}
			}
		}

		System.out.println(count);

	}
}
