package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class diagnoltraversal {

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

		public void diagnol() {
			diagnol(this.root, 0);
		}

		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

		private void diagnol(Node parent, int d) {
			if (parent == null) {
				return;
			}

			if (map.containsKey(d)) {
				ArrayList<Integer> list = map.get(d);
				list.add(parent.data);
				map.replace(d, list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(parent.data);
				map.put(d, list);
			}

			diagnol(parent.left, d + 1);
			diagnol(parent.right, d);

		}

		public void diagnolopti() {
			diagnolopti(this.root);
		}

		private void diagnolopti(Node parent) {
			LinkedList<Node> queue = new LinkedList<>();
			queue.addLast(parent);
			while (!queue.isEmpty()) {
				Node rv = queue.removeFirst();
				while (rv != null) {
					System.out.print(rv.data + " ");
					if (rv.left != null) {
						queue.addLast(rv.left);
					}
					rv = rv.right;
				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// true 74 false true 75 false false true 73 false false
		diagnoltraversal m = new diagnoltraversal();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println();
//		System.out.println(tree.isbalanced());
		tree.diagnol();
		System.out.println(tree.map);
		System.out.println();
		tree.diagnolopti();

	}

}
