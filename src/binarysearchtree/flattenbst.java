package binarysearchtree;

import java.util.Stack;

public class flattenbst {
	public static class BST {

		private static class Node {
			int data;
			Node left;
			Node right;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
		}

		private int size = 0;
		private Node root = null;

		BST(int[] arr) {
			this.root = makeBST(arr, 0, arr.length - 1);
		}

		BST(String s) {
			this.root = inputfromstring(s, this.root);
		}

		private Node makeBST(int[] arr, int lo, int hi) {
			if (lo > hi) {
				return null;
			}

			int mid = lo + (hi - lo) / 2;
			Node parent = new Node(arr[mid], null, null);
			parent.left = makeBST(arr, lo, mid - 1);
			parent.right = makeBST(arr, mid + 1, hi);

			return parent;

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
			if (parent == null) {
				return;
			}
			String str = "";
			if (parent.left != null) {
				str += parent.left.data;
			}
			str += " => " + parent.data + " <= ";
			if (parent.right != null) {
				str += parent.right.data;
			}
			System.out.println(str);
			display(parent.left);
			display(parent.right);

		}

		public void flattenbst() {
			this.root = flattenbst(this.root);
//			flattenbstpre(this.root);
		}

		public static Node prev = new Node(-1, null, null);

		// this is acc to preorder
		private void flattenbstpre(Node root) {
			if (root == null) {
				return;
			}

			flattenbstpre(root.right);
			flattenbstpre(root.left);

			root.right = prev;
			root.left = null;
			prev = root;

		}

		// this is acc to inorder
		private Node flattenbst(Node root) {
			if (root == null) {
				return root;
			}
			Node temp = new Node(-1, null, null);
			prev = temp;

			inorder(root);

			prev.left = null;
			prev.right = null;

			// Copy the tree.
			Node newRoot = temp.right;
			System.out.println(newRoot.data);

			return newRoot;
		}

		private void inorder(Node root) {
			if (root == null) {
				return;
			}
			inorder(root.left);
			prev.left = null;
			prev.right = root;
			prev = root;
			inorder(root.right);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		successorandpre m = new successorandpre();
//		int[] arr = { 1, 2 };
		String s = "5(3(2(1))(4))(7(6)(8))";
//		String s = "5(3(2)(4))";
		BST tree = new BST(s);
		tree.display();
		System.out.println();
		tree.flattenbst();
		tree.display();

	}

}
