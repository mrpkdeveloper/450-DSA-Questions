package binnarytree;

import java.util.Scanner;

public class isbalanced {

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

		public boolean isbalanced() {
			return isbalanced(this.root).isbal;
		}

		public class pair {
			int ht;
			boolean isbal;

			pair(int ht, boolean isbal) {
				this.ht = ht;
				this.isbal = isbal;
			}
		}

		private pair isbalanced(Node parent) {
			if (parent == null) {
				return new pair(0, true);
			}

			pair left = isbalanced(parent.left);
			pair right = isbalanced(parent.right);

			int mht = Math.max(left.ht, right.ht) + 1;
			boolean misbal = (Math.abs(left.ht - right.ht) <= 1) && left.isbal && right.isbal;
			pair myans = new pair(mht, misbal);
			return myans;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// true 74 false true 75 false false true 73 false false
		isbalanced m = new isbalanced();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println();
		System.out.println(tree.isbalanced());

	}
}
