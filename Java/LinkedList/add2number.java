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
		Node newhead = new Node(-1);
		f = reverse(f);
		s = reverse(s);
		Node temp1 = f;
		Node temp2 = s;
		Node temp3 = newhead;
		int c = 0;
		while (temp1 != null || temp2 != null || c != 0) {
			int a = (temp1 != null ? temp1.data : 0) + (temp2 != null ? temp2.data : 0) + c;
			c = a / 10;
			a = a % 10;
			Node nn = new Node(a);
			temp3.next = nn;
			temp3 = nn;
			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}

		return reverse(newhead.next);
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
