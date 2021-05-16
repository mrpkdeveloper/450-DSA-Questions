package stackandqueue;

import java.util.Stack;

public class nextgreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 2, 1, 3, 8, 6, 7, 5 };
		long[] ans = nextLargerElement(arr);
		for (long l : ans) {
			System.out.println(l);
		}
	}

	// O(n)-> time
	public static long[] nextLargerElement(long[] arr) {
		long[] ans = new long[arr.length];
		ans[arr.length - 1] = -1;
		Stack<Long> st = new Stack<>();
		st.push(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {

			// remove smaller elements
			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			// add itself
			st.push(arr[i]);
		}

		return ans;
	}

}
