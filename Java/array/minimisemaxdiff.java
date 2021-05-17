package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class minimisemaxdiff {
//Minimize the maximum diff between heights

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };
		int[] arr = { 6, 1, 9, 1, 1, 7, 9, 5, 2, 10 };
		minimise(arr, 4, arr.length);
		System.out.println(getMinDiff(arr, arr.length, 4));

	}

	static class pair {

		int value;
		int ind;

	}

	// aproach -1
	public static void minimise(int[] arr, int k, int n) {
		ArrayList<pair> list = new ArrayList<>();
		int[] visited = new int[n];

		for (int i = 0; i < arr.length; i++) {
			pair p = new pair();
			p.value = arr[i] + k;
			p.ind = i;
			list.add(p);
			if (arr[i] - k >= 0) {
				pair a = new pair();
				a.value = arr[i] - k;
				a.ind = i;
				list.add(a);
			}

		}

		Collections.sort(list, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}

		});

		int l = 0, r = 0, ele = 0;
		while (ele < n && r < list.size()) {

			if (visited[list.get(r).ind] == 0) {
				ele++;
			}
			visited[list.get(r).ind]++;
			r++;
		}

		int ans = list.get(r - 1).value - list.get(l).value;

		while (r < list.size()) {
			// now shift window
			if (visited[list.get(l).ind] == 1) {
				ele--;
			}
			visited[list.get(l).ind]--;
			l++;

			while (ele < n && r < list.size()) {

				if (visited[list.get(r).ind] == 0) {
					ele++;
				}
				visited[list.get(r).ind]++;
				r++;
			}

			if (ele == n) {
				ans = Math.min(ans, list.get(r - 1).value - list.get(l).value);
			} else
				break;

		}

		System.out.println(ans);

	}

	// this approach fails for some test cases
	static int getMinDiff(int arr[], int n, int k) {
		if (n == 1)
			return 0;

		Arrays.sort(arr);

		int ans = arr[n - 1] - arr[0];

		int small = arr[0] + k;
		int big = arr[n - 1] - k;
		int temp = 0;

		if (small > big) {
			temp = small;
			small = big;
			big = temp;
		}

		// Traverse middle elements
		for (int i = 1; i < n - 1; i++) {
			int subtract = arr[i] - k;
			int add = arr[i] + k;

			if (subtract >= small || add <= big)
				continue;

			if (big - subtract <= add - small)
				small = subtract;
			else
				big = add;
		}

//		System.out.println(big);
//		System.out.println(small);
		return Math.min(ans, big - small);
	}

}
