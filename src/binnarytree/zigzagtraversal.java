package binnarytree;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class zigzagtraversal {

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

		public void zigzag() {
			zigzag(this.root);
		}

		private void zigzag(Node parent) {
			Stack<Node> p = new Stack<>();
			Stack<Node> c = new Stack<>();
			p.push(parent);
			int level = 0;
			while (!p.isEmpty()) {
				Node node = p.pop();
				System.out.println(node.data + " ");
				if (level % 2 == 0) {
					if (node.left != null) {
						c.push(node.left);
					}
					if (node.right != null) {
						c.push(node.right);
					}
				} else {
					if (node.right != null) {
						c.push(node.right);
					}
					if (node.left != null) {
						c.push(node.left);
					}
				}
				if (p.size() == 0) {
					level++;
					p = c;
					c = new Stack<>();
				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// true 74 false true 75 false false true 73 false false
		zigzagtraversal m = new zigzagtraversal();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println();
		tree.zigzag();

	}

}
