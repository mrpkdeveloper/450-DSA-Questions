package stackandqueue;

import java.util.Stack;

public class longestvalidsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n) -> time and space
	static int findMaxLen(String s) {
		Stack<Integer> st = new Stack<>();
		int max = 0;
		int i = 0;
		st.push(-1);
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.size() == 0) {
					st.push(i);
				} else {
					int len = i - st.peek();
					if (max < len) {
						max = len;
					}
				}
			}
			i++;
		}
		return max;
	}

	// O(n) - > time but O(1)-> space
	static int findMaxLenopti(String s) {

		// 0 - n
		int o = 0, c = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				o++;
			} else {
				c++;
			}

			if (c > o) {
				c = 0;
				o = 0;
			} else if (c == o) {
				if (max < 2 * o) {
					max = 2 * o;
				}
			}
		}

		o = 0;
		c = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == '(') {
				o++;
			} else {
				c++;
			}

			if (o > c) {
				c = 0;
				o = 0;
			} else if (c == o) {
				if (max < 2 * o) {
					max = 2 * o;
				}
			}
		}

		return max;
	}

}
