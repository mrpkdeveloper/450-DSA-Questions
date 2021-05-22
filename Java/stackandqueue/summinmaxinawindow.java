package stackandqueue;

import java.util.Stack;

public class summinmaxinawindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
		int k = 4;
		summinmax(arr, k);

	}

	// using stack (next grtr technique)
	public static void nextgreater(int[] arr, int[] ans) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr.length - 1);
		ans[arr.length - 1] = arr.length;
		// storing index of nxt grtr element
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = arr.length;
			} else
				ans[i] = st.peek();
			st.push(i);
		}
	}

	public static void nextsmaller(int[] arr, int[] ans) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr.length - 1);
		ans[arr.length - 1] = arr.length;
		// storing index of nxt grtr element
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				ans[i] = arr.length;
			} else
				ans[i] = st.peek();
			st.push(i);
		}
	}

	public static void summinmax(int[] arr, int k) {

		int[] nxtgrtr = new int[arr.length];
		nextgreater(arr, nxtgrtr);
		int[] nxtsmall = new int[arr.length];
		nextsmaller(arr, nxtsmall);

		int sum = 0;
		int maxi = 0; // for max
		int mini = 0; // for min
		for (int i = 0; i <= arr.length - k; i++) {
			if (maxi < i) {
				maxi = i;
			}
			if (mini < i) {
				mini = i;
			}

			while (nxtgrtr[maxi] < i + k) {
				maxi = nxtgrtr[maxi];
			}
			while (nxtsmall[mini] < i + k) {
				mini = nxtsmall[mini];
			}

			System.out.println(arr[maxi] + "  " + arr[mini]);

			sum += arr[maxi] + arr[mini];

		}

		System.out.println(sum);

	}

}
