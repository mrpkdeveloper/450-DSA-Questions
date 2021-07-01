package dp;

import java.util.Arrays;
import java.util.HashMap;

public class maxrectanglewithsum0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = { { 1, 2, 3 }, { -3, -2, -1 }, { 1, 7, 5 } };
//		int[][] arr = { { 9, 7, 16, 5 }, { 1, -6, -7, 3 }, { 1, 8, 7, 9 }, { 7, -2, 0, 10 } };
		int[][] arr = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 8, 7, 9 }, { 0, 0, 0, 0 } };
		solvedp(arr);
	}

	public static void solvedp(int[][] arr) {

		int[] dp = new int[arr[0].length];
		int si = 0, sj = 0, ei = 0, ej = 0;

		for (int k = 0; k < arr.length; k++) {

			for (int i = k; i < arr.length; i++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				int sum = 0;
				map.put(sum, -1);
				for (int j = 0; j < arr[0].length; j++) {
					dp[j] += arr[i][j];
					sum += dp[j];
					if (map.containsKey(sum)) {
						int currlength = j - map.get(sum);
						int currbreadth = i - k + 1;

						int currarea = currlength * currbreadth;
						int maxarea = (ei - si + 1) * (ej - sj + 1);

						if (currarea > maxarea) {
							si = k;
							ei = i;
							sj = map.get(sum) + 1;
							ej = j;
						}
					} else {
						map.put(sum, j);
					}

				}
			}
			Arrays.fill(dp, 0);
		}

//		System.out.println(si + " " + ei);
//		System.out.println(sj + " " + ej);

		for (int i = si; i <= ei; i++) {
			for (int j = sj; j <= ej; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
