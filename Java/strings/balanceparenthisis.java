package strings;

import java.util.Stack;

public class balanceparenthisis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanced("()"));

	}

	public static boolean balanced(String s) {
		Stack<Character> list = new Stack<Character>();
		list.add(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (list.empty() == false && (list.peek() == '(' && s.charAt(i) == ')'
					|| list.peek() == '[' && s.charAt(i) == ']' || list.peek() == '{' && s.charAt(i) == '}')) {
				list.pop();
			} else {
				list.add(s.charAt(i));
			}
		}

		if (list.empty()) {
			return true;
		} else {
			return false;
		}
	}

}
