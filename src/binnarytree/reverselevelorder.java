package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class reverselevelorder {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;

		}

	}

	public ArrayList<Integer> reverseLevelOrder(Node parent) {
		// code here
		LinkedList<Node> queue = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<>();
		queue.addLast(parent);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			stack.push(rv.data);
			if (rv.right != null) {
				queue.addLast(rv.right);
			}
			if (rv.left != null) {
				queue.addLast(rv.left);
			}
		}

		while (!stack.empty()) {
			ans.add(stack.pop());
		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
