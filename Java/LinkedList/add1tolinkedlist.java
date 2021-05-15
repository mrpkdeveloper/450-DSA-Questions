package LinkedList;

public class add1tolinkedlist {

	private static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public static Node addOne(Node head) {
		head = reverse(head);
		Node temp = head;
		while (temp != null) {
			if (temp.data != 9) {
				temp.data += 1;
				break;
			} else if (temp.data == 9 && temp.next == null) {
				Node nn = new Node(1);
				temp.data = 0;
				temp.next = nn;
				break;
			} else {
				temp.data = 0;
				temp = temp.next;
			}
		}
		head = reverse(head);
		return head;

	}

	public static Node reverse(Node head) {
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head.next = null;
		return prev;
	}
}
