package searchingandsorting;

import java.util.Arrays;

public class agressivecows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 2, 8, 9 };
		AC(arr, 5, 3);

	}

	public static void AC(int[] arr, int n, int c) {

		Arrays.parallelSort(arr);

		int lo = 0, hi = n - 1;
		int ans = 0;
		while (lo <= hi) {
			int gap = lo + (hi - lo) / 2;
			int ncp = 1;
			int prev = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] - prev >= gap) {
					prev = arr[i];
					ncp++;
				}
				if (ncp == c) {
					break;
				}
			}

			if (ncp == c) {
				ans = gap;
				lo = gap + 1;
			} else {
				hi = gap - 1;
			}

		}

		System.out.println(ans);

	}

}
