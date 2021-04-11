package binnarytree;

import java.util.LinkedList;

public class levelorder {

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

	public void levelorder(Node parent) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(parent);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.print(rv.data + " ");
			if (rv.left != null) {
				queue.addLast(rv.left);
			}
			if (rv.right != null) {
				queue.addLast(rv.right);
			}
		}
	}

	public static void main(String[] args) {

	}
}
