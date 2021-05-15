package LinkedList;

public class detectloop {

	private class Node {
		int data;
		Node next;
	}

	public static boolean detectLoop(Node head) {
		// Add code here
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
