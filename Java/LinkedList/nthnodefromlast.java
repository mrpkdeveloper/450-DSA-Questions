package LinkedList;

public class nthnodefromlast {
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// optimised
	int getNthFromLast(Node head, int n) {
		Node slow = head;
		Node fast = head;
		int k = 0;
		while (fast != null && k < n) {
			fast = fast.next;
			k++;
		}

		if (k != n) {
			return -1;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

}
