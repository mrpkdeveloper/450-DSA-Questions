package stackandqueue;

import java.util.Stack;

public class evaluatepostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int evaluatePostFix(String s) {
		Stack<Integer> st = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				st.push(s.charAt(i) - '0');
			} else {
				char ch = s.charAt(i);
				int a = st.pop();
				int b = st.pop();
				if (ch == '+') {
					st.push(b + a);
				} else if (ch == '-') {
					st.push(b - a);
				} else if (ch == '*') {
					st.push(b * a);
				} else {
					st.push(b / a);
				}
			}
			i++;
		}

		return st.pop();
	}

}
