package LinkedList;

public class cloneLLwithrandompointers {
	static class Node {
		int data;
		Node next, arb;

		Node(int d) {
			data = d;
			next = arb = null;

		}
	}

	static Node copyList(Node head) {

		Node temp = head;
		// created copy of each node
		while (temp != null) {
			Node nn = new Node(temp.data);
			nn.next = temp.next;
			temp.next = nn;
			temp = nn.next;
		}

		temp = head;
		// creating arb link
		while (temp != null) {
			Node copy = temp.next;
			Node arb = temp.arb;
			if (arb != null) {
				copy.arb = temp.arb.next;
			}
			temp = copy.next;
		}

		Node nlist = new Node(-1);
		Node temp1 = nlist;
		temp = head;
		while (temp != null && temp.next != null) {

			temp1.next = temp.next;
			temp1 = temp1.next;

			temp.next = temp.next.next;
			temp = temp.next;
		}

		return nlist.next;
	}

}
