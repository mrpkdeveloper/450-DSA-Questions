package heap;

import java.util.PriorityQueue;

public class connectropes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = { 4, 3, 2, 6 };
		System.out.println(minCost(arr, 4));
	}

	public static long minCost(long arr[], int n) {

		PriorityQueue<Long> heap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		Long ans = 0L;
		while (heap.size() > 1) {
			long a = heap.remove();
			long b = heap.remove();
			heap.add(a + b);
			ans += a + b;
		}

		return ans;
	}
}
