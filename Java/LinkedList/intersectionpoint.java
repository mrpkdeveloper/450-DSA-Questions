package LinkedList;

public class intersectionpoint {
	private class Node {
		int data;
		Node next;
	}

	// most optimised solution
	public static int intersectPoint(Node head1, Node head2) {

		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null || temp2 != null) {

			if (temp1 == temp2) {
				return temp1.data;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;

			if (temp1 == null) {
				temp1 = head2;
			}
			if (temp2 == null) {
				temp2 = head1;
			}

		}
		return -1;
	}
}
