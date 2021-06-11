package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pickingupchicks {

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
		int a = 1;
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			long k = scn.nextLong();
			long b = scn.nextLong();
			long time = scn.nextLong();

			long[] speed = new long[n];
			long[] pos = new long[n];

			for (int i = 0; i < pos.length; i++) {
				pos[i] = scn.nextLong();
			}
			for (int i = 0; i < speed.length; i++) {
				speed[i] = scn.nextLong();
			}
			solve(speed, pos, time, k, b, a);
			a++;

			t--;
		}

	}

	public static void solve(long[] speed, long[] pos, long time, long k, long b, int t) {

		int count = 0, swap = 0, notposible = 0;

		for (int i = pos.length - 1; i >= 0; i--) {

			long disttoreach = (b - pos[i]);
			long distcanreach = speed[i] * time;

			if (distcanreach >= disttoreach) {
				count++;
				if (notposible > 0) {
					swap += notposible;
				}
			} else {
				notposible++;
			}

			if (count >= k) {
				break;
			}

		}

		if (count >= k) {
			System.out.println("Case #" + t + ": " + swap);
		} else {
			System.out.println("Case #" + t + ": IMPOSSIBLE");
		}

	}

}
