package binarysearchtree;

import java.util.Stack;

public class largestbst {
	public static class BST {

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

		private int size = 0;
		private Node root = null;

		BST(int[] arr) {
//			this.root = makeBSTfrompre(arr, 0, arr.length - 1);
			this.root = makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		BST(String s) {
			this.root = inputfromstring(s, this.root);
		}

		// time complexity of order of n2
		private Node makeBSTfrompre(int[] arr, int lo, int hi) {

			Node parent = new Node(arr[0], null, null);
			for (int i = 1; i < arr.length; i++) {
				add(parent, arr[i]);
			}
			return parent;

		}

		public static int i = 0;

		private Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
			if (i >= arr.length || arr[i] < min || arr[i] > max) {
				return null;
			}
			Node node = new Node(arr[i++], null, null);
			node.left = makeBSTfrompreoptimised(arr, min, node.data);
			node.right = makeBSTfrompreoptimised(arr, node.data, max);
			return node;
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

		public boolean find(int n) {
			return find(this.root, n);
		}

		private boolean find(Node parent, int n) {
			if (parent == null) {
				return false;
			}

			boolean ans = false;
			;
			if (n > parent.data) {
				ans = find(parent.right, n);
			} else if (n < parent.data) {
				ans = find(parent.left, n);
			} else {
				return true;
			}

			return ans;

		}

		public void add(int n) {
			this.root = add(this.root, n);
		}

		private Node add(Node parent, int n) {
			if (parent == null) {
				return new Node(n, null, null);
			}
			if (n > parent.data) {
				parent.right = add(parent.right, n);
			} else if (n < parent.data) {
				parent.left = add(parent.left, n);
			}
			return parent;
		}

//		public int max() {
//			return max(this.root);
//		}

		private Node max(Node parent) {

			if (parent == null) {
				return null;
			}
			if (parent.right != null) {
				return max(parent.right);
			} else {
				return parent;
			}
		}

		private Node min(Node parent) {

			if (parent == null) {
				return null;
			}
			if (parent.left != null) {
				return min(parent.left);
			} else {
				return parent;
			}
		}

		public class pair {
			int size;
			boolean isbst;
			Node node;
			int min;
			int max;

			pair(int size, boolean ans) {
				this.size = size;
				this.isbst = ans;
			}
		}

		boolean isbst(Node root, int min, int max) {
			if (root == null) {
				return true;
			}

			if (min >= root.data || max <= root.data) {
				return false;
			} else if (!isbst(root.left, min, root.data)) {
				return false;
			} else if (!isbst(root.right, root.data, max)) {
				return false;
			}

			return true;

		}

		public int largestbst() {
			pair ans = largestbst(this.root);
//			System.out.println("Node----- " + ans.node.data);
			return ans.size;
		}

		private pair largestbst(Node root) {

			if (root == null) {
				pair mp = new pair(0, true);
				mp.min = Integer.MAX_VALUE;
				mp.max = Integer.MIN_VALUE;
				return mp;
			}

			pair left = largestbst(root.left);
			pair right = largestbst(root.right);

			pair mp = new pair(0, false);
			mp.isbst = left.isbst && right.isbst && (root.data > left.max && root.data < right.min);
			mp.min = Math.min(root.data, Math.min(left.min, right.min));
			mp.max = Math.max(root.data, Math.max(left.max, right.max));

			if (mp.isbst) {
				mp.size = left.size + right.size + 1;
				mp.node = root;
			} else {
				if (left.size > right.size) {
					mp.size = left.size;
					mp.node = left.node;
				} else {
					mp.size = right.size;
					mp.node = right.node;
				}
			}
			return mp;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		successorandpre m = new successorandpre();
//		int[] arr = { 1, 2 };
//		int[] arr = { 10, 5, 1, 7, 40, 50 };
//		int[] arr = { 1, 3 };
//		int[] arr = {};
//		String s = "1(4(6)(8))(4)";
		String s = "0(2(1)(3))";
		BST tree = new BST(s);
		tree.display();
		System.out.println(tree.largestbst());
	}

}
