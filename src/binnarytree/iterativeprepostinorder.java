package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class iterativeprepostinorder {

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

		BinaryTree() {
			Scanner scn = new Scanner(System.in);
			this.root = input(scn, null, false);

		}

		private Node input(Scanner scn, Node parent, Boolean isleftorright) {
			if (parent == null) {
				System.out.println("Enter data for the parent node");
			} else {

				if (isleftorright) {
					System.out.println("Enter data for the left child of " + parent.data);
				} else {
					System.out.println("Enter data for the right child of " + parent.data);
				}
			}

			int data = scn.nextInt();
			Node node = new Node(data, null, null);
			this.size++;
			System.out.println("does " + node.data + " has left child");
			Boolean choice = false;
			choice = scn.nextBoolean();
			if (choice) {
				node.left = input(scn, node, true);
			}

			choice = false;
			System.out.println("does " + node.data + " has right child");
			choice = scn.nextBoolean();
			if (choice) {
				node.right = input(scn, node, false);
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

		public void inorder() {
			inorder(this.root);
		}

		private void inorder(Node parent) {
			if (parent == null) {
				return;
			}
			inorder(parent.left);
			System.out.print(parent.data + " ");
			inorder(parent.right);

		}

		public void iterative() {
			iterative(this.root);
		}

		public class pair {
			Node node;
			int state;

			pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		private void iterative(Node parent) {
			Stack<pair> stack = new Stack<>();
			String pre = "";
			String post = "";
			String in = "";
			pair mp = new pair(parent, 1);
			stack.push(mp);
			while (!stack.isEmpty()) {
				pair top = stack.peek();
				if (top.state == 1) {
					// pre s++ left
					pre += top.node.data + " ";
					top.state++;
					if (top.node.left != null) {
						pair leftp = new pair(top.node.left, 1);
						stack.push(leftp);
					}

				} else if (top.state == 2) {
					// in s++ right
					in += top.node.data + " ";
					top.state++;
					if (top.node.right != null) {
						pair rightp = new pair(top.node.right, 1);
						stack.push(rightp);
					}

				} else {
					// post pop
					post += top.node.data + " ";
					stack.pop();
				}

			}

			System.out.println(pre);
			System.out.println(in);
			System.out.println(post);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		iterativeprepostinorder m = new iterativeprepostinorder();
		BinaryTree tree = m.new BinaryTree();
//		tree.display();
		tree.inorder();
		System.out.println();
		tree.iterative();

	}

}
