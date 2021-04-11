package array;

import java.util.Scanner;

public class buysellstock2tran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 15, 10, 20, 40, 45, 71, 50, 55 };
		int[] arr = { 10, 22, 5, 75, 65, 80 };
		buysell(arr);
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//		buysell(arr);

	}

	public static void buysell(int[] arr) {
		int[] lr = new int[arr.length];
		int[] rl = new int[arr.length];
		int minprice = arr[0];

		// aaj sell krdo to ab tak max profit
		for (int i = 1; i < arr.length; i++) {
			if (minprice >= arr[i]) {
				minprice = arr[i];
			}
			int profit = arr[i] - minprice;
			if (profit >= lr[i - 1]) {
				lr[i] = profit;
			} else {
				lr[i] = lr[i - 1];
			}

			System.out.println(lr[i]);

		}
		System.out.println();

		// aaj buy krlo to ab tak max profit (right to left)
		int maxprice = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {

			if (maxprice <= arr[i]) {
				maxprice = arr[i];
			}
			int profit = maxprice - arr[i];
			if (profit >= rl[i + 1]) {
				rl[i] = profit;
			} else {
				rl[i] = rl[i + 1];
			}
			System.out.println(rl[i]);
		}
		System.out.println();
		int maxsum = 0;
		for (int i = 0; i < rl.length; i++) {
			if (maxsum < lr[i] + rl[i]) {
				maxsum = lr[i] + rl[i];
			}
		}

		System.out.println(maxsum);

	}

}
