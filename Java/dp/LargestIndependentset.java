package dp;

import java.util.HashMap;

public class LargestIndependentset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root = new node(20);
		root.left = new node(8);
		root.left.left = new node(4);
		root.left.right = new node(12);
		root.left.right.left = new node(10);
		root.left.right.right = new node(14);
		root.right = new node(22);
		root.right.right = new node(25);

		HashMap<node, Integer> dp = new HashMap<>();
		System.out.println(solve(root, dp));

	}

	public static class node {
		int data;
		node left, right;

		node(int data) {
			this.data = data;
		}
	}

	public static int solve(node root, HashMap<node, Integer> dp) {

		if (root == null) {
			return 0;
		}

		if (dp.containsKey(root)) {
			return dp.get(root);
		}

		int inc = 1;
		if (root.left != null) {
			inc += solve(root.left.left, dp);
			inc += solve(root.left.right, dp);
		}
		if (root.right != null) {
			inc += solve(root.right.left, dp);
			inc += solve(root.right.right, dp);
		}

		int exc = solve(root.left, dp) + solve(root.right, dp);

		int myans = Math.max(inc, exc);
		dp.put(root, myans);
		return myans;

	}

}
