package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class kthsmallestAGAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kthsmallest();

	}

	public static class pair implements Comparable<pair> {
		long start;
		long end;

		pair(long s, long e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(pair o) {
			if (this.start != o.start)
				return (int) (this.start - o.start);
			else
				return (int) (this.end - o.end);
		}

	}

	public static void kthsmallest() {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();
			int q = s.nextInt();
			int idx = 0, idx1 = 0;
			pair[] arr = new pair[n];
			long[] size = new long[n];
			while (n > 0) {
				long start = s.nextLong();
				long end = s.nextLong();
				arr[idx++] = new pair(start, end);
				n--;
			}

			Arrays.sort(arr);
			merge(arr);

			for (int i = 0; i < size.length; i++) {
				size[i] = arr[i].end - arr[i].start + 1;
			}

			while (q > 0) {
				long k = s.nextLong();
				int flag = 1;

				for (int i = 0; i < size.length; i++) {
					if (k <= size[i]) {
						flag = 0;
						long start = arr[i].start;
						System.out.println(start + k - 1);
					} else {
						k = k - size[i];
					}
				}

				if (flag == 1)
					System.out.println(-1);

				q--;
			}

			t--;
		}
	}

	public static void merge(pair[] arr) {

		Stack<pair> st = new Stack<>();
		int i = 0;
		while (i < arr.length) {
			pair rv = arr[i];
			if (i == 0) {
				st.push(rv);
			} else {
				pair top = st.peek();
				// merger
				if (top.end >= rv.start) {
					if (top.end < rv.end) {
						top.end = rv.end;
					}
				} else {
					st.push(rv);
				}
			}
			i++;
		}

	}

}
