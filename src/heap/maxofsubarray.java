package heap;

import java.util.LinkedList;

public class maxofsubarray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int K = 3;
		nextgreater(arr, new int[arr.length]);

	}

	// o(n) time
	public static void nextgreater(int[] arr, int[] ans) {

		LinkedList<Integer> st = new LinkedList<Integer>();
		st.addFirst(arr[arr.length - 1]);
		ans[arr.length - 1] = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.removeFirst();
			}
			ans[i] = st.peek();
			st.addFirst(arr[i]);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	public static void maxsubarray(int[] arr, int k) {

		int[] nxtgrt = new int[arr.length];
		nextgreater(arr, nxtgrt);

	}

}
