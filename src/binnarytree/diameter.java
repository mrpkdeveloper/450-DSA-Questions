package binnarytree;

import java.util.Scanner;

public class diameter {
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

		public int height(Node root) {
			if (root == null) {
				return -1;
			}

			int left = height(root.left);
			int right = height(root.right);

			return Math.max(left, right) + 1;

		}

		public int diameter1() {
			return diameter1(this.root);
		}

		// but this is inefficient
		private int diameter1(Node parent) {
			if (parent == null) {
				return 0;
			}

			int ld = diameter1(parent.left);
			int rd = diameter1(parent.right);
			int height = height(parent.left) + height(parent.right) + 2;

			return Math.max(height, Math.max(ld, rd));

		}

		public class diapair {
			int height;
			int dia;
		}

		public int diameter2() {
			return diameter2(this.root).dia;
		}

		// but this is efficient
		private diapair diameter2(Node parent) {
			if (parent == null) {
				diapair d = new diapair();
				d.height = -1;
				d.dia = 0;
				return d;
			}

			diapair ld = diameter2(parent.left);
			diapair rd = diameter2(parent.right);

			diapair mp = new diapair();
			int f = ld.height + rd.height + 2;
			mp.dia = Math.max(f, Math.max(ld.dia, rd.dia));
			mp.height = Math.max(ld.height, rd.height) + 1;

			return mp;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		diameter m = new diameter();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println(tree.diameter1());

	}

}
