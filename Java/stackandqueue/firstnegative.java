package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class firstnegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
//		firstnegative(arr, k);
	}

	public long[] printFirstNegativeInteger(long arr[], int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();
		long[] ans = new long[N - K + 1];
		int k = 0;
		int i;
		for (i = 0; i < K; i++) {
			if (arr[i] < 0) {
				q.add(i);
			}
		}
		for (; i < arr.length; i++) {
			if (q.size() == 0) {
				ans[k++] = 0;
			} else {
				ans[k++] = arr[q.peek()];
			}

			while (!q.isEmpty() && q.peek() <= i - K) {
				q.remove();
			}
			if (arr[i] < 0) {
				q.add(i);
			}
		}

		if (q.size() == 0) {
			ans[k++] = 0;
		} else {
			ans[k++] = arr[q.peek()];
		}

		return ans;

	}

}
