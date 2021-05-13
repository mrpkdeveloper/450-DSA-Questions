package LinkedList;

public class flattenedLL {

	class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}

	Node flatten(Node root) {
		if (root.next == null) {
			return root;
		}
		Node temp = flatten(root.next);
		Node tempfinal = merge(root, temp);
		return tempfinal;
	}

	Node merge(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		Node temp3 = new Node(0);
		Node temp = temp3;
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				temp.bottom = temp1;
				temp1 = temp1.bottom;
			} else {
				temp.bottom = temp2;
				temp2 = temp2.bottom;
			}
			temp = temp.bottom;
		}

		if (temp1 == null) {
			if (temp2 != null) {
				temp.bottom = temp2;
			}
		} else if (temp2 == null) {
			if (temp1 != null) {
				temp.bottom = temp1;
			}
		}
		return temp3.bottom;

	}

}
