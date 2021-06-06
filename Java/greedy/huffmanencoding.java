package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class huffmanencoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abcdef";
//		int f[] = { 5, 9, 12, 13, 16, 45 };
		String s = "qwertyuiopasdfghjklzxcvbn";
		int f[] = { 8, 9, 14, 19, 20, 21, 21, 25, 33, 45, 50, 50, 66, 68, 70, 73, 74, 75, 76, 82, 85, 90, 94, 97, 100 };
		ArrayList<String> ans = huffmanCodes(s, f, f.length);
		System.out.println(ans);

	}

	public static class Node implements Comparable<Node> {
		int data;
		char ch;
		Node left, right;

		Node(int d, char c) {
			this.data = d;
			this.ch = c;
			this.left = null;
			this.right = null;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.data - o.data;
		}
	}

	public static ArrayList<String> huffmanCodes(String s, int f[], int N) {
		// Code here

		PriorityQueue<Node> heap = new PriorityQueue<>();
		for (int i = 0; i < s.length(); i++) {
			heap.add(new Node(f[i], s.charAt(i)));
		}

		while (heap.size() > 0) {
			Node rv = heap.poll();
			System.out.println(rv.ch + " - " + rv.data);
		}

//		Node root = null;
//		while (heap.size() > 1) {
//			Node one = heap.remove();
//			Node two = heap.remove();
//
//			Node nn = new Node(one.data + two.data, '-');
//			nn.left = one;
//			nn.right = two;
//			root = nn;
//			heap.add(nn);
//		}
		ArrayList<String> fans = new ArrayList<String>();
//		print(root, "", fans);

		return fans;

	}

	private static void print(Node root, String ans, ArrayList<String> fans) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null && root.ch != '-') {
			fans.add(ans);
			return;
		}

		print(root.left, ans + "0", fans);
		print(root.right, ans + "1", fans);

	}

}
