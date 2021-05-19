package stackandqueue;

import java.util.Stack;

public class redundantbrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "((a+b))";
		String s = "((a+b)+(d+e))";
//		String s = "(a+(b)/c)";
		System.out.println(redundant(s));

	}

	public static boolean redundant(String s) {

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ')') {
				boolean flag = true;
				char op = st.peek();
				while (op != '(') {
					if (op == '+' || op == '-' || op == '*' || op == '/') {
						flag = false;
					}
					st.pop();
					op = st.peek();
				}
				st.pop();
				if (flag == true)
					return true;

			} else {
				st.push(ch);
			}
		}

		return false;
	}

}
