package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class kthancestor {
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

		public ArrayList<Integer> roottonode(Node parent, int n) {
			if (parent == null) {
				return new ArrayList<Integer>();
			}

			if (parent.data == n) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(parent.data);
				return list;
			}

			ArrayList<Integer> listleft = roottonode(parent.left, n);
			ArrayList<Integer> listright = roottonode(parent.right, n);

			if (listleft.size() > 0) {
				listleft.add(parent.data);
				return listleft;
			}
			if (listright.size() > 0) {
				listright.add(parent.data);
				return listright;
			}

			return new ArrayList<Integer>();

		}

		public int kthancestor(int n1, int k) {

			return kthancestor(this.root, n1, k);
		}

		private int kthancestor(Node parent, int n1, int k) {

			ArrayList<Integer> listn1 = roottonode(parent, n1);

			int i = listn1.size() - 1;
			while (i >= 0 && i != k) {
				i--;
			}
			if (i == k)
				return listn1.get(i);
			else
				return -1;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		kthancestor m = new kthancestor();
//			BinaryTree tree = m.new BinaryTree("1(3(2)(1(1)))(-1(4(1)(2))(5(6)))");
//			BinaryTree tree = m.new BinaryTree("1(3(2)(4))(6)");
		BinaryTree tree = m.new BinaryTree("1(2(3))");
		tree.display();
		System.out.println();
		System.out.println(tree.kthancestor(3, 1));

	}

}
