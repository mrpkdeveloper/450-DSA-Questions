package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gergovia {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		while (true) {
			int n = scn.nextInt();
			if (n == 0) {
				break;
			}
			long[] arr = new long[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextLong();
			}
			solve2(arr);
		}

	}

	// brute force O(n2) -> time ans O(1) -> space
	public static void solve(int[] arr) {

		int work = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > 0) {
					if (arr[j] < 0) {
						int min = Math.min(arr[i], -arr[j]);
						arr[i] -= min;
						arr[j] += min;
						work += (j - i) * min;
					}
				} else {
					if (arr[j] > 0) {
						int min = Math.min(-arr[i], arr[j]);
						arr[i] += min;
						arr[j] -= min;
						work += (j - i) * min;
					}
				}
			}
		}

		System.out.println(work);

	}

	// most optimised O(n) -> time ans O(1) -> space
	public static void solve2(long[] arr) {
		long work = 0;
		int sell = 0, buy = 0;
		while (true) {
			while (sell < arr.length && arr[sell] >= 0) {
				sell++;
			}
			while (buy < arr.length && arr[buy] <= 0) {
				buy++;
			}

			if (sell == arr.length || buy == arr.length) {
				break;
			}

			long min = (long) Math.min(arr[buy], -arr[sell]);

			work += min * (Math.abs(sell - buy));
			arr[buy] -= min;
			arr[sell] += min;

		}

		System.out.println(work);

	}

}
