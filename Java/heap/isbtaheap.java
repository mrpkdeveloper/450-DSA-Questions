package heap;

import binnarytree.treefromstring;
import binnarytree.treefromstring.BinaryTree;

public class isbtaheap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treefromstring m = new treefromstring();
		BinaryTree tree = m.new BinaryTree("5(2)(3)");
		tree.display();
		System.out.println();

		System.out.println(isHeap(tree.root));
	}

	public static boolean isHeap(binnarytree.treefromstring.BinaryTree.Node root) {

		return (isHeapmax(root) && iscomplete(root, noofnodes(root), 0));

	}

	public static boolean isHeapmax(binnarytree.treefromstring.BinaryTree.Node root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.data < root.left.data || root.right != null && root.data < root.right.data) {
			return false;
		}
		boolean left = isHeapmax(root.left);
		boolean right = isHeapmax(root.right);

		if (left && right) {
			return true;
		}
		return false;

	}

	public static int noofnodes(binnarytree.treefromstring.BinaryTree.Node root) {
		if (root == null) {
			return 0;
		}

		return (1 + noofnodes(root.left) + noofnodes(root.right));
	}

	public static boolean iscomplete(binnarytree.treefromstring.BinaryTree.Node root, int totalnodes, int index) {
		if (root == null) {
			return true;
		}

		if (index > totalnodes) {
			return false;
		}

		return (iscomplete(root.left, totalnodes, 2 * index + 1) && iscomplete(root.right, totalnodes, 2 * index + 2));

	}

}
