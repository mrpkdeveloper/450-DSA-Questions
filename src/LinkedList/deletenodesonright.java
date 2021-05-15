package LinkedList;

public class deletenodesonright {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node compute(Node head) {
		Node rh = reverse(head);
		Node temp = rh;
		Node nn = new Node(-1);
		Node nnt = nn;
		while (temp != null) {
			if (temp.data >= nnt.data) {
				nnt.next = temp;
				nnt = nnt.next;

			}
			temp = temp.next;
		}
		nnt.next = null;
		return reverse(nn.next);

	}

	static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
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
