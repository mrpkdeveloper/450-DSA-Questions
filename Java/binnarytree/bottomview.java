package binnarytree;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class bottomview {

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

		public void verticallevelorder() {
			verticallevelorder(this.root, 0, 0);
		}

		public class pair {
			int depth;
			int data;

			pair(int depth, int data) {
				this.depth = depth;
				this.data = data;
			}
		}

		Map<Integer, pair> map = new TreeMap<>();

		// for bottom view
		private void verticallevelorder(Node parent, int ht, int depth) {
			if (parent == null) {
				return;
			}
			if (map.containsKey(ht)) {
				pair mp = map.get(ht);
				if (mp.depth < depth) {
					map.replace(ht, new pair(depth, parent.data));
				}
			} else {
				map.put(ht, new pair(depth, parent.data));
			}
			verticallevelorder(parent.left, ht - 1, depth + 1);
			verticallevelorder(parent.right, ht + 1, depth + 1);

		}

		public void bottomview() {
			bottomview(this.root);
		}

		private void bottomview(Node parent) {
			this.verticallevelorder();
			for (Map.Entry<Integer, pair> mp : map.entrySet()) {
				System.out.println(mp.getValue().data);
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// true 74 false true 75 false false true 73 false false
		bottomview m = new bottomview();
		BinaryTree tree = m.new BinaryTree();
		tree.display();
		System.out.println();
		tree.bottomview();

	}

}
