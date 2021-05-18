package stackandqueue;

import java.util.Stack;

public class balancedpara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "((({{}}))))";
		System.out.println(ispar(x));

	}

	static boolean ispar(String x) {
		Stack<Character> st = new Stack<>();
		int i = 0;
		while (i < x.length()) {
			char ch = x.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[') {
				st.push(ch);
			} else {
				if (!st.isEmpty()) {
					char cl = st.peek();
					if ((ch == ')' && cl == '(') || (ch == ']' && cl == '[') || (ch == '}' && cl == '{')) {
						st.pop();
					} else {
						return false;
					}

				} else {
					return false;
				}
			}
			i++;
		}
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

}
