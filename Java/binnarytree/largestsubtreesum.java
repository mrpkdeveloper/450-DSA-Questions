package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class largestsubtreesum {

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

		public int sum() {
			return sum(this.root);
		}

		public int maxsumsofar = Integer.MIN_VALUE;

		private int sum(Node parent) {
			if (parent == null) {
				return 0;
			}

			if (parent.left == null && parent.right == null) {
				return parent.data;
			}

			int left = sum(parent.left);
			int right = sum(parent.right);
			int mysum = left + right + parent.data;
			if (mysum > maxsumsofar) {
				maxsumsofar = mysum;
			}
			return mysum;
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
		largestsubtreesum m = new largestsubtreesum();
//		BinaryTree tree = m.new BinaryTree("4(2(3(4))(1))(6(1))");
		BinaryTree tree = m.new BinaryTree("1(2(4))(3(1(2(1))))");
//		BinaryTree tree = m.new BinaryTree("0(-2(4))(3(1(2(1))))");
		int[] in = { 4, -2, 5, 0, -6, 3, 2 };
		int[] pre = { 0, -2, 4, 5, 3, -6, 2 };
		tree.treefrominandpre(in, pre);
		System.out.println(tree.sum());
		System.out.println(tree.maxsumsofar);

	}
}
