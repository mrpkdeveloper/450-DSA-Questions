package stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class maxelementinwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 8, 4, 5, 2, 3, 6 };
		int k = 3;
		maxinwindow2(arr, k);

	}

	// O(n) -> time using deque
	public static void maxinwindow(int[] arr, int k) {

		Deque<Integer> q = new LinkedList<Integer>();
		int i;
		// work for 1st window
		for (i = 0; i < k; i++) {
			while (!q.isEmpty() && arr[i] > arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);
		}

		for (; i < arr.length; i++) {
			System.out.print(arr[q.getFirst()] + " ");
			while (!q.isEmpty() && q.getFirst() <= i - k) {
				q.removeFirst();
			}
			while (!q.isEmpty() && arr[i] > arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);

		}
		System.out.print(arr[q.getFirst()] + " ");
	}

	// using stack (next grtr technique)
	public static void nextgreater(int[] arr, int[] ans) {

		LinkedList<Integer> st = new LinkedList<Integer>();
		st.addFirst(arr.length - 1);
		ans[arr.length - 1] = arr.length;
		// storing index of nxt grtr element
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.removeFirst();
			}
			if (st.size() == 0) {
				ans[i] = arr.length;
			} else
				ans[i] = st.peek();
			st.addFirst(i);
		}
	}

	public static void maxinwindow2(int[] arr, int k) {
		int[] nxtgrtr = new int[arr.length];
		nextgreater(arr, nxtgrtr);
		int j = 0;
		for (int i = 0; i <= nxtgrtr.length - k; i++) {
			if (j < i) {
				j = i;
			}

			while (nxtgrtr[j] < i + k) {
				j = nxtgrtr[j];
			}

			System.out.print(arr[j] + " ");
		}

	}

}
