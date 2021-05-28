package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ekospoj {

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
//		int[] arr = { 4, 42, 40, 26, 46 };
//		int m = 20;
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		long m = scn.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}
		cut(arr, m);

	}

	public static void cut(long[] arr, long m) {
		long lo = Long.MAX_VALUE, hi = 0;
		for (int i = 0; i < arr.length; i++) {
			if (lo > arr[i]) {
				lo = arr[i];
			}

			if (hi < arr[i]) {
				hi = arr[i];
			}
		}
		long ans = 0;
		while (lo <= hi) {
			long mid = lo + (hi - lo) / 2;
			long woodcut = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					woodcut += arr[i] - mid;
				}
			}

			if (woodcut >= m) {
				if (ans < mid) {
					ans = mid;
				}
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		PrintWriter writer = new PrintWriter(System.out);
		writer.print(ans);
		writer.flush();
		writer.close();
	}

}
