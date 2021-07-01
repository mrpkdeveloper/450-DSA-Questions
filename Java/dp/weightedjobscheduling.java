package dp;

import java.util.Arrays;

public class weightedjobscheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class pair implements Comparable<pair> {
		int s, e, p;

		pair(int s, int e, int p) {
			this.s = s;
			this.e = e;
			this.p = p;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.e - o.e;
		}

	}

	public static void solvedp(pair[] jobs) {
		Arrays.parallelSort(jobs);
		int[] dp = new int[jobs.length];

		for (int i = 0; i < dp.length; i++) {
			dp[i] = jobs[i].p;
		}

		for (int i = 0; i < dp.length; i++) {
			int inc = jobs[i].p;
			for (int j = i - 1; j >= 0; j--) {
				if (jobs[j].e <= jobs[i].s) {
					inc += dp[j];
					break;
				}
			}
			dp[i] = Math.max(inc, dp[i - 1]);
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}

	}

}
