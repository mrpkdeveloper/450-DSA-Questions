package LinkedList;

public class pallindrome {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			this.data = key;
			next = null;
		}
	}

	static boolean isPalindrome(Node head) {
		Node mid = mid(head);
		mid.next = reverse(mid.next);

		mid = mid.next;
		Node temp = head;
		while (mid != null) {
			if (temp.data != mid.data) {
				return false;
			}
			temp = temp.next;
			mid = mid.next;
		}
		return true;
	}

	static Node mid(Node head) {
		Node s = head;
		Node f = head;
		while (f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}

	static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head.next = null;
		head = prev;
		return head;
	}

}
