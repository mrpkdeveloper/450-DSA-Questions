package dp;

import java.util.Arrays;
import java.util.HashMap;

public class maxrectanglewithequal01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 0, 0, 1, 1 }, { 0, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 0, 0, 1 } };
//		int arr[][] = { { 0, 0, 1, 1 }, { 0, 1, 1, 1 } };

		solve(arr);
	}

	public static void solve(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = -1;
				}
			}
		}

		int[] dp = new int[arr[0].length];
		int si = 0, sj = 0, ei = 0, ej = 0;
		int maxarea = Integer.MIN_VALUE;

		for (int k = 0; k < arr.length; k++) {

			for (int i = k; i < arr.length; i++) {
				int sum = 0;
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(sum, -1);
				for (int j = 0; j < arr[0].length; j++) {
					dp[j] += arr[i][j];
					sum += dp[j];
					if (map.containsKey(sum)) {
						int currarea = (j - map.get(sum)) * (i - k + 1);
						maxarea = Math.max(currarea, maxarea);
					} else {
						map.put(sum, j);
					}
				}
			}
			Arrays.fill(dp, 0);
		}

		System.out.println(maxarea);

	}

}
