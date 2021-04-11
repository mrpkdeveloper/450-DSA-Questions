package binnarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class isomorphictree {

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
				int end = i - 1;
				String leftsub = s.substring(start, end);
				node.left = inputfromstring(leftsub, node);
				if (end + 2 < s.length() - 1) {
					String rightsub = s.substring(end + 2, s.length() - 1);
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

		public boolean isomorphic(BinaryTree tree) {
			return isomorphic(this.root, tree.root);
		}

		private boolean isomorphic(Node parent1, Node parent2) {
			if (parent1 == null && parent2 == null) {
				return true;
			}

			if (parent1 == null || parent2 == null) {
				return false;
			}

			if (parent1.data != parent2.data) {
				return false;
			}

			boolean a = isomorphic(parent1.left, parent2.left) && isomorphic(parent1.right, parent2.right);
			boolean b = isomorphic(parent1.left, parent2.right) && isomorphic(parent1.right, parent2.left);
			return a || b;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		isomorphictree m = new isomorphictree();
		BinaryTree tree = m.new BinaryTree("10(-20)");
		BinaryTree tree2 = m.new BinaryTree("1(3)(2)");
		tree.display();
		System.out.println();
		System.out.println(tree.isomorphic(tree2));

	}
}
