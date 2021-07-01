package misclaneous;

import java.util.Scanner;
import java.util.Stack;

public class joshmirrortreequestion {
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

//		public void mirror() {
//			
//		}

		public boolean checkmirrorstructure(Node root1, Node root2) {
			if (root1 == null && root2 == null) {
				return true;
			} else if (root1 == null || root2 == null) {
				return false;
			} else {
				root2.data = root1.data;
			}

			if (checkmirrorstructure(root1.left, root2.right) && checkmirrorstructure(root1.right, root2.left)) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		joshmirrortreequestion m = new joshmirrortreequestion();
		BinaryTree tree = m.new BinaryTree("1(2(4(5)(6)))(3()(7(8)(9)))");
		tree.display();
		System.out.println(tree.checkmirrorstructure(tree.root.left, tree.root.right));
		tree.display();
	}

}
