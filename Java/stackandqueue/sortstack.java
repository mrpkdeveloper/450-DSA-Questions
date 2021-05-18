package stackandqueue;

import java.util.Stack;

public class sortstack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Stack<Integer> sort(Stack<Integer> s) {
		if (s.size() == 1) {
			return s;
		}
		int top = s.pop();
		Stack<Integer> ans = sort(s);
		return insert(top, ans);
	}

	public Stack<Integer> insert(int top, Stack<Integer> s) {
		if (s.size() == 0) {
			s.push(top);
			return s;
		}

		if (top > s.peek()) {
			s.push(top);
			return s;
		} else {

			int t = s.pop();
			Stack<Integer> ans = insert(top, s);
			ans.push(t);
			return ans;
		}
	}

}
