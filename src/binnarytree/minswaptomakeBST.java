package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class minswaptomakeBST {

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
			this.root = inputfromstring(s);

		}

		BinaryTree(int[] arr) {
			this.root = inputfromarr(arr, 0);
		}

		private Node inputfromstring(String s) {
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
				node.left = inputfromstring(leftsub);
				if (end + 1 < s.length() - 1) {
					String rightsub = s.substring(end + 1, s.length() - 1);
					node.right = inputfromstring(rightsub);
				}
			}
			return node;

		}

		private Node inputfromarr(int[] arr, int i) {
			if (i >= arr.length) {
				return null;
			}

			Node node = new Node(arr[i], null, null);
			node.left = inputfromarr(arr, 2 * i + 1);
			node.right = inputfromarr(arr, 2 * i + 2);

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

		public void inorder(Node parent, ArrayList<Integer> ans) {
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
		minswaptomakeBST m = new minswaptomakeBST();
//		BinaryTree tree = m.new BinaryTree("4(2(3)(1))(6(1))");
		int[] arr = { 5, 6, 7, 8, 9, 10, 11 };
		BinaryTree tree = m.new BinaryTree(arr);
		tree.display();
		System.out.println();
		ArrayList<Integer> ans = new ArrayList<>();
		tree.inorder(tree.root, ans);
		System.out.println(ans);

	}
}
