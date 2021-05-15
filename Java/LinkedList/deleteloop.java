package LinkedList;

public class deleteloop {
	private class Node {
		int data;
		Node next;
	}

	public static void removeLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// loop detected
			if (fast == slow) {
				// if both points to head
				if (fast == head) {
					while (slow.next != fast) {
						slow = slow.next;
					}
				} else {
					fast = head;
					while (fast.next != slow.next) {
						fast = fast.next;
						slow = slow.next;
					}

				}
				slow.next = null;
				break;
			}
		}

	}

}
