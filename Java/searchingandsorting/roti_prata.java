package searchingandsorting;

import java.util.Scanner;

public class roti_prata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int s = scn.nextInt();
			int[] arr = new int[s];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(prata(arr, n));
			t--;
		}

	}

	// check if n prata can be made in t time
	public static boolean check(int[] arr, long t, int n) {
		int nop = 0;
		for (int i = 0; i < arr.length; i++) {
			int time = arr[i];
			int j = 2;
			while (time <= t) {
				nop++;
				time += arr[i] * j;
				j++;
			}
			if (nop >= n) {
				return true;
			}
		}
		return false;
	}

	public static long prata(int[] arr, int n) {

		long lo = 0;
		long ans = 0;
		long hi = (long) Math.pow(10, 8);
		while (lo <= hi) {
			long mid = lo + (hi - lo) / 2;
			if (check(arr, mid, n)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return ans;
	}

}
