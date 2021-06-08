package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class buymaxstocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 10, 7, 4 };
		int k = 100;
		solve(price, k);

	}

	public static class pair implements Comparable<pair> {
		int price, n;

		pair(int p, int n) {
			this.price = p;
			this.n = n;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.price - o.price;
		}

	}

	public static void solve(int[] price, int k) {

		PriorityQueue<pair> heap = new PriorityQueue<>();
		for (int i = 0; i < price.length; i++) {
			heap.add(new pair(price[i], i + 1));
		}

		int maxn = 0;
		int amt = 0;
		while (!heap.isEmpty()) {
			pair rv = heap.remove();
//			System.out.println(rv.price + " - " + rv.n);
			for (int i = 1; i <= rv.n; i++) {
				if (amt + rv.price <= k) {
					amt += rv.price;
					maxn++;
				}
			}
		}

//		System.out.println(amt);
		System.out.println(maxn);

	}

}
