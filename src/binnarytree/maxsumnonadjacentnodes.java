package binnarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class maxsumnonadjacentnodes {
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

		// wrong approach works only on array not on tree
//		private void inorder(Node parent, ArrayList<Integer> ans) {
//			if (parent == null) {
//				return;
//			}
//
//			inorder(parent.left, ans);
//			ans.add(parent.data);
//			inorder(parent.right, ans);
//		}
//
//		public int maxsum() {
//			return maxsum(this.root);
//		}

		// greedy

//		private int maxsum(Node parent) {
//			ArrayList<Integer> ans = new ArrayList<>();
//			inorder(parent, ans);
//			Integer[] arr = new Integer[ans.size()];
//			System.out.println(ans);
//			ans.toArray(arr);
//			int inc = 0, exc = 0, maxsum = 0;
//			for (int i = 0; i < arr.length; i++) {
//				int temp = inc;
//				inc = arr[i] + exc;
//				exc = Math.max(temp, exc);
//				if (maxsum < Math.max(inc, exc)) {
//					maxsum = Math.max(inc, exc);
//				}
//			}
//
//			return maxsum;
//		}

		public int maxsum() {
			return maxsum(this.root);
		}

		HashMap<Node, Integer> map = new HashMap<>();

		private int maxsum(Node parent) {
			if (parent == null) {
				return 0;
			}

			if (map.containsKey(parent)) {
				return map.get(parent);
			}

			int inc = parent.data;
			if (parent.left != null) {
				inc += maxsum(parent.left.left);
				inc += maxsum(parent.left.right);
			}
			if (parent.right != null) {
				inc += maxsum(parent.right.left);
				inc += maxsum(parent.right.right);
			}

			int exc = maxsum(parent.left) + maxsum(parent.right);

			int myans = Math.max(inc, exc);
			map.put(parent, myans);
			return myans;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		maxsumnonadjacentnodes m = new maxsumnonadjacentnodes();
		BinaryTree tree = m.new BinaryTree("40(2(1))(3(5)(2))");
		tree.display();
		System.out.println();
//		int[] in = { 1, 6, 8, 7 };
//		int[] pre = { 1, 6, 7, 8 };
//		tree.treefrominandpre(in, pre);
//		tree.display();
		System.out.println(tree.maxsum());

	}

}
