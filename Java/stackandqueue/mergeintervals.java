package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class mergeintervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intv = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		merge(intv);

	}

	public static class pair implements Comparable<pair> {
		int start;
		int end;

		pair(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if (this.start != o.start)
				return this.start - o.start;
			else
				return this.end - o.end;
		}

	}

	// using stack
	public static void merge(int[][] intv) {

		pair[] arr = new pair[intv.length];
		for (int i = 0; i < intv.length; i++) {
			arr[i] = new pair(intv[i][0], intv[i][1]);
		}

		Arrays.parallelSort(arr);

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

		while (st.size() > 0) {
			pair rv = st.pop();
			System.out.println(rv.start + " - " + rv.end);
		}

	}

	// without using extra space
	public static int[][] mergeintervals(int[][] arr) {

		// sorting arr
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		int start = 0, end = 1;
		ArrayList<int[]> ans = new ArrayList<>();
		int[] arrres = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arrres[1] >= arr[i][0]) {
				if (arrres[1] <= arr[i][1])
					arrres[1] = arr[i][1];
			} else {
				ans.add(arrres);
				arrres = arr[i];
			}
		}

		ans.add(arrres);

		return ans.toArray(new int[0][]);
	}

}
