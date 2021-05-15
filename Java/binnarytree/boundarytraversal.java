package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class boundarytraversal {

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

		private void boundaryleft(Node parent, ArrayList<Integer> ans) {
			if (parent == null) {
				return;
			}
			if (parent.left != null) {
				ans.add(parent.data);
				boundaryleft(parent.left, ans);
			} else if (parent.right != null) {
				ans.add(parent.data);
				boundaryleft(parent.right, ans);
			}
		}

		private void boundaryleafnode(Node parent, ArrayList<Integer> ans) {
			if (parent == null) {
				return;
			}
			if (parent.left == null && parent.right == null) {
				ans.add(parent.data);
				return;
			}

			boundaryleafnode(parent.left, ans);
			boundaryleafnode(parent.right, ans);
		}

		private void boundaryright(Node parent, ArrayList<Integer> ans) {
			if (parent == null) {
				return;
			}
			if (parent.right != null) {
				boundaryright(parent.right, ans);
				ans.add(parent.data);
			} else if (parent.left != null) {
				boundaryright(parent.left, ans);
				ans.add(parent.data);
			}
		}

		public ArrayList<Integer> boundary() {
			return boundary(this.root);
		}

		private ArrayList<Integer> boundary(Node parent) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(parent.data);
			boundaryleft(parent.left, ans);
			boundaryleafnode(parent, ans);
			boundaryright(parent.right, ans);
			return ans;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// true 74 false true 75 false false true 73 false false
		boundarytraversal m = new boundarytraversal();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println();
		System.out.println(tree.boundary());
	}

}
