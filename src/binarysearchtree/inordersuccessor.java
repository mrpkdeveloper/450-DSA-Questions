package binarysearchtree;

import java.util.Stack;

public class inordersuccessor {
	public static class BST {

		private class Node {
			int data;
			Node left;
			Node right;
			Node next;

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

		BST(String s) {
			this.root = inputfromstring(s, this.root);
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

		private Node inputfromstring(String s, Node parent) {
			if (s.length() == 0) {
				return null;
			}
			Node node = new Node(0, null, null);
			int i = 0;
			while (i < s.length() && s.charAt(i) != '(') {
				i++;
			}
			int start = i + 1;
			String no = s.substring(0, i);
			node.data = Integer.parseInt(no);
			if (i < s.length()) {
				Stack<Character> stack = new Stack<>();
				stack.push(s.charAt(i));
				i++;
				while (!stack.isEmpty() && i < s.length()) {
					if (s.charAt(i) == '(') {
						stack.push(s.charAt(i));
					} else if (s.charAt(i) == ')') {
						stack.pop();
					}
					i++;
				}
				int end = i;
				String leftsub = s.substring(start, end - 1);
				node.left = inputfromstring(leftsub, node);
				if (end + 1 < s.length() - 1) {
					String rightsub = s.substring(end + 1, s.length() - 1);
					node.right = inputfromstring(rightsub, node);
				}
			}
			return node;

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
			this.root = add(this.root, n);
		}

		private Node add(Node parent, int n) {
			if (parent == null) {
				return new Node(n, null, null);
			}
			if (n > parent.data) {
				parent.right = add(parent.right, n);
			} else if (n < parent.data) {
				parent.left = add(parent.left, n);
			}
			return parent;
		}

//		public int max() {
//			return max(this.root);
//		}

		private Node max(Node parent) {

			if (parent == null) {
				return null;
			}
			if (parent.right != null) {
				return max(parent.right);
			} else {
				return parent;
			}
		}

		private Node min(Node parent) {

			if (parent == null) {
				return null;
			}
			if (parent.left != null) {
				return min(parent.left);
			} else {
				return parent;
			}
		}

		Node suc = new Node(-1, null, null);
		Node pre = new Node(-1, null, null);

		public class pair {
			Node node;
			int state;

			pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

//		public void populateNext(Node root) {
//			if (root == null) {
//				return;
//			}
//
//			// iterative inorder
//			String in = "";
//			Stack<pair> stack = new Stack<>();
//			stack.add(new pair(root, 1));
//			while (!stack.isEmpty()) {
//				pair top = stack.peek();
//				if (top.state == 1) {
//					// pre
//					top.state++;
//					if (top.node.left != null) {
//						stack.add(new pair(top.node.left, 1));
//					}
//				} else if (top.state == 2) {
//					// in
//					in += top.node.data + " ";
//					suc = new Node(-1, null, null);
//					succ(root, top.node.data);
//					System.out.print(top.node.data + "->" + suc.data + " ");
//					top.state++;
//					if (top.node.right != null) {
//						stack.add(new pair(top.node.right, 1));
//					}
//				} else {
//					// post
//					stack.pop();
//				}
//			}
//			System.out.println(in);
//		}

		static Node next = null;

		public static void populateNext(Node node) {
			if (node != null) {
				// First set the next pointer in right subtree
				populateNext(node.right);

				// Set the next as previously visited node in reverse Inorder
				node.next = next;

				// Change the prev for subsequent node
				next = node;

				// Finally, set the next pointer in left subtree
				populateNext(node.left); 
			}
		}

		public static void inorder(Node parent) {
			if (parent == null) {
				return;
			}

			inorder(parent.left);
			System.out.print(parent.data + "-> ");
			if (parent.next != null) {
				System.out.print(parent.next.data + " ");
			} else {
				System.out.print(-1 + " ");
			}
			inorder(parent.right);
		}

//		public void succ(int n) {
//			succ(this.root, n);
//		}

		public void succ(Node root, int n) {
			if (root == null) {
				return;
			}
			if (root.data == n) {
				if (root.right != null) {
					suc = min(root.right);
				}
				return;
			}
			if (root.data > n) {
				suc = root;
				succ(root.left, n);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		successorandpre m = new successorandpre();
//		int[] arr = { 1, 2 };
//		int[] arr = {};
		String s = "50(40(35)(45))";
		BST tree = new BST(s);
		tree.display();
		tree.populateNext(tree.root);
		tree.inorder(tree.root);
	}

}
