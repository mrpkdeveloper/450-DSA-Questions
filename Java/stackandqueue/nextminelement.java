package stackandqueue;

import java.util.Stack;

public class nextminelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 8, 5, 2, 25 };
		nxtmin(arr);

	}

	public static void nxtmin(int[] arr) {

		Stack<Integer> st = new Stack<>();

		int[] ans = new int[arr.length];
		ans[arr.length - 1] = -1;
		st.push(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] < st.peek()) {
				st.pop();
			}

			if (st.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(arr[i]);
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
