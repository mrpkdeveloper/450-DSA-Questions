package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class issumtree {

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
			node.data = Integer.parseInt(String.valueOf(s.charAt(0)));
			if (s.length() > 1) {
				Stack<Character> stack = new Stack<>();
				stack.push(s.charAt(1));
				int i = 2;
				while (!stack.isEmpty() && i < s.length()) {
					if (s.charAt(i) == '(') {
						stack.push(s.charAt(i));
					} else if (s.charAt(i) == ')') {
						stack.pop();
					}
					i++;
				}
				int end = i;
				String leftsub = s.substring(2, end - 1);
//				System.out.println(leftsub);
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

		public boolean issumtree() {
			return issumtree(this.root).ans;
		}

		public class pair {
			boolean ans;
			int sum;

			pair(boolean ans, int sum) {
				this.ans = ans;
				this.sum = sum;
			}
		}

		private pair issumtree(Node parent) {
			if (parent == null) {
				pair mp = new pair(true, 0);
				return mp;
			}
			if (parent.left == null && parent.right == null) {
				pair mp = new pair(true, parent.data);
				return mp;
			}

			pair left = issumtree(parent.left);
			pair right = issumtree(parent.right);
			Boolean ans = false;

			pair mp = new pair(left.ans && right.ans && (left.sum + right.sum == parent.data),
					left.sum + right.sum + parent.data);
			return mp;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		issumtree m = new issumtree();
//		BinaryTree tree = m.new BinaryTree("4(2(3)(1))(6)");
		BinaryTree tree = m.new BinaryTree("7(3(1)(2))(1(1))");
		tree.display();
		System.out.println();
		System.out.println(tree.issumtree());

	}

}
