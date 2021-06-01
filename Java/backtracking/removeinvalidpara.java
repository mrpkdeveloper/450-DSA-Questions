package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class removeinvalidpara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "())))()v(k";
//		String s = "(a)())()";
		HashSet<String> map = new HashSet<>();
		HashSet<String> ans = new HashSet<>();
		List<String> fans = new ArrayList<String>();
		int min = getmin(s);
		print(s, min, ans, map);
		for (String val : ans) {
			fans.add(val);
		}
		System.out.println(fans);
	}

	public static void print(String s, int minnoofremoval, HashSet<String> ans, HashSet<String> map) {
		if (minnoofremoval == 0) {
			// check if valid or not
			if (getmin(s) == 0) {
				if (!ans.contains(s)) {
					ans.add(s);
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(') {
				continue;
			}
			String res = s.substring(0, i) + s.substring(i + 1);
			if (!map.contains(res)) {
				map.add(res);
				print(res, minnoofremoval - 1, ans, map);
			}
		}
	}

	public static int getmin(String s) {

		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(') {
				st.pop();
			} else if (s.charAt(i) == '(' || s.charAt(i) == ')')
				st.push(s.charAt(i));
		}

		return st.size();

	}

}
