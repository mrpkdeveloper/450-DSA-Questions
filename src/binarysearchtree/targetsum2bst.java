package binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class targetsum2bst {
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

		public void inorder(Node parent, ArrayList<Integer> list) {
			if (parent == null) {
				return;
			}
			inorder(parent.left, list);
			list.add(parent.data);
			inorder(parent.right, list);
		}

		public static int countPairs(Node root1, Node root2, int x) {
			if (root1 == null || root2 == null) {
				return 0;
			}
			int ans = 0;
			ans += countPairs(root1.left, root2, x);
			int c = x - root1.data;
			if (find(root2, c)) {
				ans += 1;
			}
			ans += countPairs(root1.right, root2, x);

			return ans;

		}

		public static boolean find(Node root, int n) {
			if (root == null) {
				return false;
			}
			Boolean ans = false;
			if (n > root.data) {
				ans = find(root.right, n);
			} else if (n < root.data) {
				ans = find(root.left, n);
			} else {
				return true;
			}

			return ans;
		}

	}

	public static void main(String[] args) {
//		int[] arr = {};
//		5 3 7 2 4 6 8
//		10 6 15 3 8 11 18
//		String s = "1()(3()(4()(5()(6))))";
//		int[] arr1 = { 2, 3, 4, 5, 6, 7, 8 };
		int[] arr1 = { 897, 684, 585, 786, 188, 943, 980, 523, 39, 797, 281, 808, 739, 579, 118, 967, 256 };
//		int[] arr2 = { 3, 6, 8, 10, 11, 15, 18 };
		int[] arr2 = { 841, 991, 759, 722, 51, 752, 619, 870, 371, 649, 78, 871, 418, 326, 554, 2, 111, 93, 944, 91,
				615, 334, 239, 896, 142, 977, 826, 259, 944, 433, 245, 136, 423, 3, 858 };
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		BST tree1 = new BST(arr1);
		tree1.display();
		BST tree2 = new BST(arr2);
		System.out.println();
		tree2.display();
		System.out.println();
		System.out.println(tree1.countPairs(tree1.root, tree2.root, 825));
//		System.out.println(tree2.find(tree2.root, 8));

	}

}
