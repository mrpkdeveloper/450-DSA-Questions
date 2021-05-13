package LinkedList;

public class mergesort {
	static class Node {
		int data;
		Node next;

		Node(int key) {
			this.data = key;
			next = null;
		}
	}

	static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = middle(head);
		Node head2 = mid.next;
		mid.next = null;
		Node temp1 = mergeSort(head);
		Node temp2 = mergeSort(head2);

		Node nn = merge(temp1, temp2);
		return nn;
	}

	// using n extra space
	static Node merge(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		Node newhead = new Node(-1);
		Node temp3 = newhead;
		Node prev = temp3;

		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				temp3.data = temp1.data;
				temp1 = temp1.next;
			} else {
				temp3.data = temp2.data;
				temp2 = temp2.next;
			}
			prev = temp3;
			Node nn = new Node(-1);
			temp3.next = nn;
			temp3 = nn;
		}

		prev.next = null;

		if (temp1 == null) {
			if (temp2 != null) {
				prev.next = temp2;
			}
		} else if (temp2 == null) {
			if (temp1 != null) {
				prev.next = temp1;
			}
		}
		return newhead;

	}

	// no extra space
	static Node mergenospace(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		Node newhead = new Node(-1);
		Node temp3 = newhead;

		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				temp3.next = temp1;
				temp1 = temp1.next;
			} else {
				temp3.next = temp2;
				temp2 = temp2.next;
			}
			temp3 = temp3.next;
		}

		if (temp1 == null) {
			if (temp2 != null) {
				temp3.next = temp2;
			}
		} else if (temp2 == null) {
			if (temp1 != null) {
				temp3.next = temp1;
			}
		}
		return newhead.next;

	}

	static Node middle(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node s = head;
		Node f = head;
		while (f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}

}
