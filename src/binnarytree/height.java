package binnarytree;

public class height {

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

	public int height(Node root) {
		if (root == null) {
			return -1;
		}

		int left = height(root.left);
		int right = height(root.right);

		return Math.max(left, right) + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
