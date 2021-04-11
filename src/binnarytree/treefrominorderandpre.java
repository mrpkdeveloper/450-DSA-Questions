package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class treefrominorderandpre {
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

		public void treefrominandpre(int[] in, int[] pre) {
			this.root = treefrominandpre(in, 0, in.length - 1, pre, 0, pre.length - 1);
		}

		private Node treefrominandpre(int[] in, int inlo, int inhi, int[] pre, int prelo, int prehi) {
			if (inlo > inhi) {
				return null;
			}
			Node parent = new Node(pre[prelo], null, null);
			int i;
			for (i = inlo; i <= inhi; i++) {
				if (in[i] == pre[prelo]) {
					break;
				}
			}
			int end = i - inlo;

			parent.left = treefrominandpre(in, inlo, inlo + end - 1, pre, prelo + 1, prelo + end);
			parent.right = treefrominandpre(in, inlo + end + 1, inhi, pre, prelo + end + 1, prehi);
			return parent;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		treefrominorderandpre m = new treefrominorderandpre();
		BinaryTree tree = m.new BinaryTree("4(2(3)(1))(6(1))");
		tree.display();
		System.out.println();
		int[] in = { 1, 6, 8, 7 };
		int[] pre = { 1, 6, 7, 8 };
		tree.treefrominandpre(in, pre);
		tree.display();

	}
}
