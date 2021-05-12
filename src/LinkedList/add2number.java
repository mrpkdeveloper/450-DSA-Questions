package LinkedList;

public class add2number {
	private static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	static Node addTwoLists(Node f, Node s) {
		Node newhead = new Node(0);
		f = reverse(f);
		s = reverse(s);
		Node temp1 = f;
		Node temp2 = s;
		Node temp3 = newhead;
		int c = 0;
		while (temp1 != null && temp2 != null) {
			int a = temp1.data + temp2.data + c;
			c = a / 10;
			a = a % 10;
			temp3.data = a;
			Node nn = new Node(0);
			temp3.next = nn;
			temp3 = nn;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if (temp1 == null) {
			while (temp2 != null) {
				int a = temp2.data + c;
				c = a / 10;
				a = a % 10;
				temp3.data = a;
				Node nn = new Node(0);
				temp3.next = nn;
				temp3 = nn;
				temp2 = temp2.next;
			}
		} else {
			while (temp1 != null) {
				int a = temp1.data + c;
				c = a / 10;
				a = a % 10;
				temp3.data = a;
				Node nn = new Node(0);
				temp3.next = nn;
				temp3 = nn;
				temp1 = temp1.next;
			}
		}

		while (c != 0) {
			temp3.data = c % 10;
			c = c / 10;
			Node nn = new Node(0);
			temp3.next = nn;
			temp3 = nn;
		}
		newhead = reverse(newhead);
		temp3 = newhead;
		newhead = newhead.next;
		temp3.next = null;
		temp3 = null;
		return newhead;
	}

	static Node reverse(Node head) {
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
