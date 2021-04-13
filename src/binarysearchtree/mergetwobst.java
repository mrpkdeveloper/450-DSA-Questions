package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class mergetwobst {

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

		public void inorder(Node parent, ArrayList<Integer> list) {
			if (parent == null) {
				return;
			}
			inorder(parent.left, list);
			list.add(parent.data);
			inorder(parent.right, list);
		}

		private Node makeBST(ArrayList<Integer> arr, int lo, int hi) {
			if (lo > hi) {
				return null;
			}

			int mid = lo + (hi - lo) / 2;
			Node parent = new Node(arr.get(mid), null, null);
			parent.left = makeBST(arr, lo, mid - 1);
			parent.right = makeBST(arr, mid + 1, hi);

			return parent;

		}

		public void mergebst(BST tree) {
			this.root = mergebst(this.root, tree.root);
		}

		private Node mergebst(Node parent1, Node parent2) {
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			inorder(parent1, list1);
			inorder(parent2, list2);
			ArrayList<Integer> list3 = new ArrayList<>();
			int i = 0, j = 0;
			while (i < list1.size() && j < list2.size()) {
				if (list1.get(i) < list2.get(j)) {
					list3.add(list1.get(i));
					i++;
				} else {
					list3.add(list2.get(j));
					j++;
				}
			}
			if (i == list1.size()) {
				while (j < list2.size()) {
					list3.add(list2.get(j));
					j++;
				}
			} else {
				while (i < list1.size()) {
					list3.add(list1.get(i));
					i++;
				}
			}
			System.out.println(list3);
			return makeBST(list3, 0, list3.size() - 1);
		}

	}

	public static void main(String[] args) {
//		int[] arr = { 1, 2 };
//		int[] arr = { 10, 5, 1, 7, 40, 50 };
//		int[] arr = { 1, 3 };
//		int[] arr = {};
		String s = "1()(3()(4()(5()(6))))";
		BST tree = new BST(s);
		String s1 = "2()(7()(8()(10()(12))))";
		BST tree1 = new BST(s1);
//		tree.display();
		tree.mergebst(tree1);
		tree.display();

	}

}
