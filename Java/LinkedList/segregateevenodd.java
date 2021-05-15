package LinkedList;

public class segregateevenodd {
	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	Node divide(int N, Node head) {
		// code here
		Node nne = new Node(-1);
		Node nno = new Node(-1);
		Node nnte = nne;
		Node nnto = nno;
		Node temp = head;
		while (temp != null) {
			if (temp.data % 2 == 0) {
				nnte.next = temp;
				nnte = nnte.next;
			} else {
				nnto.next = temp;
				nnto = nnto.next;
			}
			temp = temp.next;
		}
		nnte.next = null;
		nnto.next = null;
		if (nne.next != null) {
			nnte.next = nno.next;
			return nne.next;
		} else {
			return nno.next;
		}

	}
}
