package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minplatforms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arrival[] = { 950, 1100, 940, 1500, 1800, 900 };
//		int dept[] = { 1120, 1130, 1200, 1900, 2000, 910 };
		int arrival[] = { 2200, 900, 2230 };
		int dept[] = { 800, 2200, 2250 };
		train[] arr = new train[2];
		for (int i = 0; i < arr.length; i++) {
			if (arrival[i] >= dept[i]) {
				arr[i] = new train(1, 2);
			} else
				arr[i] = new train(arrival[i], dept[i]);

		}

		System.out.println(findPlatform(arrival, dept, dept.length));
		solve(arr);
	}

	public static class train implements Comparable<train> {
		int at, dt;

		train(int a, int d) {
			this.at = a;
			this.dt = d;
		}

		@Override
		public int compareTo(train o) {
//			return this.at - o.at;
			if (this.at - o.at < 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void solve(train[] arr) {
		Arrays.parallelSort(arr);
		int maxp = 1;
		PriorityQueue<train> heap = new PriorityQueue<>();
		heap.add(new train(arr[0].dt, arr[0].at));
		for (int i = 1; i < arr.length; i++) {
			if (heap.peek().at < arr[i].at) {
				train rv = heap.remove();
				System.out.println(rv.dt + " - " + rv.at);
			} else {
				maxp++;
			}
			heap.add(new train(arr[i].dt, arr[i].at));
		}
		System.out.println(maxp);
	}

	// optimised solution O(nlogn) -> time O(1) - > space
	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int maxplat = 1;
		int i = 1, j = 0;
		while (i < arr.length) {
			if (arr[i] <= dep[j]) {
				maxplat++;
			} else {
				j++;
			}
			i++;
		}

		return maxplat;

	}

}
