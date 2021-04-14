package binarysearchtree;

import java.util.Stack;

public class median {
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

		public void morristraversalinorder() {
			morristraversalinorder(this.root);
		}

		// o(1) space traversal
		private void morristraversalinorder(Node root) {
			Node current = root;
			while (current != null) {
				if (current.left == null) {
//					System.out.print(current.data + " ");
					n++;
					current = current.right;
				} else {
					Node pre = current.left;
					while (pre.right != null && pre.right != current) {
						pre = pre.right;
					}
					if (pre.right == null) {
						pre.right = current;
						current = current.left;
					}
					// left is already visited remove link and visit right
					else {
						pre.right = null;// break the link
//						System.out.print(current.data + " ");
						n++;
						current = current.right;
					}
				}

			}

		}

		public static int k = 0;
		public static int n = 0;

		public void findMedian(Node root) {
			n = 0;
			k = 0;
			morristraversalinorder(root);
			if (n % 2 == 0) {
				k = n / 2;
				int a = kthsmallest(root);
				k = (n / 2) + 1;
				int b = kthsmallest(root);
				float ans = (float) ((float) (a + b) / 2);
				System.out.println(ans);
			} else {
				k = (n + 1) / 2;
				int b = kthsmallest(root);
				System.out.println(b);
			}
		}

		public static int kthsmallest(Node root) {
			Node current = root;
			while (current != null) {
				if (current.left == null) {
					k--;
					if (k == 0) {
						return current.data;
					}
					current = current.right;
				} else {
					Node pre = current.left;
					while (pre.right != null && pre.right != current) {
						pre = pre.right;
					}
					if (pre.right == null) {
						pre.right = current;
						current = current.left;
					}
					// left is already visited remove link and visit right
					else {
						pre.right = null;// break the link
						k--;
						if (k == 0) {
							return current.data;
						}
						current = current.right;
					}
				}

			}

			return Integer.MIN_VALUE;
		}

	}

	public static void main(String[] args) {
//		int[] arr = {};
//		5 3 7 2 4 6 8
//		10 6 15 3 8 11 18
//		String s = "1()(3()(4()(5()(6))))";
		int[] arr1 = { 2, 3, 4, 5, 6, 7, 8 };
		BST tree1 = new BST(arr1);
		tree1.display();
		System.out.println();
//		tree1.morristraversalinorder();
		tree1.findMedian(tree1.root);

	}

}
