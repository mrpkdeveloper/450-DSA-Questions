package binarysearchtree;

public class deletionandfindvalue {

	public class BST {

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

		private int size = 0;
		private Node root = null;

		BST(int[] arr) {
			this.root = makeBST(arr, 0, arr.length - 1);
		}

		private Node makeBST(int[] arr, int lo, int hi) {
			if (lo > hi) {
				return null;
			}

			int mid = lo + (hi - lo) / 2;
			Node parent = new Node(arr[mid], null, null);
			parent.left = makeBST(arr, lo, mid - 1);
			parent.right = makeBST(arr, mid + 1, hi);

			return parent;

		}

		public void display() {
			display(this.root);
		}

		private void display(Node parent) {
			if (parent == null) {
				return;
			}
			String str = "";
			if (parent.left != null) {
				str += parent.left.data;
			}
			str += " => " + parent.data + " <= ";
			if (parent.right != null) {
				str += parent.right.data;
			}
			System.out.println(str);
			display(parent.left);
			display(parent.right);

		}

		public boolean find(int n) {
			return find(this.root, n);
		}

		private boolean find(Node parent, int n) {
			if (parent == null) {
				return false;
			}

			boolean ans = false;
			;
			if (n > parent.data) {
				ans = find(parent.right, n);
			} else if (n < parent.data) {
				ans = find(parent.left, n);
			} else {
				return true;
			}

			return ans;

		}

		public void add(int n) {
			add(this.root, n);
		}

		private void add(Node parent, int n) {
			if (n > parent.data) {
				if (parent.right != null)
					add(parent.right, n);
				else {
					parent.right = new Node(n, null, null);
				}
			} else {
				if (parent.left != null)
					add(parent.left, n);
				else {
					parent.left = new Node(n, null, null);
				}
			}

		}

		public int max() {
			return max(this.root);
		}

		private int max(Node parent) {

			if (parent == null) {
				return 0;
			}
			if (parent.right != null) {
				return max(parent.right);
			} else {
				return parent.data;
			}
		}

		public void remove(int n) {
			this.root = remove(this.root, n);
		}

		private Node remove(Node node, int n) {
			if (node == null) {
				return null;
			}

			if (n > node.data) {
				node.right = remove(node.right, n);
			} else if (n < node.data) {
				node.left = remove(node.left, n);
			} else {
				if (node.left == null && node.right == null) {
					return null;
				} else if (node.left != null && node.right == null) {
					return node.left;
				} else if (node.left == null && node.right != null) {
					return node.right;
				} else {
					node.data = max(node.left);
					node.left = remove(node.left, node.data);
					return node;
				}
			}

			return node;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deletionandfindvalue m = new deletionandfindvalue();
		int[] arr = { 1, 2, 3, 4, 5, 7, 8 };
//		int[] arr = {};
		BST tree = m.new BST(arr);
		tree.display();
		System.out.println();
		tree.remove(4);
		tree.display();

	}

}
