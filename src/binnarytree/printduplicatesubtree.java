package binnarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class printduplicatesubtree {

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

		BinaryTree(String s) {
			Scanner scn = new Scanner(System.in);
			this.root = inputfromstring(s, null);

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

		private String printduplicates(Node parent, Map<String, Integer> map) {
			if (parent == null) {
				String s = "";
				return s;
			}
			String s = "(";
			s += printduplicates(parent.left, map);
			s += parent.data;
			s += printduplicates(parent.right, map);
			s += ")";

//			String ans = left + "/" + parent.data + "/" + right;
			if (map.containsKey(s) && map.get(s) == 1) {
				int i = 0;
//				while (ans.charAt(i) != '/') {
//					i++;
//				}
				System.out.print(parent.data + " ");
			}
			if (map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}

			return s;
		}

		public void printall() {
			printall(this.root);
		}

		private void printall(Node parent) {
			Map<String, Integer> map = new HashMap<>();
			printduplicates(parent, map);
			System.out.println(map);
			int flag = 0;
//			for (Map.Entry<String, Integer> ans : map.entrySet()) {
//				if (ans.getValue() > 1) {
//					flag = 1;
//					int i = 0;
//					while (ans.getKey().charAt(i) != '/') {
//						i++;
//					}
//					System.out.print(ans.getKey().substring(0, i) + " ");
//				}
//			}
			if (flag == 0) {
				System.out.println(-1);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		printduplicatesubtree m = new printduplicatesubtree();
//		BinaryTree tree = m.new BinaryTree("1(3(2)(1(1)))(-1(4(1)(2))(5(6)))");
//		BinaryTree tree = m.new BinaryTree("1(2(4))(3(2(4))(4))");
		BinaryTree tree = m.new BinaryTree("10(20(25))(30(20(25)))");
		tree.display();
		System.out.println();
		tree.printall();

	}

}
