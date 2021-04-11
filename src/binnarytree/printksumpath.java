package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class printksumpath {
	public class BinaryTree {

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

		private Node root = null;
		private int size = 0;

		BinaryTree(String s) {
			Scanner scn = new Scanner(System.in);
			this.root = inputfromstring(s, null);

		}

		private Node inputfromstring(String s, Node parent) {
			if (s.length() == 0) {
				return null;
			}
			Node node = new Node(0, null, null);
			int i = 0;
			while (i < s.length() && s.charAt(i) != '(') {
				i++;
			}
			int start = i + 1;
			String no = s.substring(0, i);
			node.data = Integer.parseInt(no);
			if (i < s.length()) {
				Stack<Character> stack = new Stack<>();
				stack.push(s.charAt(i));
				i++;
				while (!stack.isEmpty() && i < s.length()) {
					if (s.charAt(i) == '(') {
						stack.push(s.charAt(i));
					} else if (s.charAt(i) == ')') {
						stack.pop();
					}
					i++;
				}
				int end = i;
				String leftsub = s.substring(start, end - 1);
				node.left = inputfromstring(leftsub, node);
				if (end + 1 < s.length() - 1) {
					String rightsub = s.substring(end + 1, s.length() - 1);
					node.right = inputfromstring(rightsub, node);
				}
			}
			return node;

		}

		public void display() {
			display(this.root);
		}

		private void display(Node parent) {

			String str = "";
			if (parent.left != null) {
				str += parent.left.data + " => ";
			} else {
				str += "End => ";
			}
			str += parent.data;
			if (parent.right != null) {
				str += " <= " + parent.right.data;
			} else {
				str += " <= End";
			}
			System.out.println(str);
			if (parent.left != null) {
				display(parent.left);
			}
			if (parent.right != null) {
				display(parent.right);
			}

		}

		public void path(int k) {
			ArrayList<Integer> ans = new ArrayList<>();
			path(this.root, k, ans);
		}

		private void path(Node parent, int k, ArrayList<Integer> ans) {
			if (parent == null) {
				return;
			}
			ans.add(parent.data);
			path(parent.left, k, ans);
			path(parent.right, k, ans);

			Integer[] arr = new Integer[ans.size()];
			ans.toArray(arr);
			int sum = 0;
			String s = "";
			for (int i = arr.length - 1; i >= 0; i--) {
				sum += arr[i];
				s = arr[i] + " " + s;
				if (sum == k) {
					System.out.println(s);
				}
			}

			ans.remove(ans.size() - 1);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		printksumpath m = new printksumpath();
		BinaryTree tree = m.new BinaryTree("1(3(2)(1(1)))(-1(4(1)(2))(5(6)))");
//		BinaryTree tree = m.new BinaryTree("1(3(2))(6)");
		tree.display();
		System.out.println();
		tree.path(5);

	}
}
