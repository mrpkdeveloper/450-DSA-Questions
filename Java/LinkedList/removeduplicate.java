package LinkedList;

public class removeduplicate {

	private class Node {
		int data;
		Node next;
	}

	Node removeDuplicates(Node head) {
		if (head == null) {
			return head;
		}
		Node temp = head;
		while (temp != null) {
			Node ahead = temp.next;
			while (ahead != null && temp.data == ahead.data) {
				temp.next = ahead.next;
				ahead = temp.next;
			}
			temp = temp.next;
		}
		return head;
	}

}
