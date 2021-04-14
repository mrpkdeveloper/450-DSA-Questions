package binarysearchtree;

import java.util.Stack;

public class replacewithleastgreterelement {
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

		public static Node succ = null;

		public static Node add(Node parent, int n) {
			if (parent == null) {
				return new Node(n, null, null);
			}
			if (n > parent.data) {
				parent.right = add(parent.right, n);
			} else {
				succ = parent;
				parent.left = add(parent.left, n);
			}

			return parent;
		}

		public static void replace(int[] arr) {
			Node root = null;
			for (int i = arr.length - 1; i >= 0; i--) {
				root = add(root, arr[i]);
				if (succ != null) {
					arr[i] = succ.data;
					succ = null;
				} else {
					arr[i] = -1;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}

		}

	}

	public static void main(String[] args) {
//		int[] arr = {};
//		5 3 7 2 4 6 8
//		10 6 15 3 8 11 18
//		String s = "13(10(3(1)(6))(11()(12)))(18(15)(20))";
//		int[] arr1 = { 1, 3, 6, 10, 11, 12, 13, 15, 18, 20 };
//		BST tree1 = new BST(arr1);
//		tree1.display();
		int[] arr = { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
		BST.replace(arr);
	}
}
