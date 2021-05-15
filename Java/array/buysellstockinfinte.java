package array;

import java.util.Scanner;

public class buysellstockinfinte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
//		int[] arr = { 10, 22, 5, 75, 85, 80 };
//		int[] arr = { 90, 80, 70, 60, 50 };
		buysell(arr);

	}

	public static void buysell(int[] arr) {
		int buy = 0, sell = 0, profit = 0;
		while (buy < arr.length && sell < arr.length) {
			if (sell < arr.length - 1 && arr[sell] <= arr[sell + 1]) {
				sell++;
			} else {
				profit += arr[sell] - arr[buy];
				sell++;
				buy = sell;
			}
		}

		System.out.println(profit);

	}

}
