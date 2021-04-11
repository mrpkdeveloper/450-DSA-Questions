package strings;

import java.util.Stack;

public class countreversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(count("}{{}}{{{"));
		System.out.println(count("{}{{}{"));

	}

	public static int count(String s) {
		Stack<Character> list = new Stack<Character>();
		list.add(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (list.empty() == false && (list.peek() == '{' && s.charAt(i) == '}')) {
				list.pop();
			} else {
				list.add(s.charAt(i));
			}
		}

		int open = 0, close = 0;
		if (list.empty()) {
			return 0;
		} else if (list.size() % 2 != 0) {
			return -1;
		} else {
			while (!list.empty()) {
				if (list.peek() == '{') {
					open++;
				} else if (list.peek() == '}') {
					close++;
				}
				list.pop();
			}

			return ((open + close) / 2 + open % 2);

		}
	}

}
