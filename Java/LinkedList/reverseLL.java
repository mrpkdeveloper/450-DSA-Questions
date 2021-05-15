package LinkedList;

public class reverseLL {

	private class ListNode {
		int data;
		ListNode next;
	}

	// iteratively
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode prev = head;
		ListNode curr = prev.next;
		while (curr != null) {
			ListNode ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		ListNode tail = prev;
		curr = head;
		head = tail;
		tail = curr;
		tail.next = null;
		return head;

	}

	public ListNode reverseListrecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode temp = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}

}
