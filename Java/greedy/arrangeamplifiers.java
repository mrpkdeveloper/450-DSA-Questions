package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class arrangeamplifiers {

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
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			long[] arr = new long[n];
			int count1 = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextLong();
				if (arr[i] == 1) {
					count1++;
				}
			}
			solve(arr, count1);
			t--;
		}

	}

	private static void solve(long[] arr, int count1) {
		Arrays.parallelSort(arr);
		for (int i = 0; i < count1; i++) {
			System.out.print(arr[i] + " ");
		}

		if (arr.length - count1 == 2 && arr[count1] == 2 && arr[count1 + 1] == 3) {
			System.out.print(arr[count1] + " " + arr[count1 + 1]);
		} else {
			for (int i = arr.length - 1; i >= count1; i--) {
				System.out.print(arr[i] + " ");
			}
		}

		System.out.println();
	}

}
