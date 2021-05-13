package LinkedList;

import java.util.PriorityQueue;

public class ksortedLL {

	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	// insertion sort O(nk)
	public static Node sortedDll(Node head, int k) {
		// Write your code here.
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = head;
		Node temp2 = head.next;

		while (temp2 != null) {
			Node j = temp2;
			while (j.prev != null && j.prev.data > j.data) {
				int t = j.prev.data;
				j.prev.data = j.data;
				j.data = t;
				j = j.prev;
			}
			temp2 = temp2.next;
		}
		return head;

	}

	public static Node sortedDlloptimised(Node head, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		Node temp = head;
		int i = 0;
		while (i <= k) {
			heap.add(temp.data);
			i++;
			temp = temp.next;
		}
		Node temp2 = head;
		while (temp != null) {
			temp2.data = heap.remove();
			temp2 = temp2.next;
			heap.add(temp.data);
			temp = temp.next;
		}
		while (heap.size() > 0) {
			temp2.data = heap.remove();
			temp2 = temp2.next;
		}

		return head;
	}

}
