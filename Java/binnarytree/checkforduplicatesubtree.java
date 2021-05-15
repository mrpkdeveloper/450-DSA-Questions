package binnarytree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class checkforduplicatesubtree {
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

		public boolean checkduplicatesub() {
			return checkduplicatesub(this.root).ans;
		}

		public class pair {
			String s;
			boolean ans;

			pair(String s, boolean ans) {
				this.s = s;
				this.ans = ans;
			}
		}

		HashMap<String, Integer> map = new HashMap<>();

		private pair checkduplicatesub(Node parent) {
			if (parent == null) {
				String s = "$";
				pair mp = new pair(s, false);
				return mp;
			}

			if (parent.right == null && parent.left == null) {
				String s = "" + parent.data;
				pair mp = new pair(s, false);
				return mp;
			}

			pair left = checkduplicatesub(parent.left);
			pair right = checkduplicatesub(parent.right);
			String s = parent.data + left.s + right.s;
			pair mp = new pair(s, map.containsKey(s) || left.ans || right.ans);
			if (!map.containsKey(s)) {
				map.put(s, 1);
			}
			return mp;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		checkforduplicatesubtree m = new checkforduplicatesubtree();
//		BinaryTree tree = m.new BinaryTree("4(2(3(4))(1))(6(1))");
		BinaryTree tree = m.new BinaryTree("1(2(4)(5))(3(2(4)(5)))");
		tree.display();
		System.out.println();
		System.out.println(tree.checkduplicatesub());

	}

}
