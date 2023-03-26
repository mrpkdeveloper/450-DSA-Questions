package strings;

import java.util.Stack;

import java.util.*;

public class balanceparenthisis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanced("()"));

	}

    public static boolean balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
