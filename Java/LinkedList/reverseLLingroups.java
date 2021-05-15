package LinkedList;

public class reverseLLingroups {
	private class Node {
		int data;
		Node next;
	}

	public static Node reverse(Node head, int k) {
		if (head == null) {
			return head;
		}

		Node prev = head;
		Node curr = prev.next;
		int i = 0;
		while (i <= k - 2 && curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
			i++;
		}
		Node temp = reverse(curr, k);
		head.next = temp;
		return prev;
	}

}
