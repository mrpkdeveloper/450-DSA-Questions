package LinkedList;

public class reversedoublyLL {
	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static Node reverseDLL(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = null;
		Node current = head;

		/*
		 * swap next and prev for all nodes of doubly linked list
		 */
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		return temp.prev;

	}

}
