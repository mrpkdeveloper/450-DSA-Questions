package LinkedList;

public class rotatedoublyLLbyn {
	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Node rotateP(Node head, int p) {

		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		while (p > 0) {
			tail.next = head;
			head.prev = tail;
			head = head.next;
			head.prev = null;
			tail = tail.next;
			tail.next = null;
			p--;
		}

		return head;
	}

}
