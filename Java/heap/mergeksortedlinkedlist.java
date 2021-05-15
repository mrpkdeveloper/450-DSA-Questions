package heap;

import java.util.PriorityQueue;

public class mergeksortedlinkedlist {

	public static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class pair implements Comparable<pair> {
		int llname;
		Node node;

		pair(int l, Node n) {
			this.llname = l;
			this.node = n;
		}

		@Override
		public int compareTo(pair o) {
			return this.node.data - o.node.data;
		}
	}

	public static Node mergeKList(Node[] arr, int K) {

		PriorityQueue<pair> heap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			heap.add(new pair(i, arr[i]));
		}

		pair rv = heap.remove();
		Node head = rv.node;
		Node tail = head;
		if (rv.node.next != null) {
			heap.add(new pair(rv.llname, rv.node.next));
		}
		while (heap.size() > 0) {
			rv = heap.remove();
			Node temp = rv.node;
			tail.next = temp;
			tail = tail.next;
			if (rv.node.next != null) {
				heap.add(new pair(rv.llname, rv.node.next));
			}
		}
		return head;
	}

}
