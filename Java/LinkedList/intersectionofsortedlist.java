package LinkedList;

public class intersectionofsortedlist {

	private static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public static Node findIntersection(Node head1, Node head2) {
		Node nhead = new Node(0);
		Node temp1 = head1;
		Node temp2 = head2;
		Node temp3 = nhead;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp3.data = temp1.data;
				temp1 = temp1.next;
				temp2 = temp2.next;
				if (temp1 != null && temp2 != null) {
					Node nn = new Node(0);
					temp3.next = nn;
					temp3 = nn;
				}

			} else if (temp1.data < temp2.data) {
				temp1 = temp1.next;
			} else {
				temp2 = temp2.next;
			}
		}

		return nhead;

	}

}
