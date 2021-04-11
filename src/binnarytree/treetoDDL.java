package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class treetoDDL {

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

		public Node treetoDDL(Node parent) {

			ArrayList<Integer> ans = new ArrayList<Integer>();
			inorder(parent, ans);
			System.out.println(ans);
			Node head = new Node(ans.get(0), null, null);
			Node prev = new Node(ans.get(1), null, null);
			head.right = prev;
			prev.left = head;
			for (int i = 2; i < ans.size(); i++) {
				Node node = new Node(ans.get(i), prev, null);
				prev.right = node;
				prev = node;
			}

			return head;

		}

		public Node treetoDDL2(Node parent) {
			Node head = new Node(0, null, null);
			inorder2(parent, head);
			return head;

		}

		Node prev = null;

		private void inorder2(Node parent, Node head) {
			if (parent == null) {
				return;
			}
			inorder2(parent.left, head);
			if (prev == null) {
				head = parent;
			} else {
				parent.left = prev;
				prev.right = parent;
			}
			prev = parent;
			inorder2(parent.right, head);
		}

		private void inorder(Node parent, ArrayList<Integer> ans) {
			if (parent == null) {
				return;
			}

			inorder(parent.left, ans);
			ans.add(parent.data);
			inorder(parent.right, ans);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		treetoDDL m = new treetoDDL();
		BinaryTree tree = m.new BinaryTree("4(2(3)(1))(6)");
		tree.display();
		System.out.println();

	}

}
